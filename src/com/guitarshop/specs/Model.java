package com.guitarshop.specs;

/**
 * Represents Instrument Specification Property for a model
 *
 * @author Zorawar Moolenaar
 * @version 2.0
 * @since 2.0
 */
public class Model implements SpecValue {
  private final String name;
  
  private Model(String name) {
    this.name = name.toLowerCase();
  }
  
  /**
   * creates an instrument's model represented as a string
   * @param name the model name
   * @return this Model
   */
  public static Model create(String name){
    return new Model(name);
  }
  
  /**
   * to String representation
   * @return to String representation
   */
  @Override
  public String toString(){
    return name;
  }
}
