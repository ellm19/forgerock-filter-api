package com.example.filter;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilterIntegrationTest {

    @Test
    void matchesAdministratorsOlderThan30() {
        // Create user resource having various properties
        Map<String, String> user = new LinkedHashMap<>();
        user.put("firstname", "Joe");
        user.put("surname", "Bloggs");
        user.put("role", "administrator");
        user.put("age", "35");

        // Create a filter which matches all administrators older than 30
        Filter filter = Filters.and(
                Filters.equalTo("role", "administrator"),
                Filters.greaterThan("age", "30")
        );

        // Filter should match
        assertTrue(filter.matches(user));

        user.put("age", "25");

        // Filter should not match
        assertFalse(filter.matches(user));
    }
}
