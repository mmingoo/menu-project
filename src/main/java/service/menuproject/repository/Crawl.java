package service.menuproject.repository;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class Crawl {
    List<String> menuList = new ArrayList<>();
    List<String> dateList = new ArrayList<>();
    public List<String> crawlDate(String pageurl) throws IOException {
    Elements rows = crawl(pageurl);
        return selectDate(rows);
    }


    public List<String> crawlMenu(String pageurl) throws IOException {
        Elements rows = crawl(pageurl);
        return selectMenu(rows);
    }

    public Elements crawl(String pageurl) throws IOException {
        String url = pageurl;
        Document doc = Jsoup.connect(url).get();
        Elements tables = doc.select(".table_1 table");
        String date;

        Elements rows = tables.select("tbody tr");
        return rows;
    }
    public List<String> selectDate(Elements rows){
        for(Element row : rows){
            Elements dateElement = row.select("th");
            String date = dateElement.text();
            dateList.add(date);
        }
        return dateList;
    }

    public List<String> selectMenu(Elements rows){
        for(Element row : rows){
            Elements menuCells = row.select("td");
            menuList.add(menuCells.text());
        }
        return menuList;
    }

//    private List<String> createDate(){
//        List<String> newDateList = new ArrayList<>();
//        for (String date : dateList) {
//            if (!date.isEmpty()) {
//                newDateList.add(date);
//            }
//        }
//        return newDateList;
//    }
}


