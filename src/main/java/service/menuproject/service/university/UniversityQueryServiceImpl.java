package service.menuproject.service.university;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import service.menuproject.base.exception.RestApiException;
import service.menuproject.base.exception.UniversityErrorStatus;
import service.menuproject.domain.University;
import service.menuproject.repository.UniversityRepository;

@Service
@RequiredArgsConstructor
public class UniversityQueryServiceImpl implements UniversityQueryService{

    private final UniversityRepository universityRepository;

    @Override
    public University findByName(String name){
        // 대학교 조회
        University university = universityRepository.findByName(name)
                .orElseThrow(() -> new RestApiException(UniversityErrorStatus.UNIVERSITY_NOT_FOUND));

        return university;
    }
}
