package com.api.sats.es.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.api.sats.es.model.Restaurant;
import com.api.sats.es.service.RestaurantService;

@RestController
public class RestaurantController {

	@Autowired
	private RestaurantService restService;
	
	@PostMapping
	public ResponseEntity<Object> ingestRestaurant(
			@RequestHeader(value = "sats-locale", required = true) String locale,
			@RequestHeader(value = "sats-marketid", required = true) String marketId,
			@RequestHeader(value = "sats-uuid", required = true) String uuid,
			@RequestBody Restaurant restaurant) {
				return restService.ingestRestaurant(marketId,locale,uuid,restaurant);
		
	}
	
}
