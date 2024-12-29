package service.menuproject.service.crawl;

import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

public interface CrawlCommandService {
    List<String> crawlDate(String pageurl) throws IOException;

    List<String> crawlMenu(String pageurl) throws IOException;

    List<String> selectDate(Elements rows);

    List<String> selectMenu(Elements rows);

    Elements crawl(String pageurl) throws IOException;
}
