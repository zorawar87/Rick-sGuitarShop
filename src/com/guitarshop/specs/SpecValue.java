package com.guitarshop.specs;

public interface SpecValue<E extends Enum> {
  boolean testEquality(E standard, String value);
  
  /**
   * Tests equality of two <code>SpecValue</code> values.
   *
   * @param val1 value to compare against
   * @param val2 value to compare with
   * @return Returns <code>true</code> if values are equal; <code>false</code> otherwise
   */
  static boolean testEquality(SpecValue val1, SpecValue val2) {
    return val1.equals(val2);
  }
}
