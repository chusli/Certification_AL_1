package org.example.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RegularItemTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void whenQualityGreaterThanZeroThenUpdateQuality(int initialQuality) {
        RegularItem regularItem = new RegularItem("foo", 3, initialQuality);

        regularItem.update();

        assertThat(regularItem.quality).isEqualTo(initialQuality - 1);
    }

    @Test
    void whenQualityZeroThenDoNotUpdate() {
        RegularItem regularItem = new RegularItem("foo", 3, 0);

        regularItem.update();

        assertThat(regularItem.quality).isEqualTo(0);
    }

}