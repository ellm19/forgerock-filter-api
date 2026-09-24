package com.example.filter;

import org.junit.jupiter.api.Test;

import static com.example.filter.TestData.USER;
import static org.junit.jupiter.api.Assertions.*;

public class EqualsFilterTest {

    @Test
    void returnsTrue_WhenValueMatches() {
        Filter filter = Filters.equalTo("role", "administrator");

        assertTrue(filter.matches(USER));
    }

    @Test
    void returnsTrue_WhenValueIsDifferentCase() {
        Filter filter = Filters.equalTo("role", "ADMINISTRATOR");

        assertTrue(filter.matches(USER));
    }

    @Test
    void returnsFalse_WhenValueDoesNotMatch() {
        Filter filter = Filters.equalTo("role", "customer");

        assertFalse(filter.matches(USER));
    }

    @Test
    void returnsFalse_WhenPropertyIsDifferentCase() {
        Filter filter = Filters.equalTo("ROLE", "administrator");

        assertFalse(filter.matches(USER));
    }
}
