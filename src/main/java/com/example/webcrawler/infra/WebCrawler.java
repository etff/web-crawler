package com.example.webcrawler.infra;

import com.example.webcrawler.application.crawler.Crawler;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

@Component
public class WebCrawler implements Crawler {
    private Document document;

    @Override
    public String getDataFromUrl(String url) {
        try {
            document = Jsoup.connect(url).get();
            return document.html().trim();
        } catch (Exception e) {
            e.getMessage();
        }
        return "";
    }
}
