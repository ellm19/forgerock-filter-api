package com.example.filter;

import java.util.Objects;

public final class PropertyPresentFilter extends AbstractFilter {

    private final String property;

    public PropertyPresentFilter(String property) {
        this.property = Objects.requireNonNull(property);
    }

    @Override
    public <T> T accept(FilterVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public String getProperty() {
        return property;
    }
}
