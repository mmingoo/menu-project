package service.menuproject;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import service.menuproject.service.CrawlQueryService;

@SpringBootApplication
@RequiredArgsConstructor
public class MenuProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(MenuProjectApplication.class, args);


    }

}
