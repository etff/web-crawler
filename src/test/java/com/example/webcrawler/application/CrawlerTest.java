package com.example.webcrawler.application;

import com.example.webcrawler.application.crawler.Crawler;
import com.example.webcrawler.application.stub.StubCrawler;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CrawlerTest {

    @Test
    void crawler() {
        Crawler crawler = new StubCrawler();
        String dataFromUrl = crawler.getDataFromUrl("https://www.google.com");

        assertThat(dataFromUrl).isNotEmpty();
    }
}
