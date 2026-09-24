package com.example.filter;

public final class LessThanFilter extends AbstractPropertyValueFilter {
    public LessThanFilter(String property, String value) {
        super(property, value);
    }

    @Override
    public <T> T accept(FilterVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
