package service.menuproject.converter.toEntity;
import service.menuproject.domain.University;
import service.menuproject.web.dto.Request.UniversityRequest;

public class toUniversityEntity {
    public static University toUniversity(UniversityRequest.CreateUniversityDto universityDto){
        return University.builder()
                .name(universityDto.getName())
                .location(universityDto.getLocation())
                .build();
    }
}
