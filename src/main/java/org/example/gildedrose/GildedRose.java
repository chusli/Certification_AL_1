package org.example.gildedrose;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item instanceof RegularItem regularItem) {
                regularItem.update();
            } else {
                if (item.quality < 50) {
                    if (item instanceof MaturingItem maturingItem) {
                        maturingItem.update();
                    }

                    if (item instanceof ScarcityItem scarcityItem) {
                        scarcityItem.update();
                    }
                }
            }

            if (!(item instanceof LegendaryItem)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!(item instanceof MaturingItem)) {
                    if (!(item instanceof ScarcityItem)) {
                        if (item.quality > 0) {
                            if (!(item instanceof LegendaryItem)) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }

}
