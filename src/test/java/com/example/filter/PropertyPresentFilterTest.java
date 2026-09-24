package com.example.filter;

import org.junit.jupiter.api.Test;

import static com.example.filter.TestData.USER;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PropertyPresentFilterTest {

    @Test
    void returnsTrue_WhenPropertyIsPresent() {
        Filter filter = Filters.present("role");

        assertTrue(filter.matches(USER));
    }

    @Test
    void returnsFalse_WhenPropertyIsNotPresent() {
        Filter filter = Filters.present("role");

        assertFalse(filter.matches(USER));
    }
}
