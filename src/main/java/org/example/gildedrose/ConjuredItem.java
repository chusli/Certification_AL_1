package org.example.gildedrose;

public class ConjuredItem extends RegularItem {

    private static final int DECAY_RATE = 2;

    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality, DECAY_RATE);
    }

}
