package com.policy.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import com.policy.microservice.model.Benefits;
import com.policy.microservice.model.Hospital;
import com.policy.microservice.model.MemberPolicy;
import com.policy.microservice.model.Policy;
import com.policy.microservice.repository.BenefitsRepo;
import com.policy.microservice.repository.HospitalRepo;
import com.policy.microservice.repository.MemberPolicyRepo;
import com.policy.microservice.repository.PolicyRepo;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@ComponentScan(basePackages = "com.policy.microservice")
@EnableFeignClients
@Slf4j
public class PolicyMicroserviceApplication implements CommandLineRunner{
	
	public static void main(String[] args) {
		
		log.info("Inside Policy Microservice...");
		SpringApplication.run(PolicyMicroserviceApplication.class, args);
	}
	
	@Autowired
	private HospitalRepo hospitalRepo;
	
	@Autowired
	private PolicyRepo policyRepo;
	
	@Autowired
	private BenefitsRepo benefitsRepo;
	
	@Autowired
	private MemberPolicyRepo memberRepo;
	
	@Override
	public void run(String... args) throws Exception{
				
		Policy policy1 = new Policy("P100","Normal Health Policy",30000,12830);
		Policy policy2 = new Policy("P200","Premium Health Policy",60000,15391);
		Policy policy3 = new Policy("P300","Super Premium Health Policy",90000,18023);
		
		Hospital hospital1 = new Hospital("H100","Apollo Hospital","Rajahmundry");
		Hospital hospital2 = new Hospital("H200","Care Hospital","Vizag");
		Hospital hospital3 = new Hospital("H300","Gayathri Hospital","Vijayawada");
		Hospital hospital4 = new Hospital("H400","Varun Hospitals","Amaravathi");
		//Hospital hospital5 = new Hospital("H500","Max Superspecialty Hospital, Saket","Delhi-New Delhi");
		//Hospital hospital6 = new Hospital("H600","Fortis Memorial Research Institute","Gurgaon");
		
		policy1.getHospitals().add(hospital4);
		policy1.getHospitals().add(hospital1);
		policy1.getHospitals().add(hospital2);
		policy1.getHospitals().add(hospital3);
		
		policy2.getHospitals().add(hospital1);
		policy2.getHospitals().add(hospital2);
		policy2.getHospitals().add(hospital3);
		policy2.getHospitals().add(hospital4);
		//policy2.getHospitals().add(hospital5);
		//policy2.getHospitals().add(hospital6);
		
		policy3.getHospitals().add(hospital3);
		policy3.getHospitals().add(hospital1);
		policy3.getHospitals().add(hospital4);
		policy3.getHospitals().add(hospital3);
		
		
		Benefits b1 = new Benefits("B101","Coverage for Omicron");
		Benefits b2 = new Benefits("B102","Coverage for Dental");
		Benefits b3 = new Benefits("B103","Medical Tests covered");
		Benefits b4 = new Benefits("B104","Hospital Room charges covered");
		Benefits b5 = new Benefits("B107","Health Policy for rare diseases");
		Benefits b6 = new Benefits("B108","New Bron Action Plan Policy");
		
		policy1.getBenefits().add(b1);
		policy1.getBenefits().add(b2);
		policy1.getBenefits().add(b3);
		policy1.getBenefits().add(b5);
		
		
		MemberPolicy m1=new MemberPolicy("M101","P100",2,"21/03/2022","01/02/2021");
		MemberPolicy m2 = new MemberPolicy("M102","P200",13,"12/12/2021","16/05/2020");
		
		policy2.getBenefits().add(b1);
		policy2.getBenefits().add(b2);
		policy2.getBenefits().add(b3);
		policy2.getBenefits().add(b4);
		
		policy3.getBenefits().add(b1);
		policy3.getBenefits().add(b2);
		policy3.getBenefits().add(b5);
		policy3.getBenefits().add(b5);
		
		hospital1.getPolicies().add(policy1);
		hospital1.getPolicies().add(policy2);
		hospital1.getPolicies().add(policy3);
		
		hospital2.getPolicies().add(policy1);
		hospital2.getPolicies().add(policy2);
		
		hospital3.getPolicies().add(policy2);
		hospital3.getPolicies().add(policy3);
		
		hospital4.getPolicies().add(policy1);
		hospital4.getPolicies().add(policy2);
		
		hospital2.getPolicies().add(policy1);
		hospital3.getPolicies().add(policy2);
		hospital1.getPolicies().add(policy3);
		
		hospital4.getPolicies().add(policy2);
		hospital2.getPolicies().add(policy3);
		
		
		
		b1.getPolicyBenefits().add(policy1);
		b1.getPolicyBenefits().add(policy2);
		b1.getPolicyBenefits().add(policy3);
		
		b2.getPolicyBenefits().add(policy1);
		b2.getPolicyBenefits().add(policy2);
		b2.getPolicyBenefits().add(policy3);
		
		b3.getPolicyBenefits().add(policy1);
		b4.getPolicyBenefits().add(policy2);
		b5.getPolicyBenefits().add(policy3);
		
		b3.getPolicyBenefits().add(policy1);
		b4.getPolicyBenefits().add(policy2);
		b5.getPolicyBenefits().add(policy3);
		
		memberRepo.save(m1);
		memberRepo.save(m2);
		
		policyRepo.save(policy1);
		policyRepo.save(policy2);
		policyRepo.save(policy3);
		
		benefitsRepo.save(b1);
		benefitsRepo.save(b2);
		benefitsRepo.save(b3);
		benefitsRepo.save(b4);
		benefitsRepo.save(b5);
		benefitsRepo.save(b6);
		
		hospitalRepo.save(hospital1);
		hospitalRepo.save(hospital2);
		hospitalRepo.save(hospital3);
		hospitalRepo.save(hospital4);
	}
	
}
