package groovyinaction.ch09ast

import org.junit.jupiter.api.Test

class DetectiveTest {

    @Test
    void test_toString() {
        Detective sherlock = new Detective(firstName: 'Sherlock', lastName: 'Holmes')
        println sherlock.toString()
        assert sherlock.toString() == 'groovyinaction.ch09ast.Detective(Sherlock, Holmes)'
    }

}
