package com.example.filter;

import java.util.Map;

public class TestData {

    public static final String PROPERTY_FIRST_NAME = "firstname";
    public static final String PROPERTY_SURNAME = "surname";
    public static final String PROPERTY_ROLE = "role";
    public static final String PROPERTY_AGE = "age";
    public static final String PROPERTY_UNKNOWN = "PROPERTY_UNKNOWN";

    public static final String VALUE_FIRST_NAME = "Joe";
    public static final String VALUE_SURNAME = "Bloggs";
    public static final String VALUE_ROLE = "administrator";
    public static final String VALUE_AGE = "35";
    public static final String VALUE_UNKNOWN = "VALUE_UNKNOWN";

    public static final String VALUE_AGE_BELOW = String.valueOf(Integer.parseInt(VALUE_AGE) - 5); // "30"
    public static final String VALUE_AGE_ABOVE = String.valueOf(Integer.parseInt(VALUE_AGE) + 5);  // "40"

    public static final Map<String, String> USER = Map.of(
            PROPERTY_FIRST_NAME, VALUE_FIRST_NAME,
            PROPERTY_SURNAME, VALUE_SURNAME,
            PROPERTY_ROLE, VALUE_ROLE,
            PROPERTY_AGE, VALUE_AGE
    );


}
