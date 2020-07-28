/**
 * 
 */
package com.sats.api.es.model;

import org.springframework.data.elasticsearch.annotations.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author sats17
 *
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
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
	
}
