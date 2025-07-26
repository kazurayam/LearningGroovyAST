package groovyinaction.ch09ast

import groovy.transform.IndexedProperty

class Author {
    String name
    @IndexedProperty List<String> books
}
