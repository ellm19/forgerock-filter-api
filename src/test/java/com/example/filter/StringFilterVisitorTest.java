package com.example.filter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringFilterVisitorTest {

    private final StringFilterVisitor visitor = new StringFilterVisitor();

    @Test
    void formatsTrue() {
        Filter filter = Filters.TRUE;

        assertEquals("true", filter.accept(visitor));
        assertEquals("true", filter.toString());
    }

    @Test
    void formatsFalse() {
        Filter filter = Filters.FALSE;

        assertEquals("false", filter.accept(visitor));
        assertEquals("false", filter.toString());
    }

    @Test
    void formatsEquals() {
        Filter filter = Filters.equalTo("role", "admin");

        assertEquals("role == \"admin\"", filter.accept(visitor));
        assertEquals("role == \"admin\"", filter.toString());
    }

    @Test
    void formatsPropertyPresent() {
        Filter filter = Filters.present("role");

        assertEquals("role present", filter.accept(visitor));
        assertEquals("role present", filter.toString());
    }

    @Test
    void formatsGreaterThan() {
        Filter filter = Filters.greaterThan("age", "35");

        assertEquals("age > \"35\"", filter.accept(visitor));
        assertEquals("age > \"35\"", filter.toString());
    }

    @Test
    void formatsLessThan() {
        Filter filter = Filters.lessThan("age", "35");

        assertEquals("age < \"35\"", filter.accept(visitor));
        assertEquals("age < \"35\"", filter.toString());
    }

    @Test
    void formatsRegex() {
        Filter filter = Filters.matchesRegex("name", "Joe.*");

        assertEquals("name matches \"Joe.*\"", filter.accept(visitor));
        assertEquals("name matches \"Joe.*\"", filter.toString());
    }

    @Test
    void formatsNot() {
        Filter filter = Filters.not(
                Filters.equalTo("role", "admin")
        );

        assertEquals("NOT (role == \"admin\")", filter.accept(visitor));
        assertEquals("NOT (role == \"admin\")", filter.toString());
    }

    @Test
    void formatsAnd() {
        Filter filter = Filters.and(
                Filters.equalTo("role", "admin"),
                Filters.greaterThan("age", "35")
        );

        assertEquals("(role == \"admin\" AND age > \"35\")", filter.accept(visitor));
        assertEquals("(role == \"admin\" AND age > \"35\")", filter.toString());
    }

    @Test
    void formatsOr() {
        Filter filter = Filters.or(
                Filters.equalTo("role", "admin"),
                Filters.equalTo("role", "manager")
        );

        assertEquals("(role == \"admin\" OR role == \"manager\")", filter.accept(visitor));
        assertEquals("(role == \"admin\" OR role == \"manager\")", filter.toString());
    }

    @Test
    void formatsNestedFilters() {
        Filter filter = Filters.and(
                Filters.equalTo("role", "admin"),
                Filters.or(
                        Filters.greaterThan("age", "35"),
                        Filters.equalTo("department", "engineering")
                )
        );

        assertEquals("(role == \"admin\" AND (age > \"35\" OR department == \"engineering\"))", filter.accept(visitor));
        assertEquals("(role == \"admin\" AND (age > \"35\" OR department == \"engineering\"))", filter.toString());
    }
}
