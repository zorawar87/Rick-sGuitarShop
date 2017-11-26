package com.guitarshop;

/**
 * Describes mandolin specifications
 *
 * @author Zorawar Moolenaar
 * @version 1.1
 */
public class Mandolin extends StringInstrument{
    private MandolinStyle style;

    /**
     * Creates a MandolinBuilder
     *
     * @return MandolinBuilder
     */
    static MandolinBuilder builder() {
        return new MandolinBuilder();
    }

    /**
     * Set the number of strings on this string instrument.
     *
     * @param value to set as stringCount
     */
    public void setStyle(String value) {
        style = MandolinStyle.validate(value);
    }

    /**
     * Returns <code>true</code> if this mandolin contains property.
     *
     * @param property String to look for
     * @return <code>true</code> if the object contains the property; <code>false</code> otherwise
     */
    @Override
    public boolean contains(String property) {
        return MandolinStyle.testEquality(style, property)
                || super.contains(property);
    }
}
