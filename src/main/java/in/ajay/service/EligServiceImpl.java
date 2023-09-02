package in.ajay.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ajay.bindings.EDResponse;
import in.ajay.entity.EducationEntity;
import in.ajay.entity.EligEntity;
import in.ajay.entity.IncomeEntity;
import in.ajay.entity.KidEntity;
import in.ajay.entity.PlanEntity;
import in.ajay.entity.PlanSelEntity;
import in.ajay.repo.EducationRepo;
import in.ajay.repo.EligRepo;
import in.ajay.repo.IncomeRepo;
import in.ajay.repo.KidRepo;
import in.ajay.repo.PlanRepo;
import in.ajay.repo.PlanSelRepo;
@Service
public class EligServiceImpl implements EligService{

	@Autowired
	private PlanSelRepo planSelRepo;
	
	@Autowired
	private IncomeRepo incomeRepo;
	
	@Autowired
	private EducationRepo eduRepo;
	
	@Autowired
	private KidRepo kidRepo;
	
	@Autowired
	private PlanRepo planRepo;
	
	@Autowired
	private EligRepo eligRepo;
	
	@Override
	public EDResponse determineEligibility(Integer caseNum) {
		
		EDResponse response = new EDResponse();
		// get citizen plan name using case number
		
			PlanSelEntity planSel = planSelRepo.findByCaseNum(caseNum);
			Integer planId = planSel.getPlanId();
			PlanEntity planEntity = planRepo.findById(planId).get();
			String planName = planEntity.getPlanName();
		
		// get citizen info using case number
			
			IncomeEntity incomeEntity = incomeRepo.findByCaseNum(caseNum);
			EducationEntity educationEntity = eduRepo.findByCaseNum(caseNum);
			List<KidEntity> kidEntity = kidRepo.findByCaseNum(caseNum);
			
			response.setPlanName(planName);
			response.setCaseNum(caseNum);
			
			if("SNAP".equals(planName)) {
				Double salaryIncome = incomeEntity.getSalaryIncome();
				if(salaryIncome > 300) {
						response.setPlanStatus("DN");
						response.setDenialRsn("High Salary Income");
				}else {
						response.setPlanStatus("AP");
						response.setBenefitAmt(350.00);
						response.setEligStartDate(LocalDate.now());
						response.setEligEndDate(LocalDate.now().plusMonths(6));
				}
			}else if("CCAP" .equals(planName)) {
				Double salaryIncome = incomeEntity.getSalaryIncome();
				Long kidCount = kidRepo.findByCaseNum(caseNum).stream().count();
				//KidEntity kidCount = kidEntity.get(0);
				Integer kidAge = kidEntity.get(caseNum).getKidDob().getYear();
				//Integer kidId = kidEntity.get(caseNum).getKidId();
				
				if(salaryIncome > 300 && kidAge > 16 && kidCount.equals("")){
				//if(salaryIncome > 300 && year > 16 && !kidId.equals("")) {
					response.setPlanStatus("DN");
					response.setDenialRsn("High Salary Income");
				}else {
					response.setPlanStatus("AP");
					response.setBenefitAmt(350.00);
					response.setEligStartDate(LocalDate.now());
					response.setEligEndDate(LocalDate.now().plusMonths(6));
				}
				
			}else if("Medicaid".equals(planName)){
				Double salaryIncome = incomeEntity.getSalaryIncome();
				Double rentIncome = incomeEntity.getRentIncome();
				Double propertyIncome = incomeEntity.getPropertyIncome();
				Double totolIncome = rentIncome+propertyIncome;
				if(salaryIncome > 300 && totolIncome > 0) {
					response.setPlanStatus("DN");
					response.setDenialRsn("High Salary and Other income");
				}else {
					response.setPlanStatus("AP");
					response.setBenefitAmt(350.00);
					response.setEligStartDate(LocalDate.now());
					response.setEligEndDate(LocalDate.now().plusMonths(6));
				}
				
			}else if("Medicare".equals(planName)) {
				Integer year = kidEntity.get(planId).getKidDob().getYear();
				if(year < 65) {
					response.setPlanStatus("DN");
					response.setDenialRsn("Citizen Age is less than 65 years");
				}else {
					response.setPlanStatus("AP");
					response.setBenefitAmt(500.00);
					response.setEligStartDate(LocalDate.now());
					response.setEligEndDate(LocalDate.now().plusMonths(6));
				}
			}else if("RIW".equals(planName)) {
				Double salaryIncome = incomeEntity.getSalaryIncome();
				Long educationId = educationEntity.getEducationId();
				Integer graduationYear = educationEntity.getGraduationYear();
				//if(graduationYear.equals("") && educationId.equals("") && salaryIncome.equals(""))
				if(graduationYear.equals("")) {
					response.setPlanStatus("DN");
					response.setDenialRsn("Citizen is not graduated");
				}else {
					response.setPlanStatus("AP");
					response.setBenefitAmt(350.00);
					response.setEligStartDate(LocalDate.now());
					response.setEligEndDate(LocalDate.now().plusMonths(6));
				}
			}
			
			EligEntity entity = new EligEntity();
			BeanUtils.copyProperties(response, entity);
			
			eligRepo.save(entity);
		// based on received data identify which plan citizen applied
		// execute the condition for that plan to determine the eligibility
		
		return response;
	}

	@Override
	public boolean generateCo(Integer caseNum) {
		
		// get elig_record record based on case number
		
		
		// insert into CO table
		return false;
	}

	
}
