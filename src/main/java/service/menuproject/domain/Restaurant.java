package service.menuproject.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "restaurants")
@Entity
@Getter
@NoArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "restaurant_name", length = 50, nullable = false)
    private String name;

    @Column(length = 100)
    private String location;

    @Column(name = "morning_start_time")
    private LocalTime morningStartTime;

    @Column(name = "morning_end_time")
    private LocalTime morningEndTime;

    @Column(name = "launch_start_time")
    private LocalTime launchStartTime;

    @Column(name = "launch_end_time")
    private LocalTime launchEndTime;

    @Column(name = "dinner_start_time")
    private LocalTime dinnerStartTime;

    @Column(name = "dinner_end_time")
    private LocalTime dinnerEndTime;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "university_id", nullable = false)
    private University university;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Menu> menuList = new ArrayList<>();
}
