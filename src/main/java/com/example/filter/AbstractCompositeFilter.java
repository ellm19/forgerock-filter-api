package com.example.filter;

import java.util.List;
import java.util.Objects;

public abstract class AbstractCompositeFilter extends AbstractFilter {

    private final List<Filter> subFilters;

    protected AbstractCompositeFilter(Filter... subFilters) {
        this.subFilters = List.of(subFilters);
    }

    public final List<Filter> getSubFilters() {
        return subFilters;
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        return subFilters.equals(((AbstractCompositeFilter) obj).subFilters);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getClass(), subFilters);
    }
}
