package com.guitarshop;

/**
 * Builder class that simplies Guitar creation
 */
public class GuitarBuilder {
  private Guitar guitar;

  /**
   * Skeletal Constructor for <code>GuitarBuilder</code>
   */
  public GuitarBuilder() {
    guitar = new Guitar();
    guitar.setMetadata(new Metadata());
  }

  /**
   * Adds Brand attribute to the guitar
   * @return this <code>GuitarBuilder</code>
   */
  public GuitarBuilder withBrand (String brand) {
    if (brand == null)
      throw new IllegalArgumentException ("brand can not be null");
    guitar.setBrand(brand);
    return this;
  }

  /**
   * Adds Model attribute to the guitar
   * @return this <code>GuitarBuilder</code>
   */
  public GuitarBuilder withModel (String model) {
    if (model == null)
      throw new IllegalArgumentException ("model can not be null");
    guitar.setModel(model);
    return this;
  }

  /**
   * Adds Price attribute to the guitar
   * @return this <code>GuitarBuilder</code>
   */
  public GuitarBuilder withPrice (Number price) {
    if (price == null)
      throw new IllegalArgumentException ("price can not be null");
    guitar.setPrice(price.floatValue());
    return this;
  }

  /**
   * Adds SoundType attribute to the guitar
   * @return this <code>GuitarBuilder</code>
   */
  public GuitarBuilder withSoundType (String type) {
    if (type == null)
      throw new IllegalArgumentException ("sound type can not be null");
    guitar.setSoundType(type);
    return this;
  }

  /**
   * Adds top and back Wood attribute to the guitar
   * @return this <code>GuitarBuilder</code>
   */
  public GuitarBuilder withWood (String top, String back) {
    if (top == null || back == null)
      throw new IllegalArgumentException ("top and back wood can not be null");
    guitar.setTopWood(top);
    guitar.setBackWood(back);
    return this;
  }

  /**
   * Returns the constructed guitar
   * @return the <Guitar>
   */
  public Guitar build() {
    return guitar;
  }

}
