package com.example.filter;

public final class OrFilter extends AbstractCompositeFilter {
    public OrFilter(Filter... subFilters) {
        super(subFilters);
    }

    @Override
    public <T> T accept(FilterVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
