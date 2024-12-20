package service.menuproject.repository;

import jakarta.persistence.EntityManager;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import service.menuproject.domain.ArmDateMenu;
import service.menuproject.domain.DormitoryDateMenu;
import service.menuproject.domain.VisiontowerDateMenu;

@Repository
@RequiredArgsConstructor
public class FindWeekRepository {
    private final EntityManager em;
    public ArmDateMenu armFindMenu(int id){
        return em.find(ArmDateMenu.class, id);
    }
    public VisiontowerDateMenu visiontowerFindMenu(int id){
        return em.find(VisiontowerDateMenu.class, id);
    }
    public DormitoryDateMenu dormitoryFindMenu(int id){
        return em.find(DormitoryDateMenu.class, id);
    }
}
