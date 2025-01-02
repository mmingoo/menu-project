package service.menuproject.web.contoroller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.menuproject.base.BaseResponse;
import service.menuproject.domain.Menu;
import service.menuproject.service.menu.MenuQueryService;
import service.menuproject.web.dto.Response.MenuDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/menu")
public class MenuController {

    private final MenuQueryService menuQueryService;

    @GetMapping("/today-menu")
    public BaseResponse<MenuDTO> getTodayMenus(){
        MenuDTO todayMenus = menuQueryService.getTodayMenus();
        return BaseResponse.onSuccess(todayMenus);
    }
}
