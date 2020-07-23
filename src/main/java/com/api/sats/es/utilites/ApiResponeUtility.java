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

	public ResponseEntity<Object> applicationProcessingExceptionCreator(int resultCode, String resultType, String Message) {
		return new ResponseEntity<Object>(
			   new ErrorResponse(new ErrorStatus(SERVER_EXCEPTION_ROOT_CODE, SERVER_EXCEPTION_ROOT_TYPE,
						Collections.singletonList(new ErrorDetails(resultCode, resultType, Message)))),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public ResponseEntity<Object> validationExceptionCreator(String uuid, int resultCode, String resultType,
			String Message, String method, String requestURI) {
		return new ResponseEntity<Object>(
			   new ErrorResponse(new ErrorStatus(VALIDATION_EXCEPTION_ROOT_CODE, VALIDATION_EXCEPTION_ROOT_TYPE,
						Collections.singletonList(new ErrorDetails(resultCode, resultType, Message, method, requestURI)))),
				getHttpHeaders(uuid), HttpStatus.BAD_REQUEST);
	}

	private static final Status INGEST_RESTAURANT_SUCCESS = new Status(SUCCESS_ROOT_CODE, SUCCESS_ROOT_TYPE,
			INGEST_RESTAURANT_SUCCESS_MESSAGE);

	public ResponseEntity<Object> ingestRestaurantSuccessResponse(Restaurant response, String uuid) {
		List<Restaurant> responseList = new ArrayList<>();
		responseList.add(response);
		return new ResponseEntity<Object>(new FinalResponse(INGEST_RESTAURANT_SUCCESS, responseList),
				getHttpHeaders(uuid), HttpStatus.OK);
	}

	private HttpHeaders getHttpHeaders(String uuid) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("sats-uuid", uuid);
		return headers;
	}

}
