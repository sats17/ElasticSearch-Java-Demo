package com.sats.api.es.error.response.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.sats.api.es.error.response.ErrorStatus;

import static com.sats.api.es.utilites.test.Utility.ErrorStatusVALIDATIONExceptionReturnObject;

import nl.jqno.equalsverifier.EqualsVerifier;

public class ErrorStatusTest {

	@Test
	public void testToString() {
		ErrorStatus status = ErrorStatusVALIDATIONExceptionReturnObject();
		String expected = "ErrorStatus(rootCode=40000, rootType=ValidationException, errorList=[ErrorDetails(resultCode=40002, resultType=Please check given request body, it's format is incorrect, resultMessage=Please check given request body, it's format is incorrect, httpMethod=null, httpRequestURI=null)])";
		assertEquals(expected, status.toString());
		
	}
	
	@Test
	public void testEqualsAndHashCode() {
		EqualsVerifier.simple().forClass(ErrorStatus.class).verify();
	}
	
}
