package com.example.filter;

import org.junit.jupiter.api.Test;

import static com.example.filter.TestData.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EqualsFilterTest {

    @Test
    void returnsTrue_WhenValueMatches() {
        Filter filter = Filters.equalTo(PROPERTY_ROLE, VALUE_ROLE);

        assertTrue(filter.matches(USER));
    }

    @Test
    void returnsTrue_WhenValueIsDifferentCase() {
        Filter filter = Filters.equalTo(PROPERTY_ROLE, VALUE_ROLE.toUpperCase());

        assertTrue(filter.matches(USER));
    }

    @Test
    void returnsFalse_WhenValueDoesNotMatch() {
        Filter filter = Filters.equalTo(PROPERTY_ROLE, VALUE_UNKNOWN);

        assertFalse(filter.matches(USER));
    }

    @Test
    void returnsFalse_WhenPropertyIsDifferentCase() {
        Filter filter = Filters.equalTo(PROPERTY_ROLE.toUpperCase(), VALUE_ROLE);

        assertFalse(filter.matches(USER));
    }

    @Test
    void returnsFalse_WhenPropertyDoesNotExist() {
        Filter filter = Filters.equalTo(PROPERTY_UNKNOWN, VALUE_UNKNOWN);

        assertFalse(filter.matches(USER));
    }
}
