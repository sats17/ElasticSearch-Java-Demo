/**
 * 
 */
package com.api.sats.es.service;

import org.apache.lucene.search.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.sats.es.data.RestaurantSearchRepository;
import com.api.sats.es.model.Restaurant;

/**
 * @author satikumb
 *
 */
@Service
public class RestaurantService {
	
	@Autowired
	private ElasticSearchService esService;

	public ResponseEntity<Object> searchByRestaurantId(int pageSize, String marketId, String uuid, 
			int restaurantId) {
		
		
		return null;
	}

	public Restaurant ingestRestaurant(Restaurant restaurant) {
		
		
		
		return esService.insert(restaurant);
		
	}

}
