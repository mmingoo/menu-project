package service.menuproject.service;

import service.menuproject.web.dto.Request.UniversityRequest;

public interface UniversityCommandService {
    Long addUniversity(UniversityRequest.CreateUniversityDto universityDto);
}
