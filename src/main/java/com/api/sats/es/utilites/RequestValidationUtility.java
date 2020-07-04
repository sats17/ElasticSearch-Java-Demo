package com.api.sats.es.utilites;

import static com.api.sats.es.enums.MarketCodes.isMarketCodePresent;
import static com.api.sats.es.enums.Locales.isLocaleContains;

import static com.api.sats.es.config.Constants.LOCALE_EXCEPTION_RESULT_MESSAGE;
import static com.api.sats.es.config.Constants.UUID_EXCEPTION_RESULT_MESSAGE;
import static com.api.sats.es.config.Constants.MARKET_CODE_EXCEPTION_RESULT_MESSAGE;

import com.api.sats.es.exception.RequestHeaderException;

public class RequestValidationUtility {

	public static void validateMarketCode(String marketCode) throws RequestHeaderException {
		if(marketCode.isBlank() || marketCode == null || !isMarketCodePresent(marketCode)) {
			throw new RequestHeaderException(MARKET_CODE_EXCEPTION_RESULT_MESSAGE);
		}
	}
	
	public static void validateLocale(String locale) throws RequestHeaderException {
		if(locale.isBlank() || locale == null || !isLocaleContains(locale)) {
			throw new RequestHeaderException(LOCALE_EXCEPTION_RESULT_MESSAGE);
		}
	}
	
	public static void validateUuid(String uuid) throws RequestHeaderException {
		if(uuid == null || uuid.isBlank()) {
			throw new RequestHeaderException(UUID_EXCEPTION_RESULT_MESSAGE);
		}
	}
	
}
