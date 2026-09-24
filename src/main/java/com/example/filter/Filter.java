package com.example.filter;

import java.util.Map;

public interface Filter {

    boolean matches(Map<String, String> resource);

    <T> T accept(FilterVisitor<T> visitor);
}
