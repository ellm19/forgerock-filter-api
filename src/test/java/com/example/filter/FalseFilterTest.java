package com.example.filter;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static com.example.filter.TestData.USER;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class FalseFilterTest {

    @Test
    void returnsFalse() {
        Filter filter = Filters.FALSE;

        // Demonstrates that the filter returns false in all circumstances
        assertFalse(filter.matches(Map.of()));
        assertFalse(filter.matches((USER)));
    }
}
