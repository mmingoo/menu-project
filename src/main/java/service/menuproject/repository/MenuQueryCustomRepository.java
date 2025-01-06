package service.menuproject.repository;

import org.springframework.stereotype.Repository;
import service.menuproject.domain.Menu;
import service.menuproject.domain.Restaurant;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MenuQueryCustomRepository {

    List<Menu> findWeekMenusByRestaurant(Restaurant restaurant, LocalDate startDate, LocalDate endDate);
}
