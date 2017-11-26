package com.guitarshop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * Represents an inventory containing in-stock and sold guitars
 *
 * @author Zorawar Moolenaar
 * @version 1.0
 */
public class Inventory {
    private final Map<Integer, StringInstrument> stock, sales; // available collection, sales map

    /**
     * Default Constructor
     */
    public Inventory() {
        stock = new HashMap<>();
        sales = new HashMap<>();
    }

    /**
     * Creates guitar from given parameters and hands off adding to stock to its polymorphic counterpart
     *
     * @param si a <code>StringInstrument</code>
     */
    public void addToCollection(StringInstrument si) {
        si.assignSno();
        stock.put(si.getSno(), si);
    }

    /**
     * Removes from stock and marks it as sold (adds to sales)
     *
     * @param serialNo serial number of guitar to delete
     * @return <code>true</code> if successfully removed from stock and added to sales map; <code>false</code> otherwise
     */
    public boolean sell(int serialNo) {
        if (!stock.containsKey(serialNo)) throw new
                IllegalArgumentException("Invalid Serial Number.");
        StringInstrument si = stock.get(serialNo);
        return stock.remove(serialNo, si) && si == sales.put(serialNo, si);
    }

    /**
     * Actual implementation of the search method
     *
     * @param coll     the collection to search from
     * @param property string value that is tested against
     *                 all fields of StringInstrument, regardless of its intrinsic data type
     * @return list of matched elements, or NoSuchElementException
     */
    private ArrayList<StringInstrument> refinedSearch(Collection<StringInstrument> coll, String property) {
        if (coll.isEmpty()) throw new IllegalArgumentException("Nothing to search.");
        ArrayList<StringInstrument> results = new ArrayList<>(stock.size());
        for (StringInstrument si : coll)
            if (si.contains(property))
                results.add(si);
        if (results.isEmpty()) throw new
                NoSuchElementException(String.format("There are no elements with the \"%s\" keyword in any field.", property));
        return results;
    }

    /**
     * Searches for a guitar based on a single keyword
     * <p>
     * Keyword can be any attribute of the guitar except the price.
     *
     * @param coll     Collection to search from
     * @param property Property to search by
     * @return ArrayList containing [1,N] guitars, or null
     */
    public ArrayList<StringInstrument> search(Collection<StringInstrument> coll, String property) {
        return refinedSearch(coll, property);
    }

    /**
     * Searches for a guitar based on a single keyword
     *
     * @param s Property to search by
     * @return StringInstrument complete object if found, or null
     */
    public ArrayList<StringInstrument> search(String s) {
        return refinedSearch(stock.values(), s);
    }

    /**
     * replace a given guitar field, view a specified value
     *
     * @param serialNo serial no of guitar to change
     * @param field    field of guitar to change; MUST BE Title Case
     * @param value    value of field to set
     * @throws NoSuchElementException   if invalid serial number is injected
     * @throws IllegalArgumentException if invalid field or value is injected
     */
    public void replace(int serialNo, String field, String value) throws NoSuchElementException, IllegalArgumentException {
        if (!stock.containsKey(serialNo))
            throw new NoSuchElementException(String.format("StringInstrument #%d is not in stock.", serialNo));
        StringInstrument si = stock.get(serialNo);
        if (purify(field).equals("brand")) si.setBrand(value);
        else if (purify(field).equals("model")) si.setModel(value);
        else if (purify(field).equals("price"))
            try {
                Float.parseFloat(value);
                si.setPrice(Float.parseFloat(value));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(String.format("Price can only be a decimal. %s is not.", value));
            }
        else if (purify(field).equals("soundtype")) si.setSoundType(value);
        else if (purify(field).equals("topwood")) si.setTopWood(value);
        else if (purify(field).equals("backwood")) si.setBackWood(value);
        else throw new IllegalArgumentException(String.format("%s is not an editable field.", (String) field));
    }

  /*
   *
   * Helper Methods
   *
   */

    /**
     * Returns a Collection of guitars in stock
     *
     * @return Collection of StringInstruments in stock
     */
    public Collection<StringInstrument> getStockContents() {
        return stock.values();
    }

    /**
     * Checks whether there are any guitars in stock
     *
     * @return true if stock has guitars
     */
    public boolean stockNotEmpty() {
        return !stock.isEmpty();
    }

    /**
     * Returns a StringInstrument with given serial number from stock
     *
     * @param serialNo serial number of guitar to get from stock
     * @return StringInstrument if found
     * @throws NoSuchElementException if guitar is not in stock
     */
    public StringInstrument getFromStock(int serialNo) {
        StringInstrument si = stock.get(serialNo);
        if (si == null) throw new NoSuchElementException(
                String.format("StringInstrument #%d is not in stock.\n", serialNo));
        return si;
    }

    /**
     * Returns a Collection of guitars sold
     *
     * @return Collection of StringInstruments sold
     */
    public Collection<StringInstrument> getSalesContents() {
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
                "\t+=======+=====================+====================+===========+====================+============+============+";
        String titles =
                "\t| S.No. |        Brand        |       Model        |   Price   |      SoundType     |  Top-Wood  | Back-Wood  |";
        if (!foot)
            System.out.printf("%s\n%s\n%s\n", border, titles, border);
        else
            System.out.printf("%s\n", border);
    }

    /**
     * Prints all guitars available in a given collection
     *
     * @param c collection to display from
     */
    public void showFrom(Collection<StringInstrument> c) {
        printPadding();
        for (StringInstrument si : c)
            System.out.printf("%s", si);
        printPadding(true);
    }
}
