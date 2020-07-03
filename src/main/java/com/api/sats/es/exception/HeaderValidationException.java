package com.api.sats.es.exception;

import org.springframework.http.ResponseEntity;

public class HeaderValidationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ResponseEntity<Object> response;

	public HeaderValidationException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HeaderValidationException(ResponseEntity<Object> response) {
		this.response = response;
	}

	public ResponseEntity<Object> getResponse() {
		return response;
	}
	

}
