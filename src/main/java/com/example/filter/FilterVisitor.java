package com.example.filter;

public interface FilterVisitor<T> {

    T visit(TrueFilter filter);

    T visit(FalseFilter filter);

    T visit(AndFilter filter);

    T visit(OrFilter filter);

    T visit(NotFilter filter);

    T visit(PropertyPresentFilter filter);

    T visit(EqualsFilter filter);

    T visit(LessThanFilter filter);

    T visit(GreaterThanFilter filter);

    T visit(RegexFilter filter);

    T visit(ExclusiveOrFilter filter);
}
