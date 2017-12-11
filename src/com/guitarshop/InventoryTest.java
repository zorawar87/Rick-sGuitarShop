package com.guitarshop;

import com.guitarshop.specs.*;

import java.util.Collection;

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
    modifyTest();
    //searchTest();
    //removeTest();
    System.out.println ("All Tests passed.");
    System.exit (0);
  }

  private static void addToCollectionTest() {
    System.out.println ("Test#1: Adding to collection.");
    System.out.println ("\t\tTest#1.1: Testing proper input, case and whitespace insensitivity, and some errors.");
    
    InstrumentSpecification is = new InstrumentSpecification();
    inv.addToCollection (new Instrument (is, 321));
    is = new InstrumentSpecification();
    is.addNewProperty("instrument name", InstrumentName.GUITAR).addNewProperty("builder", Builder.GIBSON).addNewProperty("model", Model.createModel("something"))
      .addNewProperty("type", SoundType.ACOUSTIC).addNewProperty("top wood", Wood.ROSEWOOD)
        .addNewProperty("back wood", Wood.CEDAR);
    inv.addToCollection (new Instrument (is, 123));
    is = new InstrumentSpecification();
    is.addNewProperty("instrument name", InstrumentName.MANDOLIN).addNewProperty("builder", Builder.PAULREEDSMITH).addNewProperty("model", Model.createModel("Fancy"))
      .addNewProperty("type",SoundType.ELECTRIC).addNewProperty("top wood",Wood.ALDER).addNewProperty("back wood",Wood.ROSEWOOD);
    inv.addToCollection (new Instrument (is, 222));
    is = new InstrumentSpecification();
    is.addNewProperty("instrument name", InstrumentName.DOBRO).addNewProperty("builder", Builder.FENDER).addNewProperty("model", Model.createModel("works"))
        .addNewProperty("type",SoundType.ACOUSTIC).addNewProperty("top wood",Wood.MAHOGANY).addNewProperty("back wood",Wood.CEDAR);
    inv.addToCollection (new Instrument (is, 299.99));
    
    System.out.println ("Test#1: Passed.\nState of inventory:");
    display (inv.getStockContents());
  }

  private static void modifyTest() {
    System.out.println ("Test#2: Modifying collection.");
    System.out.println ("\t\tTest#2.1: Testing proper input, case and whitespace insensitivity, and some errors.");
  
    inv.replace (1, "instrument name", InstrumentName.BASS);
    inv.replace (1, "builder", Builder.IBANEZ);
    inv.replace (1, "type", SoundType.ELECTRIC);
    inv.replace (1, "top wood", Wood.ROSEWOOD);
    inv.replace (1, "back wood", Wood.ROSEWOOD);
    inv.replace (1, "model", Model.createModel("y4m4h4 r0s3 w00d"));
    
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
