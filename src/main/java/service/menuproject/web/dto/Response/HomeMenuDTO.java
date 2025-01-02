package service.menuproject.web.dto.Response;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import service.menuproject.base.enums.DayOfWeek;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class HomeMenuDTO {

    // 홈 화면에서 오늘의 메뉴 불러오는데 식당별로 그룹화하기 위해 RestaurantMenus(식당별로) 에 오늘 메뉴(TodayMenuInfo)를 담아서 반환함.
    private List<RestaurantMenus> todayMenus;


    // 식당별로 그룹화하는데 필요한 DTO
    @Getter
    @Builder
    @AllArgsConstructor
    public static class RestaurantMenus{
        private String restaurantName;
        private Long restaurantId;
        private List<TodayMenuInfo> menus;
    }


    // 오늘의 메뉴를 담을 DTO 필요
    @Getter
    @AllArgsConstructor
    @Builder
    public static class TodayMenuInfo {
        private LocalDate date;
        private Long restaurantId;
        private String menu;

        @Enumerated(EnumType.STRING)
        private DayOfWeek dayOfWeek;

        @Enumerated(EnumType.STRING)
        private String  mealType;

    }


}
