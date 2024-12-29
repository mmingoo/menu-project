package service.menuproject.service.university;

import service.menuproject.domain.University;

public interface UniversityQueryService{
    University findByName(String name);
}
