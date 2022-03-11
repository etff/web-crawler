package com.example.webcrawler.application.stub;

import com.example.webcrawler.application.crawler.Crawler;

public class StubCrawler implements Crawler {

    @Override
    public String getDataFromUrl(String url) {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Document</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>hello world!</h1>\n" +
                "</body>\n" +
                "</html>";
    }
}
