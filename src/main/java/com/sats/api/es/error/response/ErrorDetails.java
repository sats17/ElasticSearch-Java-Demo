package com.sats.api.es.error.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDetails {

	private int resultCode;
	private String resultType;
	private String resultMessage;
	private String httpMethod;
	private String httpRequestURI;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((httpMethod == null) ? 0 : httpMethod.hashCode());
		result = prime * result + ((httpRequestURI == null) ? 0 : httpRequestURI.hashCode());
		result = prime * result + resultCode;
		result = prime * result + ((resultMessage == null) ? 0 : resultMessage.hashCode());
		result = prime * result + ((resultType == null) ? 0 : resultType.hashCode());
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
		ErrorDetails other = (ErrorDetails) obj;
		if (httpMethod == null) {
			if (other.httpMethod != null)
				return false;
		} else if (!httpMethod.equals(other.httpMethod))
			return false;
		if (httpRequestURI == null) {
			if (other.httpRequestURI != null)
				return false;
		} else if (!httpRequestURI.equals(other.httpRequestURI))
			return false;
		if (resultCode != other.resultCode)
			return false;
		if (resultMessage == null) {
			if (other.resultMessage != null)
				return false;
		} else if (!resultMessage.equals(other.resultMessage))
			return false;
		if (resultType == null) {
			if (other.resultType != null)
				return false;
		} else if (!resultType.equals(other.resultType))
			return false;
		return true;
	}
	
	

}
