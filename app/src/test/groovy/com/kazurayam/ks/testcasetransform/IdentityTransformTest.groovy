package com.kazurayam.ks.testcasetransform

import org.codehaus.groovy.ast.GroovyCodeVisitor
import org.codehaus.groovy.ast.MethodNode
import org.codehaus.groovy.control.SourceUnit
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import java.nio.file.Path
import java.nio.file.Paths

class IdentityTransformTest {

    String code

    @BeforeEach
    void setup() {
        Path sourcePath = Paths.get("src/test/groovy/org/example/AppTest.groovy")
        code = sourcePath.toFile().getText()
    }

    @Test
    void test_visitScriptCode() {
        SourceUnit sourceUnit = SourceUnit.create("com.example.AppTest", code)
        sourceUnit.parse()   // source -> CST
        sourceUnit.completePhase()   // mark compilation finished
        sourceUnit.convert() // CST -> AST
        visitScriptCode(sourceUnit, new IdentityTransform())
    }

    private static void visitScriptCode(SourceUnit source, GroovyCodeVisitor transformer) {
        source.getAST().getStatementBlock().visit(transformer)
        for (Object method : source.getAST().getMethods()) {
            MethodNode methodNode = (MethodNode) method;
            methodNode.getCode().visit(transformer);
        }
    }


}
