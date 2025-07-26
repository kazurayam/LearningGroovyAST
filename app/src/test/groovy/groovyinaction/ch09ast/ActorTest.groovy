package groovyinaction.ch09ast

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ActorTest {

    def magneto
    def gandalf

    @BeforeEach
    void beforeEach() {
        magneto = new Actor(firstName: 'Ian', lastName: 'McKellen')
        gandalf = new Actor(firstName: 'Ian', lastName: 'McKellen')
    }

    @Test
    void test_equals() {
        assert magneto == gandalf
    }

    @Test
    void test_hashCode() {
        assert magneto.hashCode() == gandalf.hashCode()
    }
}
