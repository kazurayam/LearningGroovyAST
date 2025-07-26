package com.kazurayam.ks.asttransform

import org.junit.jupiter.api.Test

class LoggedAnnotationDemoTest {

    @Test
    void testSmoke() {
        def LoggedAnnotationDemo demo = new LoggedAnnotationDemo()
        demo.exampleMethod()
    }
}
