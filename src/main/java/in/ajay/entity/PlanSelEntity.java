package in.ajay.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "IES_PLAN_SELECTION")
public class PlanSelEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer planSelId;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	@OneToOne
	@JoinColumn(name= "case_num")
	private AppEntity appEntity;
	
	@ManyToOne
	private Integer planId;
	
	@ManyToOne
	private Integer caseNum;

	
	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public AppEntity getAppEntity() {
		return appEntity;
	}

	public void setAppEntity(AppEntity appEntity) {
		this.appEntity = appEntity;
	}

	public Integer getPlanSelId() {
		return planSelId;
	}

	public void setPlanSelId(Integer planSelId) {
		this.planSelId = planSelId;
	}

	public Integer getPlanId() {
		return planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	public Integer getCaseNum() {
		return caseNum;
	}

	public void setCaseNum(Integer caseNum) {
		this.caseNum = caseNum;
	}
	
}
