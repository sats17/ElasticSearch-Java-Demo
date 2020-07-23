/**
 * 
 */
package com.api.sats.es.model;

import org.springframework.data.elasticsearch.annotations.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author satikumb
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(indexName = "esrestaurants")
public class Restaurant {
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("nationalStoreNumber")
	private Integer nationalStoreNumber;
	
	@JsonProperty("storeIdentifierType")
	private String storeIdentifierType;
	
	@JsonProperty("localization")
	private String 	localization;
	
	@JsonProperty("gblNumber")
	private String gblNumber;
	
	@JsonProperty("countryCode")
	private String countryCode;
	
	@JsonProperty("marketCode")
	private String marketCode;
	
	@JsonProperty("address")
	private Address address;
	
	@JsonProperty("generalStatus")
	private GeneralStatus generalStatus;
	
	@JsonProperty("currentStatus")
	private CurrentStatus currentStatus;
	
	@JsonProperty("location")
	private Location location;
	
	@JsonProperty("storeType")
	private StoreType storeType;
	
	

	public Restaurant(String id, Integer nationalStoreNumber, String storeIdentifierType, String localization,
			String gblNumber, String countryCode, String marketCode, Address address, GeneralStatus generalStatus,
			CurrentStatus currentStatus, Location location, StoreType storeType) {
		super();
		this.id = id;
		this.nationalStoreNumber = nationalStoreNumber;
		this.storeIdentifierType = storeIdentifierType;
		this.localization = localization;
		this.gblNumber = gblNumber;
		this.countryCode = countryCode;
		this.marketCode = marketCode;
		this.address = address;
		this.generalStatus = generalStatus;
		this.currentStatus = currentStatus;
		this.location = location;
		this.storeType = storeType;
	}

	public Restaurant() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getNationalStoreNumber() {
		return nationalStoreNumber;
	}

	public void setNationalStoreNumber(Integer nationalStoreNumber) {
		this.nationalStoreNumber = nationalStoreNumber;
	}

	public String getStoreIdentifierType() {
		return storeIdentifierType;
	}

	public void setStoreIdentifierType(String storeIdentifierType) {
		this.storeIdentifierType = storeIdentifierType;
	}

	public String getLocalization() {
		return localization; 
	}

	public void setLocalization(String localization) {
		this.localization = localization;
	}

	public String getGblNumber() {
		return gblNumber;
	}

	public void setGblNumber(String gblNumber) {
		this.gblNumber = gblNumber;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getMarketCode() {
		return marketCode;
	}

	public void setMarketCode(String marketCode) {
		this.marketCode = marketCode;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public GeneralStatus getGeneralStatus() {
		return generalStatus;
	}

	public void setGeneralStatus(GeneralStatus generalStatus) {
		this.generalStatus = generalStatus;
	}

	public CurrentStatus getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(CurrentStatus currentStatus) {
		this.currentStatus = currentStatus;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public StoreType getStoreType() {
		return storeType;
	}

	public void setStoreType(StoreType storeType) {
		this.storeType = storeType;
	}

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", nationalStoreNumber=" + nationalStoreNumber + ", storeIdentifierType="
				+ storeIdentifierType + ", localization=" + localization + ", gblNumber=" + gblNumber + ", countryCode="
				+ countryCode + ", marketCode=" + marketCode + ", address=" + address + ", generalStatus="
				+ generalStatus + ", currentStatus=" + currentStatus + ", location=" + location + ", storeType="
				+ storeType + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((countryCode == null) ? 0 : countryCode.hashCode());
		result = prime * result + ((currentStatus == null) ? 0 : currentStatus.hashCode());
		result = prime * result + ((gblNumber == null) ? 0 : gblNumber.hashCode());
		result = prime * result + ((generalStatus == null) ? 0 : generalStatus.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((localization == null) ? 0 : localization.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((marketCode == null) ? 0 : marketCode.hashCode());
		result = prime * result + ((nationalStoreNumber == null) ? 0 : nationalStoreNumber.hashCode());
		result = prime * result + ((storeIdentifierType == null) ? 0 : storeIdentifierType.hashCode());
		result = prime * result + ((storeType == null) ? 0 : storeType.hashCode());
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
		Restaurant other = (Restaurant) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (countryCode == null) {
			if (other.countryCode != null)
				return false;
		} else if (!countryCode.equals(other.countryCode))
			return false;
		if (currentStatus == null) {
			if (other.currentStatus != null)
				return false;
		} else if (!currentStatus.equals(other.currentStatus))
			return false;
		if (gblNumber == null) {
			if (other.gblNumber != null)
				return false;
		} else if (!gblNumber.equals(other.gblNumber))
			return false;
		if (generalStatus == null) {
			if (other.generalStatus != null)
				return false;
		} else if (!generalStatus.equals(other.generalStatus))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (localization == null) {
			if (other.localization != null)
				return false;
		} else if (!localization.equals(other.localization))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (marketCode == null) {
			if (other.marketCode != null)
				return false;
		} else if (!marketCode.equals(other.marketCode))
			return false;
		if (nationalStoreNumber == null) {
			if (other.nationalStoreNumber != null)
				return false;
		} else if (!nationalStoreNumber.equals(other.nationalStoreNumber))
			return false;
		if (storeIdentifierType == null) {
			if (other.storeIdentifierType != null)
				return false;
		} else if (!storeIdentifierType.equals(other.storeIdentifierType))
			return false;
		if (storeType == null) {
			if (other.storeType != null)
				return false;
		} else if (!storeType.equals(other.storeType))
			return false;
		return true;
	}
	
	
	
}
