package com.example.filter;

import org.junit.jupiter.api.Test;

import static com.example.filter.TestData.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrFilterTest {

    @Test
    void returnsTrue_WhenOneFilterMatches() {
        Filter filter = Filters.or(
                Filters.equalTo(PROPERTY_ROLE, VALUE_ROLE),
                Filters.equalTo(PROPERTY_ROLE, VALUE_UNKNOWN)
        );

        assertTrue(filter.matches(USER));
    }

    @Test
    void returnsTrue_WhenAllFiltersMatch() {
        Filter filter = Filters.or(
                Filters.equalTo(PROPERTY_ROLE, VALUE_ROLE),
                Filters.equalTo(PROPERTY_AGE, VALUE_AGE)
        );

        assertTrue(filter.matches(USER));
    }

    @Test
    void returnsFalse_WhenNoFiltersProvided() {
        Filter filter = new OrFilter();

        assertFalse(filter.matches(USER));
    }

    @Test
    void returnsFalse_WhenNoFiltersMatch() {
        Filter filter = Filters.or(
                Filters.equalTo(PROPERTY_ROLE, VALUE_UNKNOWN),
                Filters.equalTo(PROPERTY_ROLE, VALUE_UNKNOWN)
        );

        assertFalse(filter.matches(USER));
    }
}
