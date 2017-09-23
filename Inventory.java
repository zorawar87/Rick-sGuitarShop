import java.util.HashMap;

public class Inventory {
  public HashMap<Integer, Guitar> collection, sales; //available collection, sales

  public Inventory() {
    collection = new HashMap<Integer, Guitar>();
  }

  public boolean addToCollection (Guitar g) {
    if (g == collection.put (g.getSno(), g))
      return true;
    return false;
  }
  public boolean removeFromCollection (Guitar g) {
    return collection.remove (g.getSno(), g);
  }
}
