/**
 * 
 */
package com.api.sats.es.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.sats.es.exception.ElasticSearchException;
import com.api.sats.es.model.Restaurant;
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
	
	private ObjectMapper OBJECT_MAPPER;

	public ResponseEntity<Object> searchByRestaurantId(int pageSize, String marketId, String uuid, 
			int restaurantId) {
		
		return null;
	}

	public ResponseEntity<Object> ingestRestaurant(String marketCode, String locale, String uuid, String body) throws ElasticSearchException {
		
		Restaurant restaurant = null;
		try {
			System.out.println("Before ");
			restaurant = OBJECT_MAPPER.readValue(body, Restaurant.class);
			System.out.println("After");
		} catch (JsonMappingException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		restaurant.setMarketCode(marketCode);
		restaurant.setLocalization(locale);
		restaurant.setId(restaurant.getGblNumber()+":"+locale); 
		System.out.println(restaurant);
		Restaurant response = esService.insert(restaurant);
		System.out.println(response);
		
		return apiResponseUtility.ingestRestaurantSuccessResponse(response, uuid);
	}

}
