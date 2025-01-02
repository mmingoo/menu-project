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
public class VisiontowerMenuDTO {

    // 홈 화면에서 오늘의 메뉴 불러오는데 식당별로 그룹화하기 위해 RestaurantMenus(식당별로) 에 오늘 메뉴(TodayMenuInfo)를 담아서 반환함.
    private List<RestaurantWeekMenus> weekRestaurantMenus;


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


    // 식당 메뉴 조회 시 여러 메뉴들을 날짜별로 묶어서 조회해야 하기 위한 DTO
    // 식당별로 그룹화하는데 필요한 DTO
    @Getter
    @Builder
    @AllArgsConstructor
    public static class RestaurantWeekMenus{
        private String restaurantName;
        private LocalDate date;
        private List<TodayMenuInfo> menus;
    }
}
