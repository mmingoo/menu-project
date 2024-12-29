package service.menuproject.service.university;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import service.menuproject.domain.University;
import service.menuproject.repository.UniversityRepository;

import service.menuproject.web.dto.Request.UniversityRequest;

import static service.menuproject.converter.toEntity.ToUniversityEntity.toUniversity;

@Service
@RequiredArgsConstructor
public class UniversityCommandServiceImpl implements UniversityCommandService {
    private final UniversityRepository universityRepository;

    //Todo: 대학교 추가 기능
    @Override
    public Long addUniversity(UniversityRequest.CreateUniversityDto universityDto){
        University university = toUniversity(universityDto);

        Long universityId = universityRepository.save(university).getId();

        return universityId;
    }
}
