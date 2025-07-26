package groovyinaction.ch09ast

import org.junit.jupiter.api.Test

class PoliticianTest {

    def politicians = [
            new Politician(first:'Margaret', initial:'H' as char, last:'Thacher'),
            new Politician(first:'George', initial:'W' as char, last:'Bush')
    ]

    @Test
    void test_smoke() {
        def sorted = politicians.toSorted()
        assert sorted*.initials() == ['GWB', 'MHT']
        // *. is spread-dot operator
        // sorted *. initials() is equivalent to
        // sorted.collect { item -> item?.initials()}
    }
}
