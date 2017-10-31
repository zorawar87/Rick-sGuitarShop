import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Zorawar Moolenaar
 * @version 0.5
 */
public class Tester {
  static Inventory inv = new Inventory();

  /**
   * Triggers the User Interface
   */
  public static void main (String args[]) {
    insert();
    remove();
    modify();
    search();
    display (inv.getCollectionContents());
    display (inv.getSalesContents());
  }


  /**
   * Allows user to insert a guitar through the command line
   */
  public static void insert () {
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


  /**
   * Allows user to remove guitars from command line
   */
  public static void remove() {
    System.out.print ("Removing Serial number 2.");
    int serialNo = 2;
    if (!inv.sell (serialNo)) return;
    if (!inv.collection.isEmpty())
      System.out.print ("\tRemove was successful! Would you like to delete more? (1/0) "); 
  }

  public static void modify() {
    System.out.print ("Modifying Serial number 3.");
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
      if (res.size() == 0) {
        System.out.print ("No results found.");
        return;
      }
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
