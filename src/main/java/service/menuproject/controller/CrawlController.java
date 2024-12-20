package service.menuproject.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.menuproject.service.CrawlService;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class CrawlController {
    private final CrawlService crawlService;

    @GetMapping("/crawl")
    public void getCrawl() throws IOException {
        String url = "https://aibigdata-study.tistory.com/";
        crawlService.makeTitleUrl(url);
    }
}
