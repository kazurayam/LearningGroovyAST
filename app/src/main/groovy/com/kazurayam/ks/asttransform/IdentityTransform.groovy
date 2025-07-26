package com.kazurayam.ks.asttransform

import org.codehaus.groovy.ast.CodeVisitorSupport
import org.codehaus.groovy.ast.expr.ClassExpression
import org.codehaus.groovy.ast.expr.MethodCallExpression
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class IdentityTransform extends CodeVisitorSupport {

    private static Logger logger = LoggerFactory.getLogger(IdentityTransform.class)

    @Override
    void visitClassExpression(ClassExpression expression) {
        logger.info("visitClassExpression(${expression.toString()})")
    }

    @Override
    void visitMethodCallExpression(MethodCallExpression call) {
        logger.info("visitMethodCallExpression(${call.toString()})")
    }

}
