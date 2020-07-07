/**
 * 
 */
package com.api.sats.es.utilites;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.sats.es.error.response.ErrorDetails;
import com.api.sats.es.error.response.ErrorResponse;
import com.api.sats.es.error.response.ErrorStatus;
import com.api.sats.es.exception.HeaderValidationException;
import com.api.sats.es.model.Restaurant;
import com.api.sats.es.response.FinalResponse;
import com.api.sats.es.response.Status;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import static com.api.sats.es.config.Constants.SUCCESS_ROOT_TYPE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.api.sats.es.config.Constants.*;
//import static com.api.sats.es.config.Constants.INGEST_RESTAURANT_SUCCESS_MESSAGE;

/**
 * @author satikumb
 *
 */
@Service
public class ApiResponeUtility {

	private static final ErrorResponse ElasticSearchExceptionCreator(String Message) {
		return new ErrorResponse(new ErrorStatus(ELASTIC_SEARCH_EXCEPTION_ROOT_CODE, ELASTIC_SEARCH_EXCEPTION_ROOT_TYPE,
				Collections.singletonList(new ErrorDetails(ELASTIC_SEARCH_EXCEPTION_RESULT_CODE,
						ELASTIC_SEARCH_EXCEPTION_RESULT_TYPE, Message))));
	}

	public ResponseEntity<Object> applicationProcessingException(String Message) {
		return new ResponseEntity<Object>(ElasticSearchExceptionCreator(Message), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private static final Status INGEST_RESTAURANT_SUCCESS = new Status(SUCCESS_ROOT_CODE, SUCCESS_ROOT_TYPE,
			INGEST_RESTAURANT_SUCCESS_MESSAGE);

	public ResponseEntity<Object> ingestRestaurantSuccessResponse(Restaurant response, String uuid) {
		List<Restaurant> responseList = new ArrayList<>();
		responseList.add(response);
		return new ResponseEntity<Object>(new FinalResponse(INGEST_RESTAURANT_SUCCESS, responseList),
				getHttpHeaders(uuid), HttpStatus.OK);
	}

	private static final ErrorResponse HeaderValidationExceptionCreator(String Message) {
		return new ErrorResponse(
				new ErrorStatus(HEADER_VALIDATION_EXCEPTION_ROOT_CODE, HEADER_VALIDATION_EXCEPTION_ROOT_TYPE,
						Collections.singletonList(new ErrorDetails(HEADER_VALIDATION_EXCEPTION_RESULT_CODE,
								HEADER_VALIDATION_EXCEPTION_RESULT_TYPE, Message))));
	}

	public ResponseEntity<Object> missingRequestHeaderException(String uuid, String Message) {
		return new ResponseEntity<Object>(HeaderValidationExceptionCreator(Message), getHttpHeaders(uuid),
				HttpStatus.BAD_REQUEST);
	}
	
	private static final ErrorResponse RequestNotValidExceptionCreator(String method, String requestURI) {
		return new ErrorResponse(
				new ErrorStatus(REQUEST_NOT_VALID_EXCEPTION_ROOT_CODE, REQUEST_NOT_VALID_EXCEPTION_ROOT_TYPE, 
						Collections.singletonList(new ErrorDetails(METHOD_NOT_VALID_EXCEPTION_RESULT_CODE,
								METHOD_NOT_VALID_EXCEPTION_RESULT_TYPE,method,requestURI,METHOD_NOT_VALID_EXCEPTION_RESULT_MESSAGE)))); 
				
	}
	
	public ResponseEntity<Object> requestNotValidException(String method, String requestURI) {
		return new ResponseEntity<Object>(RequestNotValidExceptionCreator(method, requestURI),HttpStatus.METHOD_NOT_ALLOWED);
	}

	private HttpHeaders getHttpHeaders(String uuid) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("sats-uuid", uuid);
		return headers;
	}

	

}
