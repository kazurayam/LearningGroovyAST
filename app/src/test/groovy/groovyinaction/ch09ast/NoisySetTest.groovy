package groovyinaction.ch09ast

import org.junit.jupiter.api.Test

class NoisySetTest {

    @Test
    void testSmoke() {
        Set ns = new NoisySet()
        ns.add(1)
        ns.addAll([2, 3])
        assert ns.size() == 3
    }
}
