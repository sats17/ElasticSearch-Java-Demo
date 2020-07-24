package com.sats.api.es.response;

import java.util.List;

import com.sats.api.es.model.Restaurant;

public class FinalResponse {
	
	private Status status;
	private List<Restaurant> restaurnts;
	
	public FinalResponse() {}
	
	public FinalResponse(Status status, List<Restaurant> restaurnts) {
		super();
		this.status = status;
		this.restaurnts = restaurnts;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public List<Restaurant> getRestaurnts() {
		return restaurnts;
	}
	public void setRestaurnts(List<Restaurant> restaurnts) {
		this.restaurnts = restaurnts;
	}
	@Override
	public String toString() {
		return "FinalResponse [status=" + status + ", restaurnts=" + restaurnts + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((restaurnts == null) ? 0 : restaurnts.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		FinalResponse other = (FinalResponse) obj;
		if (restaurnts == null) {
			if (other.restaurnts != null)
				return false;
		} else if (!restaurnts.equals(other.restaurnts))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	
	
	
}
