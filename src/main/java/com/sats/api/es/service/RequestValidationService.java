package com.sats.api.es.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sats.api.es.exception.RequestValidationException;
import com.sats.api.es.model.Restaurant;
import com.sats.api.es.exception.RequestHeaderValidationException;
import com.sats.api.es.utilites.ApiResponeUtility;

import static com.sats.api.es.config.Constants.*;
import static com.sats.api.es.utilites.RequestValidationUtility.validateLocale;
import static com.sats.api.es.utilites.RequestValidationUtility.validateMarketCode;
import static com.sats.api.es.utilites.RequestValidationUtility.validateUuid;
import static com.sats.api.es.utilites.RequestValidationUtility.validateRequestBody;

@Service
public class RequestValidationService {
	
	@Autowired
	private ApiResponeUtility apiResponseUtility;

	public Restaurant validateIngestRestaurantRequest(String marketCode, String locale, String uuid, String body) 
			throws RequestValidationException {
		try {
			validateMarketCode(marketCode);
			validateUuid(uuid);
			validateLocale(locale);
			return validateRequestBody(body);
		} catch (RequestHeaderValidationException exception) {
			throw new RequestValidationException(apiResponseUtility.validationExceptionCreator(uuid, 
					HEADER_VALIDATION_EXCEPTION_RESULT_CODE, HEADER_VALIDATION_EXCEPTION_RESULT_TYPE,exception.getMessage(),
					null, null));
		} catch (JsonProcessingException exception) {
			throw new RequestValidationException(apiResponseUtility.validationExceptionCreator(uuid, 
					REQUEST_BODY_VALIDATION_EXCEPTION_RESULT_CODE, REQUEST_BODY_VALIDATION_EXCEPTION_RESULT_TYPE, 
					REQUEST_BODY_VALIDATION_EXCEPTION_RESULT_MESSAGE, null, null));
		}
	}

}
