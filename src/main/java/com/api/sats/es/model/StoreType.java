/**
 * 
 */
package com.api.sats.es.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author satikumb
 *
 */
public class StoreType {
	
	@JsonProperty("storeTypeCode")
	private String storeTypeCode;
	@JsonProperty("partyName")
	private String partyName;
	
	public StoreType(String storeTypeCode, String partyName) {
		super();
		this.storeTypeCode = storeTypeCode;
		this.partyName = partyName;
	}
	public String getStoreTypeCode() {
		return storeTypeCode;
	}
	public void setStoreTypeCode(String storeTypeCode) {
		this.storeTypeCode = storeTypeCode;
	}
	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	@Override
	public String toString() {
		return "StoreType [storeTypeCode=" + storeTypeCode + ", partyName=" + partyName + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((partyName == null) ? 0 : partyName.hashCode());
		result = prime * result + ((storeTypeCode == null) ? 0 : storeTypeCode.hashCode());
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
		StoreType other = (StoreType) obj;
		if (partyName == null) {
			if (other.partyName != null)
				return false;
		} else if (!partyName.equals(other.partyName))
			return false;
		if (storeTypeCode == null) {
			if (other.storeTypeCode != null)
				return false;
		} else if (!storeTypeCode.equals(other.storeTypeCode))
			return false;
		return true;
	}
	 
	 
	
}
