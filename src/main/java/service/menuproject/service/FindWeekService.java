package service.menuproject.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import service.menuproject.domain.ArmDateMenu;
import service.menuproject.domain.DormitoryDateMenu;
import service.menuproject.domain.VisiontowerDateMenu;
import service.menuproject.repository.FindWeekRepository;

import java.time.DayOfWeek;

@Service
@RequiredArgsConstructor
public class FindWeekService {
    private final FindWeekRepository findWeekRepository;
    public ArmDateMenu armFindWeek(DayOfWeek day){
        int n = 0;

        if (day == DayOfWeek.MONDAY){
            n = 1;
        }else if (day == DayOfWeek.TUESDAY){
            n = 2;
        }else if (day == DayOfWeek.WEDNESDAY){
            n = 3;
        }else if (day == DayOfWeek.THURSDAY){
            n = 4;
        }else if (day == DayOfWeek.FRIDAY){
            n = 5;
        }else if (day == DayOfWeek.SATURDAY){
            n = 6;
        }
        return findWeekRepository.armFindMenu(n);
    }

    public DormitoryDateMenu dormitoryFindWeek(DayOfWeek day){
        int n = 0;

        if (day == DayOfWeek.MONDAY){
            n = 1;
        }else if (day == DayOfWeek.TUESDAY){
            n = 2;
        }else if (day == DayOfWeek.WEDNESDAY){
            n = 3;
        }else if (day == DayOfWeek.THURSDAY){
            n = 4;
        }else if (day == DayOfWeek.FRIDAY){
            n = 5;
        }else if (day == DayOfWeek.SATURDAY){
            n = 6;
        }
        return findWeekRepository.dormitoryFindMenu(n);
    }
    public VisiontowerDateMenu visiontowerFindWeek(DayOfWeek day){
        int n = 0;

        if (day == DayOfWeek.MONDAY){
            n = 1;
        }else if (day == DayOfWeek.TUESDAY){
            n = 2;
        }else if (day == DayOfWeek.WEDNESDAY){
            n = 3;
        }else if (day == DayOfWeek.THURSDAY){
            n = 4;
        }else if (day == DayOfWeek.FRIDAY){
            n = 5;
        }else if (day == DayOfWeek.SATURDAY){
            n = 6;
        }
        return findWeekRepository.visiontowerFindMenu(n);
    }

}
