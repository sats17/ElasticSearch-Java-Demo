package com.api.sats.es.utilites;

import static com.api.sats.es.enums.MarketCodes.isMarketCodePresent;
import static com.api.sats.es.enums.Locales.isLocaleContains;

import com.api.sats.es.exception.RequestHeaderException;

public class RequestValidationUtility {

	public static void validateMarketCode(String marketCode) throws RequestHeaderException {
		if(marketCode.isEmpty() || marketCode == null || !isMarketCodePresent(marketCode)) {
			throw new RequestHeaderException();
		}
	}
	
	public static void validateLocale(String locale) throws RequestHeaderException {
		if(locale.isEmpty() || locale == null || !isLocaleContains(locale)) {
			throw new RequestHeaderException();
		}
	}
	
	public static void validateUuid(String uuid) throws RequestHeaderException {
		if(uuid == null) {
			throw new RequestHeaderException();
		}
	}
	
}
