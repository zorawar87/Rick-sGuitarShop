package com.guitarshop;

public class Instrument {
  private static int COUNTER= 0;
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
  
  public Instrument (InstrumentSpecification spec, Number price) {
    this.spec = spec;
    this.meta = new Metadata (price);
  }
  
  public InstrumentSpecification getSpec() {
    return spec;
  }
  
  public int getSerialNo() { return meta.getSerialNo(); }
  public boolean matches (InstrumentSpecification template) {
    return spec.matches (template);
  }
  
  @Override
  public String toString() {
    /*
    return String.format (
        "\t| %-9s  | %03d  | %-19s | %-18s |  %06.2f   |  %-10s        | %-10s | %-10s |\n",
        this.getClass().getSimpleName(), meta.getSerialNo(), spec.getBrand(),
        spec.getModel(), meta.getPrice(), spec.getSoundType(), spec.getTopWood(),
        spec.getBackWood());
        */
    return String.format (
        "\t| %-9s  | %03d  |\n",this.getClass().getSimpleName(), meta.getSerialNo());
  }
}