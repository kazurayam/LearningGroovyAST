package groovyinaction.ch09ast

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import static org.junit.jupiter.api.Assertions.fail

class GeniusTest {

    Genius g1
    Genius g2

    @BeforeEach
    void beforeEach() {
        g1 = new Genius(firstName: "Albert", lastName: "Einstein")
        g2 = new Genius("Leonardo", "da Vinci")
    }

    @Test
    void testToString() {
        assert g1.toString() == "Genius(Albert, Einstein)"
    }

    @Test
    void testGetter() {
        assert g2.firstName == "Leonardo"
    }

    @Test
    void testImmutability() {
        try {
            g2.lastName = "DiCaprio"
            fail("should fail")
        } catch (Exception ex) {
            ;
        }
    }
}
