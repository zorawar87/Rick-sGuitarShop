package com.guitarshop.specs;

/**
 * Represents Instrument Specification Property for Instrument Name
 * @author Zorawar Moolenaar
 * @since 2.0
 * @version 2.0
 */
public enum InstrumentName implements SpecValue {
  GUITAR("Guitar"), MANDOLIN("Mandolin"), BANJO("Banjo"), DOBRO("Dobro"), FIDDLE("Fiddle"), BASS("Bass");
  private final String name;
  
  InstrumentName(String name) {
    this.name = name;
  }
  
  public static InstrumentName validate(String value) throws IllegalArgumentException {
    for (InstrumentName i : InstrumentName.values()) {
      if (i.name.replaceAll (" ", "")
          .equalsIgnoreCase (value.replaceAll (" ", ""))) {
        return i;
      }
    }
    throw new IllegalArgumentException (String.format ("%s is no such brand.",
        value));
  }
  
  /**
   * Tests equality of a known Instrument Name value against a raw string value
   *
   * @param value    raw value that is being tested
   * @return Returns <code>true</code> if values are equal; <code>false</code> otherwise
   */
  public boolean equals(String value){
    try {
      InstrumentName test = InstrumentName.validate (value);
      return this == test;
    } catch (IllegalArgumentException e) {
      return false;
    }
  }
  
  @Override
  public String toString(){ return name; }
}
