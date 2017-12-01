package com.guitarshop;

/**
 * Represents Guitar Wood Type
 */
enum Wood {
  ROSEWOOD ("Rosewood"), ALDER ("Alder"), MAHOGANY ("Mahogany"), CEDAR ("Cedar"), WILDCARD ("*");
  private final String name;

  Wood (String name) {
    this.name = name;
  }

  /**
   * Validates a string value as Wood enum value
   *
   * @param value this will be validated
   * @return enum value derived from param
   * @throws IllegalArgumentException if raw string could not get validated
   */
  public static Wood validate (String value) throws IllegalArgumentException {
    for (Wood w : Wood.values())
      if (w.name.toLowerCase().equals (
            value.toLowerCase().replaceAll (" ", "")))
        return w;
    throw new IllegalArgumentException (String.format ("%s is no such wood", value));
  }

  /**
   * Tests equality of a known Wood value against a raw string value
   *
   * @param standard enum value to compare against
   * @param value    raw value that is being tested
   * @return Returns <code>true</code> if values are equal
   * @throws IllegalArgumentException if raw string could not get validated
   */
  public static boolean testEquality (Wood standard, String value) throws IllegalArgumentException {
    try {
      Wood test = Wood.validate (value);
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
  public static boolean testEquality (Wood val1, Wood val2) {
    return val1 == val2;
  }

  /**
   * Returns a string representation of this Brand
   */
  @Override
  public String toString() {
    return name;
  }
}

