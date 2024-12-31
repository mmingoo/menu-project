package service.menuproject.service.university;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import service.menuproject.base.exception.RestApiException;
import service.menuproject.base.exception.UniversityErrorStatus;
import service.menuproject.domain.University;
import service.menuproject.repository.UniversityRepository;

import service.menuproject.web.dto.Request.UniversityRequest;

import static service.menuproject.converter.toEntity.ToUniversityEntity.toUniversity;

@Service
@RequiredArgsConstructor
public class UniversityCommandServiceImpl implements UniversityCommandService {
    private final UniversityRepository universityRepository;
    private final UniversityQueryService universityQueryService;

    //Todo: 대학교 추가 기능
    @Override
    public Long addUniversity(UniversityRequest.CreateUniversityDto universityDto) {
        universityRepository.findByName(universityDto.getName())
                .ifPresent(u -> {
                    throw new RestApiException(UniversityErrorStatus.UNIVERSITY_EXIST);
                });

        University university = toUniversity(universityDto);
        return universityRepository.save(university).getId();
    }

}

