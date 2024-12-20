package service.menuproject.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.menuproject.domain.DormitoryDateMenu;
import service.menuproject.repository.Dormitory3Repository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DormitoryService {
    private final Dormitory3Repository dormitory3Repository;

    DormitoryDateMenu dormitoryDateMenu = new DormitoryDateMenu();
//    List<String> menuList = dormitory3Repository.createMenuList();

    @Transactional // 객체 만들기
    public DormitoryDateMenu createDormitoryMenu(int dayNumber, String day){
//        dormitory3Repository.deleteMenu();
        DormitoryDateMenu DateMenu = new DormitoryDateMenu();

        DormitoryDateMenu Menu = dormitory3Repository.makeDormitoryMenu(DateMenu, dayNumber, day);
        this.saveMenuDate(Menu);
        return DateMenu;
    }


    public List<String> pageCreateDate() {
        return  dormitory3Repository.newCreateDate();

    }


    @Transactional
    public void saveMenuDate(DormitoryDateMenu menu){
        dormitory3Repository.save(menu);
    }

    public List<DormitoryDateMenu> allDateMenuList(){
        return dormitory3Repository.allList();
    }


    public List<String> dbDateList() {
       return dormitory3Repository.dbDateList();
    }

    @Transactional
    public void deleteMenuDate(){
        dormitory3Repository.deleteMenu();
    }
}