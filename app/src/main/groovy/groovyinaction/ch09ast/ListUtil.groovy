package groovyinaction.ch09ast

import groovy.transform.TailRecursive

class ListUtil {
    static List reverse(List list) {
        doReverse(list, [])
    }

    @TailRecursive
    private static List doReverse(List todo, List done) {
        if (todo.isEmpty())
            done
        else
            doReverse(todo.tail(), [todo.head()] + done)
    }
}
