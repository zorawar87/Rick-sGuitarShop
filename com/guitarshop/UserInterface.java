package com.guitarshop;

import java.util.Scanner;
import java.util.NoSuchElementException;

/**
 * @author Zorawar Moolenaar
 * @version 0.5
 */
class UserInterface {
  private static final Inventory inv = new Inventory();

  /**
   * Triggers the User Interface
   */
  public static void main (String args[]) {
    Scanner sc;
    int ch; // stores user's choice of task to execute
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
      switch (ch = sc.nextInt()) {
        case 1: insert (); break;
        case 2: remove (); break;
        case 3: modify (); break;
        case 4: search(); break;
        case 5: display (inv.getStockContents()); break;
        case 6: display (inv.getSalesContents()); break;
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
  private static void insert() {
    int ch; // stores whether the client wants to repeat task
    do {
      Scanner sc = new Scanner (System.in);
      ch = 0;
      Guitar g = new Guitar();
      System.out.println ("\tPlease replace any spaces in words with '_' (underscore) characters.");
      try {
        System.out.print ("\t\tBrand: ");
        g.setBrand (sc.nextLine());
        System.out.print ("\t\tModel: "); g.setModel (sc.nextLine());
        System.out.print ("\t\tPrice: "); g.setPrice (sc.nextFloat());
        sc = new Scanner (System.in);
        System.out.print ("\t\tAcoustic/Electric?: ");
        g.setSoundType (sc.nextLine());
        sc = new Scanner (System.in);
        System.out.print ("\t\tSoundType of top wood: ");
        g.setTopWood (sc.nextLine());
        sc = new Scanner (System.in);
        System.out.print ("\t\tSoundType of back wood: ");
        g.setBackWood (sc.nextLine());
        inv.addToCollection (g);
        System.out.print ("\tAdd was successful! Would you like to add more? (1/0) ");
        ch = sc.nextInt();
      } catch (Exception e) {
        System.out.println ("\tAborting. Error.");
      }
    } while (ch == 1);
  }


  /**
   * Allows user to remove guitars from command line
   */
  private static void remove() {
    int ch; // stores whether the client wants to repeat task
    do {
      Scanner sc = new Scanner (System.in);
      System.out.print ("Enter the serial number of the guitar: ");
      Integer serialNo = sc.nextInt();
      if (!inv.sell (serialNo)) {
        System.out.printf ("\tItem %d is not in stock\n", serialNo) ;
        remove();
      }
      if (inv.stockNotEmpty())
        System.out.print ("\tRemove was successful! Would you like to delete more? (1/0) ");
      ch = sc.nextInt();
    } while (ch == 1);
  }

  private static void modify() {
    Scanner sc = new Scanner (System.in);
    int serialNo;
    Guitar g = null;
    do {
      System.out.print ("Serial number of the guitar to modify: ");
      serialNo = sc.nextInt();
      try {
        g = inv.getFromStock (serialNo);
      } catch (NoSuchElementException e) {
        System.out.println (
          String.format ("Guitar with serial number %d is not in stock. Try again.\n",
                         serialNo));
      }
    } while (g != null);
    ArrayList<Guitar> coll = new ArrayList<>();
    coll.add (g);
    display (coll);
    System.out.print ("Modify appropriate values. Leave blank otherwise:\n");
    try {
      sc = new Scanner (System.in);
      System.out.print ("\t\tBrand: ");
      String temp = sc.nextLine();
      if (!temp.isEmpty ())
        g.setBrand (temp);
      System.out.print ("\t\tModel: ");
      temp = sc.nextLine();
      if (!temp.isEmpty ())
        g.setModel (sc.nextLine());
      System.out.print ("\t\tPlease reenter Price: ");
      float t = sc.nextFloat();
      if (t > 0)
        g.setPrice (t);
      sc = new Scanner (System.in);
      System.out.print ("\t\tAcoustic/Electric?: ");
      temp = sc.nextLine();
      if (!temp.isEmpty ())
        g.setSoundType (temp);
      sc = new Scanner (System.in);
      System.out.print ("\t\tSoundType of top wood: ");
      temp = sc.nextLine();
      if (!temp.isEmpty ())
        g.setTopWood (temp);
      sc = new Scanner (System.in);
      System.out.print ("\t\tSoundType of back wood: ");
      temp = sc.nextLine();
      if (!temp.isEmpty ())
        g.setBackWood (temp);
      coll.clear();
      coll.add (g);
      display (coll);
    } catch (Exception e) {
      System.out.println ("\tAborting. Error.");
    }
  }

  private static void search() {
    System.out.println ("You can search by S.No, type, brand, model, (back/top)wood.");
    ArrayList<Guitar> res = new ArrayList<Guitar>();
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
      if (res != null) {
        display (res);
        if (res.size() > 1) {
          System.out.print ("Would you like to refine your search? (1/0): ");
          ch = sc.nextInt();
        }
      }
    } while (ch == 1);
  }

  /* Helper Methods */
  /**
   * Allows user to display guitars from given collection
   * @param c collection to display from
   */
  private static void display(Collection<Guitar> c) {
    inv.showFrom (c);
  }

  /**
   * Clear Terminal Screen
   * <p>
   * Clear screen escape code reference taken from <a href="https://goo.gl/y4q4Hg">here</a>. Will not work on all consoles :(
   */
  private static void clear() {
    System.out.print ("\033[H\033[2J");
    System.out.flush();
  }

  /**
   * Prevents Screen from clearing until the user confirms
   */
  private static void waitForInteraction() {
    Scanner s = new Scanner (System.in);
    System.out.println ("\t>>> Hit <Enter> to complete operation and clear screen. <<<");
    s.nextLine();
  }

}
