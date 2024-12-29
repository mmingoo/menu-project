package service.menuproject.web.dto.Request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalTime;

public class RestaurantRequest {
    @Getter
    @AllArgsConstructor
    @Builder
    public static class  CreateRestaurantDto{

        @NotBlank(message = "학교를 입력해주세요")
        private String universityName;

        @NotBlank(message = "식당이름을 입력해주세요.")
        @Column(length = 20)
        private String name;

        @Column(length = 100)
        @NotBlank(message = "식딩위치를 입력해주세요.")
        private String location;

        private LocalTime morningStartTime;

        private LocalTime morningEndTime;

        private LocalTime launchStartTime;

        private LocalTime launchEndTime;

        private LocalTime dinnerStartTime;

        private LocalTime dinnerEndTime;
    }
}
