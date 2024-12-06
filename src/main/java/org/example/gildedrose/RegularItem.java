package org.example.gildedrose;

public class RegularItem extends Item {

    public RegularItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void update() {
        if (quality > 0) {
            quality--;
        }
    }

}
