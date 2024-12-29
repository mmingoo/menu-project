package service.menuproject.domain;

import jakarta.persistence.*;
        import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @Builder
    public Restaurant(String name, String location, LocalTime morningStartTime, LocalTime morningEndTime, LocalTime launchStartTime, LocalTime launchEndTime, LocalTime dinnerStartTime, LocalTime dinnerEndTime) {
        this.name = name;
        this.location = location;
        this.morningStartTime = morningStartTime;
        this.morningEndTime = morningEndTime;
        this.launchStartTime = launchStartTime;
        this.launchEndTime = launchEndTime;
        this.dinnerStartTime = dinnerStartTime;
        this.dinnerEndTime = dinnerEndTime;
    }

    public void setUniversity(University university) {
        // 기존 관계 제거
        // 현재 Restaurant가 가지고 있는 기존 University와의 관계를 정리
        if (this.university != null) {
            this.university.getRestaurantList().remove(this);
        }

        this.university = university;

        // 새로운 관계 설정
        // 새로운 University의 레스토랑 목록에 현재 Restaurant를 추가
        if (university != null && !university.getRestaurantList().contains(this)) {
            university.getRestaurantList().add(this);
        }
    }
}
