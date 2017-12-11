package com.guitarshop.specs;

/**
 * Interface that all instrument properties should follow
 *
 * @author Zorawar Moolenaar
 * @version 2.0
 * @since 2.0
 */
public interface SpecValue {
  /**
   * Tests equality of this value again the given value.
   *
   * @param value to compare against
   * @return true if the values are equal; false otherwise
   */
  default boolean equals(String value){
    return this.equals(value);
  }
  
}
