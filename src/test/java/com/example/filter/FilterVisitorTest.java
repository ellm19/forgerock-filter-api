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

        @Override
        public String visit(ExclusiveOrFilter filter) {
            return "exclusiveOr";
        }
    }

    @Test
    void visitsTrueFilter() {
        assertEquals("true", Filters.TRUE.accept(new TypeVisitor()));
    }

    @Test
    void visitsFalseFilter() {
        assertEquals("false", Filters.FALSE.accept(new TypeVisitor()));
    }

    @Test
    void visitsAndFilter() {
        Filter filter = Filters.and(Filters.TRUE, Filters.FALSE);
        assertEquals("and", filter.accept(new TypeVisitor()));
    }

    @Test
    void visitsOrFilter() {
        Filter filter = Filters.or(Filters.TRUE, Filters.FALSE);
        assertEquals("or", filter.accept(new TypeVisitor()));
    }

    @Test
    void visitsNotFilter() {
        Filter filter = Filters.not(Filters.TRUE);
        assertEquals("not", filter.accept(new TypeVisitor()));
    }

    @Test
    void visitsPropertyPresentFilter() {
        Filter filter = Filters.present("role");
        assertEquals("present", filter.accept(new TypeVisitor()));
    }

    @Test
    void visitsLessThanFilter() {
        Filter filter = Filters.lessThan("age", "35");
        assertEquals("lessThan", filter.accept(new TypeVisitor()));
    }

    @Test
    void visitsGreaterThanFilter() {
        Filter filter = Filters.greaterThan("age", "35");
        assertEquals("greaterThan", filter.accept(new TypeVisitor()));
    }

    @Test
    void visitsRegexFilter() {
        Filter filter = Filters.matchesRegex("name", "Joe.*");
        assertEquals("regex", filter.accept(new TypeVisitor()));
    }

    @Test
    void visitsExclusiveOrFilter() {
        Filter filter = Filters.exclusiveOr(Filters.TRUE, Filters.FALSE);
        assertEquals("exclusiveOr", filter.accept(new TypeVisitor()));
    }
}
