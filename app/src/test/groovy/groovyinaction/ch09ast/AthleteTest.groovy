package groovyinaction.ch09ast

import org.junit.jupiter.api.Test

class AthleteTest {

    @Test
    void test_equals_firstName() {
        def a1 = new Athlete('Michael', 'Jordan')
        def a2 = new Athlete('Michael')
        assert a1.firstName == a2.firstName
    }
}
