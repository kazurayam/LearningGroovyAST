package groovyinaction.ch09ast

class Resource {
    private static alive = 0
    private static used = 0
    Resource() {
        alive++
    }
    void use() {
        used++
    }
    static String stats() {
        "$alive alive, $used used"
    }
}
