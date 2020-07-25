/**
 * 
 */
package com.sats.api.es.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sats.api.es.exception.ElasticSearchException;
import com.sats.api.es.model.Restaurant;
import com.sats.api.es.utilites.ApiResponeUtility;

import static com.sats.api.es.config.Constants.*;

/**
 * @author Sats17
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
		
		return apiResponseUtility.successResponseCreator(response, INGEST_RESTAURANT_SUCCESS_MESSAGE, uuid);
	}
	
}
