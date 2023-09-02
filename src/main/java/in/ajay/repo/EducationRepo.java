package in.ajay.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.ajay.entity.EducationEntity;

public interface EducationRepo extends JpaRepository<EducationEntity, Long> {

	@Query("from EducationEntity where caseNum=:caseNum")
	public EducationEntity findByCaseNum(Integer caseNum);
}
