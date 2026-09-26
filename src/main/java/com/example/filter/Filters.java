package com.example.filter;

public final class Filters {

    private Filters() {}

    public static Filter and(Filter... filters) { return new AndFilter(filters); }
    public static Filter or(Filter... filters) { return new OrFilter(filters); }
    public static Filter not(Filter subFilter) { return new NotFilter(subFilter); }
    public static Filter equalTo(String property, String value) { return new EqualsFilter(property, value); }
    public static Filter present(String property) { return new PropertyPresentFilter(property); }
    public static Filter lessThan(String property, String value) { return new LessThanFilter(property, value); }
    public static Filter greaterThan(String property, String value) { return new GreaterThanFilter(property, value); }
    public static Filter matchesRegex(String property, String pattern) { return new RegexFilter(property, pattern); }
    public static Filter exclusiveOr(Filter... filters) { return new ExclusiveOrFilter(filters); }
    public static final Filter TRUE = new TrueFilter();
    public static final Filter FALSE = new FalseFilter();
}
