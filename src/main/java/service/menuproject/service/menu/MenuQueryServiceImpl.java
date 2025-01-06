package service.menuproject.service.menu;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import service.menuproject.domain.Menu;
import service.menuproject.domain.Restaurant;
import service.menuproject.repository.MenuRepository;
import service.menuproject.service.restaurant.RestaurantQueryService;
import service.menuproject.web.dto.Response.HomeMenuDTO;
import service.menuproject.web.dto.Response.RestaurantMenuDTO;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Repository
@RequiredArgsConstructor
public class MenuQueryServiceImpl implements MenuQueryService{

    private final MenuRepository menuRepository;

    private final RestaurantQueryService restaurantQueryService;

    //Todo: 홈-오늘의 메뉴 조회
    @Override
    public HomeMenuDTO getTodayMenus() {
        LocalDate date = LocalDate.now();

        // 메뉴 데이터를 restaurantId로 그룹화
        Map<Long, List<HomeMenuDTO.TodayMenuInfo>> groupedMenus = menuRepository.findByDate(date).stream()
                .map(menu -> HomeMenuDTO.TodayMenuInfo.builder()
                        .date(menu.getDate())
                        .restaurantId(menu.getRestaurant().getId())
                        .menu(menu.getMenu())
                        .dayOfWeek(menu.getType())
                        .mealType(menu.getMealType())
                        .build())
                .collect(Collectors.groupingBy(
                        HomeMenuDTO.TodayMenuInfo::getRestaurantId
                ));

        // 그룹화된 데이터를 RestaurantMenus로 변환
        List<HomeMenuDTO.RestaurantMenus> restaurantMenusList = groupedMenus.entrySet().stream()
                .map(entry -> {
                    Restaurant restaurant = restaurantQueryService.findById(entry.getKey());

                    return HomeMenuDTO.RestaurantMenus.builder()
                            .restaurantId(entry.getKey())
                            .restaurantName(restaurant.getName())
                            .menus(entry.getValue())
                            .build();
                })
                .collect(Collectors.toList());

        return HomeMenuDTO.builder()
                .todayMenus(restaurantMenusList)
                .build();
    }

    //Todo: 비전타워 일주일 식단 메뉴 조회하기
    @Override
    public RestaurantMenuDTO getWeekMenus(String restaurantName) {
        // 1. 식당 정보 조회
        Restaurant restaurant = restaurantQueryService.findByName(restaurantName);
        System.out.println("식당 id : "+ restaurant.getId());

        // 2. 현재 날짜 기준으로 한 주의 시작일(월요일)과 종료일(일요일) 계산
        LocalDate now = LocalDate.now();
        LocalDate startOfWeek = now.with(DayOfWeek.MONDAY);
        LocalDate endOfWeek = now.with(DayOfWeek.SUNDAY);

        // 3. 해당 식당의 일주일치 메뉴 조회 및 날짜별로 그룹화하여 DTO로 변환
        List<RestaurantMenuDTO.DayMenus> dayMenusList = menuRepository
                .findWeekMenusByRestaurant(restaurant, startOfWeek, endOfWeek).stream()


                // 3-1. 날짜(Date)를 기준으로 메뉴들을 그룹화
                .collect(Collectors.groupingBy(Menu::getDate))
                .entrySet().stream()


                // 3-2. 각 날짜별로 DayMenus DTO 생성
                .map(entry -> RestaurantMenuDTO.DayMenus.builder()
                        .date(entry.getKey())  // 날짜 정보
                        .dayOfWeek(entry.getValue().get(0).getType())  // 요일 정보

                        // 3-3. 해당 날짜의 모든 메뉴를 MenuInfo DTO로 변환
                        .menus(entry.getValue().stream()
                                .map(menu -> RestaurantMenuDTO.MenuInfo.builder()
                                        .menu(menu.getMenu())      // 메뉴 내용
                                        .mealType(menu.getMealType())  // 식사 타입(아침,점심,저녁)
                                        .build())
                                .collect(Collectors.toList()))
                        .build())
                .collect(Collectors.toList());

        // 4. 최종 DTO 생성 및 반환
        return RestaurantMenuDTO.builder()
                .dayMenus(dayMenusList)
                .build();
}
}