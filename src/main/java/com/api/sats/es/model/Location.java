/**
 * 
 */
package com.api.sats.es.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author satikumb
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Location {

	@JsonProperty("latitude")
	private Double latitude;
	
	@JsonProperty("longtitude")
	private Double longtitude;
	
	public Location() {}

	public Location(Double latitude, Double longtitude) {
		super();
		this.latitude = latitude;
		this.longtitude = longtitude;
	}

	public Double getLatitude() { 
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(Double longtitude) {
		this.longtitude = longtitude;
	}

	@Override
	public String toString() {
		return "Location [latitude=" + latitude + ", longtitude=" + longtitude + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result + ((longtitude == null) ? 0 : longtitude.hashCode());
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
		Location other = (Location) obj;
		if (latitude == null) {
			if (other.latitude != null)
				return false;
		} else if (!latitude.equals(other.latitude))
			return false;
		if (longtitude == null) {
			if (other.longtitude != null)
				return false;
		} else if (!longtitude.equals(other.longtitude))
			return false;
		return true;
	}
	
	
	
}
