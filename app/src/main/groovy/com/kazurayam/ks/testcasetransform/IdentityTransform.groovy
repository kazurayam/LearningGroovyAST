package com.kazurayam.ks.testcasetransform

import org.codehaus.groovy.ast.CodeVisitorSupport
import org.codehaus.groovy.ast.expr.MethodCallExpression
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class IdentityTransform extends CodeVisitorSupport {

    private static Logger logger = LoggerFactory.getLogger(IdentityTransform.class)

    @Override
    void visitMethodCallExpression(MethodCallExpression call) {
        logger.info("called visitMethodCallExpression with arg: ${call.toString()}")
    }
}
