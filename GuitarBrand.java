

/**
 * Represents Guitar Brand
 */
public enum GuitarBrand {
  GIBSON ("Gibson"), FENDER ("Fender"), IBANEZ ("Ibanez"), PAUL_REED_SMITH ("Paul Reed Smith"), EPIPHONE ("Epiphone"), JACKSON ("Jackson"), TAYLOR ("Taylor"), MARTIN ("Martin"), YAMAHA ("Yamaha"), RICKENBACKER ("Rickenbacker");
  String name;
  GuitarBrand (String s) {
    name = s;
  }
  /**
   * Overrides toString representation
   */
  public String toString() {
    return name;
  }
}

