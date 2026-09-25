package com.example.filter;

import org.junit.jupiter.api.Test;

import static com.example.filter.TestData.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LessThanFilterTest {

    @Test
    void returnsTrue_WhenValueIsLess() {
        Filter filter = Filters.lessThan(PROPERTY_AGE, VALUE_AGE_ABOVE);

        assertTrue(filter.matches(USER));
    }

    @Test
    void returnsFalse_WhenValueIsEqual() {
        Filter filter = Filters.lessThan(PROPERTY_AGE, VALUE_AGE);

        assertFalse(filter.matches(USER));
    }

    @Test
    void returnsFalse_WhenValueIsGreater() {
        Filter filter = Filters.lessThan(PROPERTY_AGE, VALUE_AGE_BELOW);

        assertFalse(filter.matches(USER));
    }

    @Test
    void returnsFalse_WhenPropertyDoesNotExist() {
        Filter filter = Filters.lessThan(PROPERTY_UNKNOWN, VALUE_AGE);

        assertFalse(filter.matches(USER));
    }
}
