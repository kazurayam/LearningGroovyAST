/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.codehaus.groovy.ast

import groovy.transform.PackageScope
import org.codehaus.groovy.ast.builder.AstBuilder
import org.codehaus.groovy.ast.stmt.BlockStatement
import org.codehaus.groovy.ast.stmt.CatchStatement
import org.codehaus.groovy.ast.stmt.EmptyStatement
import org.codehaus.groovy.ast.stmt.IfStatement
import org.codehaus.groovy.ast.stmt.TryCatchStatement
import org.codehaus.groovy.ast.expr.*
import org.codehaus.groovy.control.CompilePhase
import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Tests the CodeVisitorSupport.
 *
 * @author Hamlet D'Arcy
 */

class CodeVisitorSupportTest {

    Logger logger = LoggerFactory.getLogger(CodeVisitorSupportTest.class)

    @Test
    void testIfElse() {
        def ast = new AstBuilder().buildFromCode { if (true) { 1 } else  { 2 } }
        def visitor = new RecordingCodeVisitorSupport()
        visitor.visitBlockStatement((BlockStatement)ast[0]) // first element is always BlockStatement

        assert visitor.history[0] == BlockStatement
        assert visitor.history[1] == IfStatement
        assert visitor.history[2] == BooleanExpression
        assert visitor.history[3] == BlockStatement
        assert visitor.history[4] == BlockStatement
        assert visitor.history.size() == 5
    }

    @Test
    void testEmptyStatementsOnIfElse() {
        def ast = new AstBuilder().buildFromCode(CompilePhase.SEMANTIC_ANALYSIS, true, {
            if (true) { 1 }
        })
        def visitor = new RecordingCodeVisitorSupport()
        visitor.visitBlockStatement((BlockStatement)ast[0]) // first element is always BlockStatement

        assert visitor.history.size() == 5
        assert visitor.history[0] == BlockStatement
        assert visitor.history[1] == IfStatement
        assert visitor.history[2] == BooleanExpression
        assert visitor.history[3] == BlockStatement
        assert visitor.history[4] == EmptyStatement
    }

    @Test
    void testTryCatchFinally() {
        def ast = new AstBuilder().buildFromCode {
            def x
            try {
                x = 1
            } catch (IOException ei) {
                x = 2
            } finally {
                x = 4
            }
        }
        def visitor = new RecordingCodeVisitorSupport()
        visitor.visitBlockStatement((BlockStatement)ast[0]) // first element is always BlockStatement
        assert visitor.history.size() == 7
        visitor.history.each { stmt ->
            logger.info(stmt.toString())
        }
        assert visitor.history[0] == BlockStatement
        assert visitor.history[1] == TryCatchStatement
        assert visitor.history[2] == BlockStatement
        assert visitor.history[3] == CatchStatement
        assert visitor.history[4] == BlockStatement
        assert visitor.history[5] == BlockStatement
        assert visitor.history[6] == BlockStatement
    }

    @Test
    void testEmptyStatementsOnTryCatch() {
        def ast = new AstBuilder().buildFromCode {
            def x
            try {
                x = 1
            } catch (IOException ei) {
                x = 2
            }
        }
        def visitor = new RecordingCodeVisitorSupport()
        visitor.visitBlockStatement((BlockStatement)ast[0]) // first element is always BlockStatement

        assert visitor.history.size() == 6
        assert visitor.history[0] == BlockStatement
        assert visitor.history[1] == TryCatchStatement
        assert visitor.history[2] == BlockStatement
        assert visitor.history[3] == CatchStatement
        assert visitor.history[4] == BlockStatement
        assert visitor.history[5] == EmptyStatement
    }
}

/**
 * Records the visit method that were called so that they can be queried and verified later.
 * This would be better implemented using invokeMethod but it is called from Java so it
 * won't dispatch correctly.
 *
 * @author Hamlet D'Arcy
 */
@PackageScope class RecordingCodeVisitorSupport extends CodeVisitorSupport implements GroovyInterceptable {
    def history = []

    void visitBlockStatement(BlockStatement node) {
        history << (node.getClass() as Object)
        super.visitBlockStatement(node)
    }

    void visitIfElse(IfStatement node) {
        history << (node.getClass() as Object)
        super.visitIfElse(node)
    }

    void visitBooleanExpression(BooleanExpression node) {
        history << (node.getClass() as Object)
        super.visitBooleanExpression(node)
    }

    void visitEmptyStatement(EmptyStatement node) {
        history << (node.getClass() as Object)
        super.visitEmptyStatement(node)
    }

    void visitTryCatchFinally(TryCatchStatement node) {
        history << (node.getClass() as Object)
        super.visitTryCatchFinally(node)
    }

    void visitCatchStatement(CatchStatement node) {
        history << (node.getClass() as Object)
        super.visitCatchStatement(node)
    }

}
