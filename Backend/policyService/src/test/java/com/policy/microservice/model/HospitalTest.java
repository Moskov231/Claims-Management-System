package com.policy.microservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HospitalTest {
	@Test
	@DisplayName("Checking the correctness of Hospital object")
	void testingHospital()
	{
		Hospital hospital=new Hospital();
		hospital.setHospitalId("H101");
		hospital.setLocation("Hyderabad");
		hospital.setName("Apollo Hospital");
		assertEquals("H101",hospital.getHospitalId());
		assertEquals("Hyderabad",hospital.getLocation());
		assertEquals("Apollo Hospital",hospital.getName());
	}

}
