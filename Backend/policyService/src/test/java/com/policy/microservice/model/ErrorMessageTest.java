package com.policy.microservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ErrorMessageTest {
@Test
@DisplayName("Checking the correctness of ErrorMessage object")
void testingErrorMessage()
{
	ErrorMessage errorMessage=new ErrorMessage();
	Date date=new Date();
	errorMessage.setDescription("Random Error, crashing.....");
	errorMessage.setMessage("Recompiling.....");
	errorMessage.setStatusCode(500);
	errorMessage.setTimestamp(date);
	assertEquals("Random Error, crashing.....",errorMessage.getDescription());
	assertEquals("Recompiling.....",errorMessage.getMessage());
	assertEquals(500,errorMessage.getStatusCode());
	assertEquals(date,errorMessage.getTimestamp());
}
}
