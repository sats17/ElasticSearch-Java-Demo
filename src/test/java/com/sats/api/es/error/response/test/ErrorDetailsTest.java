package com.sats.api.es.error.response.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.sats.api.es.error.response.ErrorDetails;

import nl.jqno.equalsverifier.EqualsVerifier;

import static com.sats.api.es.utilites.test.Utility.ErrorDetailsValidationExceptionReturnObject;

public class ErrorDetailsTest {
	
	@Test
	public void testToString() {
		String expected = "ErrorDetails(resultCode=40002, resultType=Please check given request body, it's format is incorrect, resultMessage=Please check given request body, it's format is incorrect, httpMethod=null, httpRequestURI=null)"; 
		assertEquals(expected, ErrorDetailsValidationExceptionReturnObject().toString());
	}

	
	@Test
	public void equalsContract() {
		EqualsVerifier.simple().forClass(ErrorDetails.class).verify();
	}
	
	
}
