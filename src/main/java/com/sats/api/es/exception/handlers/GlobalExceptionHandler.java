package com.sats.api.es.exception.handlers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.sats.api.es.exception.ElasticSearchException;
import com.sats.api.es.exception.RequestBodyValidationException;
import com.sats.api.es.utilites.ApiResponeUtility;

import static com.sats.api.es.config.Constants.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@Autowired
	private ApiResponeUtility apiResponseUtility;

	@ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<Object> methodNotSupportedException(
			HttpRequestMethodNotSupportedException methodNotSupportedException, HttpServletRequest httpRequest) {
		return apiResponseUtility.validationExceptionCreator(null, METHOD_NOT_VALID_EXCEPTION_RESULT_CODE,
				METHOD_NOT_VALID_EXCEPTION_RESULT_TYPE, METHOD_NOT_VALID_EXCEPTION_RESULT_MESSAGE,
				httpRequest.getMethod(), httpRequest.getRequestURI());
	}

	@ExceptionHandler(value = ElasticSearchException.class)
	public ResponseEntity<Object> elasticSearchException(ElasticSearchException elasticSearchException) {
		return elasticSearchException.getResponse();
	}

	@ExceptionHandler(value = RequestBodyValidationException.class)
	public ResponseEntity<Object> headerValidationException(RequestBodyValidationException headerValidationException) {
		return headerValidationException.getInfo();
	}

	@ExceptionHandler({ JsonProcessingException.class, JsonMappingException.class })
	public ResponseEntity<Object> inputBodyParseException() {
		return apiResponseUtility.validationExceptionCreator(null, REQUEST_BODY_VALIDATION_EXCEPTION_RESULT_CODE,
				REQUEST_BODY_VALIDATION_EXCEPTION_RESULT_TYPE, REQUEST_BODY_VALIDATION_EXCEPTION_RESULT_MESSAGE, null, null);
	}

}
