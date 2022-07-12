package com.policy.microservice.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.policy.microservice.model.Hospital;

@SpringBootTest
class ProviderDTOTest {

	ProviderDTO providerDTO=new ProviderDTO();
	
	@Test
	@DisplayName("Checking if providerDTO is loading or not")
	void providerDTOIsLoadingOrNot() {
		assertThat(providerDTO).isNotNull();
	}
	
	@Test
	@DisplayName("Checking if all the getter and setters working")
	void checkProviderDTO() {
		Set<Hospital> list=new HashSet<>();
		list.add( new Hospital("H1","Apollo Hospital","Delhi-Indraprastha"));
		list.add( new Hospital("H2","Artemis Hospital","Gurgaon"));
		ProviderDTO providerDTO =new ProviderDTO(list);
		
		assertEquals(2,providerDTO.getProviders().size());
	}
	
}
