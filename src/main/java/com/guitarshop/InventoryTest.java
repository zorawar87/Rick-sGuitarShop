package com.guitarshop;

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
        addToCollectionTest();
        //modify();
        searchTest();
//        display (inv.getStockContents());
//        display (inv.getSalesContents());
//        remove();
    }


    /**
     * Allows user to insert a guitar
     */
    private static void addToCollectionTest() {
        System.out.println("Test#1: Adding to collection.");
        System.out.println("\t\tTest#1.1: Testing proper input, case and whitespace insensitivity, and some errors.");
        Guitar g = Guitar.builder()
                .withBrand ("Gibson").withModel ("something").withPrice (123)
                .withSoundType ("acoustic").withWood ("Rose Wood", "Cedar")
                .build();
        inv.addToCollection (g);
        g = Guitar.builder()
                .withBrand ("Paul Reed Smith").withModel ("fancy").withPrice(222)
                .withSoundType ("El ecTr ic").withWood ("alder", "mahogany")
                .build();
        inv.addToCollection (g);
        g = Guitar.builder()
                .withBrand ("fEn dEr    ").withModel ("works").withPrice (299.99)
                .withSoundType ("AcOUSTic").withWood ("Cedar", "alder")
                .build();
        inv.addToCollection (g);
        g = Guitar.builder()
                .withBrand ("  Ya Ma Ha  ").withModel ("xx5321").withPrice (315.99)
                .withSoundType ("electric").withWood ("Cedar", "alder")
                .build();
        inv.addToCollection (g);
        System.out.println("\t\tTest#1.2: Testing incorrect methods."+
                "These will throw IllegalArgumentExceptions to be handled by the UI.");
        try {
            g = Guitar.builder()
                    .withBrand("IbAnEz").withModel("works").withPrice(299.99)
                    .withSoundType("Electric").withWood("rosewod", "Cedar")
                    .build();
            inv.addToCollection (g);
        } catch (IllegalArgumentException e ) { System.out.println("\t\t\tCaught Exception: "+e);}
        try {
            g = Guitar.builder()
                    .withBrand("Ibanez").withModel("works").withPrice(299.99)
                    .withSoundType("Electrics").withWood("rosewod", "Cedar")
                    .build();
            inv.addToCollection (g);
        } catch (IllegalArgumentException e ) { System.out.println("\t\t\tCaught Exception: "+e);}
        try {
            g = Guitar.builder()
                    .withBrand("IbAnE").withModel("works").withPrice(299.99)
                    .withSoundType("Eectric").withWood("rosewod", "Cedar")
                    .build();
            inv.addToCollection (g);
        } catch (IllegalArgumentException e ) { System.out.println("\t\t\tCaught Exception: "+ e);}

        System.out.println("Test#1: Passed.\nState of inventory.");
        display(inv.getStockContents());
    }

    private static void modify() {
        System.out.println("Test#2: Modifying collection.");
        System.out.println("\t\tTest#2.1: Testing proper input, case and whitespace insensitivity, and some errors.");
        System.out.println("\t\tTest#2.2: Testing incorrect methods."+
                "These will throw IllegalArgumentExceptions to be handled by the UI.");
        try {
        } catch (IllegalArgumentException e ) { System.out.println("\t\t\tCaught Exception: "+e);}
        System.out.println("Test#1: Passed.\nState of inventory.");
        display(inv.getStockContents());
    }

    private static void searchTest() {
        ArrayList<Guitar> res = new ArrayList<>();

        res = inv.search("electric");
        display (res);
        inv.search(res, "cedar");
        display (res);
        res = inv.search("cedar");
        display (res);
        inv.search(res, "acoustic");
        display (res);
        res = inv.search("alder");
        res = inv.search("1");
        res = inv.search("1");
    }

    /**
     * Allows user to remove -- sell -- guitars
     */
    private static void remove() {
        System.out.print ("Removing Serial number 2.");
        int serialNo = 2;
        inv.sell (serialNo);
    }

    /**
     * Allows user to display guitars from given collection
     * @param c collection to display from
     */
    private static void display (Collection<Guitar> c) {
        inv.showFrom (c);
    }
}