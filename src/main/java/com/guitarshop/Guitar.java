package com.guitarshop;
/**
 * Describes guitar specifications
 * @author Zorawar Moolenaar
 * @version 1.0
 */
public class Guitar {
    private Metadata meta;
    private Brand brand;
    private String model;
    private float price;
    private SoundType type;
    private Wood topWood, backWood;

    /**
     * Creates a GuitarBuilder in accordance with the Builder Design Pattern
     * @return GuitarBuilder
     */
    static GuitarBuilder builder() {
        return new GuitarBuilder();
    }

    /**
     * Creates a new Guitar
     */
    public Guitar(){this.meta=new Metadata();}

    /**
     * Get the Serial number
     * @return serial number of object
     */
    public int getSno() { return meta.getSno(); }

    /**
     * Set the metadata for this guitar.
     * @param value to set as metadata
     */
    public void setMetadata (Metadata value ) { meta = value; }
    /**
     * Set the brand of this guitar.
     * @param value to set as brand
     */
    public void setBrand (String value ) {
        brand = Brand.validate (value);
    }
    /**
     * Set the model of this guitar.
     * @param value to set as model
     */
    public void setModel (String value ) {
        model = value;
    }
    /**
     * Set the price of this guitar.
     * @param value to set as price
     */
    public void setPrice (Float value ) {
        price = value;
    }
    /**
     * Set the type of this guitar.
     * @param value to set as type
     */
    public void setSoundType (String value ) {
        type = SoundType.validate (value);
    }
    /**
     * Set the top wood type of this guitar.
     * @param value to set as topWood
     */
    public void setTopWood (String value ) {
        topWood = Wood.validate (value);
    }
    /**
     * Set the back wood type of this guitar.
     * @param value to set as backWood
     */
    public void setBackWood (String value ) {
        backWood = Wood.validate (value);
    }

    /**
     * Automatically assign a serial number to this guitar.
     */
    public void assignSno() { meta.assignSno();  meta.getSno(); }

    /**
     * Returns <code>true</code> if this guitar. contains property.
     * @param property String to look for
     * @return <code>true</code> if the object contains the property; <code>false</code> otherwise
     */
    public boolean contains (String property) {
        if (meta.contains (property)) return true;
        property = property.toLowerCase();
        return Brand.testEquality (brand, property)
                || property.equals (model.toLowerCase())
                || SoundType.testEquality (type, property)
                || Wood.testEquality (topWood, property)
                || Wood.testEquality (backWood, property);
    }

    /**
     * Returns a string representation of this guitar.
     * @return formatted string representation
     */
    public String toString () {
        return String.format (
                "\t|  %03d  | %-19s | %-18s |  %.2f   |  %-10s        | %-10s | %-10s |\n",
                meta.getSno(), brand, model, price, type, topWood, backWood);
    }
}