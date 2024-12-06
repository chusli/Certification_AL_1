package org.example.gildedrose;

public abstract class AbstractItem extends Item {

    private static final int MAXIMUM_QUALITY = 50;

    private static final int MINIMUM_QUALITY = 0;

    public AbstractItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void update() {
        if (quality > MAXIMUM_QUALITY) {
            quality = MAXIMUM_QUALITY;
        }
        if (quality <= MINIMUM_QUALITY) {
            quality = MINIMUM_QUALITY;
        }
        sellIn--;
    }

}
