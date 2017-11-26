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

}
