package com.policy.microservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.policy.microservice.PolicyMicroserviceApplication;

@SpringBootTest
class PolicyMicroserviceApplicationTests {

	PolicyMicroserviceApplication policyMicroserviceApplication;
	@Test
	void contextLoads() {
		assertTrue(true);
	}
	
	@Test
	void testComponentProcessingMicroserviceApplication() {
		assertThat(policyMicroserviceApplication).isNull();
	}
}
