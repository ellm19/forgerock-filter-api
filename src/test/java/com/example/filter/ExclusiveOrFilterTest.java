package com.example.filter;

import org.junit.jupiter.api.Test;

import static com.example.filter.TestData.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExclusiveOrFilterTest {

    @Test
    void returnsTrue_WhenOneFilterMatches() {
        Filter filter = Filters.exclusiveOr(
                Filters.equalTo(PROPERTY_ROLE, VALUE_ROLE),
                Filters.equalTo(PROPERTY_ROLE, VALUE_UNKNOWN)
        );

        assertTrue(filter.matches(USER));
    }

    @Test
    void returnsFalse_WhenAllFiltersMatch() {
        Filter filter = Filters.exclusiveOr(
                Filters.equalTo(PROPERTY_ROLE, VALUE_ROLE),
                Filters.equalTo(PROPERTY_AGE, VALUE_AGE)
        );

        assertFalse(filter.matches(USER));
    }

    @Test
    void returnsFalse_WhenNoFiltersProvided() {
        Filter filter = new ExclusiveOrFilter();

        assertFalse(filter.matches(USER));
    }

    @Test
    void returnsFalse_WhenNoFiltersMatch() {
        Filter filter = Filters.exclusiveOr(
                Filters.equalTo(PROPERTY_ROLE, VALUE_UNKNOWN),
                Filters.equalTo(PROPERTY_ROLE, VALUE_UNKNOWN)
        );

        assertFalse(filter.matches(USER));
    }
}
