package com.example.webcrawler.application.formtter;

public class TextParser {
    private static final String REMOVE_HTML = "<([^>]+)>";
    private static final String ACCEPT_NUMBER_ENGLISH = "[^a-zA-Z0-9]";

    public String parseHTML(String text) {
        return text.replaceAll(REMOVE_HTML, "")
                .replaceAll(ACCEPT_NUMBER_ENGLISH, "")
                .trim();
    }

    public String parseText(String text) {
        return text.replaceAll(ACCEPT_NUMBER_ENGLISH, "")
                .trim();
    }
}
