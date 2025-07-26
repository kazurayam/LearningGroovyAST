package com.medium.groovyast

import org.junit.jupiter.api.Test


class PersonTest {
    @Test
    void test_equals() {
        Person p1 = new Person('Albert Einstein', 77)
        Person p2 = new Person('Albert Einstein', 77)
        assert p1 == p2
    }
}
