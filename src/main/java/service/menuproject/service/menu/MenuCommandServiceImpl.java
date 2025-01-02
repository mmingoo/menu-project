package service.menuproject.service.menu;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import service.menuproject.base.enums.DayOfWeek;
import service.menuproject.domain.Menu;
import service.menuproject.domain.Restaurant;
import service.menuproject.repository.MenuRepository;
import service.menuproject.service.crawl.CrawlCommandServiceImpl;
import org.jsoup.nodes.Element;
import service.menuproject.service.restaurant.RestaurantQueryService;
import service.menuproject.web.dto.Request.CrawlDto;
import service.menuproject.web.dto.Response.MenuDTO;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MenuCommandServiceImpl implements  MenuCommandService {
    private final CrawlCommandServiceImpl crawlCommandServiceImpl;
    private final RestaurantQueryService restaurantQueryService;
    private final MenuRepository menuRepository;
    String currentDate = null;
    String currentDayOfWeek = null;

    @Override
    //Todo: 비전타워 메뉴 생성
    public void createVisiontowerMenu() throws IOException {

        String visiontowerUrl = "https://www.gachon.ac.kr/kor/7347/subview.do";

        Elements rows = crawlCommandServiceImpl.crawl(visiontowerUrl);
        Restaurant restaurant = restaurantQueryService.findByName("비전타워 식당");

        System.out.println(rows);
        for(Element row : rows ) {

            // 날짜 관련 정보 추출
            CrawlDto.DateInfo dateInfo = getDateAndDayOfWeek(row);
//            System.out.println("dateInfo:"+dateInfo.getDate());

            // 메뉴 정보 관련 추출
            CrawlDto.MenuInfo menuInfo = getMenu(row);
//            System.out.println("menu:"+menuInfo.getMenu());

            if (dateInfo != null && menuInfo != null) {

                //String 형식의 Date를 LocalDate 형식으로 변환
                LocalDate date = LocalDate.parse(dateInfo.getDate(), DateTimeFormatter.ofPattern("yyyy.MM.dd"));

                // 요일 변환 (short name -> enum)
                DayOfWeek dayOfWeek = DayOfWeek.fromShortName(dateInfo.getDayOfWeek());

                // 객체 생성
                Menu visiontowerMenu = Menu.builder()
                        .type(dayOfWeek)
                        .mealType(menuInfo.getTimeSlot())
                        .menu(menuInfo.getMenu())
                        .date(date)
                        .restaurant(restaurant)
                        .build();

                menuRepository.save(visiontowerMenu);
            }

        }

    }

    @Override
    //Todo: 아름관 메뉴 생성
    public void createArmMenu() throws IOException {

        String visiontowerUrl = "https://www.gachon.ac.kr/kor/7349/subview.do";

        Elements rows = crawlCommandServiceImpl.crawl(visiontowerUrl);
        Restaurant restaurant = restaurantQueryService.findByName("교육대학원 식당");

        System.out.println(rows);
        for(Element row : rows ) {

            // 날짜 관련 정보 추출
            CrawlDto.DateInfo dateInfo = getDateAndDayOfWeek(row);
//            System.out.println("dateInfo:"+dateInfo.getDate());

            // 메뉴 정보 관련 추출
            CrawlDto.MenuInfo menuInfo = getMenu(row);
//            System.out.println("menu:"+menuInfo.getMenu());

            if (dateInfo != null && menuInfo != null) {

                //String 형식의 Date를 LocalDate 형식으로 변환
                LocalDate date = LocalDate.parse(dateInfo.getDate(), DateTimeFormatter.ofPattern("yyyy.MM.dd"));

                // 요일 변환 (short name -> enum)
                DayOfWeek dayOfWeek = DayOfWeek.fromShortName(dateInfo.getDayOfWeek());

                // 객체 생성
                Menu visiontowerMenu = Menu.builder()
                        .type(dayOfWeek)
                        .mealType(menuInfo.getTimeSlot())
                        .menu(menuInfo.getMenu())
                        .date(date)
                        .restaurant(restaurant)
                        .build();

                menuRepository.save(visiontowerMenu);
            }
        }
    }

    @Override
    //Todo: 학생생활관 메뉴 생성
    public void createDormitoryMenu() throws IOException {

        String visiontowerUrl = "https://www.gachon.ac.kr/kor/7350/subview.do";

        Elements rows = crawlCommandServiceImpl.crawl(visiontowerUrl);
        Restaurant restaurant = restaurantQueryService.findByName("학생생활관 식당");

        System.out.println(rows);
        for(Element row : rows ) {

            // 날짜 관련 정보 추출
            CrawlDto.DateInfo dateInfo = getDateAndDayOfWeek(row);
//            System.out.println("dateInfo:"+dateInfo.getDate());

            // 메뉴 정보 관련 추출
            CrawlDto.MenuInfo menuInfo = getMenu(row);
//            System.out.println("menu:"+menuInfo.getMenu());

            if (dateInfo != null && menuInfo != null) {

                //String 형식의 Date를 LocalDate 형식으로 변환
                LocalDate date = LocalDate.parse(dateInfo.getDate(), DateTimeFormatter.ofPattern("yyyy.MM.dd"));

                // 요일 변환 (short name -> enum)
                DayOfWeek dayOfWeek = DayOfWeek.fromShortName(dateInfo.getDayOfWeek());

                // 객체 생성
                Menu visiontowerMenu = Menu.builder()
                        .type(dayOfWeek)
                        .mealType(menuInfo.getTimeSlot())
                        .menu(menuInfo.getMenu())
                        .date(date)
                        .restaurant(restaurant)
                        .build();

                menuRepository.save(visiontowerMenu);
            }
        }
    }



    @Override
    //Todo: 메디컬 메뉴 생성
    public void createMedicalMenu() throws IOException {

        String visiontowerUrl = "https://www.gachon.ac.kr/kor/7351/subview.do";

        Elements rows = crawlCommandServiceImpl.crawl(visiontowerUrl);
        Restaurant restaurant = restaurantQueryService.findByName("메디컬 식당");

        System.out.println(rows);
        for(Element row : rows ) {

            // 날짜 관련 정보 추출
            CrawlDto.DateInfo dateInfo = getDateAndDayOfWeek(row);
//            System.out.println("dateInfo:"+dateInfo.getDate());

            // 메뉴 정보 관련 추출
            CrawlDto.MenuInfo menuInfo = getMenu(row);
//            System.out.println("menu:"+menuInfo.getMenu());

            if (dateInfo != null && menuInfo != null) {

                //String 형식의 Date를 LocalDate 형식으로 변환
                LocalDate date = LocalDate.parse(dateInfo.getDate(), DateTimeFormatter.ofPattern("yyyy.MM.dd"));

                // 요일 변환 (short name -> enum)
                DayOfWeek dayOfWeek = DayOfWeek.fromShortName(dateInfo.getDayOfWeek());

                // 객체 생성
                Menu visiontowerMenu = Menu.builder()
                        .type(dayOfWeek)
                        .mealType(menuInfo.getTimeSlot())
                        .menu(menuInfo.getMenu())
                        .date(date)
                        .restaurant(restaurant)
                        .build();

                menuRepository.save(visiontowerMenu);
            }
        }
    }














    //Todo 날짜, 요일 추출
    private CrawlDto.DateInfo getDateAndDayOfWeek(Element row) {
        Element dateCell = row.selectFirst("th");
        try {
            CrawlDto.DateInfo dateInfo = null;
            if (dateCell != null) {
                // html 가져오기
                String fullDateText = dateCell.html();

                // <br> 기준으로파싱하기
                String[] parts = fullDateText.split("<br>");
                if (parts.length >= 2) {

                    // 첫번째 요소를 date로 저장하기
                    String date = parts[0].trim();

                    // 두번째 요소를 요일로 저장
                    String dayOfWeek = parts[1].replaceAll("[()\\s]", "");
                    currentDate = date;
                    currentDayOfWeek = dayOfWeek;

                    dateInfo = new CrawlDto.DateInfo(currentDate, currentDayOfWeek);
                    return dateInfo;
                }

            }else {
                dateInfo = new CrawlDto.DateInfo(currentDate, currentDayOfWeek);

                return dateInfo;
            }
        } catch (NullPointerException e) {
            log.error("날짜 데이터 파싱 중 null 발생: {}", e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            log.error("날짜 형식 파싱 중 오류 발생: {}", e.getMessage());
        } catch (Exception e) {
            log.error("날짜 처리 중 예상치 못한 오류 발생: {}", e.getMessage());
        }
        return null;
    }


    // 메뉴 추출
    public CrawlDto.MenuInfo getMenu(Element row){
        Elements cells = row.select("td");

        try {
            if (cells.size() >= 2) {
                String timeSlot = cells.get(0).text();
                String menuText = cells.get(1).text();
                return new CrawlDto.MenuInfo(timeSlot, menuText);
            }
        }catch (IndexOutOfBoundsException e) {
            // 인덱스 오류 처리 (cells가 2개 미만인 경우)
            log.error("메뉴 파싱 중 오류 발생: {}", e.getMessage());
        } catch (Exception e) {
            // 기타 예외 처리
            log.error("예상치 못한 오류 발생: {}", e.getMessage());
        }
        return null;
    }


}