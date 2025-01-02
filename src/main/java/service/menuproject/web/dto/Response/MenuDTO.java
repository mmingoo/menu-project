package service.menuproject.web.dto.Response;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.context.annotation.Bean;
import service.menuproject.base.enums.DayOfWeek;
import service.menuproject.domain.Restaurant;
import service.menuproject.web.dto.Request.RestaurantRequest;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class MenuDTO {
    private List<RestaurantMenus> todayMenus;

    @Getter
    @Builder
    @AllArgsConstructor
    public static class RestaurantMenus{
        private String restaurantName;
        private Long restaurantId;
        private List<TodayMenuInfo> menus;
    }

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
