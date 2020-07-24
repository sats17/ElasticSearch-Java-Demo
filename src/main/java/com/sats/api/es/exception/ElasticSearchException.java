/**
 * 
 */
package com.sats.api.es.exception;

import org.springframework.http.ResponseEntity;

/**
 * @author satikumb
 *
 */
public class ElasticSearchException extends Exception {

	private ResponseEntity<Object> response;
	
	public ElasticSearchException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ElasticSearchException(ResponseEntity<Object> response) {
		this.response = response;
		// TODO Auto-generated constructor stub
	}
	
	public ResponseEntity<Object> getResponse() {
		return this.response;
	}

}
