package com.kazurayam.ks.asttransform

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import static org.junit.jupiter.api.Assertions.assertEquals

class PersonTest {

    Person p1
    Person p2

    @BeforeEach
    void setup() {
        p1 = new Person(name: "Joe", age: 21)
        p2 = new Person(name: "Joe", age: 21)
    }

    @Test
    void testIdentity() {
        assertEquals(p1, p2, "should be equal")
    }

}
