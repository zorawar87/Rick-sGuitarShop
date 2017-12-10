package com.guitarshop.specs;

/**
 * Represents Instrument Specification Property for Instrument Name
 * @author Zorawar Moolenaar
 * @since 2.0
 * @version 2.0
 */
public enum InstrumentName implements SpecValue<InstrumentName> {
  GUITAR("Guitar"), MANDOLIN("Mandolin"), BANJO("Banjo"), DOBRO("Dobro"), FIDDLE("Fiddle"), BASS("Bass");
  private final String name;
  
  InstrumentName(String name) {
    this.name = name;
  }
  
  public static InstrumentName validate(String value) throws IllegalArgumentException {
    for (InstrumentName i : InstrumentName.values()) {
      if (i.name.toLowerCase().replaceAll (" ", "")
          .equals (value.toLowerCase().replaceAll (" ", ""))) {
        return i;
      }
    }
    throw new IllegalArgumentException (String.format ("%s is no such brand.",
        value));
  }
  
  /**
   * Tests equality of a known Instrument Name value against a raw string value
   *
   * @param standard enum value to compare against
   * @param value    raw value that is being tested
   * @return Returns <code>true</code> if values are equal; <code>false</code> otherwise
   */
  public boolean testEquality(InstrumentName standard, String value){
    try {
      InstrumentName test = InstrumentName.validate (value);
      return standard == test;
    } catch (IllegalArgumentException e) {
      return false;
    }
  }
}
