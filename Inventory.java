import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collection;

public class Inventory {
  HashMap<Integer, Guitar> collection, sales; //available collection, sales map
  ArrayList<Guitar> results; //list containing search results

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
   * Sells an item
   * <p>
   * Removes from collection and adds to sales
   * @param sn serial number of guitar to delete
   * @return true if successfully removed from collection, and added to sales map
   */
  public boolean sell (int sn) {
    if (collection.containsKey (sn)) {
      Guitar g = collection.get (sn);
      return collection.remove (sn, g) && g == sales.put (sn, g);
    } else {
      System.out.printf ("Invalid Serial Number.\n");
      return false;
    }
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

  /**
   * Searches for a guitar based on a single keyword
   * <p>
   * Keyword can be any attribute of the guitar except the price.
   * @param c Collection to search from
   * @param s Property to search by
   * @return ArrayList containing [1,N] guitars, or null
   */
  public ArrayList searchByProperties (Collection<Guitar> c, String s) {
    results = new ArrayList<Guitar> (Guitar.COUNTER);
    for (Guitar g : c)
      if (g.contains (s))
        results.add (g);
    if (results.isEmpty())
      return null;
    return results;
  }

  /**
   * Searches for a guitar based on a single keyword
   * @param s Property to search by
   * @return Guitar complete object if found, or null
   */
  public ArrayList searchByProperties (String s) {
    return searchByProperties (collection.values(), s);
  }

  /*
   * Table Generation Helpers
   */
  /**
   * Polymorphic padding function that doesnt print a footer
   */
  public void printPadding() {
    printPadding (false);
  }

  /**
   * Polymorphic padding function that creates a tabular view
   * @param foot decides whether a header or footer needs to be printed
   */
  public void printPadding (boolean foot) {
    String border = "\t+=======+=====================+====================+===========+====================+============+============+";
    String titles = "\t| S.No. |        Brand        |       Model        |   Price   |        Type        |  Top-Wood  | Back-Wood  |";
    if (!foot)
      System.out.printf ("%s\n%s\n%s\n", border, titles, border);
    else
      System.out.printf ("%s\n", border);
  }

  /**
   * Prints all guitars available in the collection
   */
  public void showAll() {
    showFrom (collection.values());
  }

  /**
   * Prints all guitars available in a given collection
   * @param c collection to display from
   */
  public void showFrom (Collection<Guitar> c) {
    printPadding();
    for (Guitar g : c)
      System.out.printf ("%s", g);
    printPadding (true);
  }
}
