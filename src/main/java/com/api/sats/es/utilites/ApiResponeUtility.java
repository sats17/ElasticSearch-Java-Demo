/**
 * 
 */
package com.api.sats.es.utilites;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.sats.es.model.Restaurant;
import com.api.sats.es.response.FinalResponse;
import com.api.sats.es.response.Status;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import static com.api.sats.es.config.Constants.SUCCESS_ROOT_TYPE;

import java.util.ArrayList;
import java.util.List;

import static com.api.sats.es.config.Constants.SUCCESS_ROOT_CODE;
import static com.api.sats.es.config.Constants.INGEST_RESTAURANT_SUCCESS_MESSAGE;

/**
 * @author satikumb
 *
 */
@Service
public class ApiResponeUtility {
	
	private static final Status INGEST_RESTAURANT_SUCCESS = new Status(SUCCESS_ROOT_CODE, SUCCESS_ROOT_TYPE, 
			INGEST_RESTAURANT_SUCCESS_MESSAGE);

	public ResponseEntity<Object> applicationProcessingException() {
		return null;
	}

	public ResponseEntity<Object> ingestRestaurantSuccessResponse(Restaurant response,String uuid) {
		List<Restaurant> responseList = new ArrayList<>();
		responseList.add(response);
		return new ResponseEntity<Object>(new FinalResponse(INGEST_RESTAURANT_SUCCESS,responseList),getHttpHeaders(uuid), HttpStatus.OK);
	}
	
	private HttpHeaders getHttpHeaders(String uuid) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("sats-uuid", uuid);
		return headers;
		
	}

}
