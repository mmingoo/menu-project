package service.menuproject.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import service.menuproject.base.enums.DayOfWeek;

import java.time.LocalDate;

@Table(name = "menus")
@Entity
@Getter
@NoArgsConstructor
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(nullable = false, length = 150)
    private String menu;

//    @Column(nullable = false, length = 5)
    @Enumerated(EnumType.STRING)
    private DayOfWeek type;

//    @Column(nullable = false)
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    private String mealType;

    @Builder
    public Menu(String menu, DayOfWeek type, LocalDate date, Restaurant restaurant, String mealType) {
        this.menu = menu;
        this.type = type;
        this.date = date;
        this.restaurant = restaurant;
        this.mealType = mealType;
    }
}
