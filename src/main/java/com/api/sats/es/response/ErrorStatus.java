package com.api.sats.es.response;

import java.util.List;

public class ErrorStatus {
		
	private int rootCode;
	private String rootType;
	private List<ErrorDetails> errorList;
	
	public ErrorStatus() {}
	
	public ErrorStatus(int rootCode, String rootType, List<ErrorDetails> errorList) {
		super();
		this.rootCode = rootCode;
		this.rootType = rootType;
		this.errorList = errorList;
	}

	public int getRootCode() {
		return rootCode;
	}

	public void setRootCode(int rootCode) {
		this.rootCode = rootCode;
	}

	public String getRootType() {
		return rootType;
	}

	public void setRootType(String rootType) {
		this.rootType = rootType;
	}

	public List<ErrorDetails> getErrorList() {
		return errorList;
	}

	public void setErrorList(List<ErrorDetails> errorList) {
		this.errorList = errorList;
	}

	@Override
	public String toString() {
		return "ErrorStatus [rootCode=" + rootCode + ", rootType=" + rootType + ", errorList=" + errorList + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((errorList == null) ? 0 : errorList.hashCode());
		result = prime * result + rootCode;
		result = prime * result + ((rootType == null) ? 0 : rootType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ErrorStatus other = (ErrorStatus) obj;
		if (errorList == null) {
			if (other.errorList != null)
				return false;
		} else if (!errorList.equals(other.errorList))
			return false;
		if (rootCode != other.rootCode)
			return false;
		if (rootType == null) {
			if (other.rootType != null)
				return false;
		} else if (!rootType.equals(other.rootType))
			return false;
		return true;
	}
	
	
	
	
	
	
}
