package com.api.sats.es.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.sats.es.exception.HeaderValidationException;
import com.api.sats.es.exception.RequestHeaderException;
import com.api.sats.es.utilites.ApiResponeUtility;

import static com.api.sats.es.utilites.RequestValidationUtility.validateMarketCode;
import static com.api.sats.es.utilites.RequestValidationUtility.validateLocale;
import static com.api.sats.es.utilites.RequestValidationUtility.validateUuid;
import static com.api.sats.es.config.Constants.*;

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
