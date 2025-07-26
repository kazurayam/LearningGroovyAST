package groovyinaction.ch09ast

import org.junit.jupiter.api.Test

class ListUtilTest {

    @Test
    void testDoReverse() {
        assert ListUtil.reverse(['a', 'b', 'c']) == ['c', 'b', 'a']
    }
}
