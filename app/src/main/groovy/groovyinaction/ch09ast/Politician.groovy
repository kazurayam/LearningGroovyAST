package groovyinaction.ch09ast

import groovy.transform.Sortable

@Sortable(includes = 'last, initial')
class Politician {
    String first
    Character initial
    String last
    String initials() {
        first[0] + initial + last[0]
    }
}
