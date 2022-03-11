package com.example.webcrawler.application;

import com.example.webcrawler.application.crawler.Crawler;
import com.example.webcrawler.application.formtter.TextFormatter;
import com.example.webcrawler.application.formtter.TextOrder;
import com.example.webcrawler.application.formtter.TextParser;
import com.example.webcrawler.dto.CrawlerRequest;
import com.example.webcrawler.dto.CrawlerResponse;
import com.example.webcrawler.dto.Type;
import org.springframework.stereotype.Service;

@Service
public class CrawlerService {
    private final Crawler crawler;
    private final TextParser textParser;
    private final TextFormatter textFormatter;
    private final TextOrder textOrder;

    public CrawlerService(Crawler crawler) {
        this.crawler = crawler;
        this.textParser = new TextParser();
        this.textFormatter = new TextFormatter();
        this.textOrder = new TextOrder();
    }

    public CrawlerResponse getData(CrawlerRequest dto) {
        final String foundData = crawler.getDataFromUrl(dto.getUrl());
        if (dto.getType().equals(Type.HTML)) {
            final String parsedText = textParser.parseHTML(foundData);
            return textFormatter.changeFormat(textOrder.compare(parsedText), dto.getUnit());
        }
        final String parsedText = textParser.parseText(foundData);
        return textFormatter.changeFormat(textOrder.compare(parsedText), dto.getUnit());
    }
}
