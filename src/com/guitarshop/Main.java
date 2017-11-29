package com.guitarshop;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Is the user interface for Rick's Guitar Shop
 *
 * @author Zorawar Moolenaar
 * @version 0.8
 */
public class Main {
    private static final Inventory inv = new Inventory();

    /**
     * Triggers the User Interface
     * @param args list of command line Args
     */
    public static void main(String args[]) {
      /*
        System.out.println("UI under construction.");
        System.exit(1);
        */
        Scanner sc;
        int ch; // stores user's choice of task to execute
        do {
            clear();
            sc = new Scanner(System.in);
            System.out.println("\t|--------------------------------------------------------------|");
            System.out.println("\t|               Rick's Guitar & Mandolin Inventory             |");
            System.out.println("\t|---------------------===================----------------------|");
            System.out.println("\t|                    Supported Operations                      |");
            System.out.println("\t|--------------------------------------------------------------|");
            System.out.println("\t|     1. Insert Instrument     2. Remove (sell) Instrument     |");
            System.out.println("\t|     3. Modify Instrument     4. Search Instrument            |");
            System.out.println("\t|     5. Display Instrument    6. Show Removed (sold)          |");
            System.out.println("\t|                       7. Quit                                |");
            System.out.println("\t|--------------------------------------------------------------|");
            System.out.print("\t   Enter a number to do task: ");
            switch (ch = sc.nextInt()) {
                case 1:
                  jdi();
                    //insert();
                    break;
                case 2:
                    remove();
                    break;
                case 3:
                    modify();
                    break;
                case 4:
                    search();
                    break;
                case 5:
                    display(inv.getStockContents());
                    break;
                case 6:
                    display(inv.getSalesContents());
                    break;
                case 7:
                    break;
                default:
                    System.out.println(">>> Invalid Option. Try Again <<<");
            }
            waitForInteraction();
        } while (ch != 7);
    }

    private static void jdi(){
      GuitarSpecification gs;
      gs = GuitarSpecification.builder().withBrand("Yamaha").withModel("adads").withSoundType("acoustic").withWood("cedar","alder").build();
      inv.addToCollection(new Guitar(gs));
      gs = GuitarSpecification.builder().withBrand("Fender").withModel("cxzv").withSoundType("electric").withWood("rosewood","mahogany").build();
      inv.addToCollection(new Guitar(gs));
      gs = GuitarSpecification.builder().withBrand("Paul Reed Smith").withModel("qwewq").withSoundType("electric").withWood("cedar","mahogany").build();
      inv.addToCollection(new Guitar(gs));
    }

    /**
     * Allows user to insert a guitar through the command line
    private static void insert() {
        int ch; // stores whether the client wants to repeat task
        do {
            Scanner sc = new Scanner(System.in);
            ch = 0;
            inv.addToCollection(populateGuitar());
            System.out.println("\tAdd was successful! Would you like to add more? (1/0) ");
            ch = sc.nextInt();
        } while (ch == 1);
    }

    private static Guitar populateGuitar(Guitar si){
      Scanner sc = new Scanner(System.in);
      try {
          System.out.print("\t\tBrand: ");
          si.setBrand(sc.nextLine());
          System.out.print("\t\tModel: ");
          si.setModel(sc.nextLine());
          System.out.print("\t\tPrice: ");
          sc.nextFloat();
          sc = new Scanner(System.in);
          System.out.print("\t\tAcoustic/Electric?: ");
          si.setSoundType(sc.nextLine());
          sc = new Scanner(System.in);
          System.out.print("\t\tType of top wood: ");
          si.setTopWood(sc.nextLine());
          sc = new Scanner(System.in);
          System.out.print("\t\tType of back wood: ");
          si.setBackWood(sc.nextLine());
      } catch (Exception e) {
          e.printStackTrace();
          System.out.println("\tAborting. Error.");
      }
      return si;
    }

    private static Guitar populateGuitar(){
      Guitar g = new Guitar();
      Scanner sc = new Scanner(System.in);
      try {
          g =(Guitar)populateGuitar(g);
          System.out.print("\t\tString Count: ");
          g.setStringCount(sc.nextInt());
      } catch (Exception e) {
          e.printStackTrace();
          System.out.println("\tAborting. Error.");
      }
      return g;
    }
     */

    /**
     * Allows user to remove guitars from command line
     */
    private static void remove() {
        int ch; // stores whether the client wants to repeat task
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the serial number of the guitar: ");
            Integer serialNo = sc.nextInt();
            if (!inv.sell(serialNo)) {
                System.out.printf("\tItem %d is not in stock\n", serialNo);
                remove();
            }
            if (inv.stockNotEmpty())
                System.out.print("\tRemove was successful! Would you like to delete more? (1/0) ");
            ch = sc.nextInt();
        } while (ch == 1);
    }

    private static void modify() {
        Scanner sc = new Scanner(System.in);
        int serialNo;
        Guitar si = null;
        do {
            System.out.print("Serial number of the string instrument to modify: ");
            serialNo = sc.nextInt();
            try {
                si = inv.getFromStock(serialNo);
            } catch (NoSuchElementException e) {
                System.out.println(
                        String.format("String Instrument with serial number %d is not in stock. Try again.\n",
                                serialNo));
            }
        } while (si != null);
        ArrayList<Guitar> coll = new ArrayList<>();
        coll.add(si);
        display(coll);
        System.out.print("Modify appropriate values. Leave blank otherwise:\n");
        try {
            sc = new Scanner(System.in);
            System.out.print("\t\tBrand: ");
            String temp = sc.nextLine();
            if (!temp.isEmpty())
                si.setBrand(temp);
            System.out.print("\t\tModel: ");
            temp = sc.nextLine();
            if (!temp.isEmpty())
                si.setModel(sc.nextLine());
            System.out.print("\t\tPlease reenter Price: ");
            float t = sc.nextFloat();
            if (t > 0)
                si.setPrice(t);
            sc = new Scanner(System.in);
            System.out.print("\t\tAcoustic/Electric?: ");
            temp = sc.nextLine();
            if (!temp.isEmpty())
                si.setSoundType(temp);
            sc = new Scanner(System.in);
            System.out.print("\t\tSoundType of top wood: ");
            temp = sc.nextLine();
            if (!temp.isEmpty())
                si.setTopWood(temp);
            sc = new Scanner(System.in);
            System.out.print("\t\tSoundType of back wood: ");
            temp = sc.nextLine();
            if (!temp.isEmpty())
                si.setBackWood(temp);
            coll.clear();
            coll.add(si);
            display(coll);
        } catch (Exception e) {
            System.out.println("\tAborting. Error.");
        }
    }

    private static void search() {
        System.out.println("You can search by S.No, type, brand, model, (back/top)wood.");
        List<Guitar> res = new ArrayList<Guitar>();
        int ch; // stores whether the client wants to repeat task
        do {
            Scanner sc = new Scanner(System.in);
            ch = 0;
            System.out.print("Please mention a search keyword: ");
            String serialNo = sc.nextLine();
            if (res.isEmpty())
                res = inv.search(serialNo);
            else
                res = inv.search(res, serialNo);
            if (res != null) {
                display(res);
                if (res.size() > 1) {
                    System.out.print("Would you like to refine your search? (1/0): ");
                    ch = sc.nextInt();
                }
            }
        } while (ch == 1);
    }

  /* Helper Methods */

    /**
     * Allows user to display guitars from given collection
     *
     * @param c collection to display from
     */
    private static void display(Collection<Guitar> c) {
        inv.showFrom(c);
    }

    /**
     * Clear Terminal Screen
     * <p>
     * Clear screen escape code reference taken from <a href="https://goo.gl/y4q4Hg">here</a>. Will not work on all consoles :(
     */
    private static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Prevents Screen from clearing until the user confirms
     */
    private static void waitForInteraction() {
        Scanner s = new Scanner(System.in);
        System.out.println("\t>>> Hit <Enter> to complete operation and clear screen. <<<");
        s.nextLine();
    }

}
