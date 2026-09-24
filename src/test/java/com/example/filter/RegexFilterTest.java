package com.example.filter;

import org.junit.jupiter.api.Test;

import static com.example.filter.TestData.USER;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegexFilterTest {

    @Test
    void returnsTrue_WhenRegexMatches() {
        Filter filter = Filters.matchesRegex("name", "Jane.*");

        assertTrue(filter.matches(USER));
    }

    @Test
    void returnsTrue_WhenRegexIsDifferentCase() {
        Filter filter = Filters.matchesRegex("name", "jane.*");

        assertTrue(filter.matches(USER));
    }

    @Test
    void returnsFalse_WhenRegexDoesNotMatch() {
        Filter filter = Filters.matchesRegex("name", "Bob.*");

        assertFalse(filter.matches(USER));
    }

    @Test
    void returnsFalse_WhenPropertyIsDifferentCase() {
        Filter filter = Filters.matchesRegex("NAME", "jane.*");

        assertFalse(filter.matches(USER));
    }
}
