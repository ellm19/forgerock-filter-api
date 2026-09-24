package com.example.filter;

import org.junit.jupiter.api.Test;

import static com.example.filter.TestData.USER;
import static org.junit.jupiter.api.Assertions.*;

public class GreaterThanFilterTest {

    @Test
    void returnsTrue_WhenValueIsGreater() {
        Filter filter = Filters.greaterThan("age", "25");

        assertTrue(filter.matches(USER));
    }

    @Test
    void returnsFalse_WhenValueIsEqual() {
        Filter filter = Filters.greaterThan("age", "30");

        assertFalse(filter.matches(USER));
    }

    @Test
    void returnsFalse_WhenValueIsLess() {
        Filter filter = Filters.greaterThan("age", "35");

        assertFalse(filter.matches(USER));
    }
}
