package com.sats.api.es.utilites;

import static com.sats.api.es.config.Constants.LOCALE_EXCEPTION_RESULT_MESSAGE;
import static com.sats.api.es.config.Constants.MARKET_CODE_EXCEPTION_RESULT_MESSAGE;
import static com.sats.api.es.config.Constants.UUID_EXCEPTION_RESULT_MESSAGE;
import static com.sats.api.es.enums.Locales.isLocaleContains;
import static com.sats.api.es.enums.MarketCodes.isMarketCodePresent;

import com.sats.api.es.exception.RequestHeaderException;

public class RequestValidationUtility {

	private RequestValidationUtility() {}
	
	public static void validateMarketCode(String marketCode) throws RequestHeaderException {
		if(marketCode == null || marketCode.isBlank() || !isMarketCodePresent(marketCode)) {
			throw new RequestHeaderException(MARKET_CODE_EXCEPTION_RESULT_MESSAGE);
		} 
	} 
	
	public static void validateLocale(String locale) throws RequestHeaderException {
		if(locale == null || locale.isBlank() || !isLocaleContains(locale)) {
			throw new RequestHeaderException(LOCALE_EXCEPTION_RESULT_MESSAGE);
		} 
	}
	
	public static void validateUuid(String uuid) throws RequestHeaderException {
		if(uuid == null || uuid.isBlank()) {
			throw new RequestHeaderException(UUID_EXCEPTION_RESULT_MESSAGE);
		}
	}
	
}
