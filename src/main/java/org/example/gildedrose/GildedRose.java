package org.example.gildedrose;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item instanceof AbstractItem abstractItem) {
                abstractItem.update();
            }
        }
    }

}
