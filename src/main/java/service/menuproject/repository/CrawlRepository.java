package service.menuproject.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import service.menuproject.domain.CrawlData;

@Repository
@RequiredArgsConstructor
public class CrawlRepository {

    private final EntityManager em;

    @Transactional
    public void save(CrawlData data){
        em.persist(data);
    }


    // 타이틀을 크롤링해서 리스트형식으로 가져오기
//    public List<String> titleCrawl(String pageurl) throws IOException {
//        List <String> titleList = new ArrayList<>();
//        Document doc = Jsoup.connect(pageurl).get();
//        Elements titles = doc.select(".post-item .title");
//
//        // 태그를 제거하고 텍스트만 가져오기
//        for (Element item : titles) {
//            String title = item.text();
//            System.out.println(title);
//            titleList.add(title);
//        }
//
//        return titleList;
//    }

    // url을 크롤링해서 리스트형식으로 가져오기
//    public List<String> urlCrawl(String pageurl) throws IOException {
//        List<String> urlList = new ArrayList<>();
//        String org_url = "aibigdata-study.tistory.com";
//
//        Document doc = Jsoup.connect(pageurl).get();
//        Elements urls = doc.select(".post-item a");
//
//        // Extract href attribute from each <a> element
//        for (Element url : urls) {
//            String href = org_url+ url.attr("href");
//            System.out.println(href);
//            urlList.add(href);
//        }
//
//        return urlList;
//    }






}


