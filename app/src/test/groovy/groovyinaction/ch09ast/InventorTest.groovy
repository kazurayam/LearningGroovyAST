package groovyinaction.ch09ast

import org.junit.jupiter.api.Test

class InventorTest {
    def f1 = new Inventor('Thomas', 'Edison')
    def f2 = new Inventor('Thomas')

    @Test
    void testEquals() {
        assert f1 != f2
    }

    @Test
    void testGetter() {
        assert f1.firstName == f2.firstName
    }

    @Test
    void testToString() {
        println f1.toString()
        assert f1.toString() == "Inventor(Thomas, Edison)"
    }
}
