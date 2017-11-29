package com.guitarshop;

/**
 * Builder class that simplifies Guitar creation
 *
 * @author Zorawar Moolenaar
 * @version 1.1
 */
class GuitarSpecificationBuilder {
    private final GuitarSpecification spec;

    /**
     * Skeletal Constructor for <code>GuitarSpecificationBuilder</code>
     */
    GuitarSpecificationBuilder() {
        spec = new GuitarSpecification();
    }

    /**
     * Adds Brand attribute to the guitar
     *
     * @param brand of the <code>Guitar</code>
     * @return this <code>GuitarSpecificationBuilder</code>
     */
    GuitarSpecificationBuilder withBrand(String brand) {
        if (brand == null)
            throw new IllegalArgumentException("brand can not be null");
        spec.setBrand(brand);
        return this;
    }

    /**
     * Adds Model attribute to the guitar
     *
     * @param model of the <code>Guitar</code>
     * @return this <code>GuitarSpecificationBuilder</code>
     */
    GuitarSpecificationBuilder withModel(String model) {
        if (model == null)
            throw new IllegalArgumentException("model can not be null");
        spec.setModel(model);
        return this;
    }

    /**
     * Adds SoundType attribute to the guitar
     *
     * @param type of sound (electric/acoustic) of the <code>Guitar</code>
     * @return this <code>GuitarSpecificationBuilder</code>
     */
    GuitarSpecificationBuilder withSoundType(String type) {
        if (type == null)
            throw new IllegalArgumentException("sound type can not be null");
        spec.setSoundType(type);
        return this;
    }

    /**
     * Adds top and back Wood attribute to the guitar
     *
     * @param top wood of the <code>Guitar</code>
     * @param back Wood of the <code>Guitar</code>
     * @return this <code>GuitarSpecificationBuilder</code>
     */
    GuitarSpecificationBuilder withWood(String top, String back) {
        if (top == null || back == null)
            throw new IllegalArgumentException("top and back wood can not be null");
        spec.setTopWood(top);
        spec.setBackWood(back);
        return this;
    }

    /**
     * Returns the constructed guitar
     *
     * @return the <code>Guitar</code>
     */
    GuitarSpecification build() {
        return spec;
    }

}
