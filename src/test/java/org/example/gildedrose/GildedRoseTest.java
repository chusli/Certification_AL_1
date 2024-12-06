package org.example.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseTest {

    @Test
    void regularItemLosesQuality() {
        Item[] items = new Item[]{new RegularItem("foo", 2, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0]).usingRecursiveComparison().ignoringFields("decayRate").isEqualTo(new Item("foo", 1, 9));
    }

    @Test
    void regularItemLosesDoubleQualityAfterSellInReached() {
        Item[] items = new Item[]{new RegularItem("foo", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0]).usingRecursiveComparison().ignoringFields("decayRate").isEqualTo(new Item("foo", -1, 8));
    }

    @Test
    void legendaryItemNeverLosesItsQuality() {
        GildedRose gildedRose = new GildedRose(new Item[]{new LegendaryItem("Sulfuras, Hand of Ragnaros", 42)});
        gildedRose.updateQuality();
        assertThat(gildedRose.items[0]).usingRecursiveComparison().isEqualTo(new Item("Sulfuras, Hand of Ragnaros", 42, 80));
    }

    @Test
    void maturingItemGainsQuality() {
        GildedRose gildedRose = new GildedRose(new Item[]{new MaturingItem("Aged Brie", 10, 10)});
        gildedRose.updateQuality();
        assertThat(gildedRose.items[0]).usingRecursiveComparison().isEqualTo(new Item("Aged Brie", 9, 11));
    }

    @Test
    void maturingItemNeverOvershootsQualityOf50() {
        GildedRose gildedRose = new GildedRose(new Item[]{new MaturingItem("Aged Brie", 10, 50)});
        gildedRose.updateQuality();
        assertThat(gildedRose.items[0]).usingRecursiveComparison().isEqualTo(new Item("Aged Brie", 9, 50));
    }

    @Test
    void scarcityItemGainsQuality() {
        GildedRose gildedRose = new GildedRose(new Item[]{new ScarcityItem("Backstage passes to a TAFKAL80ETC concert", 20, 10)});
        gildedRose.updateQuality();
        assertThat(gildedRose.items[0]).usingRecursiveComparison().isEqualTo(new Item("Backstage passes to a TAFKAL80ETC concert", 19, 11));
    }

    @Test
    void scarcityItemGainsMoreQualityTheOlderItIs() {
        GildedRose gildedRose = new GildedRose(new Item[]{
                new ScarcityItem("Backstage passes to a TAFKAL80ETC concert", 10, 10),
                new ScarcityItem("Backstage passes to a TAFKAL80ETC concert", 2, 10)
        });
        gildedRose.updateQuality();
        assertThat(gildedRose.items[0]).usingRecursiveComparison().isEqualTo(new Item("Backstage passes to a TAFKAL80ETC concert", 9, 12));
        assertThat(gildedRose.items[1]).usingRecursiveComparison().isEqualTo(new Item("Backstage passes to a TAFKAL80ETC concert", 1, 13));
    }

    @Test
    void scarcityItemDropQualityToZeroWhenSellInZero() {
        GildedRose gildedRose = new GildedRose(new Item[]{new ScarcityItem("Backstage passes to a TAFKAL80ETC concert", 0, 10)});
        gildedRose.updateQuality();
        assertThat(gildedRose.items[0]).usingRecursiveComparison().isEqualTo(new Item("Backstage passes to a TAFKAL80ETC concert", -1, 0));

    }

    @Test
    void scarcityItemNeverOvershootsQualityOf50() {
        GildedRose gildedRose = new GildedRose(new Item[]{new ScarcityItem("Backstage passes to a TAFKAL80ETC concert", 10, 50)});
        gildedRose.updateQuality();
        assertThat(gildedRose.items[0]).usingRecursiveComparison().isEqualTo(new Item("Backstage passes to a TAFKAL80ETC concert", 9, 50));
    }

    @Test
    void conjuredItemDecayTwiceAsFast() {
        GildedRose gildedRose = new GildedRose(new Item[]{new ConjuredItem("Mana Cake", 10, 20)});
        gildedRose.updateQuality();
        assertThat(gildedRose.items[0]).usingRecursiveComparison().ignoringFields("decayRate").isEqualTo(new Item("Mana Cake", 9, 18));
    }

}