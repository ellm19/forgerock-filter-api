package com.example.filter;

public final class FalseFilter extends AbstractFilter {

    @Override
    public <T> T accept(FilterVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
