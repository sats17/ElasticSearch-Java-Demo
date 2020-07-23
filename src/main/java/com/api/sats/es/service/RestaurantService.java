/**
 * 
 */
package com.api.sats.es.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.sats.es.exception.ElasticSearchException;
import com.api.sats.es.model.Address;
import com.api.sats.es.model.Restaurant;
import com.api.sats.es.model.Test;
import com.api.sats.es.utilites.ApiResponeUtility;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author satikumb
 *
 */
@Service
public class RestaurantService { 
	
	@Autowired
	private ElasticSearchService esService;
	
	@Autowired
	private ApiResponeUtility apiResponseUtility;
	
	private ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	public ResponseEntity<Object> searchByRestaurantId(int pageSize, String marketId, String uuid, 
			int restaurantId) {
		
		return null;
	}

	public ResponseEntity<Object> ingestRestaurant(String marketCode, String locale, String uuid, String body) throws ElasticSearchException, JsonMappingException, JsonProcessingException {
		
		Restaurant restaurant = OBJECT_MAPPER.readValue(body, Restaurant.class);
		restaurant.setMarketCode(marketCode);
		restaurant.setLocalization(locale);
		restaurant.setId(restaurant.getGblNumber()+":"+locale); 
		Restaurant response = esService.insert(restaurant);
		
		return apiResponseUtility.ingestRestaurantSuccessResponse(response, uuid);
	}
	
//	public Test testing(String body) throws JsonMappingException, JsonProcessingException {
//		System.out.println(body);
//		OBJECT_MAPPER.readValue(body, Test.class);
//		return new Test();
//	}
}
