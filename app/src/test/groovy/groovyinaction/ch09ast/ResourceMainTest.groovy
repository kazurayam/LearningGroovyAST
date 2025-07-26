package groovyinaction.ch09ast

import org.junit.jupiter.api.Test

class ResourceMainTest {
    @Test
    void test_smoke() {
        new ResourceMain().with {
            assert Resource.stats() == '1 alive, 0 used'
            res2.use()
            res3.use()
            res4.use()
            assert Resource.stats() == '4 alive, 3 used'
            assert res4 instanceof Resource
            def expected = 'res4=java.lang.ref.SoftReference'
            assert it.dump().contains(expected)
        }
    }
}
