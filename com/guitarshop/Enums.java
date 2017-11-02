package com.guitarshop;

/**
 * Represents Guitar Brand
 */
@SuppressWarnings ("SpellCheckingInspection")
enum Brand {
  GIBSON ("Gibson"), FENDER ("Fender"), IBANEZ ("Ibanez"), PAULREEDSMITH ("Paul Reed Smith"), EPIPHONE ("Epiphone"), JACKSON ("Jackson"), TAYLOR ("Taylor"), MARTIN ("Martin"), YAMAHA ("Yamaha"), RICKENBACKER ("Rickenbacker");
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
  private static Brand validate (String value) throws IllegalArgumentException {
    for (Brand b : Brand.values()) {
      if (b.name.toLowerCase().equals (value.toLowerCase()))
        return b;
    }
    throw new IllegalArgumentException (String.format ("%s is no such brand\n",
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

/**
 * Represents Guitar SoundType
 */
enum SoundType {
  ACOUSTIC ("Acoustic"), ELECTRIC ("Electric");
  private final String name;
  SoundType (String s) {
    name = s;
  }

  /**
   * Validates a string value as SoundType enum value
   * @param value this will be validated
   * @return enum value derived from param
   * @throws IllegalArgumentException if raw string could not get validated
   */
  private static SoundType validate (String value) throws IllegalArgumentException {
    for (SoundType t : SoundType.values())
      if (t.name.toLowerCase().replaceAll ("\\s",
      "").equals (value.toLowerCase().replaceAll ("\\s", "")))
        return t;
    throw new IllegalArgumentException ("no such sound type");
  }

  /**
   * Tests equality of a known SoundType value against a raw string value
   * @param standard enum value to compare against
   * @param value raw value that is being tested
   * @return Returns <code>true</code> if values are equal
   * @throws IllegalArgumentException if raw string could not get validated
   */
  public static boolean testEquality (SoundType standard, String value) throws IllegalArgumentException {
    try {
      SoundType test = SoundType.validate (value);
      return standard == test;
    } catch (IllegalArgumentException e) {return false;}
  }

  /**
   * Returns a string representation of this SoundType
   */
  @Override
  public String toString() {
    return name;
  }
}

/**
 * Represents Guitar Wood Type
 */
enum Wood {
  ROSEWOOD ("Rosewood"), ALDER ("Alder"), MAHOGANY ("Mahogany"), CEDAR ("Cedar");
  private final String name;
  Wood (String name) {
    this.name = name;
  }

  /**
   * Validates a string value as Wood enum value
   * @param value this will be validated
   * @return enum value derived from param
   * @throws IllegalArgumentException if raw string could not get validated
   */
  private static Wood validate (String value) throws IllegalArgumentException {
    for (Wood w : Wood.values())
      if (w.name.toLowerCase().equals (value.toLowerCase()))
        return w;
    throw new IllegalArgumentException ("no such wood");
  }

  /**
   * Tests equality of a known Wood value against a raw string value
   * @param standard enum value to compare against
   * @param value raw value that is being tested
   * @return Returns <code>true</code> if values are equal
   * @throws IllegalArgumentException if raw string could not get validated
   */
  public static boolean testEquality (Wood standard, String value) throws IllegalArgumentException {
    try {
      Wood test = Wood.validate (value);
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

