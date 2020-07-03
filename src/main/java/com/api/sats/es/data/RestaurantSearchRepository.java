/**
 * 
 */
package com.api.sats.es.data;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.api.sats.es.model.Restaurant;

/**
 * @author satikumb
 *
 */

public interface RestaurantSearchRepository extends ElasticsearchRepository<Restaurant, String> {


}
