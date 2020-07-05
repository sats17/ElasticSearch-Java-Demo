package com.api.sats.es.error.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDetails {

	private int resultCode;
	private String resultType;
	private String resultMessage;
	private String httpMethod;
	private String httpRequestURI;

	public ErrorDetails() {
	}

	public ErrorDetails(int resultCode, String resultType, String resultMessage) {
		super();
		this.resultCode = resultCode;
		this.resultType = resultType;
		this.resultMessage = resultMessage;
	}

	public ErrorDetails(int resultCode, String resultType, String httpMethod, String httpRequestURI,
			String resultMessage) {
		super();
		this.resultCode = resultCode;
		this.resultType = resultType;
		this.httpMethod = httpMethod;
		this.httpRequestURI = httpRequestURI;
		this.resultMessage = resultMessage;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultType() {
		return resultType;
	}

	public void setResultType(String resultType) {
		this.resultType = resultType;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public String getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}

	public String getHttpRequestURI() {
		return httpRequestURI;
	}

	public void setHttpRequestURI(String httpRequestURI) {
		this.httpRequestURI = httpRequestURI;
	}

}
