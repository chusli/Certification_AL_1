package org.example.gildedrose;

public class RegularItem extends AbstractItem {

    public RegularItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        if (sellIn < 1) {
            quality -= 2;
        } else {
            quality--;
        }
        super.update();
    }

}
