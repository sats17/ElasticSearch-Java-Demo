/**
 * 
 */
package com.sats.api.es.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Sats17
 *
*/

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
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

	
}
