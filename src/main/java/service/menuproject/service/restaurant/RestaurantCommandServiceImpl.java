package service.menuproject.service.restaurant;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import service.menuproject.domain.Restaurant;
import service.menuproject.repository.RestaurantRepository;
import service.menuproject.service.university.UniversityQueryService;
import service.menuproject.web.dto.Request.RestaurantRequest;

import static service.menuproject.converter.toEntity.ToRestaurantEntity.toRestaurant;

@Service
@RequiredArgsConstructor
public class RestaurantCommandServiceImpl implements RestaurantCommandService{

    private final RestaurantRepository restaurantRepository;
    private final UniversityQueryService universityQueryService;

    //Todo: 식당 추가 기능
    @Override
    public Long addRestaurant(RestaurantRequest.CreateRestaurantDto restaurantDto){
        // dto -> entity 로 변환
        Restaurant restaurant = toRestaurant(restaurantDto);

        // 식당에 대학교 매핑
        restaurant.setUniversity(universityQueryService.findByName(restaurantDto.getUniversityName()));

        Long restaurantId =   restaurantRepository.save(restaurant).getId();

        return restaurantId;
    }

}
