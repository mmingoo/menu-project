package service.menuproject.service.restaurant;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import service.menuproject.base.exception.RestApiException;
import service.menuproject.base.exception.RestaurantErrorStatus;
import service.menuproject.domain.Restaurant;
import service.menuproject.repository.RestaurantRepository;

@Service
@RequiredArgsConstructor
public class RestaurantQueryServiceImpl implements RestaurantQueryService{
    private final RestaurantRepository restaurantRepository;

    @Override
    public Restaurant findByName(String name){
        Restaurant restaurant = restaurantRepository.findByName(name)
                .orElseThrow(() -> new RestApiException(RestaurantErrorStatus.RESTAURANT_NOT_FOUND));

        return restaurant;
    }

    @Override
    public Restaurant findById(Long id){
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RestApiException(RestaurantErrorStatus.RESTAURANT_NOT_FOUND));

        return restaurant;
    }
}
