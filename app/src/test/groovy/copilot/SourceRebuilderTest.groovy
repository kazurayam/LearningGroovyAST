package copilot

import org.codehaus.groovy.ast.ASTNode
import org.codehaus.groovy.ast.builder.AstBuilder
import org.codehaus.groovy.control.CompilePhase
import org.junit.jupiter.api.Test

class SourceRebuilderTest {

    @Test
    void testSmoke() {
        List<ASTNode> ast =
                new AstBuilder().buildFromString(CompilePhase.CONVERSION, false,
                        "println 'Hello World'")
        SourceRebuilder visitor = new SourceRebuilder()
        ast[0].visit(visitor)
        println visitor.getSource()
    }
}
