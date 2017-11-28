package com.guitarshop;

/**
 * Describes string instrument specifications
 *
 * @author Zorawar Moolenaar
 * @version 1.1
 */
public abstract class StringInstrument {
    /** stores data relevant to Rick's guitar shop */
    protected Metadata meta;
    /** brand of the string instrument */
    protected Brand brand;
    /** model of the string instrument */
    protected String model;
    /** cost of the string instrument */
    protected Float price;
    /** sound type of the string instrument */
    protected SoundType type;
    /** top wood of the string instrument */
    protected Wood topWood; 
    /** back wood of the string instrument */
    protected Wood backWood;

    /**
     * Creates a new StringInstrument
     */
    public StringInstrument() {
        this.meta = new Metadata();
    }

    /**
     * Creates a GuitarBuilder
     *
     * @return GuitarBuilder
     */
    public static GuitarBuilder guitarBuilder() {
        return new GuitarBuilder();
    }

    /**
     * Creates a MandolinBuilder
     *
     * @return MandolinBuilder
     */
    public static MandolinBuilder mandolinBuilder() {
        return new MandolinBuilder();
    }

    /**
     * Get the Serial number
     *
     * @return serial number of object
     */
    public int getSno() {
        return meta.getSno();
    }

    /**
     * Set the brand of this string instrument.
     *
     * @param value to set as brand
     */
    public void setBrand(String value) {
        brand = Brand.validate(value);
    }

    /**
     * Set the model of this string instrument.
     *
     * @param value to set as model
     */
    public void setModel(String value) {
        model = value;
    }

    /**
     * Set the price of this string instrument.
     *
     * @param value to set as price
     */
    public void setPrice(Float value) {
        price = value;
    }

    /**
     * Set the type of this string instrument.
     *
     * @param value to set as type
     */
    public void setSoundType(String value) {
        type = SoundType.validate(value);
    }

    /**
     * Set the top wood type of this string instrument.
     *
     * @param value to set as topWood
     */
    public void setTopWood(String value) {
        topWood = Wood.validate(value);
    }

    /**
     * Set the back wood type of this string instrument.
     *
     * @param value to set as backWood
     */
    public void setBackWood(String value) {
        backWood = Wood.validate(value);
    }

    /**
     * Automatically assign a serial number to this string instrument.
     */
    public void assignSno() {
        meta.assignSno();
        meta.getSno();
    }

    /**
     * Returns <code>true</code> if this string instrument contains property.
     *
     * @param property String to look for
     * @return <code>true</code> if the object contains the property; <code>false</code> otherwise
     */
    public boolean contains(String property) {
        if (meta.contains(property)) return true;
        property = property.toLowerCase();
        return Brand.testEquality(brand, property)
                || property.equals(model.toLowerCase())
                || SoundType.testEquality(type, property)
                || Wood.testEquality(topWood, property)
                || Wood.testEquality(backWood, property)
                || property.toLowerCase().equals(this.getClass().getSimpleName().toLowerCase());
    }

    /**
     * Returns a string representation of this string instrument.
     *
     * @return formatted string representation
     */
    @Override
    public String toString() {
        return String.format(
                "\t| %-9s  | %03d  | %-19s | %-18s |  %06.2f   |  %-10s        | %-10s | %-10s |\n",
                this.getClass().getSimpleName(), meta.getSno(), brand, model, price, type, topWood, backWood);
    }
}
