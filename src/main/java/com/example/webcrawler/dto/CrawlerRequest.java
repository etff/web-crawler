package com.example.webcrawler.dto;

import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(value = "검색주소", example = "https://www.google.com")
    @URL
    private String url;

    /**
     * 필터 타입.
     */
    @ApiModelProperty(value = "검색유형 (TEXT, HTML)", example = "HTML")
    @NotNull
    private Type type;

    /**
     * 출력 단위 묶음.
     */
    @ApiModelProperty(value = "출력단위", example = "3")
    @Positive
    private Integer unit;

    public CrawlerRequest(String url, Type type, Integer unit) {
        this.url = url;
        this.type = type;
        this.unit = unit;
    }
}
