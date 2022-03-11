package com.example.webcrawler.application.formtter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TextParserTest {
    private TextParser textParser;

    @BeforeEach
    void setUp() {
        textParser = new TextParser();
    }

    @DisplayName("HTML을 제거한 텍스트를 리턴한다.")
    @Test
    void remove_html() {
        final String givenInput = ""
                + "<html>"
                + "<head>"
                + "<script src=\"/sample.js\">alert('hi');</script>"
                + "</head>"
                + "</body>"
                + "<div>hi...</div>"
                + "</body>"
                + "</html>";
        assertThat(textParser.parseHTML(givenInput)).isEqualTo("alerthihi");
    }

    @DisplayName("HTML의 한글을 제거하여 리턴한다.")
    @Test
    void remove_html_korean() {
        final String givenInput = "<html><body>가나다라abc</body></html>";
        assertThat(textParser.parseHTML(givenInput)).isEqualTo("abc");
    }

    @DisplayName("텍스트를 입력했을때 영어와 숫자만 리턴한다.")
    @Test
    void accept_english_and_number() {
        String givenInput = "*가1a";

        assertThat(textParser.parseHTML(givenInput)).isEqualTo("1a");
    }

    @DisplayName("한국어가 제거된 값을 리턴한다.")
    @Test
    void remove_text_korean() {
        final String givenInput = "가나다라abc";
        assertThat(textParser.parseText(givenInput)).isEqualTo("abc");
    }
}
