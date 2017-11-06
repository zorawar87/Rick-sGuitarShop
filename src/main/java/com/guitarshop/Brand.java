package com.guitarshop;

/**
 * Represents Guitar Brand
 */
enum Brand {
    GIBSON ("Gibson"), FENDER ("Fender"), IBANEZ ("Ibanez"), PAULREEDSMITH ("Paul Reed Smith"),
    EPIPHONE ("Epiphone"), JACKSON ("Jackson"), TAYLOR ("Taylor"), MARTIN ("Martin"),
    YAMAHA ("Yamaha"), RICKENBACKER ("Rickenbacker");
    private final String name;
    Brand (String name) {
        this.name = name;
    }

    /**
     * Validates a string value as Brand enum value.
     * @param value this will be validated
     * @return enum value derived from param
     * @throws IllegalArgumentException if raw string could not get validated
     */
    public static Brand validate (String value) throws IllegalArgumentException {
        for (Brand b : Brand.values()) {
            if (b.name.toLowerCase().replaceAll(" ","")
                 .equals (value.toLowerCase().replaceAll(" ","")))
                return b;
        }
        throw new IllegalArgumentException (String.format ("%s is no such brand.",
                value));
    }

    /**
     * Tests equality of a known Brand value against a raw string value.
     * @param standard enum value to compare against
     * @param value raw value that is being tested
     * @return Returns <code>true</code> if values are equal
     * @throws IllegalArgumentException if raw string could not get validated
     */
    public static boolean testEquality (Brand standard, String value) throws IllegalArgumentException {
        try {
            Brand test = Brand.validate (value);
            return standard == test;
        } catch (IllegalArgumentException e) {return false;}
    }

    /**
     * Returns a string representation of this Brand
     */
    @Override
    public String toString() {
        return name;
    }
}
