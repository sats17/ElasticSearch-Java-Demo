package com.sats.api.es.utilites.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sats.api.es.model.Restaurant;
import com.sats.api.es.utilites.ApiResponeUtility;

import static com.sats.api.es.config.Constants.ELASTIC_SEARCH_EXCEPTION_RESULT_CODE;
import static com.sats.api.es.config.Constants.ELASTIC_SEARCH_EXCEPTION_RESULT_TYPE;
import static com.sats.api.es.config.Constants.ELASTIC_SEARCH_INGEST_EXCEPTION_MESSAGE;
import static com.sats.api.es.config.Constants.INGEST_RESTAURANT_SUCCESS_MESSAGE;
import static com.sats.api.es.config.Constants.REQUEST_BODY_VALIDATION_EXCEPTION_RESULT_CODE;
import static com.sats.api.es.config.Constants.REQUEST_BODY_VALIDATION_EXCEPTION_RESULT_MESSAGE;
import static com.sats.api.es.utilites.test.Utility.ErrorStatusServerExceptionReturnObject;
import static com.sats.api.es.utilites.test.Utility.ErrorStatusVALIDATIONExceptionReturnObject;
import static com.sats.api.es.utilites.test.Utility.ErrorResponseReturnObject;
import static com.sats.api.es.utilites.test.Utility.FinalResponseObject;
import static com.sats.api.es.utilites.test.Utility.RestaruantReturnObject;


class ApiResponseUtilityTest {
	
	
	ApiResponeUtility apiResponseUtility = new ApiResponeUtility();
	HttpHeaders headers = new HttpHeaders();
	
	@BeforeEach
	public void setUp() {
		headers.set("sats-uuid", null);
		assertEquals(headers, apiResponseUtility.getHttpHeaders(null));
	}
	
	@Test
	public void getHttpHeaders() {
		
	}
	
	@Test
	public void testApplicationProcessingExceptionCreator() {
		
		ResponseEntity<Object> expectedResponse = new ResponseEntity<>(ErrorResponseReturnObject(ErrorStatusServerExceptionReturnObject()),
				HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseEntity<Object> actualResponse = apiResponseUtility.applicationProcessingExceptionCreator(ELASTIC_SEARCH_EXCEPTION_RESULT_CODE, 
				ELASTIC_SEARCH_EXCEPTION_RESULT_TYPE, ELASTIC_SEARCH_INGEST_EXCEPTION_MESSAGE);
		assertEquals(expectedResponse, actualResponse);
	} 
	
	@Test
	public void testValidationExceptionCreator() {
		
		ResponseEntity<Object> expectedResponse = new ResponseEntity<>(ErrorResponseReturnObject(ErrorStatusVALIDATIONExceptionReturnObject()),
				headers, HttpStatus.BAD_REQUEST);
		
		ResponseEntity<Object> actualResponse = apiResponseUtility.validationExceptionCreator(null, REQUEST_BODY_VALIDATION_EXCEPTION_RESULT_CODE, 
				REQUEST_BODY_VALIDATION_EXCEPTION_RESULT_MESSAGE, REQUEST_BODY_VALIDATION_EXCEPTION_RESULT_MESSAGE, null, null);
	
		assertEquals(expectedResponse, actualResponse);
	} 
	
	@Test
	public void testSuccessResponseCreator() {
		ArrayList<Restaurant> responseList = new ArrayList<>();
		responseList.add(RestaruantReturnObject()); 
		ResponseEntity<Object> expectedResponse = new ResponseEntity<Object>(FinalResponseObject(responseList), headers, HttpStatus.OK);
	
		ResponseEntity<Object> actualResponse = apiResponseUtility.successResponseCreator(RestaruantReturnObject(), INGEST_RESTAURANT_SUCCESS_MESSAGE, 
				null);
		assertEquals(expectedResponse, actualResponse);
	}
	
	
	
}
