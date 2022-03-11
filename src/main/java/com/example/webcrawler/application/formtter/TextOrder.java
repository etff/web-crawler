package com.example.webcrawler.application.formtter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * 택스트를 정렬합니다.
 */
public class TextOrder {
    /**
     * 택스트를 비교하여 알파벳 숫자로 교차하여 출력합니다. ex) bB1aA4 => A1a4Bb
     *
     * @param text 입력받은 텍스트
     * @return 정렬된 텍스트
     */
    public String compare(String text) {
        Queue<Character> queue = getSortNumbers(text);
        List<String> sortText = sortText(text);
        return appendText(queue, sortText);
    }

    private List<String> sortText(String input) {
        // 알파벳순서로 정렬한다
        return Arrays.stream(input.split(""))
                .filter(v -> Character.isLetter(v.charAt(0)))
                .sorted((o1, o2) -> {
                    int res = o1.compareToIgnoreCase(o2);
                    return (res == 0) ? o1.compareTo(o2) : res;
                }).collect(Collectors.toList());
    }

    private Queue<Character> getSortNumbers(String input) {
        List<Character> numbers = new ArrayList();
        for (Character c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                numbers.add(c);
            }
        }
        // 숫자만 뽑아 오름차순으로 정렬한다
        Collections.sort(numbers);
        return new LinkedList<>(numbers);
    }

    private String appendText(Queue<Character> queue, List<String> sortText) {
        // 영어와 숫자를 교차하여 출력한다.
        StringBuilder output = new StringBuilder();
        for (String text : sortText) {
            output.append(text);
            if (!queue.isEmpty()) {
                output.append(queue.poll());
            }
        }
        return new String(output);
    }
}
