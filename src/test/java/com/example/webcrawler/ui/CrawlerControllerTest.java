package com.example.webcrawler.ui;

import com.example.webcrawler.application.CrawlerService;
import com.example.webcrawler.dto.CrawlerRequest;
import com.example.webcrawler.dto.CrawlerResponse;
import com.example.webcrawler.dto.Type;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(CrawlerController.class)
class CrawlerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private CrawlerService crawlerService;
    private CrawlerRequest request;
    private CrawlerResponse response;

    @BeforeEach
    void setUp() {
        request = new CrawlerRequest("http://www.google.com", Type.HTML, 100);
        response = new CrawlerResponse("a,b,c,d", "e");
    }

    @Test
    void create() throws Exception {
        given(crawlerService.getData(any()))
                .willReturn(response);

        mockMvc.perform(
                        post("/api/crawler")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(request))
                )
                .andExpect(status().isCreated())
                .andExpect(content().string(
                        mapper.writeValueAsString(response))
                );
    }

}
