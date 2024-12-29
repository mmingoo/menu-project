package service.menuproject.web.contoroller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import service.menuproject.service.crawl.CrawlCommandServiceImpl;
import service.menuproject.service.menu.MenuCommandServiceImpl;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
public class testController {
    private final MenuCommandServiceImpl menuCommandService;
    private final CrawlCommandServiceImpl crawlCommandServiceImpl;
    private  String pageurl = "https://www.gachon.ac.kr/kor/7347/subview.do";

    @PostMapping("/crawl")
    public void crawl() throws IOException {
        System.out.println(crawlCommandServiceImpl.crawl(pageurl));
    }
    @PostMapping("/crawlDate")
    public void crawlDate() throws IOException {
        System.out.println(crawlCommandServiceImpl.crawlDate(pageurl));

    }
    @PostMapping("/crawlMenu")
    public void crawlMenu() throws IOException {
        System.out.println(crawlCommandServiceImpl.crawlMenu(pageurl));

    }

    @PostMapping("/crawl/visiontower")
    public void crawlVisiontower() throws IOException{
        menuCommandService.createVisiontowerMenu();
    }

}


