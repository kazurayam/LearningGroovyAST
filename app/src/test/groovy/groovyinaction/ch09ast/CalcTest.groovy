package groovyinaction.ch09ast

import org.junit.jupiter.api.Test

class CalcTest {

    @Test
    void testSmoke() {
        new Calc().with {
            assert sum(3,4)
            assert sum(4,4)
            assert sum(3,4)
            assert log.join(' ') == '3+4 4+4'
        }
    }
}
