package com.guitarshop.specs;

/**
 * Represents Instrument Specification Property for Mandolin Style
 *
 * @author Zorawar Moolenaar
 * @version 2.0
 * @since 1.1
 */
public enum Style implements SpecValue {
  A("A"), F("A");
  private final String name;
  
  Style(String s) {
    name = s;
  }
  
  
  /**
   * Validates a string value as Mandolin Style enum value
   *
   * @param value this will be validated
   * @return enum value derived from param
   * @throws IllegalArgumentException if raw string could not get validated
   */
  public static Style validate(String value) throws IllegalArgumentException {
    for (Style t : Style.values())
      if (t.name.equalsIgnoreCase(
          value.replaceAll(" ", "")))
        return t;
    throw new IllegalArgumentException(String.format("%s is no such mandolin style", value));
  }
  
  /**
   * Tests equality of this Mandolin Style value against a raw string value
   *
   * @param value    raw value that is being tested
   * @return Returns <code>true</code> if values are equal; <code>false</code> otherwise
   */
  public boolean equals(String value) {
    try {
      Style test = Style.validate(value);
      return this == test;
    } catch (IllegalArgumentException e) {
      return false;
    }
  }
}
