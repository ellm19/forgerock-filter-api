package com.example.filter;

import org.junit.jupiter.api.Test;

import static com.example.filter.TestData.USER;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrFilterTest {

    @Test
    void returnsTrue_WhenOneFilterMatches() {
        Filter filter = Filters.or(
                Filters.equalTo("role", "administrator"),
                Filters.equalTo("role", "manager")
        );

        assertTrue(filter.matches(USER));
    }

    @Test
    void doesNotMatchWhenNoFiltersMatch() {
        Filter filter = Filters.or(
                Filters.equalTo("role", "customer"),
                Filters.equalTo("role", "manager")
        );

        assertFalse(filter.matches(USER));
    }

    @Test
    void matchesWhenAllFiltersMatch() {
        Filter filter = Filters.or(
                Filters.equalTo("role", "administrator"),
                Filters.equalTo("role", "administrator")
        );

        assertTrue(filter.matches(USER));
    }
}
