package com.guitarshop;

import com.guitarshop.specs.SpecValue;

public class Instrument {
  private static int COUNTER = 0;
  
  class Metadata {
    private int serialNo;
    private Float price;
    
    Metadata(Number price) {
      serialNo = ++COUNTER;
      this.price = price.floatValue();
    }
    
    int getSerialNo() {
      return serialNo;
    }
    
    public void setSerialNo(int serialNo) {
      this.serialNo = serialNo;
    }
    
    Float getPrice() {
      return price;
    }
    
    public void setPrice(Float price) {
      this.price = price;
    }
  }
  
  private final Metadata meta;
  private final InstrumentSpecification spec;
  
  /**
   * Creates an Instrument with given InstrumentSpecification and Price
   * @param spec InstrumentSpecification
   * @param price Price of the instrument
   */
  public Instrument(InstrumentSpecification spec, Number price) {
    this.spec = spec;
    this.meta = new Metadata(price);
  }
  
  /**
   * gets the specification of this instrument
   * @return specification of this instrument
   */
  public InstrumentSpecification getSpec() {
    return spec;
  }
  
  /**
   * gets the serial number of this instrument
   * @return serial number
   */
  public int getSerialNo() {
    return meta.getSerialNo();
  }
  
  /**
   * gets the price of this instrument
   * @return price
   */
  public Float getPrice() {
    return meta.getPrice();
  }
  
  /**
   * Adds or updates key-value pair within the instrument's specification
   *
   * @param key property name of the instrument
   * @param value property value of the instrument
   */
  public void addProperty(String key, SpecValue value) {
    spec.addProperty(key, value);
  }
  
  /**
   * Matches this instrument's specification against the given specification
   *
   * @param template value to match against
   * @return true if the values match; false otherwise
   * @see com.guitarshop.InstrumentSpecification
   */
  public boolean matches(InstrumentSpecification template) {
    return spec.matches(template);
  }
  
  @Override
  public String toString() {
    return String.format(
        "\t| %-9s  | %03d  | %-19s | %-18s |  %06.2f   |  %-10s        | %-10s | %-10s |\n",
        spec.getProperty("instrument name"), meta.getSerialNo(), spec.getProperty("builder"),
        spec.getProperty("model"), getPrice(), spec.getProperty("type"), spec.getProperty("top wood"),
        spec.getProperty("back wood")
    );
  }
}