package com.guitarshop;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Zorawar Moolenaar
 * @version 0.5
 */
class Tester {
  private static final Inventory inv = new Inventory();

  /**
   * Triggers the User Interface
   */
  public static void main (String args[]) {
    insert();
    remove();
    modify();
    search();
    display (inv.getStockContents());
    display (inv.getSalesContents());
  }


  /**
   * Allows user to insert a guitar through the command line
   */
  private static void insert() {
    Guitar g;
    g = Guitar.builder()
        .withBrand ("Gibson").withModel ("something").withPrice (123).withSoundType ("Acoustic").withWood ("Cedar", "Cedar").build();
    inv.addToCollection (g);
    /*
    Guitar g = new Guitar (Brand.GIBSON, "something", 123, SoundType.ACOUSTIC,
                           Wood.CEDAR, Wood.CEDAR);
    g = new Guitar (Brand.FENDER, "else", 622, SoundType.ELECTRIC, Wood.ALDER,
                    Wood.ALDER);
    inv.addToCollection (g);
    g = new Guitar (Brand.IBANEZ, "model", 322, SoundType.ACOUSTIC, Wood.ROSEWOOD,
                    Wood.ALDER);
    inv.addToCollection (g);
    g = new Guitar (Brand.PAUL_REED_SMITH, "random", 521, SoundType.ELECTRIC,
                    Wood.ALDER, Wood.MAHOGANY);
    inv.addToCollection (g);
    g = new Guitar (Brand.MARTIN, "clan", 599, SoundType.ACOUSTIC, Wood.CEDAR,
                    Wood.ROSEWOOD);
    inv.addToCollection (g);
    */
  }


  /**
   * Allows user to remove -- sell -- guitars from command line
   * <p>
   * remove implies sell because we assume data entry has been done correctly
   */
  private static void remove() {
    System.out.print ("Removing Serial number 2.");
    int serialNo = 2;
    inv.sell(serialNo);
  }

  private static void modify() {
    System.out.print ("Modifying Serial number 3.");
  }

  private static void search() {
    System.out.println ("You can search by S.No, type, brand, model, (back/top)wood.");
    ArrayList<Guitar> res = new ArrayList<>();
    int ch; // stores whether the client wants to repeat task
    do {
      Scanner sc = new Scanner (System.in);
      ch = 0;
      System.out.print ("Please mention a search keyword: ");
      String serialNo = sc.nextLine();
      if (res.isEmpty())
        res = inv.searchByProperties (serialNo);
      else
        res = inv.searchByProperties (res, serialNo);
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
   * Allows user to display guitars from given collection
   * @param c collection to display from
   */
  private static void display(Collection<Guitar> c) {
    inv.showFrom (c);
  }
}
