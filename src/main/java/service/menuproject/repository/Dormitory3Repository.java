package service.menuproject.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import service.menuproject.domain.DormitoryDateMenu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class Dormitory3Repository {
    @PersistenceContext
    EntityManager em;
    String url = "https://www.gachon.ac.kr/kor/7350/subview.do";
    DormitoryDateMenu dateMenu = new DormitoryDateMenu();
    Crawl date = new Crawl();
    List<String> dateList = this.dateList();
    List<String> newDateList = new ArrayList<>();

    //db에 있는 date 뽑아오기
    public List<String> makeDateList(){
        return em.createQuery("select d.date from DormitoryDateMenu d", String.class)
                .getResultList();
    }


    //객체와 날짜 및 요일 정보를 통해 객체를 만드는 메서드
    public DormitoryDateMenu makeDormitoryMenu(DormitoryDateMenu dateMenu,int  day, String date){
        return this.createDateMenu(dateMenu, day, date);
    }


    //객체를 저장하는 메서드
    public void save(DormitoryDateMenu menu){
        em.persist(menu);
    }

    //menu 크롤링해오기
    public List<String> createMenuList() {
        try {
            return date.crawlMenu(url);
        } catch (IOException e) {
            // 예외가 발생했을 때 처리할 내용을 여기에 작성
            e.printStackTrace();
            return Collections.emptyList(); // 빈 리스트 반환하거나 다른 처리를 해야 함
        }
    }


    //date 크롤링해오기
    public List<String> dateList() {
        try {
            return date.crawlDate(url);
        } catch (IOException e) {
            // 예외가 발생했을 때 처리할 내용을 여기에 작성
            e.printStackTrace();
            return Collections.emptyList(); // 빈 리스트 반환하거나 다른 처리를 해야 함
        }
    }

    //date리스트에 date 뿐만 아니라 공백이 존재함. 이러한 공백을 없애고 date들만 추출하는 메서드
    public List<String> newCreateDate() {
        List<String> filteredDates = new ArrayList<>();
        for (String date : dateList) {
            if (!date.isEmpty()) {
                filteredDates.add(date);
            }
        }
        return filteredDates; // Return the filtered list directly
    }

    // menuList와 dateList에서 그 날의 정보를 불러와 객체에 세팅해주는 메서드
    public DormitoryDateMenu createDateMenu(DormitoryDateMenu dormitoryDateMenu,int date,String day){

        List<String> dateList = this.newCreateDate();
        List<String> menuList = this.createMenuList();
        int i = 0;

        if (day.equals("mon")){
            i = 0;
        } else if (day.equals("tue")) {
            i = 4;
        } else if (day.equals("wed")) {
            i =8;
        } else if (day.equals("thu")) {
            i = 12;
        } else if (day.equals("fri")) {
            i = 16;
        } else if (day.equals("sat")) {
            i = 20;
        }


        int breakfast = i;
        int launch1= i+1;
        int launch2 = i+2;
        int dinner = i+3;

        dormitoryDateMenu.setDate(dateList.get(date));
        dormitoryDateMenu.setMorningMenu(menuList.get(breakfast));
        dormitoryDateMenu.setLaunchMenu1(menuList.get(launch1));
        dormitoryDateMenu.setLaunchMenu2(menuList.get(launch2));
        dormitoryDateMenu.setDinnerMenu(menuList.get(dinner));

        i = 0;
        return dormitoryDateMenu;
    }


    //db에 있는 데이터 삭제하는 코드
    public void deleteMenu() {
        em.createQuery("DELETE FROM DormitoryDateMenu d ")
                .executeUpdate();
    }

    //db에서 모든 데이터 불러오는 코드
    public List<DormitoryDateMenu> allList() {
        return em.createQuery("select d from DormitoryDateMenu d", DormitoryDateMenu.class)
                .getResultList();
    }

    //db에서 date 불러오는 메서드
    public List<String> dbDateList() {
        return em.createQuery("select d.date from DormitoryDateMenu d", String.class)
                .getResultList();
    }
}