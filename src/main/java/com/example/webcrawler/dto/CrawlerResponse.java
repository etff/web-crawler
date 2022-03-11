package com.example.webcrawler.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CrawlerResponse {
    private String quotient;
    private String remains;

    public CrawlerResponse(String quotient, String remains) {
        this.quotient = quotient;
        this.remains = remains;
    }
}
