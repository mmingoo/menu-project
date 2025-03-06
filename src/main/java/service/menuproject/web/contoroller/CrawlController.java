package service.menuproject.web.contoroller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import service.menuproject.service.crawl.CrawlCommandServiceImpl;
import service.menuproject.service.menu.MenuCommandServiceImpl;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
public class CrawlController {
    private final MenuCommandServiceImpl menuCommandService;
    private final CrawlCommandServiceImpl crawlCommandServiceImpl;
    private  String pageurl = "https://www.gachon.ac.kr/kor/7347/subview.do";


    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("OK!!!!");
    }

    // 비전타워 메뉴 크롤링
    @PostMapping("/crawl/visiontower")
    public void crawlVisiontower() throws IOException{
        menuCommandService.createVisiontowerMenu();
    }

    // 아름관 메뉴 크롤링
    @PostMapping("/crawl/arm")
    public void crawlArm() throws IOException{
        menuCommandService.createArmMenu();
    }

    // 3기숙사 메뉴 크롤링
    @PostMapping("/crawl/dormitory")
    public void crawlDormitory() throws IOException{
        menuCommandService.createDormitoryMenu();
    }

    //메디컬 메뉴 조회
    @PostMapping("/crawl/medical")
    public void crawlMedical() throws IOException{
        menuCommandService.createMedicalMenu();
    }


}


