package com.example.filter;

public final class TrueFilter extends AbstractFilter {

    @Override
    public <T> T accept(FilterVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
