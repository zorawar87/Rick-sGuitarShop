package com.guitarshop;

/**
 * Describes guitar specifications
 *
 * @author Zorawar Moolenaar
 * @version 1.1
 */
public class Guitar extends StringInstrument{
    private Integer stringCount;
    /**
     * Set the number of strings on this string instrument.
     *
     * @param value to set as stringCount
     */
    public void setStringCount(Integer value) {
        stringCount = value;
    }

    /**
     * Creates a GuitarBuilder
     *
     * @return GuitarBuilder
     */
    static GuitarBuilder builder() {
        return new GuitarBuilder();
    }

    /**
     * Returns a string representation of this mandolin.
     *
     * @return formatted string representation
     */
    @Override
    public String toString() {
        return String.format(
                "\t|  %03d  | %-19s | %-18s |  %06.2f   |  %-10s        | %-10s | %-10s | %-2s |\n",
                meta.getSno(), brand, model, price, type, topWood, backWood, stringCount);
    }
}
