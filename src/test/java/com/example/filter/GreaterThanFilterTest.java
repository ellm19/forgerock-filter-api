package com.example.filter;

import org.junit.jupiter.api.Test;

import static com.example.filter.TestData.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GreaterThanFilterTest {

    @Test
    void returnsTrue_WhenValueIsGreater() {
        Filter filter = Filters.greaterThan(PROPERTY_AGE, VALUE_AGE_BELOW);

        assertTrue(filter.matches(USER));
    }

    @Test
    void returnsFalse_WhenValueIsEqual() {
        Filter filter = Filters.greaterThan(PROPERTY_AGE, VALUE_AGE);

        assertFalse(filter.matches(USER));
    }

    @Test
    void returnsFalse_WhenValueIsLess() {
        Filter filter = Filters.greaterThan(PROPERTY_AGE, VALUE_AGE_ABOVE);

        assertFalse(filter.matches(USER));
    }

    @Test
    void returnsFalse_WhenPropertyDoesNotExist() {
        Filter filter = Filters.greaterThan(PROPERTY_UNKNOWN, VALUE_AGE);

        assertFalse(filter.matches(USER));
    }
}
