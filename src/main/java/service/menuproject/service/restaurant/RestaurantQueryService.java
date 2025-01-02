package service.menuproject.service.restaurant;

import service.menuproject.domain.Restaurant;

public interface RestaurantQueryService {
    Restaurant findByName(String name);

    Restaurant findById(Long id);
}
