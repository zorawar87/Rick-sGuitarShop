package com.guitarshop;

/**
 * Represents Mandolin Styles
 */
enum MandolinStyle{
    A("A"), F("F");
    private final String name;

    MandolinStyle(String name) {
        this.name = name;
    }

    /**
     * Validates a string value as MandolinStyle enum value
     *
     * @param value this will be validated
     * @return enum value derived from param
     * @throws IllegalArgumentException if raw string could not get validated
     */
    public static MandolinStyle validate(String value) throws IllegalArgumentException {
        for (MandolinStyle w : MandolinStyle.values())
            if (w.name.toLowerCase().equals(
                    value.toLowerCase().replaceAll(" ", "")))
                return w;
        throw new IllegalArgumentException(String.format("%s is no such wood", value));
    }

    /**
     * Tests equality of a known MandolinStyle value against a raw string value
     *
     * @param standard enum value to compare against
     * @param value    raw value that is being tested
     * @return Returns <code>true</code> if values are equal
     * @throws IllegalArgumentException if raw string could not get validated
     */
    public static boolean testEquality(MandolinStyle standard, String value) throws IllegalArgumentException {
        try {
            MandolinStyle test = MandolinStyle.validate(value);
            return standard == test;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    /**
     * Returns a string representation of this Mandolin Style
     */
    @Override
    public String toString() {
        return name;
    }
}

