package com.example.webcrawler.ui;

import com.example.webcrawler.application.CrawlerService;
import com.example.webcrawler.dto.CrawlerRequest;
import com.example.webcrawler.dto.CrawlerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/crawler")
public class CrawlerController {
    private final CrawlerService crawlerService;

    @PostMapping
    public ResponseEntity<CrawlerResponse> getCrawlerData(@RequestBody @Valid CrawlerRequest dto) {
        CrawlerResponse data = crawlerService.getData(dto);
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }
}
