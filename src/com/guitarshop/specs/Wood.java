package com.guitarshop.specs;

/**
 * Represents Guitar Wood Type
 */
enum Wood implements SpecValue<Wood> {
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
   * @return Returns <code>true</code> if values are equal; <code>false</code> otherwise
   */
  public boolean testEquality (Wood standard, String value) {
    try {
      Wood test = Wood.validate (value);
      return standard == test;
    } catch (IllegalArgumentException e) {
      return false;
    }
  }

  /**
   * Returns a string representation of this Builder
   */
  @Override
  public String toString() {
    return name;
  }
}

