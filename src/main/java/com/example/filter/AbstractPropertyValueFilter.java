package com.example.filter;

import java.util.Objects;

public abstract class AbstractPropertyValueFilter extends AbstractFilter {

    private final String property;
    private final String value;

    protected AbstractPropertyValueFilter(String property, String value) {
        this.property = Objects.requireNonNull(property);
        this.value = Objects.requireNonNull(value);
    }

    public final String getProperty() {
        return property;
    }

    public final String getValue() {
        return value;
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AbstractPropertyValueFilter other = (AbstractPropertyValueFilter) obj;
        return property.equals(other.property) && value.equals(other.value);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getClass(), property, value);
    }
}
