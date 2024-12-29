package service.menuproject.service.restaurant;

import service.menuproject.web.dto.Request.RestaurantRequest;

public interface RestaurantCommandService {
    Long addRestaurant(RestaurantRequest.CreateRestaurantDto restaurantDto);
}
