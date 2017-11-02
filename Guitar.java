package com.guitarshop;
/**
 * @author Zorawar Moolenaar
 * @version 0.5
 * describes guitar specifications
 */
public class Guitar {
  private Metadata meta;
  private Brand brand;
  private String model;
  private float price;
  private SoundType type;
  private Wood topWood, backWood;

  /**
   * Creates a GuitarBuilder in accordance with the Builder Design Pattern
   * @return GuitarBuilder
   */
  public static GuitarBuilder builder() {
    return new GuitarBuilder();
  }

  /**
   * Get the Serial number
   * @return serial number of object
   */
  public int getSno() { return meta.getSno(); }
  /**
   * Get the guitar brand
   * @return brand of object
   */
  public Brand getBrand() { return brand; }
  /**
   * Returns the model of this guitar.
   * @return model of this guitar
   */
  public String getModel() { return model; }
  /**
   * Returns the price of this guitar.
   * @return price of this guitar
   */
  public Float getPrice() { return price; }
  /**
   * Returns the SoundType of this guitar.
   * @return SoundType of this guitar
   */
  public SoundType getSoundType() { return type; }
  /**
   * Returns the top Wood of this guitar.
   * @return top Wood of this guitar
   */
  public Wood getTopWood () { return topWood; }
  /**
   * Returns the back Wood of this guitar.
   * @return back Wood of this guitar
   */
  public Wood getBackWood () { return backWood; }

  /**
   * Set the metadata for this guitar.
   * @param value to 
   * @return this <code>Guitar<code>
   */
  public Guitar setMetadata ( Metadata value ) { meta = value; return this; }
  /**
   * Set the brand of this guitar.
   * @param value to set as brand
   * @return this <code>Guitar</code>
   */
  public Guitar setBrand ( String value ) { brand = Brand.validate (value); return this; }
  /**
   * Set the model of this guitar.
   * @param value to set as model
   * @return this <code>Guitar</code>
   */
  public Guitar setModel ( String value ) { model = value; return this; }
  /**
   * Set the price of this guitar.
   * @param value to set as price
   * @return this <code>Guitar</code>
   */
  public Guitar setPrice ( Float value ) { price = value; return this; }
  /**
   * Set the type of this guitar.
   * @param value to set as type
   * @return this <code>Guitar</code>
   */
  public Guitar setSoundType ( String value ) { type = SoundType.validate (value); return this; }
  /**
   * Set the top wood type of this guitar.
   * @param value to set as topWood
   * @return this <code>Guitar</code>
   */
  public Guitar setTopWood ( String value ) { topWood = Wood.validate (value); return this; }
  /**
   * Set the back wood type of this guitar.
   * @param value to set as backWood
   * @return this <code>Guitar</code>
   */
  public Guitar setBackWood ( String value ) { backWood = Wood.validate (value); return this; }

  /**
   * Automatically assign a serial number to this guitar.
   * @return this <code>Guitar</code>
   */
  public Guitar assignSno() { meta.assignSno(); return this; }

  /**
   * Returns <code>true</code> if this guitar. contains property.
   * @param property String to look for
   * @return <code>true</code> if the object contains the property; <code>false</code> otherwise
   */
  public boolean contains (String property) {
    if (meta.contains (property)) return true;
    property = property.toLowerCase();
    return Brand.testEquality (brand, property)
           || property.equals (model.toLowerCase())
           || SoundType.testEquality (type, property)
           || Wood.testEquality (topWood, property)
           || Wood.testEquality (backWood, property);
  }

  /**
   * Returns a string representation of this guitar.
   * @return formatted string representation
   */
  public String toString () {
    return String.format (
             "\t|  %03d  | %-19s | %-18s |  %.2f   |  %-10s        | %-10s | %-10s |\n",
             meta.getSno(), brand, model, price, type, topWood, backWood);
  }
}
