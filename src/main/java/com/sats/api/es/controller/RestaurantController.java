package com.sats.api.es.controller;

import static com.sats.api.es.config.Constants.BASE_API_PATH;
import static com.sats.api.es.config.Constants.RESTAURANT_INGEST_PATH;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sats.api.es.exception.ElasticSearchException;
import com.sats.api.es.exception.RequestBodyValidationException;
import com.sats.api.es.model.Restaurant;
import com.sats.api.es.service.RequestValidationService;
import com.sats.api.es.service.RestaurantService;

@RestController
@RequestMapping(BASE_API_PATH)
public class RestaurantController {

	@Autowired
	private RestaurantService restService;

	@Autowired
	private RequestValidationService requestValidationService;

	@PostMapping(RESTAURANT_INGEST_PATH)
	public ResponseEntity<Object> ingestRestaurant(
			@RequestHeader(value = "sats-marketid", required = true) String marketCode,
			@RequestHeader(value = "sats-locale", required = true) String locale,
			@RequestHeader(value = "sats-uuid", required = true) String uuid, 
			@RequestBody String body) throws RequestBodyValidationException, ElasticSearchException {

		Restaurant restaurant = requestValidationService.validateIngestRestaurantRequest(marketCode, locale, uuid, body);
		return restService.ingestRestaurant(marketCode, locale, uuid, restaurant);
	}
}
