package com.policy.microservice.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import com.policy.microservice.dto.ValidatingDTO;
import com.policy.microservice.exception.InvalidTokenException;
import com.policy.microservice.controller.PolicyMicroserviceController;
import com.policy.microservice.service.BenefitsService;
import com.policy.microservice.service.ClaimAmountService;
import com.policy.microservice.feign.AuthClient;
@SpringBootTest
class ClaimsControllerTest {

	@Autowired
	PolicyMicroserviceController policyMicroserviceController;
	@MockBean
	BenefitsService benefitsService;
	@MockBean
	ClaimAmountService claimAmountService;
	@MockBean
	AuthClient authClient;
	
	@Test
    @DisplayName("Checking for Claims Controller - if it is loading or not for @GetMapping")
    void componentProcessingControllerNotNullTest(){
        assertThat(policyMicroserviceController).isNotNull();
    }
	
	@Test
	@DisplayName("Checking getchainofproviders Endpoint with Invalid Token")
	void testGetChainOfProvidersEndpointWithInvalidToken() {
		String token="AAA";
		ValidatingDTO validatingDTO=new ValidatingDTO(false);
		when(authClient.getsValidity(token)).thenReturn(validatingDTO);
		
		assertThrows(InvalidTokenException.class, () ->
		policyMicroserviceController.getChainOfProviders("C101",token));
	}
	
	/*@Test
	@DisplayName("Checking submit Claim Endpoint with Invalid Token")
	void testSubmitClaimEndpointWithInvalidToken() {
		String token="AAA";
		ValidatingDTO validatingDTO=new ValidatingDTO(false);
		when(authClient.getsValidity(token)).thenReturn(validatingDTO);
		ClaimDTO claimDTO=new ClaimDTO();
		assertThrows(InvalidTokenException.class, () ->
        claimsController.submitClaim(claimDTO,token));
	}

	
	@Test
	@DisplayName("Checking the working of get claim Status Endpoint")
	void testGetClaimStatusWithValidParameters() {
		String token="AAA";
		ValidatingDTO validatingDTO=new ValidatingDTO(true);
		
		ClaimStatusDTO claimStatusDTO=new ClaimStatusDTO();
		claimStatusDTO.setClaimId("C101");
		claimStatusDTO.setClaimStatus("Pending");
		claimStatusDTO.setClaimDescription("Verified");
		
		when(authClient.getsValidity(token)).thenReturn(validatingDTO);
		when(claimStatusService.getClaimStatus("C101")).thenReturn(new ResponseEntity<ClaimStatusDTO>(claimStatusDTO,HttpStatus.OK));
		
		
		assertEquals(claimStatusDTO.getClaimId(), claimsController.getClaimStatus("C101",token).getBody().getClaimId()); 
		assertEquals(claimStatusDTO.getClaimStatus(), claimsController.getClaimStatus("C101",token).getBody().getClaimStatus()); 
		assertEquals(claimStatusDTO.getClaimDescription(), claimsController.getClaimStatus("C101",token).getBody().getClaimDescription()); 
	}
	
	@Test
	@DisplayName("Checking the working of Submit claim  Endpoint")
	void testSubmitClaimWithValidParameters() {
		String token="AAA";
		ValidatingDTO validatingDTO=new ValidatingDTO(true);
		ClaimDTO claimDTO=new ClaimDTO();
		ClaimStatusDTO claimStatusDTO=new ClaimStatusDTO();
		claimStatusDTO.setClaimId("C101");
		claimStatusDTO.setClaimStatus("Pending");
		claimStatusDTO.setClaimDescription("Verified");
		
		when(authClient.getsValidity(token)).thenReturn(validatingDTO);
		when(submitClaimService.submitClaim(claimDTO,token)).thenReturn(new ResponseEntity<ClaimStatusDTO>(claimStatusDTO,HttpStatus.OK));
		
		
		assertEquals(claimStatusDTO.getClaimId(), claimsController.submitClaim(claimDTO,token).getBody().getClaimId()); 
		assertEquals(claimStatusDTO.getClaimStatus(), claimsController.submitClaim(claimDTO,token).getBody().getClaimStatus()); 
		assertEquals(claimStatusDTO.getClaimDescription(),claimsController.submitClaim(claimDTO,token).getBody().getClaimDescription()); 
	}*/
}
