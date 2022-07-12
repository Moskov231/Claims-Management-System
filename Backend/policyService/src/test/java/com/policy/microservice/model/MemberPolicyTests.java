package com.policy.microservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberPolicyTests {
	
	@Test
	@DisplayName("testing the correctness of MemberPolicy object")
	void testingMemberPolicy()
	{
	MemberPolicy memberPolicy=new MemberPolicy();
	memberPolicy.setMemberId("M101");
	memberPolicy.setPolicyId("P101");
	memberPolicy.setPremiumLastDate("28-04-2022");
	memberPolicy.setSubscriptionDate("20-04-2022");
	assertEquals("M101",memberPolicy.getMemberId());
	assertEquals("P101",memberPolicy.getPolicyId());
	assertEquals("28-04-2022",memberPolicy.getPremiumLastDate());
	assertEquals("20-04-2022",memberPolicy.getSubscriptionDate());
	}

}
