package com.api.sats.es.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.sats.es.model.Restaurant;
import com.api.sats.es.service.HeaderValidationService;
import com.api.sats.es.service.RestaurantService;

import static com.api.sats.es.config.Constants.BASE_API_PATH;
import static com.api.sats.es.config.Constants.RESTAURANT_INGEST_PATH;

@RestController
@RequestMapping(BASE_API_PATH)
public class RestaurantController {

	@Autowired
	private RestaurantService restService;

	@Autowired
	private HeaderValidationService headerValidationService;

	@PostMapping(RESTAURANT_INGEST_PATH)
	public ResponseEntity<Object> ingestRestaurant(
			@RequestHeader(value = "sats-marketid", required = true) String marketCode,
			@RequestHeader(value = "sats-locale", required = true) String locale,
			@RequestHeader(value = "sats-uuid", required = true) String uuid,
			@RequestBody String body) throws Exception { 
		System.out.println(body);
		headerValidationService.validateIngestRestaurantHeaders(marketCode, locale, uuid);
		return restService.ingestRestaurant(marketCode, locale, uuid, body);
	} 

}
