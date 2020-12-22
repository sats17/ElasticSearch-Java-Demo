/**
 * 
 */
package com.sats.api.es.data;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.sats.api.es.model.Restaurant;

/**
 * @author Sats17
 *
 */
@Repository
public interface RestaurantSearchRepository extends ElasticsearchRepository<Restaurant, String> {

	Restaurant save(Restaurant restaurant);

}
