package com.guitarshop;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Tests the guitar inventory
 * @author Zorawar Moolenaar
 * @version 0.5
 */
public class InventoryTest {
  private static Inventory inv = new Inventory();

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
   * Allows user to insert a guitar
   */
  private static void insert() {
    Guitar g;
    g = Guitar.builder()
        .withBrand ("Gibson").withModel ("something").withPrice (123)
        .withSoundType ("Acoustic").withWood ("Cedar", "Cedar")
        .build();
    inv.addToCollection (g);
    g = Guitar.builder()
        .withBrand ("Paul Reed Smith").withModel ("fancy").withPrice(222)
        .withSoundType ("Electric").withWood ("Alder", "Rosewood")
        .build();
    inv.addToCollection (g);
    g = Guitar.builder()
            .withBrand ("fender").withModel ("works").withPrice (299.99)
            .withSoundType ("Acoustic").withWood ("Cedar", "Cedar")
            .build();
    inv.addToCollection (g);
    g = Guitar.builder()
            .withBrand ("fender").withModel ("works").withPrice (299.99)
            .withSoundType ("Acoustic").withWood ("Cedar", "Cedar")
            .build();
    inv.addToCollection (g);
  }


  /**
   * Allows user to remove -- sell -- guitars
   */
  private static void remove() {
    System.out.print ("Removing Serial number 2.");
    int serialNo = 2;
    inv.sell (serialNo);
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
  private static void display (Collection<Guitar> c) {
    inv.showFrom (c);
  }
}
