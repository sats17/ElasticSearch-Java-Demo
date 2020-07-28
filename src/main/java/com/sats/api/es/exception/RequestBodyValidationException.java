package com.sats.api.es.exception;

import org.springframework.http.ResponseEntity;

public class RequestBodyValidationException extends Exception {

	private static final long serialVersionUID = -2936997613994069788L;
	final transient ResponseEntity<Object> response;

	public RequestBodyValidationException() {
		super();
		this.response = null;
	}

	public RequestBodyValidationException(ResponseEntity<Object> response) {
		this.response = response;
	}

	public ResponseEntity<Object> getInfo() {
		return response;
	}
	

}
