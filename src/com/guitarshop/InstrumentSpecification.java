package com.guitarshop;

import com.guitarshop.specs.SpecValue;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class InstrumentSpecification {
  private final Map <String, SpecValue> spec;
  
  public InstrumentSpecification() {
    spec = new HashMap <>(7);
  }
  
  // TODO: prohibit if property and value are not of the same type
  public InstrumentSpecification addProperty(String property, SpecValue value){
    spec.put(property,value);
    return this;
  }
  public InstrumentSpecification addProperty(String property, String value){
    spec.put(property,resolveToEnum(value));
    return this;
  }
  
  private SpecValue resolveToEnum(String value) {
  }
  
  public SpecValue getProperty(String property) throws IllegalArgumentException {
    if (spec.containsKey(property)) return spec.get(property);
    throw new IllegalArgumentException("No Such Instrument Property");
  }
  
  public Map <String, SpecValue> getProperties() {
    return spec;
  }
  
  public Set<Map.Entry<String,SpecValue>> getAllEntries() {
    return spec.entrySet();
  }
  
  public boolean matches(InstrumentSpecification template) {
    for (Map.Entry <String, SpecValue> e : template.getAllEntries())
      if (!isCorrectKVPair(e))
        return false;
    return true;
  }
  
  // TODO: use getProperty() or spec.get()
  private boolean isCorrectKVPair(Map.Entry <String, SpecValue> e) {
    String templateKey = e.getKey();
    SpecValue templateVal = e.getValue();
    return spec.containsKey(templateKey) &&
        getProperty(templateKey) == templateVal;
  }
}
