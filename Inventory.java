import java.util.HashMap;

public class Inventory {
  public HashMap<Integer, Guitar> collection, sales; //available collection, sales

  /**
   * Default Constructor
   */
  public Inventory() {
    collection = new HashMap<Integer, Guitar>();
    sales = new HashMap<Integer, Guitar>();
  }

  /**
   * Creates guitar from given parameters and hands off adding to collection to its polymorphic counterpart
   * @param g guitar object
   * @return true if successfully added to collection
   */
  public boolean addToCollection (Guitar g) {
    g.COUNTER++;
    g.setSno (g.COUNTER);
    return g == collection.put (g.getSno(), g);
  }

  /**
   * Creates guitar from given parameters and hands off adding to collection to its polymorphic counterpart
   * @param b brand of the guitar
   * @param m model of the guitar
   * @param p price of the guitar
   * @param t type of the guitar
   * @param tw top-wood type of the guitar
   * @param bw back-wood type of the guitar
   * @return true if successfully added to collection
   */
  public boolean addToCollection (GuitarBrand b, String m, float p, GuitarType t, GuitarWood tw, GuitarWood bw) {
    Guitar g = new Guitar (b, m, p, t, tw, bw);
    return addToCollection (g);
  }

  /**
   * Removes given guitar from collection
   * @param g guitar to remove
   * @return true if removed successfully and added to sales map
   */
  public boolean removeFromCollection (Guitar g) {
    return collection.remove (g.getSno(), g) && g == sales.put (g.getSno(), g);
  }

  /**
   * Replaces guitar if the serial no exists, else adds to collection
   * <p>
   * In case serial no is not found, adding to collection is handed off to the addToCollection method
   *
   * @param g guitar to replace/add
   * @return true if successfully added/replaced
   */
  public boolean replaceGuitar (Guitar g) {
    if (collection.containsKey (g.getSno()))
      return g == collection.put (g.getSno(), g);
    return addToCollection (g);
  }

}
