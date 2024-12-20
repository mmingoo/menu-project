package service.menuproject.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.menuproject.domain.ArmDateMenu;
import service.menuproject.domain.DormitoryDateMenu;
import service.menuproject.domain.VisiontowerDateMenu;
import service.menuproject.repository.VisiontowerRepository;
import service.menuproject.service.ArmService;
import service.menuproject.service.DormitoryService;
import service.menuproject.service.FindWeekService;
import service.menuproject.service.VisiontowerService;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final DormitoryService dormitoryService;
    private final ArmService armService;
    private final VisiontowerService visiontowerService;
    private final FindWeekService findWeekService;

    private final VisiontowerRepository visiontowerRepository;
    @RequestMapping("/")
    public String Home(Model model) {
        LocalDate today = LocalDate.now();
        DayOfWeek day = today.getDayOfWeek();
        ArmDateMenu armMenu = new ArmDateMenu();
        DormitoryDateMenu dormitoryDateMenu = new DormitoryDateMenu();
        VisiontowerDateMenu visiontowerDateMenu = new VisiontowerDateMenu();

        if (day == DayOfWeek.MONDAY){
            List<Object> todayMenu = new ArrayList<>();

            armMenu = findWeekService.armFindWeek(day);
            dormitoryDateMenu = findWeekService.dormitoryFindWeek(day);
            visiontowerDateMenu = findWeekService.visiontowerFindWeek(day);


        }else if (day == DayOfWeek.TUESDAY){
            List<Object> todayMenu = new ArrayList<>();

            armMenu = findWeekService.armFindWeek(day);
            dormitoryDateMenu = findWeekService.dormitoryFindWeek(day);
            visiontowerDateMenu = findWeekService.visiontowerFindWeek(day);

            todayMenu.add(armMenu);
            todayMenu.add(dormitoryDateMenu);
            todayMenu.add(visiontowerDateMenu);
            model.addAttribute("menus", todayMenu);
        }else if (day == DayOfWeek.WEDNESDAY){
            List<Object> todayMenu = new ArrayList<>();

            armMenu = findWeekService.armFindWeek(day);
            dormitoryDateMenu = findWeekService.dormitoryFindWeek(day);
            visiontowerDateMenu = findWeekService.visiontowerFindWeek(day);


        }else if (day == DayOfWeek.THURSDAY){
            List<Object> todayMenu = new ArrayList<>();

            armMenu = findWeekService.armFindWeek(day);
            dormitoryDateMenu = findWeekService.dormitoryFindWeek(day);
            visiontowerDateMenu = findWeekService.visiontowerFindWeek(day);

        }else if (day == DayOfWeek.FRIDAY){
            List<Object> todayMenu = new ArrayList<>();

            armMenu = findWeekService.armFindWeek(day);
            dormitoryDateMenu = findWeekService.dormitoryFindWeek(day);
            visiontowerDateMenu = findWeekService.visiontowerFindWeek(day);

        }else if (day == DayOfWeek.SATURDAY){
            List<Object> todayMenu = new ArrayList<>();

            armMenu.setDate("등록된 날짜가 없습니다.");
            armMenu.setDinnerMenu("등록된 메뉴가 없습니다.");
            armMenu.setLaunchMenu("등록된 메뉴가 없습니다.");
            visiontowerDateMenu.setMorningMenu("등록된 메뉴가 없습니다.");
            visiontowerDateMenu.setLaunchMenuA("등록된 메뉴가 없습니다.");
            visiontowerDateMenu.setLaunchMenuB("등록된 메뉴가 없습니다.");
            visiontowerDateMenu.setLaunchMenuC("등록된 메뉴가 없습니다.");
            visiontowerDateMenu.setDailyMarket("등록된 메뉴가 없습니다");
            dormitoryDateMenu = findWeekService.dormitoryFindWeek(day);


        }
        model.addAttribute("dormitory", dormitoryDateMenu);
        model.addAttribute("arm", armMenu);
        model.addAttribute("vision", visiontowerDateMenu);

        return "home";
    }

    @GetMapping("/arm")
    public String Arm(Model model) {
        List<String> db_date = armService.dbDateList();
        List<String> page_date = armService.pageCreateDate();

        if (db_date.equals(page_date)) {

            List<ArmDateMenu> menus = armService.allDateMenuList();
            model.addAttribute("menus", menus);

        } else {
//            armService.deleteMenuDate();
            List<ArmDateMenu> menus = Arrays.asList(
                    armService.createArmMenu(0, "mon"),
                    armService.createArmMenu(1, "tue"),
                    armService.createArmMenu(2, "wed"),
                    armService.createArmMenu(3, "thu"),
                    armService.createArmMenu(4, "fri"));
            model.addAttribute("menus", menus);
        }
//        List<ArmDateMenu> menus = Arrays.asList(
//                armService.createArmMenu(0, "mon"),
//                armService.createArmMenu(1, "tue"),
//                armService.createArmMenu(2, "wed"),
//                armService.createArmMenu(3, "thu"),
//                armService.createArmMenu(4, "fri"));
//        model.addAttribute("menus", menus);
        return  "arm";
    }

    @GetMapping("/dormitory")
    public String Dormitory(Model model) {

        List<String> db_date = dormitoryService.dbDateList();
        List<String> page_date = dormitoryService.pageCreateDate();
        if (db_date.equals(page_date)) {

            List<DormitoryDateMenu> menus = dormitoryService.allDateMenuList();
            model.addAttribute("menus", menus);

        } else {
//            dormitoryService.deleteMenuDate();
            List<DormitoryDateMenu> menus = Arrays.asList(
                    dormitoryService.createDormitoryMenu(0, "mon"),
                    dormitoryService.createDormitoryMenu(1, "tue"),
                    dormitoryService.createDormitoryMenu(2, "wed"),
                    dormitoryService.createDormitoryMenu(3, "thu"),
                    dormitoryService.createDormitoryMenu(4, "fri"),
                    dormitoryService.createDormitoryMenu(5, "sat"));
            model.addAttribute("menus", menus);
        }
//            List<DormitoryDateMenu> menus = Arrays.asList(
//                    dormitoryService.createDormitoryMenu(0, "mon"),
//                    dormitoryService.createDormitoryMenu(1, "tue"),
//                    dormitoryService.createDormitoryMenu(2, "wed"),
//                    dormitoryService.createDormitoryMenu(3, "thu"),
//                    dormitoryService.createDormitoryMenu(4, "fri"),
//                    dormitoryService.createDormitoryMenu(5, "sat"));
//            model.addAttribute("menus", menus);

        return "dormitory";
    }

    @GetMapping("/visiontower")
    public String Vision(Model model) {

        List<String> db_date = visiontowerService.dbDateList();
        List<String> page_date = visiontowerService.pageCreateDate();
        if (db_date.equals(page_date)) {

            List<VisiontowerDateMenu> menus = visiontowerService.allDateMenuList();
            model.addAttribute("menus", menus);
        }else {
            visiontowerService.deleteMenuDate();
            List<VisiontowerDateMenu> menus = Arrays.asList(
                    visiontowerService.createVisionMenu(0, "mon"),
                    visiontowerService.createVisionMenu(1, "tue"),
                    visiontowerService.createVisionMenu(2, "wed"),
                    visiontowerService.createVisionMenu(3, "thu"),
                    visiontowerService.createVisionMenu(4, "fri"));
            model.addAttribute("menus", menus);
        }
        return "visiontower";
    }





}



