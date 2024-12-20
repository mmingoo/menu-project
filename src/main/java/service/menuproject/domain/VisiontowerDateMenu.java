package service.menuproject.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
public class VisiontowerDateMenu {

    @Id
    @GeneratedValue
    public Long id;
    public String date;
    public String morningMenu;
    public String launchMenuA;
    public String launchMenuB;
    public String launchMenuC;
    public String dailyMarket;



}
