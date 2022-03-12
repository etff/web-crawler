package com.example.webcrawler.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CrawlerResponse {
    @ApiModelProperty(value = "몫")
    private String quotient;
    @ApiModelProperty(value = "나머지")
    private String remains;

    public CrawlerResponse(String quotient, String remains) {
        this.quotient = quotient;
        this.remains = remains;
    }
}
