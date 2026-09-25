package com.example.filter;

public final class EqualsFilter extends AbstractPropertyValueFilter {

    public EqualsFilter(String property, String value) {
        super(property, value);
    }

    @Override
    public <T> T accept(FilterVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
