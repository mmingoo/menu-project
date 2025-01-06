package service.menuproject.web.contoroller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.menuproject.base.BaseResponse;
import service.menuproject.service.menu.MenuQueryService;
import service.menuproject.web.dto.Response.HomeMenuDTO;
import service.menuproject.web.dto.Response.RestaurantMenuDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/menu")
public class MenuController {

    private final MenuQueryService menuQueryService;

    @GetMapping("/today")
    public BaseResponse<HomeMenuDTO> getTodayMenus(){
        HomeMenuDTO todayMenus = menuQueryService.getTodayMenus();
        return BaseResponse.onSuccess(todayMenus);
    }

    //Todo : 일주일치 비전타워 메뉴 조회
    @GetMapping("/visiontower")
    public BaseResponse<RestaurantMenuDTO> getVisiontower(){
        RestaurantMenuDTO visiontowerHomeMenuDto = menuQueryService.getWeekMenus("비전타워 식당");
        return BaseResponse.onSuccess(visiontowerHomeMenuDto);
    }
}
