package com.policy.microservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;



import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PolicyTests {
	@Test
	@DisplayName("Checking the correctness of Policy object")
	void testingPolicy()
	{
		Policy policy=new Policy();
		policy.setPolicyId("P101");
		policy.setPolicyType("Premium");
		policy.setPremium(1255.67);
		policy.setSumInsured(545.6);
		assertEquals("P101",policy.getPolicyId());
		assertEquals("Premium",policy.getPolicyType());
		assertEquals(1255.67,policy.getPremium());
		assertEquals(545.6,policy.getSumInsured());
	}

}
