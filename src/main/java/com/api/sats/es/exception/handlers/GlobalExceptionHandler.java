package com.api.sats.es.exception.handlers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.api.sats.es.exception.ElasticSearchException;
import com.api.sats.es.exception.HeaderValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<Object> methodNotSupportedException(HttpRequestMethodNotSupportedException methodNotSupportedException, WebRequest request) {
		return new ResponseEntity<Object>("Method not supported",HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	@ExceptionHandler(value = ElasticSearchException.class)
	public ResponseEntity<Object> elasticSearchException(ElasticSearchException elasticSearchException) {
		return elasticSearchException.getResponse();
	}
	
	@ExceptionHandler(value = HeaderValidationException.class)
	public ResponseEntity<Object> headerValidationException(HeaderValidationException headerValidationException) {
		return headerValidationException.getResponse();
	}

}
