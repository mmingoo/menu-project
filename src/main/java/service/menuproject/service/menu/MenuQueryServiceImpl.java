package service.menuproject.service.menu;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import service.menuproject.domain.Restaurant;
import service.menuproject.repository.MenuRepository;
import service.menuproject.repository.RestaurantRepository;
import service.menuproject.web.dto.Response.MenuDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Repository
@RequiredArgsConstructor
public class MenuQueryServiceImpl implements MenuQueryService{

    private final MenuRepository menuRepository;

    private final RestaurantRepository restaurantRepository;
    @Override
    public MenuDTO getTodayMenus() {
        LocalDate date = LocalDate.now();

        // 메뉴 데이터를 restaurantId로 그룹화
        Map<Long, List<MenuDTO.TodayMenuInfo>> groupedMenus = menuRepository.findByDate(date).stream()
                .map(menu -> MenuDTO.TodayMenuInfo.builder()
                        .date(menu.getDate())
                        .restaurantId(menu.getRestaurant().getId())
                        .menu(menu.getMenu())
                        .dayOfWeek(menu.getType())
                        .mealType(menu.getMealType())
                        .build())
                .collect(Collectors.groupingBy(
                        MenuDTO.TodayMenuInfo::getRestaurantId
                ));

        // 그룹화된 데이터를 RestaurantMenus로 변환
        List<MenuDTO.RestaurantMenus> restaurantMenusList = groupedMenus.entrySet().stream()
                .map(entry -> {
                    Restaurant restaurant = restaurantRepository.findById(entry.getKey())
                            .orElseThrow(() -> new IllegalStateException("Restaurant not found"));
                    return MenuDTO.RestaurantMenus.builder()
                            .restaurantId(entry.getKey())
                            .restaurantName(restaurant.getName())
                            .menus(entry.getValue())
                            .build();
                })
                .collect(Collectors.toList());

        return MenuDTO.builder()
                .todayMenus(restaurantMenusList)
                .build();
    }
}