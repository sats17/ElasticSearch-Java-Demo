/**
 * 
 */
package com.api.sats.es.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author satikumb
 *
 */
public class Address {
	
	@JsonProperty("country")
	private String country;
	
	@JsonProperty("stateProvince")
	private String stateProvince;
	
	@JsonProperty("postalZip")
	private Integer postalZip;
	
	@JsonProperty("cityTown")
	private String cityTown;
	
	@JsonProperty("addressLine")
	private String addressLine;
	
	@JsonProperty("region")
	private String region;
	

	public Address(String country, String stateProvince, Integer postalZip, String cityTown, String addressLine,
			String region) {
		super();
		this.country = country;
		this.stateProvince = stateProvince;
		this.postalZip = postalZip;
		this.cityTown = cityTown;
		this.addressLine = addressLine;
		this.region = region;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStateProvince() {
		return stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	public Integer getPostalZip() {
		return postalZip;
	}

	public void setPostalZip(Integer postalZip) {
		this.postalZip = postalZip;
	}

	public String getCityTown() {
		return cityTown;
	}

	public void setCityTown(String cityTown) {
		this.cityTown = cityTown;
	}

	public String getAddressLine() {
		return addressLine;
	}

	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	

	@Override
	public String toString() {
		return "Address [country=" + country + ", stateProvince=" + stateProvince + ", postalZip=" + postalZip
				+ ", cityTown=" + cityTown + ", addressLine=" + addressLine + ", region=" + region + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressLine == null) ? 0 : addressLine.hashCode());
		result = prime * result + ((cityTown == null) ? 0 : cityTown.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((postalZip == null) ? 0 : postalZip.hashCode());
		result = prime * result + ((region == null) ? 0 : region.hashCode());
		result = prime * result + ((stateProvince == null) ? 0 : stateProvince.hashCode());
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
		Address other = (Address) obj;
		if (addressLine == null) {
			if (other.addressLine != null)
				return false;
		} else if (!addressLine.equals(other.addressLine))
			return false;
		if (cityTown == null) {
			if (other.cityTown != null)
				return false;
		} else if (!cityTown.equals(other.cityTown))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (postalZip == null) {
			if (other.postalZip != null)
				return false;
		} else if (!postalZip.equals(other.postalZip))
			return false;
		if (region == null) {
			if (other.region != null)
				return false;
		} else if (!region.equals(other.region))
			return false;
		if (stateProvince == null) {
			if (other.stateProvince != null)
				return false;
		} else if (!stateProvince.equals(other.stateProvince))
			return false;
		return true;
	}
	
	
	
	
}
