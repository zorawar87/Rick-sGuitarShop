package com.guitarshop;

/**
 * Describes a guitar
 *
 * @author Zorawar Moolenaar
 * @version 1.1
 */
public class Guitar {
  /** stores data relevant to Rick's guitar shop */
  private static int COUNTER = 0;
  /**
   * private class that stores the metadata for a guitar
   */
  protected class Metadata {
    /** serial number of the guitar */
    private int serialNo;
    /** cost of the guitar */
    private Float price;

    Metadata (Number price) {
      serialNo = ++COUNTER;
      this.price = price.floatValue();
    }

    int getSno() {
      return serialNo;
    }

    Float getPrice() {
      return price;
    }

    void setPrice (Float price)throws IllegalArgumentException {
      if (price == null)
        throw new IllegalArgumentException ("price can not be null");
      this.price = price;
    }
  }

  /** data specific to Rick's inventory */
  Metadata meta;
  /** specification of the given guitar */
  GuitarSpecification spec;

  /**
   * Creates a new Guitar
   *
   * @param spec specifications of the guitar
   * @param price price of the guitar
   */
  public Guitar (GuitarSpecification spec, Number price) {
    this.spec = spec;
    this.meta = new Metadata (price);
  }

  /**
   * Creates a new Guitar
   *
   * @param spec specifications of the guitar
   */
  public Guitar (GuitarSpecification spec) {
    this.spec = spec;
    this.meta = new Metadata (null);
  }

  /**
   * Get the Serial number
   *
   * @return serial number of object
   */
  public int getSno() {
    return meta.getSno();
  }

  /**
   * Set the price of this guitar.
   *
   * @param price to set as price
   */
  public void setPrice (Number price) {
    meta.setPrice (price.floatValue());
  }

  /**
   * Set the brand of this guitar.
   *
   * @param value to set as brand
   */
  public void setBrand (String value) {
    spec.setBrand (value);
  }

  /**
   * Set the model of this guitar.
   *
   * @param value to set as model
   */
  public void setModel (String value) {
    spec.setModel (value);
  }

  /**
   * Set the type of this guitar.
   *
   * @param value to set as type
   */
  public void setSoundType (String value) {
    spec.setSoundType (value);
  }

  /**
   * Set the top wood type of this guitar.
   *
   * @param value to set as topWood
   */
  public void setTopWood (String value) {
    spec.setTopWood (value);
  }

  /**
   * Set the back wood type of this guitar.
   *
   * @param value to set as backWood
   */
  public void setBackWood (String value) {
    spec.setBackWood (value);
  }

  /**
   * matches Guitar Specifications
   * @param template to match
   * @return true if the current spec matches the template
   */
  public boolean matches (GuitarSpecification template) {
    return spec.matches (template);
  }

  /**
   * Returns a string representation of a Guitar.
   *
   * @return formatted string representation
   */
  @Override
  public String toString() {
    return String.format (
             "\t| %-9s  | %03d  | %-19s | %-18s |  %06.2f   |  %-10s        | %-10s | %-10s |\n",
             this.getClass().getSimpleName(), meta.getSno(), spec.getBrand(),
             spec.getModel(), meta.getPrice(), spec.getSoundType(), spec.getTopWood(),
             spec.getBackWood());
  }
}
