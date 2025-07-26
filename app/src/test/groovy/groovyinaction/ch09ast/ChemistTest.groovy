package groovyinaction.ch09ast

import org.junit.jupiter.api.Test

class ChemistTest {
    def builder = Chemist.builder()

    @Test
    void test_smoke() {
        Chemist c = builder.first("Marie").last("Curie").born(1867).build()
        assert c.first == "Marie"
        assert c.last == "Curie"
        assert c.born == 1867
    }

}
