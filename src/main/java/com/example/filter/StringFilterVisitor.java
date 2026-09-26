package com.example.filter;

import java.util.stream.Collectors;

public final class StringFilterVisitor implements FilterVisitor<String> {

    @Override
    public String visit(TrueFilter filter) {
        return "true";
    }

    @Override
    public String visit(FalseFilter filter) {
        return "false";
    }

    @Override
    public String visit(EqualsFilter filter) {
        return filter.getProperty() + " == \"" + filter.getValue() + "\"";
    }

    @Override
    public String visit(PropertyPresentFilter filter) {
        return filter.getProperty() + " present";
    }

    @Override
    public String visit(GreaterThanFilter filter) {
        return filter.getProperty() + " > \"" + filter.getValue() + "\"";
    }

    @Override
    public String visit(LessThanFilter filter) {
        return filter.getProperty() + " < \"" + filter.getValue() + "\"";
    }

    @Override
    public String visit(RegexFilter filter) {
        return filter.getProperty() + " matches \"" + filter.getValue() + "\"";
    }

    @Override
    public String visit(NotFilter filter) {
        return "NOT (" + filter.getSubFilter().accept(this) + ")";
    }

    @Override
    public String visit(AndFilter filter) {
        return filter.getSubFilters()
                .stream()
                .map(child -> child.accept(this))
                .collect(Collectors.joining(" AND ", "(", ")"));
    }

    @Override
    public String visit(OrFilter filter) {
        return filter.getSubFilters()
                .stream()
                .map(child -> child.accept(this))
                .collect(Collectors.joining(" OR ", "(", ")"));
    }

    @Override
    public String visit(ExclusiveOrFilter filter) {
        return filter.getSubFilters()
                .stream()
                .map(child -> child.accept(this))
                .collect(Collectors.joining(" XOR ", "(", ")"));
    }
}
