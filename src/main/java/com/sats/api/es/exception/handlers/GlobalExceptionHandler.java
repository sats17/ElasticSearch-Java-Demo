package com.sats.api.es.exception.handlers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.sats.api.es.exception.ElasticSearchException;
import com.sats.api.es.exception.RequestValidationException;
import com.sats.api.es.utilites.ApiResponeUtility;

import lombok.extern.slf4j.Slf4j;

import static com.sats.api.es.config.Constants.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

	@Autowired
	private ApiResponeUtility apiResponseUtility;

	@ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<Object> methodNotSupportedException(
			HttpRequestMethodNotSupportedException methodNotSupportedException, HttpServletRequest httpRequest) {
		ResponseEntity<Object> errorResponse =  apiResponseUtility.validationExceptionCreator(null, METHOD_NOT_VALID_EXCEPTION_RESULT_CODE,
				METHOD_NOT_VALID_EXCEPTION_RESULT_TYPE, METHOD_NOT_VALID_EXCEPTION_RESULT_MESSAGE,
				httpRequest.getMethod(), httpRequest.getRequestURI());
	
		return errorResponse;
	}

	@ExceptionHandler(value = ElasticSearchException.class)
	public ResponseEntity<Object> elasticSearchException(ElasticSearchException elasticSearchException) {
		ResponseEntity<Object> errorResponse =  elasticSearchException.getResponse();
		return errorResponse;
	}

	@ExceptionHandler(value = RequestValidationException.class)
	public ResponseEntity<Object> headerValidationException(RequestValidationException headerValidationException) {
		ResponseEntity<Object> errorResponse = headerValidationException.getResponse();
		return errorResponse;
	}

	@ExceptionHandler({ JsonProcessingException.class, JsonMappingException.class })
	public ResponseEntity<Object> inputBodyParseException() {
		ResponseEntity<Object> errorResponse =  apiResponseUtility.validationExceptionCreator(null, REQUEST_BODY_VALIDATION_EXCEPTION_RESULT_CODE,
				REQUEST_BODY_VALIDATION_EXCEPTION_RESULT_TYPE, REQUEST_BODY_VALIDATION_EXCEPTION_RESULT_MESSAGE, null, null);
		return errorResponse;
	}

}
