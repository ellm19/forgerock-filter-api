package com.example.filter;

import org.junit.jupiter.api.Test;

import static com.example.filter.TestData.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegexFilterTest {

    @Test
    void returnsTrue_WhenRegexMatches() {
        Filter filter = Filters.matchesRegex(PROPERTY_SURNAME, "B.*");

        assertTrue(filter.matches(USER));
    }

    @Test
    void returnsTrue_WhenRegexIsDifferentCase() {
        Filter filter = Filters.matchesRegex(PROPERTY_SURNAME, "b.*");

        assertTrue(filter.matches(USER));
    }

    @Test
    void returnsFalse_WhenRegexDoesNotMatch() {
        Filter filter = Filters.matchesRegex(PROPERTY_SURNAME, "C.*");

        assertFalse(filter.matches(USER));
    }

    @Test
    void returnsFalse_WhenPropertyIsDifferentCase() {
        Filter filter = Filters.matchesRegex(PROPERTY_SURNAME.toUpperCase(), "B.*");

        assertFalse(filter.matches(USER));
    }

    @Test
    void returnsFalse_WhenPropertyDoesNotExist() {
        Filter filter = Filters.matchesRegex(PROPERTY_UNKNOWN, "CF.*");

        assertFalse(filter.matches(USER));
    }
}
