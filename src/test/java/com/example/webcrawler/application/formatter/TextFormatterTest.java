package com.example.webcrawler.application.formatter;

import com.example.webcrawler.application.formtter.TextFormatter;
import com.example.webcrawler.dto.CrawlerResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TextFormatterTest {
    private TextFormatter textFormatter;

    @BeforeEach
    void setUp() {
        textFormatter = new TextFormatter();
    }

    @DisplayName("텍스트의 포멧을 몫과 나머지로 리턴합니다.")
    @Test
    void formatting() {
        final String givenText = "abcde";
        final int givenUnit = 2;

        CrawlerResponse actual = textFormatter.changeFormat(givenText, givenUnit);

        assertThat(actual.getQuotient()).isEqualTo("ab,cd");
        assertThat(actual.getRemains()).isEqualTo("e");
    }

    @DisplayName("텍스트 길이보다 출력단위가 크면 나머지만 리턴합니다. ")
    @Test
    void formatting_with_unit_bigger_than_text_length() {
        final String givenText = "abc";
        final int givenUnit = 5;

        CrawlerResponse actual = textFormatter.changeFormat(givenText, givenUnit);

        assertThat(actual.getQuotient()).isEmpty();
        assertThat(actual.getRemains()).isEqualTo("abc");
    }

    @DisplayName("주어진 텍스트가 빈 값이면 예외를 던집니다.")
    @ParameterizedTest
    @NullAndEmptySource
    void formatting_with_empty_text(String text) {
        final int givenUnit = 2;

        assertThatThrownBy(() -> {
            textFormatter.changeFormat(text, givenUnit);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("출력 단위 묶음이 음수이면 예외를 던집니다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, -10, -50})
    void formatting_with_negative_unit(int unit) {
        final String givenText = "abcd";

        assertThatThrownBy(() -> {
            textFormatter.changeFormat(givenText, unit);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
