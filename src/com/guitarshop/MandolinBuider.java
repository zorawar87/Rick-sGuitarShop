package com.guitarshop;

/**
 * Builder class that simplifies Mandolin creation
 *
 * @author Zorawar Moolenaar
 * @version 1.0
 */
class MandolinBuilder {
    private final Mandolin mandolin;

    /**
     * Skeletal Constructor for <code>MandolinBuilder</code>
     */
    MandolinBuilder() {
        mandolin = new Mandolin();
    }

    /**
     * Adds Brand attribute to the mandolin
     *
     * @return this <code>MandolinBuilder</code>
     */
    MandolinBuilder withBrand(String brand) {
        if (brand == null)
            throw new IllegalArgumentException("brand can not be null");
        mandolin.setBrand(brand);
        return this;
    }

    /**
     * Adds Model attribute to the mandolin
     *
     * @return this <code>MandolinBuilder</code>
     */
    MandolinBuilder withModel(String model) {
        if (model == null)
            throw new IllegalArgumentException("model can not be null");
        mandolin.setModel(model);
        return this;
    }

    /**
     * Adds Price attribute to the mandolin
     *
     * @return this <code>MandolinBuilder</code>
     */
    MandolinBuilder withPrice(Number price) {
        if (price == null)
            throw new IllegalArgumentException("price can not be null");
        mandolin.setPrice(price.floatValue());
        return this;
    }

    /**
     * Adds SoundType attribute to the mandolin
     *
     * @return this <code>MandolinBuilder</code>
     */
    MandolinBuilder withSoundType(String type) {
        if (type == null)
            throw new IllegalArgumentException("sound type can not be null");
        mandolin.setSoundType(type);
        return this;
    }

    /**
     * Adds top and back Wood attribute to the mandolin
     *
     * @return this <code>MandolinBuilder</code>
     */
    MandolinBuilder withWood(String top, String back) {
        if (top == null || back == null)
            throw new IllegalArgumentException("top and back wood can not be null");
        mandolin.setTopWood(top);
        mandolin.setBackWood(back);
        return this;
    }

    /**
     * Returns the constructed mandolin
     *
     * @return the <Mandolin>
     */
    Mandolin build() {
        return mandolin;
    }

}
