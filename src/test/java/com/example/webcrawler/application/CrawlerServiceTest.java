package com.example.webcrawler.application;

import com.example.webcrawler.application.stub.StubCrawler;
import com.example.webcrawler.dto.CrawlerRequest;
import com.example.webcrawler.dto.CrawlerResponse;
import com.example.webcrawler.dto.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CrawlerServiceTest {
    private CrawlerService crawlerService;

    @BeforeEach
    void setUp() {
        crawlerService = new CrawlerService(new StubCrawler());
    }

    @Test
    void getData() {
        CrawlerRequest request = new CrawlerRequest("https://www.google.com", Type.HTML, 10);

        final CrawlerResponse actual = crawlerService.getData(request);

        assertThat(actual).isNotNull();
    }
}
