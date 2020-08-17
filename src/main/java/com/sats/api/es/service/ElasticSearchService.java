/**
 * 
 */
package com.sats.api.es.service;

import static com.sats.api.es.config.Constants.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.sats.api.es.data.RestaurantSearchRepository;
import com.sats.api.es.exception.ElasticSearchException;
import com.sats.api.es.model.Restaurant;
import com.sats.api.es.utilites.ApiResponeUtility;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Sats17
 *
 */

@Slf4j
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
			log.error("Error occurs while ingesting data into elastic search", exception.getMessage());
			throw new ElasticSearchException(apiResponseUtility.applicationProcessingExceptionCreator(
							ELASTIC_SEARCH_EXCEPTION_RESULT_CODE,
							ELASTIC_SEARCH_EXCEPTION_RESULT_TYPE, ELASTIC_SEARCH_INGEST_EXCEPTION_MESSAGE));
		}
	}

}
