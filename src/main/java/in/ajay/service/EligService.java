package in.ajay.service;



import in.ajay.bindings.EDResponse;

public interface EligService {

	public EDResponse determineEligibility(Integer caseNum);
	
	public boolean generateCo(Integer caseNum);
}
