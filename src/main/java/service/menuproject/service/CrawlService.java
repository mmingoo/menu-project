package service.menuproject.service;


import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.menuproject.domain.CrawlData;
import service.menuproject.repository.CrawlRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CrawlService {
    private final CrawlRepository crawlRepository;


    //타이틀, url 묶기
    public void makeTitleUrl(String url) throws IOException {
        List<String> title_list = this.titleCrawl(url);
        List<String> url_list = this.urlCrawl(url);

        for(int i  = 0; i<title_list.size(); i++){
            CrawlData newCrawlData = new CrawlData();

            String title = title_list.get(i);
            String pageUrl = url_list.get(i);

            newCrawlData.setTitle(title);
            newCrawlData.setUrl(pageUrl);

            this.save(newCrawlData);
        }
    }

    @Transactional
    public void save(CrawlData newCrawlData ){
        crawlRepository.save(newCrawlData);
    }



    // 타이틀을 크롤링해서 리스트형식으로 가져오기
    public List<String> titleCrawl(String pageurl) throws IOException {
        List<String> titleList = new ArrayList<>();
        Document doc = Jsoup.connect(pageurl).get();
        Elements titles = doc.select(".post-item .title");

        // 태그를 제거하고 텍스트만 가져오기
        for (Element item : titles) {
            String title = item.text();
            System.out.println(title);
            titleList.add(title);
        }

        return titleList;
    }

    // url을 크롤링해서 리스트형식으로 가져오기
    public List<String> urlCrawl(String pageurl) throws IOException {
        List<String> urlList = new ArrayList<>();
        String org_url = "aibigdata-study.tistory.com";

        Document doc = Jsoup.connect(pageurl).get();
        Elements urls = doc.select(".post-item a");

        // Extract href attribute from each <a> element
        for (Element url : urls) {
            String href = org_url+ url.attr("href");
            System.out.println(href);
            urlList.add(href);
        }

        return urlList;
    }
}
