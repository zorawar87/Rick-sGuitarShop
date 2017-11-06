package com.guitarshop;
/**
 * Reflects how a guitar is viewed in the context of Rick’s inventory
 * @author Zorawar Moolenaar
 * @version 1.0
 */
public class Metadata {
    private static int COUNTER = 0;
    private Integer serialNo;

    Metadata() {
        serialNo = null;
    }
    int getSno() {return serialNo;}
    void assignSno() { serialNo = ++COUNTER; }

    /**
     * Method that checks whether the object has a given property in its fields
     * @param property property to search for
     * @return true if the object contains the property
     */
    public boolean contains (String property) {
        try {
            int s = Integer.parseInt (property);
            return serialNo == s;
        } catch (Exception e) {
            return false;
        }
    }
}