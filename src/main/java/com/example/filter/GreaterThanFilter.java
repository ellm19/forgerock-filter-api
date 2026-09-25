package com.example.filter;

public final class GreaterThanFilter extends AbstractPropertyValueFilter {

    public GreaterThanFilter(String property, String value) {
        super(property, value);
    }

    @Override
    public <T> T accept(FilterVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
