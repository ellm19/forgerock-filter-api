package com.example.filter;

public final class RegexFilter extends AbstractPropertyValueFilter {
    public RegexFilter(String property, String value) {
        super(property, value);
    }

    @Override
    public <T> T accept(FilterVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
