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
import com.api.sats.es.utilites.ApiResponeUtility;

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

	public ResponseEntity<Object> searchByRestaurantId(int pageSize, String marketId, String uuid, 
			int restaurantId) {
		
		return null;
	}

	public ResponseEntity<Object> ingestRestaurant(String marketId, String locale, String uuid, Restaurant restaurant) {
		
		restaurant.setMarketCode(marketId);
		restaurant.setLocalization(locale);
		restaurant.setId(restaurant.getGblNumber()+":"+locale);
		Restaurant response = esService.insert(restaurant);
		
		return apiResponseUtility.ingestRestaurantSuccessResponse(response, uuid);
		
	}

}
