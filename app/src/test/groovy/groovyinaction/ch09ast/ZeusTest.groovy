package groovyinaction.ch09ast

import org.junit.jupiter.api.Test
import static org.junit.jupiter.api.Assertions.fail

class ZeusTest {

    @Test
    void testSingletonInstance() {
        assert Zeus.instance
    }

    @Test
    void testSmoke() {
        try {
            new Zeus()
            fail("should fail here")
        } catch (Exception ex) {
            assert ex.message ==
                    "Can't instantiate singleton groovyinaction.ch09ast.Zeus." +
                    " Use groovyinaction.ch09ast.Zeus.instance"
        }
    }
}
