package com.guitarshop;
/**
 * @author Zorawar Moolenaar
 * @version 0.6
 * Reflects how a guitar is viewed in the context of Rick’s inventory
 */
class Metadata {
  private static int COUNTER = 0;
  private Integer serialNo;

  public Metadata() {
    serialNo = null;
  }
  public int getSno() {return serialNo;}
  public void assignSno() { serialNo = ++COUNTER; }

  /**
   * Method that checks whether the object has a given property in its fields
   * @param property property to search for
   * @return true if the object contains the property
   */
  public boolean contains (String property) {
    try {
      int s = Integer.parseInt (property);
      return serialNo == s;
    } catch (Exception e) {
      return false;
    }
  }
}
