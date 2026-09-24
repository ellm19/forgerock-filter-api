package com.example.filter;

import org.junit.jupiter.api.Test;

import static com.example.filter.TestData.USER;
import static org.junit.jupiter.api.Assertions.*;

public class AndFilterTest {

    @Test
    void returnsTrue_WhenAllFiltersMatch() {
        Filter filter = Filters.and(
                Filters.equalTo("role", "administrator"),
                Filters.equalTo("name", "Jane Doe")
        );

        assertTrue(filter.matches(USER));
    }

    @Test
    void returnsFalse_WhenOneFilterDoesNotMatch() {
        Filter filter = Filters.and(
                Filters.equalTo("role", "administrator"),
                Filters.equalTo("name", "Joe Doe")
        );

        assertFalse(filter.matches(USER));
    }

    @Test
    void returnsFalse_WhenAllFiltersDoNotMatch() {
        Filter filter = Filters.and(
                Filters.equalTo("role", "customer"),
                Filters.equalTo("name", "Joe Doe")
        );

        assertFalse(filter.matches(USER));
    }
}
