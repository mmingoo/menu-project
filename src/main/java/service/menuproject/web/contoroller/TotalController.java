package service.menuproject.web.contoroller;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
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

    //학교 추가
    @PostMapping("/university")
    @Scheduled(cron = "0 58 16 ? * THU")

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

    // 식당추가

    @PostMapping("/restaurant")
    @Scheduled(cron = "0 59 16 ? * THU")
    public BaseResponse<Long> addRestaurant(
//                                            @RequestBody RestaurantRequest.CreateRestaurantDto createRestaurantDto
                                            )
    {
        RestaurantRequest.CreateRestaurantDto createRestaurantDto1 =  RestaurantRequest.CreateRestaurantDto.builder()
                .universityName("가천대학교")
                .name("비전타워")
                .location("비전타워 1층")
                .build();
        RestaurantRequest.CreateRestaurantDto createRestaurantDto2 =  RestaurantRequest.CreateRestaurantDto.builder()
                .universityName("가천대학교")
                .name("교육대학원 식당")
                .location("교육대학원 지하 1층")
                .build();
        RestaurantRequest.CreateRestaurantDto createRestaurantDto3 =  RestaurantRequest.CreateRestaurantDto.builder()
                .universityName("가천대학교")
                .name("학생생활관 식당")
                .location("제3학생생활관 1층 학생식당")
                .build();
        RestaurantRequest.CreateRestaurantDto createRestaurantDto4 =  RestaurantRequest.CreateRestaurantDto.builder()
                .universityName("가천대학교")
                .name("체육관(메디컬) 식당")
                .location("메디컬캠퍼스 체육관 1층")
                .build();


        long universityId = restaurantCommandService.addRestaurant(createRestaurantDto1);
        restaurantCommandService.addRestaurant(createRestaurantDto2);
        restaurantCommandService.addRestaurant(createRestaurantDto3);
        restaurantCommandService.addRestaurant(createRestaurantDto4);

        return BaseResponse.onSuccess(universityId);
    }


}
