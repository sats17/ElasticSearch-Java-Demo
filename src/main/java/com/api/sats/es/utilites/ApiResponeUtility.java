/**
 * 
 */
package com.api.sats.es.utilites;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.sats.es.model.Restaurant;
import com.api.sats.es.response.ErrorDetails;
import com.api.sats.es.response.ErrorResponse;
import com.api.sats.es.response.ErrorStatus;
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
	
	private static final ErrorResponse ELASTIC_SEARCH_EXCEPTION = new ErrorResponse( 
			new ErrorStatus(ELASTIC_SEARCH_EXCEPTION_ROOT_CODE, ELASTIC_SEARCH_EXCEPTION_ROOT_TYPE,
					Collections.singletonList(new ErrorDetails(ELASTIC_SEARCH_EXCEPTION_RESULT_CODE,
							ELASTIC_SEARCH_EXCEPTION_RESULT_TYPE, ELASTIC_SEARCH_EXCEPTION_MESSAGE))));
	
	public ResponseEntity<Object> applicationProcessingException() {
		return new ResponseEntity<Object>(ELASTIC_SEARCH_EXCEPTION,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	private static final Status INGEST_RESTAURANT_SUCCESS = new Status(SUCCESS_ROOT_CODE, SUCCESS_ROOT_TYPE, 
			INGEST_RESTAURANT_SUCCESS_MESSAGE);


	public ResponseEntity<Object> ingestRestaurantSuccessResponse(Restaurant response,String uuid) {
		List<Restaurant> responseList = new ArrayList<>(); 
		responseList.add(response);
		return new ResponseEntity<Object>(new FinalResponse(INGEST_RESTAURANT_SUCCESS,responseList),getHttpHeaders(uuid), HttpStatus.OK);
	}
	
	private static final ErrorResponse HEADER_VALIDATION_EXCEPTION = new ErrorResponse(
			new ErrorStatus(HEADER_VALIDATION_EXCEPTION_ROOT_CODE, HEADER_VALIDATION_EXCEPTION_ROOT_TYPE,
					Collections.singletonList(new ErrorDetails(HEADER_VALIDATION_EXCEPTION_RESULT_CODE,
							HEADER_VALIDATION_EXCEPTION_RESULT_TYPE, HEADER_VALIDATION_EXCEPTION_RESULT_MESSAGE))));

	public ResponseEntity<Object> missingRequestHeaderException(String uuid) {
		return new ResponseEntity<Object>(HEADER_VALIDATION_EXCEPTION,getHttpHeaders(uuid),
				HttpStatus.BAD_REQUEST);
	}
	
	private HttpHeaders getHttpHeaders(String uuid) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("sats-uuid", uuid);
		return headers;
	}

}
