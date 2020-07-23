package com.api.sats.es.exception.handlers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.api.sats.es.exception.ElasticSearchException;
import com.api.sats.es.exception.HeaderValidationException;
import com.api.sats.es.utilites.ApiResponeUtility;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;

import static com.api.sats.es.config.Constants.*;

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

	@ExceptionHandler(value = HeaderValidationException.class)
	public ResponseEntity<Object> headerValidationException(HeaderValidationException headerValidationException) {
		return headerValidationException.getResponse();
	}

	@ExceptionHandler({ JsonProcessingException.class, JsonMappingException.class })
	public ResponseEntity<Object> inputBodyParseException() {
		return apiResponseUtility.validationExceptionCreator(null, REQUEST_BODY_VALIDATION_EXCEPTION_RESULT_CODE,
				REQUEST_BODY_VALIDATION_EXCEPTION_RESULT_TYPE, REQUEST_BODY_VALIDATION_EXCEPTION_RESULT_MESSAGE, null, null);
	}

}
