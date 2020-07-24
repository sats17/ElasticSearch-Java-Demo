/**
 * 
 */
package com.sats.api.es.utilites;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sats.api.es.error.response.ErrorDetails;
import com.sats.api.es.error.response.ErrorResponse;
import com.sats.api.es.error.response.ErrorStatus;
import com.sats.api.es.model.Restaurant;
import com.sats.api.es.response.FinalResponse;
import com.sats.api.es.response.Status;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import static com.sats.api.es.config.Constants.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Sats17
 *
 */
@Service
public class ApiResponeUtility {

	public ResponseEntity<Object> applicationProcessingExceptionCreator(int resultCode, String resultType, String message) {
		return new ResponseEntity<Object>(
			   new ErrorResponse(new ErrorStatus(SERVER_EXCEPTION_ROOT_CODE, SERVER_EXCEPTION_ROOT_TYPE,
						Collections.singletonList(new ErrorDetails(resultCode, resultType, message, null, null)))),
				HttpStatus.INTERNAL_SERVER_ERROR); 
	}

	public ResponseEntity<Object> validationExceptionCreator(String uuid, int resultCode, String resultType,
			String message, String method, String requestURI) {
		return new ResponseEntity<Object>(
			   new ErrorResponse(new ErrorStatus(VALIDATION_EXCEPTION_ROOT_CODE, VALIDATION_EXCEPTION_ROOT_TYPE,
						Collections.singletonList(new ErrorDetails(resultCode, resultType, message, method, requestURI)))),
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
