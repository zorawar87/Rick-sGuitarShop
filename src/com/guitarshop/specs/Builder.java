package com.guitarshop.specs;

/**
 * Represents Instrument Specification Property for an instrument Builder
 *
 * @author Zorawar Moolenaar
 * @version 2.0
 * @since 1.0
 */
public enum Builder implements SpecValue {
  GIBSON ("Gibson"), FENDER ("Fender"), IBANEZ ("Ibanez"), PAULREEDSMITH ("Paul Reed Smith"),
  EPIPHONE ("Epiphone"), JACKSON ("Jackson"), TAYLOR ("Taylor"), MARTIN ("Martin"),
  YAMAHA ("Yamaha"), RICKENBACKER ("Rickenbacker"), WILDCARD ("*");
  private final String name;

  Builder(String name) {
    this.name = name;
  }

  /**
   * Validates a <code>String</code> value as <code>Builder</code> enum value.
   *
   * @param value this will be validated
   * @return enum value derived from param
   * @throws IllegalArgumentException if raw string could not get validated
   */
  public static Builder validate(String value) throws IllegalArgumentException {
    for (Builder b : Builder.values()) {
      if (b.name.replaceAll (" ", "")
          .equalsIgnoreCase (value.replaceAll (" ", ""))) {
        return b;
      }
    }
    throw new IllegalArgumentException (String.format ("%s is no such builder.",
                                        value));
  }

  /**
   * Tests equality of a known Builder value against a raw string value.
   *
   * @param value    raw value that is being tested
   * @return Returns <code>true</code> if values are equal; <code>false</code> otherwise
   * @throws IllegalArgumentException if raw string could not get validated
   */
  public boolean equals (String value) {
    try {
      SpecValue test = Builder.validate (value);
      return this == test;
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
