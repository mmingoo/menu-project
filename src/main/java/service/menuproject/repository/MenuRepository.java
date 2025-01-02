package service.menuproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import service.menuproject.domain.Menu;
import service.menuproject.domain.Restaurant;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

    List<Menu> findByDate(LocalDate date);

    List<Menu> findByRestaurant(Restaurant restaurant);
}
