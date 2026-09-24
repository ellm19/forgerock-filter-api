package com.example.filter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringFilterVisitorTest {

    private final StringFilterVisitor visitor =
            new StringFilterVisitor();

    @Test
    void formatsTrue() {
        Filter filter = Filters.TRUE;

        assertEquals(
                "true",
                filter.accept(visitor)
        );
    }

    @Test
    void formatsFalse() {
        Filter filter = Filters.FALSE;

        assertEquals(
                "false",
                filter.accept(visitor)
        );
    }

    @Test
    void formatsEquals() {
        Filter filter = Filters.equalTo("role", "admin");

        assertEquals(
                "role == \"admin\"",
                filter.accept(visitor)
        );
    }

    @Test
    void formatsPropertyPresent() {
        Filter filter = Filters.present("role");

        assertEquals(
                "role present",
                filter.accept(visitor)
        );
    }

    @Test
    void formatsGreaterThan() {
        Filter filter = Filters.greaterThan("age", "30");

        assertEquals(
                "age > \"30\"",
                filter.accept(visitor)
        );
    }

    @Test
    void formatsLessThan() {
        Filter filter = Filters.lessThan("age", "30");

        assertEquals(
                "age < \"30\"",
                filter.accept(visitor)
        );
    }

    @Test
    void formatsRegex() {
        Filter filter = Filters.matchesRegex("name", "Joe.*");

        assertEquals(
                "name matches \"Joe.*\"",
                filter.accept(visitor)
        );
    }

    @Test
    void formatsNot() {
        Filter filter = Filters.not(
                Filters.equalTo("role", "admin")
        );

        assertEquals(
                "NOT (role == \"admin\")",
                filter.accept(visitor)
        );
    }

    @Test
    void formatsAnd() {
        Filter filter = Filters.and(
                Filters.equalTo("role", "admin"),
                Filters.greaterThan("age", "30")
        );

        assertEquals(
                "(role == \"admin\" AND age > \"30\")",
                filter.accept(visitor)
        );
    }

    @Test
    void formatsOr() {
        Filter filter = Filters.or(
                Filters.equalTo("role", "admin"),
                Filters.equalTo("role", "manager")
        );

        assertEquals(
                "(role == \"admin\" OR role == \"manager\")",
                filter.accept(visitor)
        );
    }

    @Test
    void formatsNestedFilters() {
        Filter filter = Filters.and(
                Filters.equalTo("role", "admin"),
                Filters.or(
                        Filters.greaterThan("age", "30"),
                        Filters.equalTo("department", "engineering")
                )
        );

        assertEquals(
                "(role == \"admin\" AND (age > \"30\" OR department == \"engineering\"))",
                filter.accept(visitor)
        );
    }
}
