package service.menuproject.web.contoroller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.menuproject.base.BaseResponse;
import service.menuproject.repository.RestaurantRepository;
import service.menuproject.service.restaurant.RestaurantCommandService;
import service.menuproject.service.university.UniversityCommandService;
import service.menuproject.web.dto.Request.RestaurantRequest;
import service.menuproject.web.dto.Request.UniversityRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/setting")
public class TotalController {
    private final UniversityCommandService universityCommandService;
    private final RestaurantCommandService restaurantCommandService;

    @PostMapping("/university")
    public BaseResponse<Long> addUniversity(
//                                            @RequestBody UniversityRequest.CreateUniversityDto universityDto
                                             )
    {
        UniversityRequest.CreateUniversityDto universityDto = UniversityRequest.CreateUniversityDto.builder()
                .name("가천대학교")
                .location("경기도 성남시 수정구 성남대로 1342")
                .build();
        long universityId = universityCommandService.addUniversity(universityDto);
        return BaseResponse.onSuccess(universityId);
    }

    @PostMapping("/restaurant")
    public BaseResponse<Long> addRestaurant(
                                            @RequestBody RestaurantRequest.CreateRestaurantDto createRestaurantDto
                                            )
    {
        long universityId = restaurantCommandService.addRestaurant(createRestaurantDto);
        return BaseResponse.onSuccess(universityId);
    }


}
