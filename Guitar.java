/**
 * Represents Guitar Type
 */
enum GuitarType {
  ACOUSTIC ("Acoustic"), ELECTRIC ("Electric");
  String name;
  GuitarType (String s) {
    name = s;
  }
  /**
   * Overrides toString representation
   */
  public String toString() {
    return name;
  }
}

/**
 * Represents Guitar Wood Type
 */
enum GuitarWood {
  ROSEWOOD ("Rosewood"), ALDER ("Alder"), MAHOGANY ("Mahogany"), CEDAR ("Cedar");
  String name;
  GuitarWood (String s) {
    name = s;
  }
  /**
   * Overrides toString representation
   */
  public String toString() {
    return name;
  }
}

/**
 * Represents Guitar Brand
 */
enum GuitarBrand {
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

public class Guitar {
  /** Keeps track of total items that have existed and helps assign s.no. */
  static int COUNTER = 0;
  /** Serial number of the guitar */
  int sno;
  /** Guitar brand that draws from the eponymous enum */
  GuitarBrand brand;
  /** Represents the model of the guitar */
  String model;
  /** Price of the guitar */
  float price;
  /** Guitar Type that draws from the eponymous enum */
  GuitarType type;
  /** Guitar Wood Type for top and bottom that draws from the eponymous enum */
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
   * @return serial number of object
   */
  public int getSno() { return sno; }
  /**
   * Get the guitar brand
   * @return brand of object
   */
  public GuitarBrand getBrand() { return brand; }
  /**
   * Get the guitar model
   * @return model of object
   */
  public String getModel() { return model; }
  /**
   * Get the guitar price
   * @return price of object
   */
  public float getPrice() { return price; }
  /**
   * Get the guitar type
   * @return type of object
   */
  public GuitarType getType() { return type; }
  /**
   * Get the Guitar's top wood type
   * @return top wood of object
   */
  public GuitarWood getTopWood () { return topWood; }
  /**
   * Get the Guitar's back wood type
   * @return back wood of object
   */
  public GuitarWood getBackWood () { return backWood; }

  /**
   * Set the guitar's serial number
   * @param int value to set as sno
   * @return Guitar Object
   */
  public Guitar setSno ( int value ) { sno = value; return this; }
  /**
   * Set the guitar's brand
   * @param GuitarBrand value to set as brand
   * @return Guitar Object
   */
  public Guitar setBrand ( GuitarBrand value ) { brand = value; return this; }
  /**
   * Set the guitar's model
   * @param String value to set as model
   * @return Guitar Object
   */
  public Guitar setModel ( String value ) { model = value; return this; }
  /**
   * Set the guitar's price
   * @param float value to set as price
   * @return Guitar Object
   */
  public Guitar setPrice ( float value ) { price = value; return this; }
  /**
   * Set the guitar's type
   * @param GuitarType value to set as type
   * @return Guitar Object
   */
  public Guitar setType ( GuitarType value ) { type = value; return this; }
  /**
   * Set the guitar's top wood type
   * @param GuitarWood value to set as topWood
   * @return Guitar Object
   */
  public Guitar setTopWood ( GuitarWood value ) { topWood = value; return this; }
  /**
   * Set the guitar's back wood type
   * @param GuitarWood value to set as backWood
   * @return Guitar Object
   */
  public Guitar setBackWood ( GuitarWood value ) { backWood = value; return this; }

  /**
   * Method that checks whether the object has a given property in its fields
   * @param String property to look for
   * @return true if the object contains the property
   */
  public boolean contains (String property) {
    try {
      int s = Integer.parseInt (property);
      return sno == s;
    } catch (Exception e) {}; // we're probably not dealing with a serial number
    property = property.toLowerCase();
    return property.equals (brand.toString().toLowerCase()) || property.equals (model.toLowerCase()) || property.equals (type.toString().toLowerCase()) || property.equals (topWood.toString().toLowerCase()) || property.equals (backWood.toString().toLowerCase()) ;
  }

  /**
   * String Representation of a Guitar Object
   * @return formatted string representation
   */
  public String toString () {
    return String.format ("\t|  %03d  | %-19s | %-18s |  %.2f   |     %-10s     | %-10s | %-10s |\n", sno, brand, model, price, type, topWood, backWood);
  }
}
