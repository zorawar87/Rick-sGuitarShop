package com.guitarshop.specs;

public enum Style implements SpecValue<Style> {
  A, F;
  
  /**
   * Validates a string value as Mandolin Style enum value
   *
   * @param value this will be validated
   * @return enum value derived from param
   * @throws IllegalArgumentException if raw string could not get validated
   */
  public static Style validate (String value) throws IllegalArgumentException {
    for (Style t : Style.values())
      if (t.equals (
          value.toUpperCase().replaceAll (" ", "")))
        return t;
    throw new IllegalArgumentException (String.format ("%s is no such mandolin style", value));
  }
  
  /**
   * Tests equality of a known Mandolin Style value against a raw string value
   *
   * @param standard enum value to compare against
   * @param value    raw value that is being tested
   * @return Returns <code>true</code> if values are equal; <code>false</code> otherwise
   */
  public boolean testEquality (Style standard, String value) {
    try {
      SoundType test = SoundType.validate (value);
      return standard.equals(test);
    } catch (IllegalArgumentException e) {
      return false;
    }
  }
}
