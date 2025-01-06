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

    //Todo : 오늘의 메뉴 조회
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


    //Todo : 일주일치 교육대학원 메뉴 조회
    @GetMapping("/arm")
    public BaseResponse<RestaurantMenuDTO> getArm(){
        RestaurantMenuDTO armMenuDto = menuQueryService.getWeekMenus("교육대학원 식당");
        return BaseResponse.onSuccess(armMenuDto);
    }

    //Todo : 일주일치 학교식단 메뉴 조회
    @GetMapping("/dormitory")
    public BaseResponse<RestaurantMenuDTO> getDormitory(){
        RestaurantMenuDTO dormitoryMenuDto = menuQueryService.getWeekMenus("학생생활관 식당");
        return BaseResponse.onSuccess(dormitoryMenuDto);
    }

    //Todo : 일주일치 메디컬 메뉴 조회
    @GetMapping("/medical")
    public BaseResponse<RestaurantMenuDTO> getMedical(){
        RestaurantMenuDTO medicalMenuDto = menuQueryService.getWeekMenus("메디컬 식당");
        return BaseResponse.onSuccess(medicalMenuDto);
    }


}
