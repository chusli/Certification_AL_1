package org.example.gildedrose;

public class MaturingItem extends Item {

    public MaturingItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void update() {
        if (quality == 0) {
            return;
        }
        quality++;
    }

}
