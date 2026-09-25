package com.example.filter;

public final class AndFilter extends AbstractCompositeFilter {

    public AndFilter(Filter... subFilters) {
        super(subFilters);
    }

    @Override
    public <T> T accept(FilterVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
