package com.sats.api.es.response;

import java.util.List;
import com.sats.api.es.model.Restaurant;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class FinalResponse {
	
	private Status status;
	private List<Restaurant> restaurnts;
	
}
