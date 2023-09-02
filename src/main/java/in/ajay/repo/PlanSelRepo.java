package in.ajay.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.ajay.entity.PlanSelEntity;

public interface PlanSelRepo extends JpaRepository<PlanSelEntity, Integer>{

	@Query("from PlanSelEntity where caseNum=:caseNum")
	public PlanSelEntity findByCaseNum(Integer caseNum);
}
