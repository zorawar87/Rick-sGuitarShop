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
  
  public Instrument(InstrumentSpecification spec, Number price) {
    this.spec = spec;
    this.meta = new Metadata(price);
  }
  
  public InstrumentSpecification getSpec() {
    return spec;
  }
  
  public int getSerialNo() {
    return meta.getSerialNo();
  }
  public Float getPrice() {
    return meta.getPrice();
  }
  public void addNewProperty(String key, SpecValue value){
    spec.addNewProperty(key,value);
  }
  public void updateProperty(String key, SpecValue value){
    spec.updateProperty(key,value);
  }
  
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