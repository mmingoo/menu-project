package service.menuproject.web.contoroller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import service.menuproject.service.crawl.CrawlServiceCommandImpl;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
public class testController {
    private final CrawlServiceCommandImpl crawlServiceCommandImpl;
    private  String pageurl = "https://www.gachon.ac.kr/kor/7347/subview.do";

    @PostMapping("/crawl")
    public void crawl() throws IOException {
        System.out.println(crawlServiceCommandImpl.crawl(pageurl));
    }
    @PostMapping("/crawlDate")
    public void crawlDate() throws IOException {
        System.out.println(crawlServiceCommandImpl.crawlDate(pageurl));

    }
    @PostMapping("/crawlMenu")
    public void crawlMenu() throws IOException {
        System.out.println(crawlServiceCommandImpl.crawlMenu(pageurl));

    }

}


