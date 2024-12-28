package service.menuproject.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Table(name = "university")
@Entity
@Getter
@NoArgsConstructor
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 100)
    private String location;

    @OneToMany(mappedBy = "university", cascade = CascadeType.ALL)
    private List<Restaurant> restaurantList = new ArrayList<>();

}

