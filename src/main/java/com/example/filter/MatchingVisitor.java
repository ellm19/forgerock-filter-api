package com.example.filter;

import java.util.Map;
import java.util.regex.Pattern;

public final class MatchingVisitor implements FilterVisitor<Boolean> {

    private final Map<String, String> resource;

    public MatchingVisitor(Map<String, String> resource) {
        this.resource = resource;
    }

    @Override
    public Boolean visit(TrueFilter filter) {
        return true;
    }

    @Override
    public Boolean visit(FalseFilter filter) {
        return false;
    }

    @Override
    public Boolean visit(AndFilter filter) {
        for (Filter sub : filter.getSubFilters()) {
            if (!sub.accept(this)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public Boolean visit(OrFilter filter) {
        for (Filter sub : filter.getSubFilters()) {
            if (sub.accept(this)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Boolean visit(NotFilter filter) {
        return !filter.getSubFilter().accept(this);
    }

    @Override
    public Boolean visit(PropertyPresentFilter filter) {
        return resource.containsKey(filter.getProperty());
    }

    @Override
    public Boolean visit(EqualsFilter filter) {
        String value = resource.get(filter.getProperty());
        return value != null && value.equalsIgnoreCase(filter.getValue());
    }

    @Override
    public Boolean visit(RegexFilter filter) {
        String value = resource.get(filter.getProperty());

        if (value == null) {
            return false;
        }

        Pattern p = Pattern.compile(filter.getValue(), Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        return p.matcher(value).matches();
    }

    @Override
    public Boolean visit(LessThanFilter filter) {
        String actual = resource.get(filter.getProperty());

        if (actual == null) {
            return false;
        }

        return compare(actual, filter.getValue()) < 0;
    }

    @Override
    public Boolean visit(GreaterThanFilter filter) {
        String actual = resource.get(filter.getProperty());

        if (actual == null) {
            return false;
        }

        return compare(actual, filter.getValue()) > 0;
    }

    @Override
    public Boolean visit(ExclusiveOrFilter filter) {
        int matchCount = 0;

        for (Filter sub : filter.getSubFilters()) {
            if (sub.accept(this)) {
                matchCount++;
            }
        }

        return matchCount == 1;
    }

    private static Double tryParse(String s) {
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private static int compare(String actual, String expected) {
        Double actualNum = tryParse(actual);
        Double expectedNum = tryParse(expected);

        if (actualNum != null && expectedNum != null) {
            return Double.compare(actualNum, expectedNum);
        }

        return actual.compareToIgnoreCase(expected);
    }
}
