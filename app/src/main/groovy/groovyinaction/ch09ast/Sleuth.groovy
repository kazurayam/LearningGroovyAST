package groovyinaction.ch09ast

import groovy.transform.ToString

@ToString(includeNames = true, ignoreNulls = true)
class Sleuth {
    def firstName, lastName
}
