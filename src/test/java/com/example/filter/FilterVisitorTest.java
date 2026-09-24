package com.example.filter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilterVisitorTest {

    private static class TypeVisitor implements FilterVisitor<String> {

        @Override
        public String visit(TrueFilter filter) {
            return "true";
        }

        @Override
        public String visit(FalseFilter filter) {
            return "false";
        }

        @Override
        public String visit(AndFilter filter) {
            return "and";
        }

        @Override
        public String visit(OrFilter filter) {
            return "or";
        }

        @Override
        public String visit(NotFilter filter) {
            return "not";
        }

        @Override
        public String visit(PropertyPresentFilter filter) {
            return "present";
        }

        @Override
        public String visit(EqualsFilter filter) {
            return "equals";
        }

        @Override
        public String visit(LessThanFilter filter) {
            return "lessThan";
        }

        @Override
        public String visit(GreaterThanFilter filter) {
            return "greaterThan";
        }

        @Override
        public String visit(RegexFilter filter) {
            return "regex";
        }
    }

    @Test
    void visitsEqualsFilter() {
        Filter filter = Filters.equalTo("role", "admin");

        assertEquals("equals", filter.accept(new TypeVisitor()));
    }
}
