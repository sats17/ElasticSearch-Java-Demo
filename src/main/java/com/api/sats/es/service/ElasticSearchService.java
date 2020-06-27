/**
 * 
 */
package com.api.sats.es.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.sats.es.data.RestaurantSearchRepository;
import com.api.sats.es.exception.ElasticSearchException;
import com.api.sats.es.model.Restaurant;
import com.api.sats.es.utilites.ApiResponeUtility;

/**
 * @author satikumb
 *
 */
@Service
public class ElasticSearchService {

	@Autowired
	private RestaurantSearchRepository restaurantRepository;
	
	@Autowired
	private ApiResponeUtility apiResponseUtility;
	
	public Restaurant insert(Restaurant restaurant) {
		Restaurant response;
		try {
			response = restaurantRepository.save(restaurant);
		} catch (Exception exception) {
			return null;
		}
		if(response == null) {
			return null;
		} else {
			return response;
		}
	}

}
