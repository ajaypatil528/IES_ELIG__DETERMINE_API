package in.ajay.bindings;

import java.time.LocalDate;

public class EDResponse {

	private Integer caseNum;
	private String planName;
	private String planStatus;
	private Double benefitAmt;
	private LocalDate eligStartDate;
	private LocalDate eligEndDate;
	private String denialRsn;
	public Integer getCaseNum() {
		return caseNum;
	}
	public void setCaseNum(Integer caseNum) {
		this.caseNum = caseNum;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getPlanStatus() {
		return planStatus;
	}
	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}
	public Double getBenefitAmt() {
		return benefitAmt;
	}
	public void setBenefitAmt(Double benefitAmt) {
		this.benefitAmt = benefitAmt;
	}
	public LocalDate getEligStartDate() {
		return eligStartDate;
	}
	public void setEligStartDate(LocalDate eligStartDate) {
		this.eligStartDate = eligStartDate;
	}
	public LocalDate getEligEndDate() {
		return eligEndDate;
	}
	public void setEligEndDate(LocalDate eligEndDate) {
		this.eligEndDate = eligEndDate;
	}
	public String getDenialRsn() {
		return denialRsn;
	}
	public void setDenialRsn(String denialRsn) {
		this.denialRsn = denialRsn;
	}
	
	
}
