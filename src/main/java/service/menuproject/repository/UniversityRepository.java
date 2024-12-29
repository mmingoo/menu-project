package service.menuproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import service.menuproject.domain.University;

@Repository
public interface UniversityRepository extends JpaRepository<University,Long> {
}
