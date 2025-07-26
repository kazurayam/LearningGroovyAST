package com.medium.groovyast

import org.junit.jupiter.api.Test

class EmployeeTest {

    @Test
    void test_toString() {
        Employee emp = new Employee(name: 'Jane Doe', department: 'Engineering')
        println emp.toString()
        assert emp.toString() == "Employee(Jane Doe, Engineering)"
    }
}
