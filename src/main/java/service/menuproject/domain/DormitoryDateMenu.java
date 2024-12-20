package service.menuproject.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
public class DormitoryDateMenu {

    @Id
    @GeneratedValue
    public Long id;

    public String date;
    public String morningMenu;
    public String launchMenu1;
    public String launchMenu2;
    public String dinnerMenu;

    public void String() {
        System.out.println("Date: " + date);
        System.out.println("\nMorning Menu: " + morningMenu);
        System.out.println("\nLunch Menu 1: " + launchMenu1);
        System.out.println("\nLunch Menu 2: " + launchMenu2);
        System.out.println("\nDinner Menu: " + dinnerMenu);

    }
}
