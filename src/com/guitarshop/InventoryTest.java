package com.guitarshop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Tests the guitar inventory
 *
 * @author Zorawar Moolenaar
 * @version 0.5
 */
public class InventoryTest {
    private static Inventory inv = new Inventory();

    /**
     * checks CRUD in the inventory
     * @param args list of command line args
     */
    public static void main(String args[]) {
        System.out.println("Testing the inventory for Rick's Guitar Shop");
        addToCollectionTest();
        modify();
        searchTest();
        remove();
        System.out.println("All Tests passed.");
        System.exit(0);
    }

    private static void addToCollectionTest() {
        System.out.println("Test#1: Adding to collection.");
        System.out.println("\t\tTest#1.1: Testing proper input, case and whitespace insensitivity, and some errors.");
        Guitar g = Guitar.builder()
                .withBrand("Gibson").withModel("something").withPrice(123)
                .withSoundType("acoustic").withWood("Rose Wood", "Cedar")
                .build();
        inv.addToCollection(g);
        g = Guitar.builder()
                .withBrand("Paul Reed Smith").withModel("fancy").withPrice(222)
                .withSoundType("El ecTr ic").withWood("alder", "mahogany")
                .build();
        inv.addToCollection(g);
        g = Guitar.builder()
                .withBrand("fEn dEr    ").withModel("works").withPrice(299.99)
                .withSoundType("AcOUSTic").withWood("Cedar", "alder")
                .build();
        inv.addToCollection(g);
        g = Guitar.builder()
                .withBrand("  Ya Ma Ha  ").withModel("xx5321").withPrice(315.99)
                .withSoundType("electric").withWood("Cedar", "alder")
                .build();
        inv.addToCollection(g);
        System.out.println("\t\tTest#1.2: Testing incorrect methods." +
                "These will throw IllegalArgumentExceptions to be handled by the UI.");
        try {
            g = Guitar.builder()
                    .withBrand("IbAnEz").withModel("works").withPrice(299.99)
                    .withSoundType("Electric").withWood("rosewod", "Cedar")
                    .build();
            inv.addToCollection(g);
        } catch (IllegalArgumentException e) {
            System.out.println("\t\t\tCaught Exception: " + e);
        }
        try {
            g = Guitar.builder()
                    .withBrand("Ibanez").withModel("works").withPrice(299.99)
                    .withSoundType("Electrics").withWood("rosewod", "Cedar")
                    .build();
            inv.addToCollection(g);
        } catch (IllegalArgumentException e) {
            System.out.println("\t\t\tCaught Exception: " + e);
        }
        try {
            g = Guitar.builder()
                    .withBrand("IbAnE").withModel("works").withPrice(299.99)
                    .withSoundType("Eectric").withWood("rosewod", "Cedar")
                    .build();
            inv.addToCollection(g);
        } catch (IllegalArgumentException e) {
            System.out.println("\t\t\tCaught Exception: " + e);
        }

        System.out.println("Test#1: Passed.\nState of inventory:");
        display(inv.getStockContents());
    }

    private static void modify() {
        System.out.println("Test#2: Modifying collection.");
        System.out.println("\t\tTest#2.1: Testing proper input, case and whitespace insensitivity, and some errors.");
        inv.replace(4, "topwood", "Mahogany");
        inv.replace(4, "back wOOd", "rose wood");
        inv.replace(4, "model", "y4m4h4 r0s3 w00d");
        inv.replace(4, "PRice   ", "599.99");
        inv.replace(4, "PRi ce   ", "99");
        System.out.println("\t\tTest#2.2: Testing incorrect methods." +
                "These will throw IllegalArgumentExceptions and NoSuchElement Exception to be handled by the UI.");
        try {
            inv.replace(3, "PRicE   ", "60a0.99");
        } catch (IllegalArgumentException e) {
            System.out.println("\t\t\tCaught Exception: " + e);
        }
        try {
            inv.replace(3, "PRiDE   ", "600.99");
        } catch (IllegalArgumentException e) {
            System.out.println("\t\t\tCaught Exception: " + e);
        }
        try {
            inv.replace(22, "PRice   ", "600.99");
        } catch (NoSuchElementException e) {
            System.out.println("\t\t\tCaught Exception: " + e);
        }
        System.out.println("Test#2: Passed.\nState of inventory:");
        display(inv.getStockContents());
    }

    private static void searchTest() {
        System.out.println("Test#3: Searching.");
        System.out.println("\t\tTest#3.1: Testing proper input, case and whitespace insensitivity, and some errors.");
        ArrayList<Guitar> res;
        System.out.println("\t\t\tTest#3.1.1: Searching for \"electric\".");
        res = inv.search("electric");
        display(res);
        System.out.println("\t\t\tTest#3.1.1.1: Refining Searching  \"electric AND alder\".");
        inv.search(res, "ald er");
        display(res);
        System.out.println("\t\t\tTest#3.1.2: Searching for \"1\".");
        res = inv.search("1");
        display(res);
        System.out.println("\t\t\tTest#3.1.3: Searching for \"gib   SON\".");
        res = inv.search("gib   SON");
        display(res);
        System.out.println("\t\tTest#3.2:. Testing with unacceptable values");
        try {
            inv.search("fjdljds");
        } catch (NoSuchElementException e) {
            System.out.println("\t\t\tCaught Exception: " + e);
        }
        try {
            inv.search("132132789 7 889ds7f8dsjksahdjkashdkjsa");
        } catch (NoSuchElementException e) {
            System.out.println("\t\t\tCaught Exception: " + e);
        }
        System.out.println("Test#3: Passed.\nState of inventory:");
        display(inv.getStockContents());
    }

    private static void remove() {
        System.out.println("Test#4: Removing (Selling) elements.");
        System.out.println("\t\tTest#4.1: Testing proper input, case and whitespace insensitivity, and some errors.");
        inv.sell(3);
        inv.sell(1);
        System.out.println("\t\tTest#4.2: Testing invalid serial numbers." +
                "These will throw IllegalArgumentExceptions to be handled by the UI.");
        try {
            inv.sell(22);
        } catch (IllegalArgumentException e) {
            System.out.println("\t\t\tCaught Exception: " + e);
        }
        System.out.println("Test#4: Passed.\nState of inventory:");
        display(inv.getStockContents());
        System.out.println("Test#4: The sales have been logged and contain:");
        display(inv.getSalesContents());
    }

    private static void display(Collection<Guitar> c) {
        inv.showFrom(c);
    }
}