package com.example.filter;

import org.junit.jupiter.api.Test;

import static com.example.filter.TestData.USER;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LessThanFilterTest {

    @Test
    void returnsTrue_WhenValueIsLess() {
        Filter filter = Filters.lessThan("age", "35");

        assertTrue(filter.matches(USER));
    }

    @Test
    void returnsFalse_WhenValueIsEqual() {
        Filter filter = Filters.lessThan("age", "30");

        assertFalse(filter.matches(USER));
    }

    @Test
    void returnsFalse_WhenValueIsGreater() {
        Filter filter = Filters.lessThan("age", "25");

        assertFalse(filter.matches(USER));
    }
}
