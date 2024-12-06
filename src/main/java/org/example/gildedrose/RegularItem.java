package org.example.gildedrose;

public class RegularItem extends AbstractItem {

    int decayRate = 1;

    public RegularItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    RegularItem(String name, int sellIn, int quality, int decayRate) {
        super(name, sellIn, quality);
        this.decayRate = decayRate;
    }

    @Override
    public void update() {
        if (sellIn < 1) {
            quality -= decayRate * 2;
        } else {
            quality -= decayRate;
        }
        super.update();
    }

}
