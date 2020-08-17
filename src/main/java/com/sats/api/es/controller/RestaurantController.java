package com.sats.api.es.controller;

import static com.sats.api.es.config.Constants.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sats.api.es.exception.ElasticSearchException;
import com.sats.api.es.exception.RequestValidationException;
import com.sats.api.es.model.Restaurant;
import com.sats.api.es.service.RequestValidationService;
import com.sats.api.es.service.RestaurantService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(BASE_API_PATH)
public class RestaurantController {

	@Autowired
	private RestaurantService restService;

	@Autowired
	private RequestValidationService requestValidationService;
	
//	Logger log = LoggerFactory.getLogger(RestaurantController.class);

	@PostMapping(RESTAURANT_INGEST_PATH)
	public ResponseEntity<Object> ingestRestaurant(
			@RequestHeader(value = MARKET_CODE, required = true) String marketCode,
			@RequestHeader(value = LOCALE, required = true) String locale,
			@RequestHeader(value = UUID, required = true) String uuid, 
			@RequestBody String requestBody) throws RequestValidationException, ElasticSearchException {
		
		log.info("Request recieved for Data INGEST into elasticSearch."
				+ "\n Headers : {} = {}, {} = {}, {} = {} \n Body: {} = {} ",
				MARKET_CODE, marketCode, LOCALE, locale, UUID, uuid, "REQUEST-BODY", requestBody );

		Restaurant restaurant = requestValidationService.validateIngestRestaurantRequest(marketCode, locale, uuid, requestBody);
		log.debug("Converted String Request body to restaurant object = {}",restaurant.toString());
		return restService.ingestRestaurant(marketCode, locale, uuid, restaurant);
	}
}
