package org.example.gildedrose;

public class MaturingItem extends AbstractItem {

    public MaturingItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        if (quality == 0) {
            return;
        }
        quality++;
        super.update();
    }

}
