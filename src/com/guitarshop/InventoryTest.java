package com.guitarshop;

import com.guitarshop.specs.*;

import java.util.List;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Tests the guitar inventory
 *
 * @author Zorawar Moolenaar
 * @version 1.1
 * @see Inventory
 */
public class InventoryTest {
  private static Inventory inv = new Inventory();

  /**
   * checks CRUD in the inventory
   * @param args list of command line args
   */
  public static void main (String args[]) {
    System.out.println ("Testing the inventory for Rick's Instrument Shop");
    addToCollectionTest();
    //modifyTest();
    //searchTest();
    //removeTest();
    System.out.println ("All Tests passed.");
    System.exit (0);
  }

  private static void addToCollectionTest() {
    System.out.println ("Test#1: Adding to collection.");
    System.out.println ("\t\tTest#1.1: Testing proper input, case and whitespace insensitivity, and some errors.");
    InstrumentSpecification is = new InstrumentSpecification();
    is.addProperty("instrument name", InstrumentName.GUITAR).addProperty("builder", Builder.GIBSON).addProperty("model", Model.createModel("something"))
      .addProperty("type", SoundType.ACOUSTIC).addProperty("top wood", Wood.ROSEWOOD)
        .addProperty("back wood", Wood.CEDAR);
    inv.addToCollection (new Instrument (is, 123));
        /*
    gs = InstrumentSpecification.builder()
         .withBrand ("Paul Reed Smith").withModel ("fancy")
         .withSoundType ("El ecTr ic").withWood ("alder", "mahogany")
         .build();
    inv.addToCollection (new Instrument (gs, 222));
    gs = InstrumentSpecification.builder()
         .withBrand ("fEn dEr    ").withModel ("works")
         .withSoundType ("AcOUSTic").withWood ("Cedar", "alder")
         .build();
    inv.addToCollection (new Instrument (gs, 299.99));
    gs = InstrumentSpecification.builder()
         .withBrand ("  Ya Ma Ha  ").withModel ("xx5321")
         .withSoundType ("electric").withWood ("Cedar", "alder")
         .build();
    inv.addToCollection (new Instrument (gs, 315.99));
    System.out.println ("\t\tTest#1.2: Testing incorrect methods." +
                        "These will throw IllegalArgumentExceptions to be handled by the UI.");
    try {
      gs = InstrumentSpecification.builder()
           .withBrand ("IbAnEz").withModel ("works")
           .withSoundType ("Electric").withWood ("rosewod", "Cedar")
           .build();
      inv.addToCollection (new Instrument (gs, 299.99));
    } catch (IllegalArgumentException e) {
      System.out.println ("\t\t\tCaught Exception: " + e);
    }
    try {
      gs = InstrumentSpecification.builder()
           .withBrand ("Ibanez").withModel ("works")
           .withSoundType ("Electrics").withWood ("rosewod", "Cedar")
           .build();
      inv.addToCollection (new Instrument (gs, 299.99));
    } catch (IllegalArgumentException e) {
      System.out.println ("\t\t\tCaught Exception: " + e);
    }
    try {
      gs = InstrumentSpecification.builder()
           .withBrand ("IbAnE").withModel ("works")
           .withSoundType ("Eectric").withWood ("rosewod", "Cedar")
           .build();
      inv.addToCollection (new Instrument (gs, 299.99));
    } catch (IllegalArgumentException e) {
      System.out.println ("\t\t\tCaught Exception: " + e);
    }

*/
    System.out.println ("Test#1: Passed.\nState of inventory:");
    display (inv.getStockContents());
  }

  private static void modifyTest() {
    System.out.println ("Test#2: Modifying collection.");
    System.out.println ("\t\tTest#2.1: Testing proper input, case and whitespace insensitivity, and some errors.");
    inv.replace (4, "topwood", "Mahogany");
    inv.replace (4, "back wOOd", "rose wood");
    inv.replace (4, "model", "y4m4h4 r0s3 w00d");
    inv.replace (4, "PRice   ", "599.99");
    inv.replace (4, "PRi ce   ", "99");
    System.out.println ("\t\tTest#2.2: Testing incorrect methods." +
                        "These will throw IllegalArgumentExceptions and NoSuchElement Exception to be handled by the UI.");
    try {
      inv.replace (3, "PRicE   ", "60a0.99");
    } catch (IllegalArgumentException e) {
      System.out.println ("\t\t\tCaught Exception: " + e);
    }
    try {
      inv.replace (3, "PRiDE   ", "600.99");
    } catch (IllegalArgumentException e) {
      System.out.println ("\t\t\tCaught Exception: " + e);
    }
    try {
      inv.replace (22, "PRice   ", "600.99");
    } catch (NoSuchElementException e) {
      System.out.println ("\t\t\tCaught Exception: " + e);
    }
    System.out.println ("Test#2: Passed.\nState of inventory:");
    display (inv.getStockContents());
  }

  private static void searchTest() {
    /*
    List<Instrument> res;
    InstrumentSpecification gs;

    System.out.println ("Test#3: Searching.");
    System.out.println ("\t\tTest#3.1: Testing proper input, case and whitespace insensitivity, and some errors.");

    System.out.println ("\t\t\tTest#3.1.1: Searching for spec with \"electric\" sound type.");
    gs =  InstrumentSpecification.builder()
          .withBrand ("*").withModel ("*")
          .withSoundType ("electric").withWood ("*", "*")
          .build();
    res = inv.search (gs);
    display (res);

    System.out.println ("\t\t\tTest#3.1.2: Searching for spec with \"Paul Reed S  mith\" brand, \"fancy\" model, AND \"mahogany\" backwood.");
    gs =  InstrumentSpecification.builder()
          .withBrand ("Paul Reed Smith").withModel ("*")
          .withSoundType ("e l e c t r i c").withWood ("*", "mahOgAn  y")
          .build();
    display (res);

    System.out.println ("\t\t\tTest#3.1.3: Searching for spec with brand \"gib   SON\", \"something\" model, AND \"acoustic\" sound type.");
    gs =  InstrumentSpecification.builder()
          .withBrand ("Gibson").withModel ("something")
          .withSoundType ("acoustic").withWood ("*", "*")
          .build();
    res = inv.search (gs);
    display (res);
    System.out.println ("\t\tTest#3.2:. Testing with valid field values, but no guitars in-stock");
    System.out.println ("\t\t\tTest#3.2.1: Searching for spec with brand \"gib   SON\", \"something\" model, AND \"acoustic\" sound type.");
    try {
      gs =  InstrumentSpecification.builder()
            .withBrand ("gib   SON").withModel ("something")
            .withSoundType ("electric").withWood ("*", "*")
            .build();
      res = inv.search (gs);
      inv.search (gs);
    } catch (NoSuchElementException e) {
      System.out.println ("\t\t\tCaught Exception: " + e);
    }
    System.out.println ("Test#3: Passed.\nState of inventory:");
    display (inv.getStockContents());
    */
  }

  private static void removeTest() {
  /*
    System.out.println ("Test#4: Removing (Selling) elements.");
    System.out.println ("\t\tTest#4.1: Testing proper input, case and whitespace insensitivity, and some errors.");
    inv.sell (3);
    inv.sell (1);
    System.out.println ("\t\tTest#4.2: Testing invalid serial numbers." +
                        "These will throw IllegalArgumentExceptions to be handled by the UI.");
    try {
      inv.sell (22);
    } catch (IllegalArgumentException e) {
      System.out.println ("\t\t\tCaught Exception: " + e);
    }
    System.out.println ("Test#4: Passed.\nState of inventory:");
    display (inv.getStockContents());
    System.out.println ("Test#4: The sales have been logged and contain:");
    display (inv.getSalesContents());
    */
  }

  private static void display (Collection<Instrument> c) {
    inv.showFrom (c);
  }
}
