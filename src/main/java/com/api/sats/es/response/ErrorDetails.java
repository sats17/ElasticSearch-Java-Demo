package com.api.sats.es.response;

public class ErrorDetails {
	
	private int resultCode;
	private String resultType;
	private String resultMessage;
	
	public ErrorDetails() {}
	
	public ErrorDetails(int resultCode, String resultType, String resultMessage) {
		super();
		this.resultCode = resultCode;
		this.resultType = resultType;
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
	
	
	
	
	
}
