package com.sats.api.es.exception;

import org.springframework.http.ResponseEntity;

public class InternalServerException extends Exception {

	private static final long serialVersionUID = 4927407264734385953L;
	final transient ResponseEntity<Object> response;
	
	public InternalServerException() {
		super();
		this.response = null;
	}

	public InternalServerException(ResponseEntity<Object> response) {
		this.response = response;
	}
	
	public ResponseEntity<Object> getResponse() {
		return this.response;
	}
	
	
	
}
