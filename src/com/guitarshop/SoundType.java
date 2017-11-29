package com.guitarshop;

/**
 * Represents Guitar SoundType
 */
enum SoundType {
    ACOUSTIC("Acoustic"), ELECTRIC("Electric"), WILDCARD("*");
    private final String name;

    SoundType(String s) {
        name = s;
    }

    /**
     * Validates a string value as SoundType enum value
     *
     * @param value this will be validated
     * @return enum value derived from param
     * @throws IllegalArgumentException if raw string could not get validated
     */
    public static SoundType validate(String value) throws IllegalArgumentException {
        for (SoundType t : SoundType.values())
            if (t.name.toLowerCase().equals(
                    value.toLowerCase().replaceAll(" ", "")))
                return t;
        throw new IllegalArgumentException(String.format("%s is no such sound type", value));
    }

    /**
     * Tests equality of a known SoundType value against a raw string value
     *
     * @param standard enum value to compare against
     * @param value    raw value that is being tested
     * @return Returns <code>true</code> if values are equal
     * @throws IllegalArgumentException if raw string could not get validated
     */
    public static boolean testEquality(SoundType standard, String value) throws IllegalArgumentException {
        try {
            SoundType test = SoundType.validate(value);
            return standard == test;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    /**
     * Tests equality of two enum values.
     *
     * @param val1 enum value 1
     * @param val2 enum value 2
     * @return Returns <code>true</code> if values are equal
     */
    public static boolean testEquality(SoundType val1, SoundType val2){
        return val1 == val2;
    }

    /**
     * Returns a string representation of this SoundType
     */
    @Override
    public String toString() {
        return name;
    }
}
