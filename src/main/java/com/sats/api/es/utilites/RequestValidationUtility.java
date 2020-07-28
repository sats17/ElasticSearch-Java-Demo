package com.sats.api.es.utilites;

import static com.sats.api.es.config.Constants.LOCALE_EXCEPTION_RESULT_MESSAGE;
import static com.sats.api.es.config.Constants.MARKET_CODE_EXCEPTION_RESULT_MESSAGE;
import static com.sats.api.es.config.Constants.UUID_EXCEPTION_RESULT_MESSAGE;
import static com.sats.api.es.enums.Locales.isLocaleContains;
import static com.sats.api.es.enums.MarketCodes.isMarketCodePresent;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sats.api.es.exception.RequestHeaderValidationException;
import com.sats.api.es.model.Restaurant;

public class RequestValidationUtility {

	private static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	private RequestValidationUtility() {
	}

	public static void validateMarketCode(String marketCode) throws RequestHeaderValidationException {
		if (marketCode == null || marketCode.isBlank() || !isMarketCodePresent(marketCode)) {
			throw new RequestHeaderValidationException(MARKET_CODE_EXCEPTION_RESULT_MESSAGE);
		}
	}

	public static void validateLocale(String locale) throws RequestHeaderValidationException {
		if (locale == null || locale.isBlank() || !isLocaleContains(locale)) {
			throw new RequestHeaderValidationException(LOCALE_EXCEPTION_RESULT_MESSAGE);
		}
	}

	public static void validateUuid(String uuid) throws RequestHeaderValidationException {
		if (uuid == null || uuid.isBlank()) {
			throw new RequestHeaderValidationException(UUID_EXCEPTION_RESULT_MESSAGE);
		}
	}

	public static Restaurant validateRequestBody(String body) throws JsonProcessingException {

		return OBJECT_MAPPER.readValue(body, Restaurant.class);

	}

}
