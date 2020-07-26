package com.sats.api.es.exception;

import org.springframework.http.ResponseEntity;

public class HeaderValidationException extends Exception {

	private static final long serialVersionUID = -2936997613994069788L;
	final transient ResponseEntity<Object> response;

	public HeaderValidationException() {
		super();
		this.response = null;
	}

	public HeaderValidationException(ResponseEntity<Object> response) {
		this.response = response;
	}

	public ResponseEntity<Object> getInfo() {
		return response;
	}
	

}
