package com.example.filter;

import java.util.Objects;

public final class NotFilter extends AbstractFilter {

    private final Filter subFilter;

    public NotFilter(Filter filter) {
        this.subFilter = Objects.requireNonNull(filter);
    }

    @Override
    public <T> T accept(FilterVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Filter getSubFilter() {
        return subFilter;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof NotFilter)) return false;
        return subFilter.equals(((NotFilter) obj).subFilter);
    }

    @Override
    public int hashCode() { return Objects.hash(NotFilter.class, subFilter); }
}
