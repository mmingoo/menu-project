package service.menuproject.service.menu;

import service.menuproject.web.dto.Response.HomeMenuDTO;
import service.menuproject.web.dto.Response.RestaurantMenuDTO;

public interface MenuQueryService {
    HomeMenuDTO getTodayMenus();

    //Todo: 비전타워 일주일 식단 메뉴 조회하기
    RestaurantMenuDTO getWeekMenus(String restaurantName);
}
