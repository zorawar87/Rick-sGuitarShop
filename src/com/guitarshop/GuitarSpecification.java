package com.guitarshop;

/**
 * Describes guitar specification
 *
 * @author Zorawar Moolenaar
 * @version 1.1
 */
public class GuitarSpecification {
  /** brand of the guitar */
  Brand brand;
  /** model of the guitar */
  String model;
  /** sound type of the guitar */
  SoundType type;
  /** top wood of the guitar */
  Wood topWood; 
  /** back wood of the guitar */
  Wood backWood;

  /**
   * Set the brand of this guitar.
   *
   * @param value to set as brand
   */
  public void setBrand(String value) {
      brand = Brand.validate(value);
  }

  /**
   * Set the model of this guitar.
   *
   * @param value to set as model
   */
  public void setModel(String value) {
      model = value;
  }

  /**
   * Set the type of this guitar.
   *
   * @param value to set as type
   */
  public void setSoundType(String value) {
      type = SoundType.validate(value);
  }

  /**
   * Set the top wood type of this guitar.
   *
   * @param value to set as topWood
   */
  public void setTopWood(String value) {
      topWood = Wood.validate(value);
  }

  /**
   * Set the back wood type of this guitar.
   *
   * @param value to set as backWood
   */
  public void setBackWood(String value) {
      backWood = Wood.validate(value);
  }

  /**
   * returns the brand name of the guitar
   * @return brand name of the guitar
   */
  public Brand getBrand(){ return brand; }
  /**
   * returns the model of the guitar
   * @return model name of the guitar
   */
  public String getModel(){ return model; }
  /**
   * returns the sound type of the guitar
   * @return sound type of the guitar
   */
  public SoundType getType(){ return type; }
  /**
   * returns the top wood type of the guitar
   * @return top wood type of the guitar
   */
  public Wood getTopWood(){ return topWood; }
  /**
   * returns the back wood type of the guitar
   * @return back wood type of the guitar
   */
  public Wood getBackWood(){ return backWood; }

  /**
   * Creates a GuitarSpecificationBuilder
   *
   * @return GuitarSpecificationBuilder
   */
  public static GuitarSpecificationBuilder builder() {
      return new GuitarSpecificationBuilder();
  }

  /**
   * Returns <code>true</code> if this guitar specification contains property.
   *
   * @param property String to look for
   * @return <code>true</code> if the item contains the property; <code>false</code> otherwise
   */
  public boolean contains(String property) {
    property = property.toLowerCase();
    return Brand.testEquality(brand, property)
            || property.equals(model.toLowerCase())
            || SoundType.testEquality(type, property)
            || Wood.testEquality(topWood, property)
            || Wood.testEquality(backWood, property);
  }

  /**
   * matches Guitar Specifications
   * @param template to match
   * @return true if the current spec matches the template
   */
  public boolean matches(GuitarSpecification template){
    return
      (Brand.testEquality(Brand.WILDCARD, template.brand) || Brand.testEquality(brand, template.brand))
      && 
      (SoundType.testEquality(SoundType.WILDCARD, template.type) || SoundType.testEquality(type, template.type))
      &&
      (template.model.equals("*") || template.model.toLowerCase().equals(model.toLowerCase()))
      && 
      (Wood.testEquality(Wood.WILDCARD, template.topWood) || Wood.testEquality(topWood, template.topWood))
      && 
      (Wood.testEquality(Wood.WILDCARD, template.backWood) || Wood.testEquality(backWood, template.backWood));
  }

  /**
   * Returns a string representation of this guitar.
   *
   * @return formatted string representation
   */
  @Override
  public String toString() {
      return String.format(
              "\t| %-19s | %-18s | %-10s        | %-10s | %-10s |\n",
              brand, model, type, topWood, backWood);
  }

}
