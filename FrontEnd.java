import java.util.Scanner;

public class FrontEnd {
  static Inventory inv = new Inventory(), sold = new Inventory();

  public static void main (String args[]) {
    startUI();
    insert ();
    insert ();
    insert ();
    insert ();
    insert ();
    insert ();
    insert ();
    insert ();
    insert ();
    view ();
    insert ();
    view ();
    delete();
    view();
  }

  public static void startUI() {
    String choice;
    System.out.println ("What do you want to do?");
    //System.in.scanf ("%s", choice);
  }

  public static void insert () {
    Scanner sc = new Scanner (System.in);
    /* Sample Code
    Guitar g = new Guitar();
    try {
      System.out.print ("brand: "); g.setBrand (GuitarBrand.valueOf (sc.nextLine().toUpperCase()));
      System.out.print ("model: "); g.setModel (sc.nextLine());
      System.out.print ("price: "); g.setPrice (sc.nextInt());
      sc = new Scanner (System.in);
      System.out.print ("type: "); g.setType (GuitarType.valueOf (sc.nextLine().toUpperCase()));
      sc = new Scanner (System.in);
      System.out.print ("type of top wood: "); g.setTopWood (GuitarWood.valueOf (sc.nextLine().toUpperCase()));
      sc = new Scanner (System.in);
      System.out.print ("type of back wood: "); g.setBackWood (GuitarWood.valueOf (sc.nextLine().toUpperCase()));
    } catch (Exception e) {
      System.out.println ("Aborting. Error.");
      return;
    }
    */
    Guitar g = new Guitar (GuitarBrand.GIBSON, "something", 123, GuitarType.ACOUSTIC, GuitarWood.CEDAR, GuitarWood.CEDAR);
    inv.addToCollection (g);
  }

  public static void view () {
    for (Guitar g : inv.collection.values())
      System.out.printf ("%s\n", g);
  }

  public static void delete() {
    Scanner s = new Scanner (System.in);
    int sn;
    System.out.print ("Enter the serial number of the guitar: ");
    sn = s.nextInt();
    Guitar g = inv.collection.get (sn);
    if (inv.removeFromCollection (g))
      sold.addToCollection (g);
  }
}
