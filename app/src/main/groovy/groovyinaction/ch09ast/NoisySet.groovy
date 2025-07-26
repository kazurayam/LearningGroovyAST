package groovyinaction.ch09ast

class NoisySet {

    @Delegate
    Set delegate = new HashSet()

    @Override
    boolean add(item) {
        println "adding $item"
        delegate.add(item)
    }

    @Override
    boolean addAll(Collection items) {
        items.each {
            println "adding $it"
        }
        delegate.addAll(items)
    }
}
