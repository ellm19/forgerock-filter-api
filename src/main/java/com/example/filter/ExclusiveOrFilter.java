package com.example.filter;

public final class ExclusiveOrFilter extends AbstractCompositeFilter {

    public ExclusiveOrFilter(Filter... subFilters) {
        super(subFilters);
    }

    @Override
    public <T> T accept(FilterVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
