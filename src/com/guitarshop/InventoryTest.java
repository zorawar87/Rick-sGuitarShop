package com.guitarshop;

import com.guitarshop.specs.*;

import java.util.Collection;
import java.util.List;

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
    searchTest();
    removeTest();
    System.out.println ("All Tests passed.");
    System.exit (0);
  }

  private static void addToCollectionTest() {
    System.out.println ("Test#1: Adding to collection.");
    System.out.println ("\t\tTest#1.1: Testing proper input, case and whitespace insensitivity, and some errors.");
    
    InstrumentSpecification is = new InstrumentSpecification();
    inv.addToCollection (new Instrument (is, 321));
    is = new InstrumentSpecification();
    is.addProperty("instrument name", InstrumentName.GUITAR).addProperty("builder", Builder.GIBSON).addProperty("model", Model.create("something"))
      .addProperty("type", SoundType.ACOUSTIC).addProperty("top wood", Wood.ROSEWOOD)
        .addProperty("back wood", Wood.CEDAR);
    inv.addToCollection (new Instrument (is, 123));
    is = new InstrumentSpecification();
    is.addProperty("instrument name", InstrumentName.MANDOLIN).addProperty("builder", Builder.PAULREEDSMITH).addProperty("model", Model.create("Fancy"))
      .addProperty("type",SoundType.ELECTRIC).addProperty("top wood",Wood.ALDER).addProperty("back wood",Wood.ROSEWOOD);
    inv.addToCollection (new Instrument (is, 222));
    is = new InstrumentSpecification();
    is.addProperty("instrument name", InstrumentName.DOBRO).addProperty("builder", Builder.FENDER).addProperty("model", Model.create("works"))
        .addProperty("type",SoundType.ACOUSTIC).addProperty("top wood",Wood.MAHOGANY).addProperty("back wood",Wood.CEDAR);
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
    inv.replace (1, "model", Model.create("y4m4h4 r0s3 w00d"));
    
    System.out.println ("Test#2: Passed.\nState of inventory:");
    display (inv.getStockContents());
  }

  private static void searchTest() {
    List<Instrument> res;
    InstrumentSpecification is = new InstrumentSpecification();

    System.out.println ("Test#3: Searching.");
    System.out.println ("\t\tTest#3.1: Testing proper input, case and whitespace insensitivity, and some errors.");

    System.out.println ("\t\t\tTest#3.1.1: Searching for spec with \"electric\" sound type.");
    is.addProperty("builder", Builder.WILDCARD).addProperty("model",Model.create("*"))
      .addProperty("type",SoundType.ELECTRIC).addProperty("top wood",Wood.WILDCARD).addProperty("back wood",Wood.WILDCARD);
    res = inv.search (is);
    display (res);
  
    System.out.println ("\t\t\tTest#3.1.2: Searching for spec with \"Paul Reed S  mith\" brand, AND \"rosewood\" back wood.");
    is = new InstrumentSpecification();
    is.addProperty("builder", Builder.PAULREEDSMITH).addProperty("model",Model.create("*"))
        .addProperty("type",SoundType.WILDCARD).addProperty("back wood",Wood.ROSEWOOD).addProperty("top wood",Wood.WILDCARD);
    res = inv.search (is);
    display (res);
    
    System.out.println ("Test#3: Passed.\nState of inventory:");
    display (inv.getStockContents());
  }

  private static void removeTest() {
    System.out.println ("Test#4: Removing (Selling) elements.");
    System.out.println ("\t\tTest#4.1: Testing proper input, case and whitespace insensitivity, and some errors.");
    inv.sell (4);
    inv.sell (1);
    System.out.println ("Test#4: Passed.\nState of inventory:");
    display (inv.getStockContents());
    System.out.println ("Test#4: The sales have been logged and contain:");
    display (inv.getSalesContents());
  }

  private static void display (Collection<Instrument> c) {
    inv.showFrom (c);
  }
}
