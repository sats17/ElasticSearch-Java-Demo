package com.api.sats.es.exception.handlers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.api.sats.es.exception.ElasticSearchException;
import com.api.sats.es.exception.HeaderValidationException;
import com.api.sats.es.utilites.ApiResponeUtility;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@Autowired
	private ApiResponeUtility apiResponseUtility;
	
	@ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<Object> methodNotSupportedException(HttpRequestMethodNotSupportedException methodNotSupportedException, 
			 HttpServletRequest httpRequest) {
		return apiResponseUtility.requestNotValidException(httpRequest.getMethod(),httpRequest.getRequestURI());
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
