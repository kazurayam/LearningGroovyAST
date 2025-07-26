package groovyinaction.ch09ast

import groovy.transform.builder.Builder

@Builder
class Chemist {
    String first
    String last
    int born
}
