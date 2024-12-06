package org.example.gildedrose;

public class LegendaryItem extends AbstractItem {

    private static final int NON_BREAKING_QUALITY = 80;

    public LegendaryItem(String name, int sellIn) {
        super(name, sellIn, NON_BREAKING_QUALITY);
    }

    @Override
    public void update() {
        // do not call super.update() to ensure quality is non breaking
    }

}
