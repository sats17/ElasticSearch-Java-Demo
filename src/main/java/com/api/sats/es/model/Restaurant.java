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
	
}
