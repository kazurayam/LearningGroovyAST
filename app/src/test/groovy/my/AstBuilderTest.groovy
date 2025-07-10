package my

import org.codehaus.groovy.ast.ASTNode
import org.codehaus.groovy.ast.builder.AstBuilder
import org.codehaus.groovy.control.CompilePhase
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.nio.file.Path
import java.nio.file.Paths
import static org.junit.jupiter.api.Assertions.assertNotNull

class AstBuilderTest {

    List<ASTNode> ast

    @BeforeEach
    void setup() {
        Path sourcePath = Paths.get("src/test/groovy/org/example/AppTest.groovy")
        String code = sourcePath.toFile().getText()
        AstBuilder astBuilder = new AstBuilder()
        ast = astBuilder.buildFromString(CompilePhase.CONVERSION, false, code)
    }

    @Test
    void test_buildFromString() {
        assertNotNull(ast, "ast must not be null")
    }
}
