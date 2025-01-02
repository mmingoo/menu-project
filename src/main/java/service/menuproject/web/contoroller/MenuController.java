package service.menuproject.web.contoroller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.menuproject.base.BaseResponse;
import service.menuproject.service.menu.MenuQueryService;
import service.menuproject.web.dto.Response.HomeMenuDTO;
import service.menuproject.web.dto.Response.VisiontowerMenuDTO;

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

    @GetMapping("/visiontower")
    public BaseResponse<VisiontowerMenuDTO> getVisiontower(){
        VisiontowerMenuDTO visiontowerHomeMenuDto = menuQueryService.getVisiontowerMenus();
        return BaseResponse.onSuccess(visiontowerHomeMenuDto);
    }
}
