import java.util.Scanner;

public class FrontEnd {
  static Inventory inv = new Inventory(), sold = new Inventory();

  public static void main (String args[]) {
    startUI();
  }

  public static void startUI() {
    Scanner s;
    int ch = 0;
    do {
      clear();
      s = new Scanner (System.in);
      printf ("\n\t%S's Product Inventory.\n", ProductInventory.whoami() );
      println ("\t+---------------------------------+");
      println ("\t|      Rick's Guitar Inventory    |");
      println ("\t|-------------=======-------------|");
      println ("\t|        Supported Operations     |");
      println ("\t+---------------------------------+");
      println ("\t|     1. Insert      2. Remove    |");
      println ("\t|     3. Modify      4. Search    |");
      println ("\t+---------------------------------+");
      print   ("\t\tEnter a number to do task: ");
      try {
        ch = s.nextInt();
      } catch (Exception e) {
      }
      switch (ch) {
        case 1: insert (); break;
        case 2: remove (); break;
        case 3: modify (); break;
        case 4: display (); break;
        case 5: break;
        default:
          println (">>Invalid Option. Try Again<<");
      }
    } while (ch != 5);
  }

}

public static void printPadding() {
  printPadding (false);
}

public static void printPadding (boolean foot) {
  String border = "\t+=======+=====================+====================+===========+====================+============+============+";
  String titles = "\t| S.No. |        Brand        |       Model        |   Price   |        Type        |  Top-Wood  | Back-Wood  |";
  if (!foot)
    System.out.printf ("%s\n%s\n%s\n", border, titles, border);
  else
    System.out.printf ("%s\n", border);
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
  g = new Guitar (GuitarBrand.FENDER, "else", 622, GuitarType.ELECTRIC, GuitarWood.ALDER, GuitarWood.ALDER);
  inv.addToCollection (g);
  g = new Guitar (GuitarBrand.IBANEZ, "adjshds", 322, GuitarType.ACOUSTIC, GuitarWood.ROSEWOOD, GuitarWood.ALDER);
  inv.addToCollection (g);
  g = new Guitar (GuitarBrand.PAUL_REED_SMITH, "skladj", 521, GuitarType.ELECTRIC, GuitarWood.ALDER, GuitarWood.MAHOGANY);
  inv.addToCollection (g);
  g = new Guitar (GuitarBrand.MARTIN, "cxiicv", 599, GuitarType.ACOUSTIC, GuitarWood.CEDAR, GuitarWood.ROSEWOOD);
  inv.addToCollection (g);
}

public static void display () {
  printPadding();
  for (Guitar g : inv.collection.values())
    System.out.printf ("%s", g);
  printPadding (true);
}

public static void remove() {
  Scanner s = new Scanner (System.in);
  int sn;
  System.out.print ("Enter the serial number of the guitar: ");
  sn = s.nextInt();
  Guitar g = inv.collection.get (sn);
  if (inv.removeFromCollection (g))
    sold.addToCollection (g);
}

public static void modify() {
  Scanner s = new Scanner (System.in);
  int sn;
  System.out.print ("Enter the serial number of the guitar: ");
  sn = s.nextInt();
  Guitar g = inv.collection.get (sn);
  System.out.printf ("what would you like to modify?\n");
}
}
