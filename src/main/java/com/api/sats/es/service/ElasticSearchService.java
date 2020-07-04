/**
 * 
 */
package com.api.sats.es.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.sats.es.data.RestaurantSearchRepository;
import com.api.sats.es.exception.ElasticSearchException;
import com.api.sats.es.exception.InternalServerException;
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
	
	public Restaurant insert(Restaurant restaurant) throws ElasticSearchException {
		try {
			return restaurantRepository.save(restaurant);
		} catch (Exception exception) {
			throw new ElasticSearchException(apiResponseUtility.applicationProcessingException());
		} 
	}

}
