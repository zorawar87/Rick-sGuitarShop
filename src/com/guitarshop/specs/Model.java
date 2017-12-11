package com.guitarshop.specs;

public class Model implements SpecValue {
  private final String name;
  
  public Model(String name) {
    this.name = name;
  }
  
  public static Model createModel(String name){
    return new Model(name);
  }
  @Override
  public String toString(){
    return name;
  }
}