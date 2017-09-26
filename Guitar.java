enum GuitarType {
  ACOUSTIC, ELECTRIC;
}

enum GuitarWood {
  ROSEWOOD, ALDER, MAHOGANY, CEDAR;
}

enum GuitarBrand {
  GIBSON, FENDER, IBANEZ, PAUL_REED_SMITH, EPIPHONE, JACKSON, TAYLOR, MARTIN, YAMAHA, RICKENBACKER;
}

public class Guitar {
  static int COUNTER = 0;
  int sno;
  GuitarBrand brand;
  String model;
  float price;
  GuitarType type;
  GuitarWood topWood, backWood;

  /**
   * Default Constructor
   */
  public Guitar () {
    this (null, null, -1, null, null, null);
  }

  /**
   * Parameterized Constructor
   * @param b brand of the guitar
   * @param m model of the guitar
   * @param p price of the guitar
   * @param t type of the guitar
   * @param tw top-wood type of the guitar
   * @param bw back-wood type of the guitar
   */
  public Guitar (GuitarBrand b, String m, float p, GuitarType t, GuitarWood tw, GuitarWood bw) {
    sno = -1;
    brand = b;
    model = m;
    price = p;
    type = t;
    topWood = tw;
    backWood = bw;
  }

  /**
   * Get the Serial number
   * @return int
   */
  public int getSno() { return sno; }
  /**
   * Get the guitar brand
   * @return GuitarBrand
   */
  public GuitarBrand getBrand() { return brand; }
  /**
   * Get the guitar model
   * @return String
   */
  public String getModel() { return model; }
  /**
   * Get the guitar price
   * @return float
   */
  public float getPrice() { return price; }
  /**
   * Get the guitar type
   * @return GuitarType
   */
  public GuitarType getType() { return type; }
  /**
   * Get the Guitar's top wood type
   * @return GuitarWood
   */
  public GuitarWood getTopWood () { return topWood; }
  /**
   * Get the Guitar's back wood type
   * @return GuitarWood
   */
  public GuitarWood getBackWood () { return backWood; }

  /**
   * Set the guitar's serial number
   * @return Guitar Object
   */
  public Guitar setSno ( int value ) { sno = value; return this; }
  /**
   * Set the guitar's brand
   * @return Guitar Object
   */
  public Guitar setBrand ( GuitarBrand value ) { brand = value; return this; }
  /**
   * Set the guitar's model
   * @return Guitar Object
   */
  public Guitar setModel ( String value ) { model = value; return this; }
  /**
   * Set the guitar's price
   * @return Guitar Object
   */
  public Guitar setPrice ( float value ) { price = value; return this; }
  /**
   * Set the guitar's type
   * @return Guitar Object
   */
  public Guitar setType ( GuitarType value ) { type = value; return this; }
  /**
   * Set the guitar's top wood type
   * @return Guitar Object
   */
  public Guitar setTopWood ( GuitarWood value ) { topWood = value; return this; }
  /**
   * Set the guitar's back wood type
   * @return Guitar Object
   */
  public Guitar setBackWood ( GuitarWood value ) { backWood = value; return this; }

  /**
   * String Representation of a Guitar Object
   * @return formatted string representation
   */
  public String toString () {
    return String.format ("\t|  %03d  | %-19s | %-18s |  %.2f   |     %-10s     | %-10s | %-10s |\n", sno, brand, model, price, type, topWood, backWood);
  }
}
