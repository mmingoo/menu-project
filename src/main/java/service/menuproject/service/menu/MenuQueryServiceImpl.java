package service.menuproject.service.menu;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import service.menuproject.domain.Menu;
import service.menuproject.domain.Restaurant;
import service.menuproject.repository.MenuRepository;
import service.menuproject.service.restaurant.RestaurantQueryService;
import service.menuproject.web.dto.Response.HomeMenuDTO;
import service.menuproject.web.dto.Response.VisiontowerMenuDTO;

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
    public VisiontowerMenuDTO getVisiontowerMenus() {
        Restaurant visiontower = restaurantQueryService.findByName("비전타워 식당");

        List<VisiontowerMenuDTO.DayMenus> dayMenusList = menuRepository.findByRestaurant(visiontower).stream()
                // 날짜로 그룹핑
                .collect(Collectors.groupingBy(Menu::getDate))
                .entrySet().stream()
                .map(entry -> VisiontowerMenuDTO.DayMenus.builder()
                        .date(entry.getKey())
                        .dayOfWeek(entry.getValue().get(0).getType())
                        .menus(entry.getValue().stream()
                                .map(menu -> VisiontowerMenuDTO.MenuInfo.builder()
                                        .menu(menu.getMenu())
                                        .mealType(menu.getMealType())
                                        .build())
                                .collect(Collectors.toList()))
                        .build())
                .collect(Collectors.toList());

        return VisiontowerMenuDTO.builder()
                .dayMenus(dayMenusList)
                .build();

    }
}