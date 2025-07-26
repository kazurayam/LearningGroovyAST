package com.kazurayam.ks.asttransform

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import static org.junit.jupiter.api.Assertions.assertEquals

class EmployeeTest {

    Employee e1

    @BeforeEach
    void setup() {
        e1 = new Employee(name: 'Jane Doe', department: 'Engineering')
    }

    @Test
    void testPrintln() {
        println e1
    }

    @Test
    void testToString() {
        assertEquals(
                'com.kazurayam.ks.asttransform.Employee(Jane Doe, Engineering)',
                e1.toString()
        )
    }
}
