package com.example.webcrawler.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@NoArgsConstructor
@Getter
public class CrawlerRequest {
    /**
     * 크롤링할 URL.
     */
    @URL
    private String url;

    /**
     * 필터 타입.
     */
    @NotNull
    private Type type;

    /**
     * 출력 단위 묶음.
     */
    @Positive
    private Integer unit;

    public CrawlerRequest(String url, Type type, Integer unit) {
        this.url = url;
        this.type = type;
        this.unit = unit;
    }
}
