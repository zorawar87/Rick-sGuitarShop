package com.guitarshop;

import com.guitarshop.specs.SpecValue;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * Represents an inventory containing in-stock and sold instruments
 *
 * @author Zorawar Moolenaar
 * @version 1.1
 */
public class Inventory {
  private final HashMap <Integer, Instrument> stock,
      sales; // available collection, sales map
  
  /**
   * Default Constructor
   */
  public Inventory() {
    stock = new HashMap <>();
    sales = new HashMap <>();
  }
  
  /**
   * Creates instrument from given parameters and hands off adding to stock to its polymorphic counterpart
   *
   * @param i a <code>Instrument</code>
   */
  public void addToCollection(Instrument i) {
    stock.put(i.getSerialNo(), i);
  }
  
  /**
   * Removes from stock and marks it as sold (adds to sales)
   *
   * @param serialNo serial number of instrument to delete
   * @return <code>true</code> if successfully removed from stock and added to sales map; <code>false</code> otherwise
   */
  public boolean sell(int serialNo) {
    if (!stock.containsKey(serialNo)) throw new
        IllegalArgumentException("Invalid Serial Number.");
    Instrument g = stock.get(serialNo);
    return stock.remove(serialNo, g) && g == sales.put(serialNo, g);
  }
  
  /**
   * replace a given instrument field, view a specified value
   *
   * @param serialNo serial no of instrument to change
   * @param field    field of instrument to change; MUST BE Title Case
   * @param value    value of field to set
   * @throws NoSuchElementException   if invalid serial number is injected
   */
  public void replace(int serialNo, String field,
                      SpecValue value) throws NoSuchElementException {
    if (!stock.containsKey(serialNo))
      throw new NoSuchElementException(String.format("Instrument #%d is not in stock.",
          serialNo));
    Instrument i = stock.get(serialNo);
    i.addProperty(field,value);
  }
  
  /**
   * Actual implementation of the search method
   *
   * @param coll  the collection to search from
   * @param ideal value that is tested against
   *              all fields of Instrument, regardless of its intrinsic data type
   * @return list of matched elements, or NoSuchElementException
   */
  private List <Instrument> refinedSearch(Collection <Instrument> coll,
                                          InstrumentSpecification ideal) {
    if (coll.isEmpty()) throw new IllegalArgumentException("Nothing to search.");
    List <Instrument> results = new ArrayList <>(coll.size());
    for (Instrument g : coll)
      if (g.matches(ideal))
        results.add(g);
    if (results.isEmpty()) throw new
        NoSuchElementException(
        String.format("There are no elements with the requested specifcation.\n"));
    return results;
  }
  
  /**
   * Searches for a instrument based on a single keyword
   * <p>
   * Keyword can be any attribute of the instrument except the price.
   *
   * @param coll  Collection to search from
   * @param ideal Property to search by
   * @return List containing [1,N] instruments, or null
   */
  public List <Instrument> search(Collection <Instrument> coll,
                                  InstrumentSpecification ideal) {
    return refinedSearch(coll, ideal);
  }
  
  /**
   * Searches for a instrument based on a single keyword
   *
   * @param ideal Property to search by
   * @return Instruments if found, or null
   */
  public List <Instrument> search(InstrumentSpecification ideal) {
    return refinedSearch(stock.values(), ideal);
  }
  

  /*
   *
   * Helper Methods
   *
   */
  
  /**
   * Returns a Collection of instruments in stock
   *
   * @return Collection of Instruments in stock
   */
  public Collection <Instrument> getStockContents() {
    return stock.values();
  }
  
  /**
   * Checks whether there are any instruments in stock
   *
   * @return true if stock has instruments
   */
  public boolean stockNotEmpty() {
    return !stock.isEmpty();
  }
  
  /**
   * Returns a Instrument with given serial number from stock
   *
   * @param serialNo serial number of instrument to get from stock
   * @return Instrument if found
   * @throws NoSuchElementException if instrument is not in stock
   */
  public Instrument getFromStock(int serialNo) {
    Instrument g = stock.get(serialNo);
    if (g == null) throw new NoSuchElementException(
        String.format("Instrument #%d is not in stock.\n", serialNo));
    return g;
  }
  
  /**
   * Returns a Collection of instruments sold
   *
   * @return Collection of Instruments sold
   */
  public Collection <Instrument> getSalesContents() {
    return sales.values();
  }
  
  private String purify(String s) {
    return s.toLowerCase().replaceAll(" ", "");
  }

  /*
   * Table Generation Helpers
   */
  
  /**
   * Polymorphic padding function that does not print a footer
   */
  private void printPadding() {
    printPadding(false);
  }
  
  /**
   * Polymorphic padding function that creates a tabular view
   *
   * @param foot decides whether a header or footer needs to be printed
   */
  private void printPadding(boolean foot) {
    String border =
        "\t+===========+=======+=====================+====================+===========+====================+============+============+";
    String titles =
        "\t|    Type   | S.No. |        Brand        |       Model        |   Price   |      SoundType     |  Top-Wood  | Back-Wood  |";
    if (!foot)
      System.out.printf("%s\n%s\n%s\n", border, titles, border);
    else
      System.out.printf("%s\n", border);
  }
  
  /**
   * Prints all instruments available in a given collection
   *
   * @param c collection to display from
   */
  public void showFrom(Collection <Instrument> c) {
    printPadding();
    for (Instrument g : c)
      System.out.printf("%s", g);
    printPadding(true);
  }
}
