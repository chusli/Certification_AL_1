package org.example.gildedrose;

public class ScarcityItem extends Item {

    public ScarcityItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void update() {
        if (quality == 0) {
            return;
        }

        if (sellIn > 10) {
            quality++;
        } else if (sellIn > 5) {
            quality += 2;
        } else if (sellIn > 1) {
            quality += 3;
        } else {
            quality = 0;
        }
    }

}
