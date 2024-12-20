package service.menuproject.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.menuproject.domain.VisiontowerDateMenu;
import service.menuproject.repository.VisiontowerRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisiontowerService {
    private final VisiontowerRepository visiontowerRepository;
    VisiontowerDateMenu VisionDateMenu = new VisiontowerDateMenu();
//    List<String> menuList = dormitory3Repository.createMenuList();

    @Transactional // 객체 만들기
    public VisiontowerDateMenu createVisionMenu(int dayNumber, String day){

        VisiontowerDateMenu DateMenu = new VisiontowerDateMenu();
        VisiontowerDateMenu Menu = visiontowerRepository.makeVisiontowerMenu(DateMenu, dayNumber, day);
        this.saveMenuDate(Menu);
        return DateMenu;
    }


    public  List<String> pageCreateDate() {
        return  visiontowerRepository.newCreateDate();

    }


    @Transactional
    public void saveMenuDate(VisiontowerDateMenu menu){
        visiontowerRepository.save(menu);
    }

    public List<VisiontowerDateMenu> allDateMenuList(){
        return visiontowerRepository.allList();
    }


    public List<String> dbDateList() {
       return visiontowerRepository.dbDateList();
    }

    @Transactional
    public void deleteMenuDate(){visiontowerRepository.deleteMenu();}


}