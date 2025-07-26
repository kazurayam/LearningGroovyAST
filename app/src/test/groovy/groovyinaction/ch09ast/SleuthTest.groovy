package groovyinaction.ch09ast

import org.junit.jupiter.api.Test

class SleuthTest {

    @Test
    void test_toString() {
        def nancy = new Sleuth(firstName: 'Nancy', lastName: 'Drew')
        println nancy.toString()
        assert nancy.toString() == 'groovyinaction.ch09ast.Sleuth(firstName:Nancy, lastName:Drew)'
    }

    @Test
    void test_toString_withNull() {
        def nancy = new Sleuth(firstName: 'Nancy')
        println nancy.toString()
        assert nancy.toString() == 'groovyinaction.ch09ast.Sleuth(firstName:Nancy)'
    }
}
