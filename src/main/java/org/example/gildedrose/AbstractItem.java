package org.example.gildedrose;

public abstract class AbstractItem extends Item {

    private static final int MAXIMUM_QUALITY = 50;

    public AbstractItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void update() {
        if (quality > MAXIMUM_QUALITY) {
            quality = MAXIMUM_QUALITY;
        }
    }

}
