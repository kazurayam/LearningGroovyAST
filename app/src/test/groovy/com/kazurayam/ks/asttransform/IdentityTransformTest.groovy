package com.kazurayam.ks.asttransform

import org.codehaus.groovy.ast.GroovyCodeVisitor
import org.codehaus.groovy.ast.MethodNode
import org.codehaus.groovy.control.SourceUnit
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import java.nio.file.Path
import java.nio.file.Paths

class IdentityTransformTest {

    private Logger logger = LoggerFactory.getLogger(IdentityTransformTest.class)

    private String code
    private String name

    @BeforeEach
    void setup() {
        Path sourcePath = Paths.get("src/test/groovy/org/example/AppTest.groovy")
        code = sourcePath.toFile().getText()
        name = "org.example.AppTest"
    }

    @Test
    void test_visitScriptCode() {
        logger.info("test_visitScriptCode started")
        SourceUnit sourceUnit = SourceUnit.create(name, code)
        logger.info("sourceUnit is ${sourceUnit.name}")
        sourceUnit.parse()   // source -> CST
        sourceUnit.completePhase()   // mark compilation finished
        sourceUnit.convert() // CST -> AST
        logger.info("${sourceUnit.getAST().toString()}")
        visitScriptCode(sourceUnit, new IdentityTransform())
        logger.info("test_visitScriptCode finished")
    }

    private static void visitScriptCode(SourceUnit source, GroovyCodeVisitor transformer) {
        source.getAST().getClasses()visit(transformer)
        for (Object method : source.getAST().getMethods()) {
            MethodNode methodNode = (MethodNode) method;
            methodNode.getCode().visit(transformer);
        }
    }


}
