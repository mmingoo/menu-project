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

    private List<DayMenus> dayMenus;

    @Getter
    @AllArgsConstructor
    @Builder
    public static class DayMenus {
        private LocalDate date;
        private DayOfWeek dayOfWeek;
        private List<MenuInfo> menus;
    }

    @Getter
    @AllArgsConstructor
    @Builder
    public static class MenuInfo {
        private String menu;
        private String mealType;
    }
}
