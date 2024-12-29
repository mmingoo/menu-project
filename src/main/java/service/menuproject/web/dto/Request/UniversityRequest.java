package service.menuproject.web.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class UniversityRequest {
    @Getter
    @Builder
    @AllArgsConstructor
    public static class CreateUniversityDto {
        private String name;
        private String location;
    }
}
