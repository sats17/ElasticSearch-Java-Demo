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

import lombok.extern.slf4j.Slf4j;

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

@Slf4j
@Service
public class ApiResponeUtility {

	public ResponseEntity<Object> applicationProcessingExceptionCreator(int resultCode, String resultType, String message) {
		ResponseEntity<Object> errorResponse = new ResponseEntity<Object>(
			   new ErrorResponse(new ErrorStatus(SERVER_EXCEPTION_ROOT_CODE, SERVER_EXCEPTION_ROOT_TYPE,
						Collections.singletonList(new ErrorDetails(resultCode, resultType, message, null, null)))),
				HttpStatus.INTERNAL_SERVER_ERROR);
		log.debug("Respose from applicationProcessingExceptionCreator method, after internal server error occurs {} = ",
				errorResponse.toString()); 
		return errorResponse;
	}

	public ResponseEntity<Object> validationExceptionCreator(String uuid, int resultCode, String resultType,
			String message, String method, String requestURI) {
		ResponseEntity<Object> errorResponse = new ResponseEntity<Object>(
			   new ErrorResponse(new ErrorStatus(VALIDATION_EXCEPTION_ROOT_CODE, VALIDATION_EXCEPTION_ROOT_TYPE,
						Collections.singletonList(new ErrorDetails(resultCode, resultType, message, method, requestURI)))),
				getHttpHeaders(uuid), HttpStatus.BAD_REQUEST);
		log.debug("Respose from validationExceptionCreator method, after validation error occurs {} = ",
				errorResponse.toString());
		return errorResponse;
	} 
	
	public ResponseEntity<Object> successResponseCreator(Restaurant response, String message, String uuid) {
		List<Restaurant> responseList = new ArrayList<>();
		responseList.add(response);
		Status status = new Status(SUCCESS_ROOT_CODE, SUCCESS_ROOT_TYPE, message);
		String UUID = uuid;
		ResponseEntity<Object> successResponse = new ResponseEntity<Object>(
			   new FinalResponse(status, responseList),
			   getHttpHeaders(UUID), HttpStatus.OK);
		log.debug("Respose from successResponseCreator method, after ingesting restaurant in elasticSearch {} = ",
				successResponse.toString());
		return successResponse;
	}

	public HttpHeaders getHttpHeaders(String uuid) {
		HttpHeaders headers = new HttpHeaders(); 
		headers.set("sats-uuid", uuid);
		return headers;
	}

}
