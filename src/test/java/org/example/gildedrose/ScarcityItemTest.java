package org.example.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class ScarcityItemTest {

    @Test
    void whenSellInGreaterThanTenThenUpdateQualityByOne() {
        ScarcityItem scarcityItem = new ScarcityItem("Test", 11, 10);

        scarcityItem.update();

        assertThat(scarcityItem.quality).isEqualTo(11);
    }

    @Test
    void whenSellInGreaterThanFiveThenUpdateQualityByTwo() {
        ScarcityItem scarcityItem = new ScarcityItem("Test", 6, 10);

        scarcityItem.update();

        assertThat(scarcityItem.quality).isEqualTo(12);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4})
    void whenSellInLessOrEqualToFiveThenUpdateQualityByThree(int initialSellIn) {
        ScarcityItem scarcityItem = new ScarcityItem("Test", initialSellIn, 10);

        scarcityItem.update();

        assertThat(scarcityItem.quality).isEqualTo(13);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, -1, -2})
    void whenSellInOneOrLessThenUpdateQualityToZero(int initialSellIn) {
        ScarcityItem scarcityItem = new ScarcityItem("Test", initialSellIn, 42);

        scarcityItem.update();

        assertThat(scarcityItem.quality).isEqualTo(0);

    }

}