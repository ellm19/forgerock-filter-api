package com.example.filter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FilterToStringTest {

    @Test
    void formatsSimpleFilter() {
        Filter filter = Filters.equalTo("role", "administrator");

        assertEquals(
                "role == \"administrator\"",
                filter.toString()
        );
    }

    @Test
    void formatsAndFilter() {
        Filter filter = Filters.and(
                Filters.equalTo("role", "administrator"),
                Filters.greaterThan("age", "30")
        );

        assertEquals(
                "(role == \"administrator\" AND age > \"30\")",
                filter.toString()
        );
    }

    @Test
    void formatsComplexNestedFilter() {
        Filter filter = Filters.and(
                Filters.equalTo("role", "administrator"),
                Filters.or(
                        Filters.greaterThan("age", "30"),
                        Filters.equalTo("department", "engineering")
                )
        );

        assertEquals(
                "(role == \"administrator\" AND (age > \"30\" OR department == \"engineering\"))",
                filter.toString()
        );
    }
}
