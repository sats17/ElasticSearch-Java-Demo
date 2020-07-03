package com.api.sats.es.response;

public class ErrorResponse {
	
	private ErrorStatus errorStatus;
	
	public ErrorResponse() {};

	public ErrorResponse(ErrorStatus errorStatus) {
		super();
		this.errorStatus = errorStatus;
	}

	public ErrorStatus getErrorStatus() {
		return errorStatus;
	}

	public void setErrorStatus(ErrorStatus errorStatus) {
		this.errorStatus = errorStatus;
	}
	
}
