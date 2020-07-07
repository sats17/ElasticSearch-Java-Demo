package com.api.sats.es.exception;

import org.springframework.http.ResponseEntity;

public class InternalServerException extends Exception {

	private ResponseEntity<Object> response;
	
	public InternalServerException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InternalServerException(ResponseEntity<Object> response) {
		this.response = response;
		// TODO Auto-generated constructor stub
	}
	
	public ResponseEntity<Object> getResponse() {
		return this.response;
	}
	
	
	
}
