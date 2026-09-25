package com.example.filter;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static com.example.filter.TestData.USER;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrueFilterTest {

    @Test
    void returnsTrue() {
        Filter filter = Filters.TRUE;

        // Demonstrates that the filter returns true in all circumstances
        assertTrue(filter.matches(Map.of()));
        assertTrue(filter.matches((USER)));
    }
}
