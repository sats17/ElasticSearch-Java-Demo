/**
 * 
 */
package com.api.sats.es.data;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.api.sats.es.model.Restaurant;

/**
 * @author satikumb
 *
 */
public interface RestaurantSearchRepository extends ElasticsearchRepository<Restaurant, String> {

	Restaurant findBynationalStoreNumberAndmarketCode(int restaurantId, String marketId);

}
