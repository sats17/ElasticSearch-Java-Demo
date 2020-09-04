package com.sats.api.es.controller;

import static com.sats.api.es.config.Constants.*;

import java.time.Duration;
import java.time.Instant;
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
import com.sats.api.es.response.FinalResponse;
import com.sats.api.es.service.RequestValidationService;
import com.sats.api.es.service.RestaurantService;

import io.swagger.annotations.ApiOperation;
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
	@ApiOperation(value = "Ingest restaurant into elasticsearch",
				  notes = "Provide an restaurant object to add restaurant into elastic search"
				)
	public ResponseEntity<Object> ingestRestaurant(
			@RequestHeader(value = MARKET_CODE, required = true) String marketCode,
			@RequestHeader(value = LOCALE, required = true) String locale,
			@RequestHeader(value = UUID, required = true) String uuid, 
			@RequestBody String requestBody) throws RequestValidationException, ElasticSearchException {
		Instant start = Instant.now();
		log.info("Ingesting restaurant process starts at {}",start);		
		log.debug("Request recieved for Data INGEST into elasticSearch."
				+ "\n Headers : {} = {}, {} = {}, {} = {} \n Body: {} = {} ",
				MARKET_CODE, marketCode, LOCALE, locale, UUID, uuid, "REQUEST-BODY", requestBody );

		Restaurant restaurant = requestValidationService.validateIngestRestaurantRequest(marketCode, locale, uuid, requestBody);
		
		ResponseEntity<Object> response = restService.ingestRestaurant(marketCode, locale, uuid, restaurant);
		log.debug("Success Response = {}",response);
		
		Instant end = Instant.now();
		Duration timeElapsed = Duration.between(start, end);
		
		log.info("Ingesting restaurant process ends at {}",end);
		log.info("Total time taken by this request inside application is {} milliseconds",timeElapsed.toMillis());
		return response;
	}
}
