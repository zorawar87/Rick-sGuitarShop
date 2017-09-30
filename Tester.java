import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Zorawar Moolenaar
 * @version 0.5
 */
public class Tester {
  static Inventory inv = new Inventory();

  /**
   * Clear Terminal Screen
   * <p>
   * Clear screen escape code reference taken from <a href="https://goo.gl/y4q4Hg">here</a>. Will not work on all consoles :(
   */
  public static void clear() {
    System.out.print ("\033[H\033[2J");
    System.out.flush();
  }

  /**
   * Prevents Screen from clearing until the user confirms
   */
  public static void waitForInteraction() {
    Scanner s = new Scanner (System.in);
    System.out.println ("\t>>> Hit <Enter> to complete operation and clear screen. <<<"); s.nextLine();
  }

  /**
   * Triggers the User Interface
   */
  public static void main (String args[]) {
    Scanner sc;
    int ch = 0; // stores user's choice of task to execute
    do {
      clear();
      sc = new Scanner (System.in);
      System.out.println ("\t+-------------------------------------+");
      System.out.println ("\t|         Rick's Guitar Inventory     |");
      System.out.println ("\t|--------------=========--------------|");
      System.out.println ("\t|          Supported Operations       |");
      System.out.println ("\t+-------------------------------------+");
      System.out.println ("\t|     1. Insert      2. Remove        |");
      System.out.println ("\t|     3. Modify      4. Search        |");
      System.out.println ("\t|     5. Display     6. Show Removed  |");
      System.out.println ("\t|              7. Quit                |");
      System.out.println ("\t+-------------------------------------+");
      System.out.print   ("\t   Enter a number to do task: ");
      try {
        ch = sc.nextInt();
      } catch (Exception e) {
      }
      switch (ch) {
        case 1: insert (); break;
        case 2: remove (); break;
        case 3: modify (); break;
        case 4: search(); break;
        case 5: display (inv.collection.values()); break;
        case 6: display (inv.sales.values()); break;
        case 7: break;
        default:
          System.out.println (">>> Invalid Option. Try Again <<<");
      }
      waitForInteraction();
    } while (ch != 7);
  }


  /**
   * Allows user to insert a guitar through the command line
   */
  public static void insert () {
    int ch = 0; // stores whether the client wants to repeat task
    do {
      Scanner sc = new Scanner (System.in);
      ch = 0;
      Guitar g = new Guitar();
      System.out.println ("\tPlease replace any spaces in words with '_' (underscore) characters.");
      try {
        System.out.print ("\t\tBrand: "); g.setBrand (GuitarBrand.valueOf (sc.nextLine().toUpperCase()));
        System.out.print ("\t\tModel: "); g.setModel (sc.nextLine());
        System.out.print ("\t\tPrice: "); g.setPrice (sc.nextFloat());
        sc = new Scanner (System.in);
        System.out.print ("\t\tAcoustic/Electric?: "); g.setType (GuitarType.valueOf (sc.nextLine().toUpperCase()));
        sc = new Scanner (System.in);
        System.out.print ("\t\tType of top wood: "); g.setTopWood (GuitarWood.valueOf (sc.nextLine().toUpperCase()));
        sc = new Scanner (System.in);
        System.out.print ("\t\tType of back wood: "); g.setBackWood (GuitarWood.valueOf (sc.nextLine().toUpperCase()));
        inv.addToCollection (g);
        System.out.print ("\tAdd was successful! Would you like to add more? (1/0) "); ch = sc.nextInt();
      } catch (Exception e) {
        System.out.println ("\tAborting. Error.");
      }
    } while (ch == 1);
    /* Sample Code
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
    */
  }


  /**
   * Allows user to remove guitars from command line
   */
  public static void remove() {
    int ch = 0; // stores whether the client wants to repeat task
    do {
      Scanner sc = new Scanner (System.in);
      ch = 0;
      System.out.print ("Enter the serial number of the guitar: ");
      Integer sn = sc.nextInt();
      if (!inv.sell (sn)) return;
      if (!inv.collection.isEmpty())
        System.out.print ("\tRemove was successful! Would you like to delete more? (1/0) "); ch = sc.nextInt();
    } while (ch == 1);
  }

  public static void modify() {
    Scanner sc = new Scanner (System.in);
    int sn;
    System.out.print ("Serial number of the guitar to modify: ");
    sn = sc.nextInt();
    Guitar g = inv.collection.get (sn);
    ArrayList<Guitar> coll = new ArrayList<Guitar>();
    coll.add (g);
    display (coll);
    System.out.print ("Modify appropraite values. Leave blank otherwise:\n");
    try {
      sc = new Scanner (System.in);
      System.out.print ("\t\tBrand: ");
      String temp = sc.nextLine();
      if (!temp.equals (""))
        g.setBrand (GuitarBrand.valueOf (temp.toUpperCase()));
      System.out.print ("\t\tModel: ");
      temp = sc.nextLine();
      if (!temp.equals (""))
        g.setModel (sc.nextLine());
      System.out.print ("\t\tPlease reenter Price: ");
      float t = sc.nextFloat();
      if (t > 0)
        g.setPrice (t);
      sc = new Scanner (System.in);
      System.out.print ("\t\tAcoustic/Electric?: ");
      temp = sc.nextLine();
      if (!temp.equals (""))
        g.setType (GuitarType.valueOf (temp.toUpperCase()));
      sc = new Scanner (System.in);
      System.out.print ("\t\tType of top wood: ");
      temp = sc.nextLine();
      if (!temp.equals (""))
        g.setTopWood (GuitarWood.valueOf (temp.toUpperCase()));
      sc = new Scanner (System.in);
      System.out.print ("\t\tType of back wood: ");
      temp = sc.nextLine();
      if (!temp.equals (""))
        g.setBackWood (GuitarWood.valueOf (temp.toUpperCase()));
      coll.clear();
      coll.add (g);
      display (coll);
    } catch (Exception e) {
      System.out.println ("\tAborting. Error.");
    }
  }

  public static void search() {
    System.out.println ("You can search by S.No, type, brand, model, (back/top)wood.");
    ArrayList<Guitar> res = new ArrayList<Guitar>();
    int ch = 0; // stores whether the client wants to repeat task
    do {
      Scanner sc = new Scanner (System.in);
      ch = 0;
      System.out.print ("Please mention a search keyword: ");
      String sn = sc.nextLine();
      if (res.isEmpty())
        res = inv.searchByProperties (sn);
      else
        res = inv.searchByProperties (res, sn);
      display (res);
      if (res.size() > 1) {
        System.out.print ("Would you like to refine your search? (1/0): ");
        ch = sc.nextInt();
      }
    } while (ch == 1);
  }

  /**
   * Allows user to display all guitars
   */
  public static void display () {
    inv.showAll();
  }

  /**
   * Allows user to display guitars from given collection
   * @param c collection to display from
   */
  public static void display (Collection<Guitar> c) {
    inv.showFrom (c);
  }
}
