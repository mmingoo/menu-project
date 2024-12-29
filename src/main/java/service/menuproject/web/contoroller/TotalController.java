package service.menuproject.web.contoroller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.menuproject.base.BaseResponse;
import service.menuproject.service.UniversityCommandService;
import service.menuproject.web.dto.Request.UniversityRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/setting")
public class TotalController {
    private final UniversityCommandService universityCommandService;

    @PostMapping("/university")
    public BaseResponse<Long> addUniversity(
                                            @RequestBody UniversityRequest.CreateUniversityDto universityDto
                                             )
    {
        long universityId = universityCommandService.addUniversity(universityDto);
        return BaseResponse.onSuccess(universityId);
    }

    @PostMapping("/restaurants")
    public BaseResponse<Long> addRestaurants(
            @RequestBody UniversityRequest.CreateUniversityDto universityDto
    )
    {
        long universityId = universityCommandService.addUniversity(universityDto);
        return BaseResponse.onSuccess(universityId);
    }


}
