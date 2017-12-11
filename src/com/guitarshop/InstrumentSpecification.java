package com.guitarshop;

import com.guitarshop.specs.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class InstrumentSpecification {
  /**
   * stores all properties for a given instrument
   */
  private final Map <String, SpecValue> spec;
  
  /**
   * Creates a new Instrument Specification object and assigns foundational values
   */
  public InstrumentSpecification() {
    spec = new HashMap <>(7);
    addProperty("instrument name", InstrumentName.WILDCARD);
    addProperty("type", SoundType.WILDCARD);
    addProperty("builder", Builder.WILDCARD);
    addProperty("back wood", Wood.WILDCARD);
    addProperty("top wood", Wood.WILDCARD);
    addProperty("model", Model.create("*"));
  }
  
  /**
   * add or update a property of an instrument specification
   *
   * @param property to add or update
   * @param value    to add or update
   * @return the InstrumentSpecification object
   */
  // TODO: prohibit if property and value are not of the same type
  public InstrumentSpecification addProperty(String property, SpecValue value) {
    if (spec.containsKey(property))
      spec.replace(property, value);
    else
      spec.put(property, value);
    return this;
  }
  
  
  /**
   * gets a property of this InstrumentSpecification, given the property's string representation
   *
   * @param property to retrieve
   * @return value assigned to the given property
   * @throws IllegalArgumentException when property is invalid
   */
  // does not perform input checking. expects one of seven valid properties
  public SpecValue getProperty(String property) throws IllegalArgumentException {
    if (spec.containsKey(property)) return spec.get(property);
    throw new IllegalArgumentException("No Such Instrument Property");
  }
  
  /**
   * gets all properties of this InstrumentSpecification
   *
   * @return properties and corresponding values as a map
   */
  public Map <String, SpecValue> getProperties() {
    return spec;
  }
  
  /**
   * gets all entry-sets of property-values for this InstrumentSpecification
   * @return Set of Map Entries containing property-values
   */
  public Set <Map.Entry <String, SpecValue>> getAllEntries() {
    return spec.entrySet();
  }
  
  /**
   * checks whether this instrumentSpecification is a subset of the given template
   * @param template instrumentSpecification to compare with
   * @return true if they match; false otherwise
   */
  public boolean matches(InstrumentSpecification template) {
    for (Map.Entry <String, SpecValue> e : template.getAllEntries())
      if (!isCorrectKVPair(e))
        return false;
    return true;
  }
  
  /**
   * checks whether some map entry in this instrument specification is a subset of the given map-entry
   * @param e map entry to check against
   * @return true if the given pair is valid and correct; false otherwise
   */
  private boolean isCorrectKVPair(Map.Entry <String, SpecValue> e) {
    String templateKey = e.getKey();
    SpecValue templateVal = e.getValue();
    return spec.containsKey(templateKey) &&
        (templateVal.equals(getProperty(templateKey))) ||
        (templateVal.toString().equalsIgnoreCase("*"));
  }
}
