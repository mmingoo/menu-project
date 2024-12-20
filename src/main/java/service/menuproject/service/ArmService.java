package service.menuproject.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.menuproject.domain.ArmDateMenu;
import service.menuproject.repository.ArmRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArmService {
    private final ArmRepository armRepository;

      ArmDateMenu armDateMenu = new ArmDateMenu();
//    List<String> menuList = dormitory3Repository.createMenuList();

    @Transactional // 객체 만들기
    public ArmDateMenu createArmMenu(int dayNumber, String day){
//        dormitory3Repository.deleteMenu();
        ArmDateMenu DateMenu = new ArmDateMenu();

        ArmDateMenu Menu = armRepository.makeArmMenu(DateMenu, dayNumber, day);
        this.saveMenuDate(Menu);
        return DateMenu;
    }


    public  List<String> pageCreateDate() {
        return  armRepository.newCreateDate();

    }


    @Transactional
    public void saveMenuDate(ArmDateMenu menu){
        armRepository.save(menu);
    }

    public List<ArmDateMenu> allDateMenuList(){
        return armRepository.allList();
    }


    public List<String> dbDateList() {
       return armRepository.dbDateList();
    }

    @Transactional
    public void deleteMenuDate(){
        armRepository.deleteMenu();
    }
}