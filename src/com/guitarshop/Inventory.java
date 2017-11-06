package com.guitarshop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * Represents an inventory containing in-stock and sold guitars
 *
 * @author Zorawar Moolenaar
 * @version 0.5
 */
public class Inventory {
    private final HashMap<Integer, Guitar> stock, sales; // available collection, sales map

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
     * @param g a <code>Guitar</code>
     */
    public void addToCollection(Guitar g) {
        g.assignSno();
        stock.put(g.getSno(), g);
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
        Guitar g = stock.get(serialNo);
        return stock.remove(serialNo, g) && g == sales.put(serialNo, g);
    }

    /**
     * Actual implementation of the search method
     *
     * @param coll     the collection to search from
     * @param property string value that is tested against
     *                 all fields of Guitar, regardless of its intrinsic data type
     * @return list of matched elements, or NoSuchElementException
     */
    private ArrayList<Guitar> refinedSearch(Collection<Guitar> coll, String property) {
        if (coll.isEmpty()) throw new IllegalArgumentException("Nothing to search.");
        ArrayList<Guitar> results = new ArrayList<>(stock.size());
        for (Guitar g : coll)
            if (g.contains(property))
                results.add(g);
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
    public ArrayList<Guitar> search(Collection<Guitar> coll, String property) {
        return refinedSearch(coll, property);
    }

    /**
     * Searches for a guitar based on a single keyword
     *
     * @param s Property to search by
     * @return Guitar complete object if found, or null
     */
    public ArrayList<Guitar> search(String s) {
        return refinedSearch(stock.values(), s);
    }

    private boolean replace(int serialNo, Guitar newValue) {
        return false;
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
            throw new NoSuchElementException(String.format("Guitar #%d is not in stock.", serialNo));
        Guitar g = stock.get(serialNo);
        if (purify(field).equals("brand")) g.setBrand(value);
        else if (purify(field).equals("model")) g.setModel(value);
        else if (purify(field).equals("price"))
            try {
                Float.parseFloat(value);
                g.setPrice(Float.parseFloat(value));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(String.format("Price can only be a decimal. %s is not.", value));
            }
        else if (purify(field).equals("soundtype")) g.setSoundType(value);
        else if (purify(field).equals("topwood")) g.setTopWood(value);
        else if (purify(field).equals("backwood")) g.setBackWood(value);
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
     * @return Collection of Guitars in stock
     */
    public Collection<Guitar> getStockContents() {
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
     * Returns a Guitar with given serial number from stock
     *
     * @param serialNo serial number of guitar to get from stock
     * @return Guitar if found
     * @throws NoSuchElementException if guitar is not in stock
     */
    public Guitar getFromStock(int serialNo) {
        Guitar g = stock.get(serialNo);
        if (g == null) throw new NoSuchElementException(
                String.format("Guitar #%d is not in stock.\n", serialNo));
        return g;
    }

    /**
     * Returns a Collection of guitars sold
     *
     * @return Collection of Guitars sold
     */
    public Collection<Guitar> getSalesContents() {
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
    public void showFrom(Collection<Guitar> c) {
        printPadding();
        for (Guitar g : c)
            System.out.printf("%s", g);
        printPadding(true);
    }
}