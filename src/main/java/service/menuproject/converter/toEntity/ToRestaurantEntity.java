package service.menuproject.converter.toEntity;

import service.menuproject.domain.Restaurant;
import service.menuproject.web.dto.Request.RestaurantRequest;

public class ToRestaurantEntity {
    public static Restaurant toRestaurant(RestaurantRequest.CreateRestaurantDto restaurantDto){
        return Restaurant.builder()
                .name(restaurantDto.getName())
                .location(restaurantDto.getLocation())
                .morningStartTime(restaurantDto.getMorningStartTime())
                .morningEndTime(restaurantDto.getMorningEndTime())
                .launchStartTime(restaurantDto.getLaunchStartTime())
                .launchEndTime(restaurantDto.getLaunchEndTime())
                .dinnerStartTime(restaurantDto.getDinnerStartTime())
                .dinnerEndTime(restaurantDto.getDinnerEndTime())
                .build();
    }
}
