package service.menuproject.service.menu;

import java.io.IOException;

public interface MenuCommandService {
    //Todo: 비전타워 메뉴 생성
    void createVisiontowerMenu() throws IOException;

    //Todo: 비전타워 메뉴 생성
    void createArmMenu() throws IOException;

    //Todo: 학생생활관 메뉴 생성
    void createDormitoryMenu() throws IOException;

    //Todo: 메디컬 메뉴 생성
    void createMedicalMenu() throws IOException;
}
