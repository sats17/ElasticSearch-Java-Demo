package com.sats.api.es.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sats.api.es.exception.HeaderValidationException;
import com.sats.api.es.exception.RequestHeaderException;
import com.sats.api.es.utilites.ApiResponeUtility;

import static com.sats.api.es.config.Constants.*;
import static com.sats.api.es.utilites.RequestValidationUtility.validateLocale;
import static com.sats.api.es.utilites.RequestValidationUtility.validateMarketCode;
import static com.sats.api.es.utilites.RequestValidationUtility.validateUuid;

@Service
public class HeaderValidationService {
	
	@Autowired
	private ApiResponeUtility apiResponseUtility;

	public void validateIngestRestaurantHeaders(String marketCode, String locale, String uuid) throws HeaderValidationException {
		try {
			validateMarketCode(marketCode);
			validateUuid(uuid);
			validateLocale(locale);
		} catch (RequestHeaderException exception) {
			throw new HeaderValidationException(apiResponseUtility.validationExceptionCreator(uuid, 
					HEADER_VALIDATION_EXCEPTION_RESULT_CODE, HEADER_VALIDATION_EXCEPTION_RESULT_TYPE,exception.getMessage(),
					null, null));
		}
	}

}
