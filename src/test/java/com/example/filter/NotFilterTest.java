package com.example.filter;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static com.example.filter.TestData.USER;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NotFilterTest {

    @Test
    void returnsTrue_WhenFilterDoesNotMatch() {
        Filter filter = Filters.not(
                Filters.equalTo("role", "customer")
        );

        assertTrue(filter.matches(USER));
    }

    @Test
    void returnsTrue_WhenFilterIsFalse() {
        Filter filter = Filters.not(Filters.FALSE);

        assertTrue(filter.matches(Map.of()));
    }

    @Test
    void returnsFalse_WhenFilterMatches() {
        Filter filter = Filters.not(
                Filters.equalTo("role", "administrator")
        );

        assertFalse(filter.matches(USER));
    }

    @Test
    void returnsFalse_WhenFilterIsTrue() {
        Filter filter = Filters.not(Filters.TRUE);

        assertFalse(filter.matches(Map.of()));
    }
}
