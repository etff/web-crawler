package com.example.webcrawler.application.formtter;


import com.example.webcrawler.dto.CrawlerResponse;

import java.util.Objects;

/**
 * 데이터를 요청한 출력 조건으로 포매팅합니다.
 */
public class TextFormatter {
    private static final String BLANK_NOT_ALLOWED = "빈값이 들어올 수 없습니다.";
    private static final String MINIMUM_UNIT_VALUE = "0보다 작을 수 없습니다.";

    public TextFormatter() {
    }

    /**
     * 포맷을 변경합니다. ex) abcde => 몫: ab,cd 나머지: e 로 리턴합니다.
     *
     * @param text 입력된 텍스트
     * @param unit 출력 묶음 단위
     * @return 포맷이 변경된 결과값
     */
    public CrawlerResponse changeFormat(String text, int unit) {
        validateParameters(text, unit);
        if (text.length() < unit) {
            return new CrawlerResponse("", text);
        }

        final int quotient = getQuotient(text, unit);
        final String subString = getSubstring(text, unit, quotient);
        final String remains = getRemains(text, unit, quotient);
        return new CrawlerResponse(appendText(unit, subString), remains);
    }

    private String getRemains(String text, int unit, int quotient) {
        return text.substring(quotient * unit);
    }

    private String getSubstring(String text, int unit, int quotient) {
        return text.substring(0, (quotient * unit));
    }

    private int getQuotient(String text, int unit) {
        return text.length() / unit;
    }

    private String appendText(int unit, String subString) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < subString.length(); i++) {
            sb.append(subString.charAt(i));
            int endOfText = subString.length() - 1;
            if (i % unit == unit - 1 && i != endOfText) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    private void validateParameters(String text, int unit) {
        if (Objects.isNull(text) || text.isEmpty()) {
            throw new IllegalArgumentException(BLANK_NOT_ALLOWED);
        }
        if (unit < 0) {
            throw new IllegalArgumentException(MINIMUM_UNIT_VALUE);
        }
    }
}
