import java.util.HashMap;

public class Inventory {
  public HashMap<Integer, Guitar> collection, sales; //available collection, sales

  public Inventory() {
    collection = new HashMap<Integer, Guitar>();
  }

  public boolean addToCollection (Guitar g) {
    g.COUNTER++;
    g.setSno (g.COUNTER);
    return g == collection.put (g.getSno(), g);
  }

  public boolean addToCollection (GuitarBrand b, String s, int p, GuitarType t, GuitarWood tw, GuitarWood bw) {
    Guitar g = new Guitar (b, s, p, t, tw, bw);
    g.COUNTER++;
    g.setSno (g.COUNTER);
    if (g == collection.put (g.getSno(), g))
      return true;
    return false;
  }

  public boolean removeFromCollection (Guitar g) {
    return collection.remove (g.getSno(), g);
  }
}
