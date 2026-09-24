package com.example.filter;

import java.util.Map;

public abstract class AbstractFilter implements Filter {

    @Override
    public boolean matches(Map<String, String> resource) {
        return accept(new MatchingVisitor(resource));
    }

    @Override
    public String toString() {
        return accept(new StringFilterVisitor());
    }
}
