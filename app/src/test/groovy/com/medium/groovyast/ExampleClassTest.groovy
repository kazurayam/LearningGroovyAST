package com.medium.groovyast

import org.junit.jupiter.api.Test

class ExampleClassTest {
    @Test
    void testSmoke() {
        ExampleClass ec = new ExampleClass()
        assert ec.exampleMethod()
    }
}
