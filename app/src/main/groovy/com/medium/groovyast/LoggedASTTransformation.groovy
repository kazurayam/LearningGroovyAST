package com.medium.groovyast

import org.codehaus.groovy.ast.ASTNode
import org.codehaus.groovy.ast.ClassHelper
import org.codehaus.groovy.ast.Parameter
import org.codehaus.groovy.ast.VariableScope
import org.codehaus.groovy.ast.expr.ConstantExpression
import org.codehaus.groovy.ast.expr.MethodCallExpression
import org.codehaus.groovy.ast.expr.VariableExpression
import org.codehaus.groovy.ast.MethodNode
import org.codehaus.groovy.ast.stmt.BlockStatement
import org.codehaus.groovy.ast.stmt.ExpressionStatement
import org.codehaus.groovy.control.CompilePhase
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.transform.ASTTransformation
import org.codehaus.groovy.transform.GroovyASTTransformation

@GroovyASTTransformation(phase = CompilePhase.CANONICALIZATION)
class LoggedASTTransformation implements ASTTransformation {
    @Override
    void visit(ASTNode[] nodes, SourceUnit source) {
        nodes[1].methods.each { MethodNode method ->
            if (method.hasAnnotation(Logged)) {
                method.code = new MethodCallExpression(
                        new VariableExpression("this"),
                        "log",
                        new ConstantExpression("${method.name} called"))
                method.owner.addMethod(
                        "log",
                        MethodNode.ACC_PUBLIC,
                        ClassHelper.VOID_TYPE,
                        [new Parameter(ClassHelper.STRING_TYPE, "message")] as Parameter[],
                        null,
                        new BlockStatement([
                                new ExpressionStatement(
                                        new MethodCallExpression(
                                                new VariableExpression("System.out"),
                                                "println",
                                                new VariableExpression("message")
                                        )
                                )
                        ], new VariableScope())
                )
            }
        }
    }
}
