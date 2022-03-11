package com.example.webcrawler.application.formtter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TextOrderTest {

    @DisplayName("텍스트 정렬 테스트")
    @Test
    void order() {
        TextOrder textOrder = new TextOrder();
        String input = "z0Aaa17bBZA";

        String actual = textOrder.compare(input);

        assertThat(actual).isEqualTo("A0A1a7aBbZz");
    }
}
