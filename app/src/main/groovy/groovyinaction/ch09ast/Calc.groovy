package groovyinaction.ch09ast

import groovy.transform.Memoized

class Calc {

    def log = []

    @Memoized
    int sum(int a, int b) {
        log << "$a+$b"
        a + b
    }
}
