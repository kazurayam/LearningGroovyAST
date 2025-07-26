package groovyinaction.ch09ast

import groovy.transform.Canonical
import groovy.transform.ToString

@Canonical
@ToString(includePackage=false)
class Inventor {
    String firstName, lastName
}