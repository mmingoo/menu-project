package service.menuproject.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import service.menuproject.domain.Menu;
import service.menuproject.domain.QMenu;
import service.menuproject.domain.Restaurant;

import java.time.LocalDate;
import java.util.List;

import static service.menuproject.domain.QMenu.menu1;

@Repository
public class MenuQueryCustomRepositoryImpl implements MenuQueryCustomRepository {

    private final JPAQueryFactory queryFactory;

    public MenuQueryCustomRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }


    @Override
    public List<Menu> findWeekMenusByRestaurant(Restaurant restaurant, LocalDate startDate, LocalDate endDate) {
        QMenu menu1 = QMenu.menu1;
        return queryFactory
                .selectFrom(menu1)
                .where(
                        menu1.restaurant.eq(restaurant)
                                .and(menu1.date.between(startDate,endDate))
                )
                .orderBy(menu1.date.asc())
                .fetch();
    }
}
