/**
 * 
 */
package com.sats.api.es.exception;

import org.springframework.http.ResponseEntity;

/**
 * @author Sats17
 *
 */
public class ElasticSearchException extends RuntimeException {

	private static final long serialVersionUID = -1760760238664768333L;
	final transient ResponseEntity<Object> response;
	
	public ElasticSearchException() {
		super();
		this.response = null;
	}

	public ElasticSearchException(ResponseEntity<Object> response) {
		this.response = response;
	}
	
	public ResponseEntity<Object> getResponse() {
		return this.response;
	}

}
