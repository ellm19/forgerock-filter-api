package com.example.filter;

import org.junit.jupiter.api.Test;

import static com.example.filter.TestData.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AndFilterTest {

    @Test
    void returnsTrue_WhenAllFiltersMatch() {
        Filter filter = Filters.and(
                Filters.equalTo(PROPERTY_ROLE, VALUE_ROLE),
                Filters.equalTo(PROPERTY_FIRST_NAME, VALUE_FIRST_NAME)
        );

        assertTrue(filter.matches(USER));
    }

    @Test
    void returnsTrue_WhenNoFiltersProvided() {
        Filter filter = new AndFilter();

        assertTrue(filter.matches(USER));
    }

    @Test
    void returnsFalse_WhenOneFilterDoesNotMatch() {
        Filter filter = Filters.and(
                Filters.equalTo(PROPERTY_ROLE, VALUE_ROLE),
                Filters.equalTo(PROPERTY_FIRST_NAME, VALUE_UNKNOWN)
        );

        assertFalse(filter.matches(USER));
    }

    @Test
    void returnsFalse_WhenAllFiltersDoNotMatch() {
        Filter filter = Filters.and(
                Filters.equalTo(PROPERTY_ROLE, VALUE_UNKNOWN),
                Filters.equalTo(PROPERTY_FIRST_NAME, VALUE_UNKNOWN)
        );

        assertFalse(filter.matches(USER));
    }
}
