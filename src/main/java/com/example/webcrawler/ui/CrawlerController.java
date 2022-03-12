package com.example.webcrawler.ui;

import com.example.webcrawler.application.CrawlerService;
import com.example.webcrawler.dto.CrawlerRequest;
import com.example.webcrawler.dto.CrawlerResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation(value = "크롤링 URL 텍스트 생성", notes = "크롤링할 주소의 텍스트 데이터를 출력한다")
    @ApiResponses({
            @ApiResponse(code = 201, message = "크롤링한 결과 출력"),
            @ApiResponse(code = 400, message = "잘못된 요청"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @PostMapping
    public ResponseEntity<CrawlerResponse> getCrawlerData(@RequestBody @Valid CrawlerRequest request) {
        CrawlerResponse data = crawlerService.getData(request);
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }
}
