package com.sats.api.es.utilites;

import static com.sats.api.es.config.Constants.LOCALE_EXCEPTION_RESULT_MESSAGE;
import static com.sats.api.es.config.Constants.MARKET_CODE_EXCEPTION_RESULT_MESSAGE;
import static com.sats.api.es.config.Constants.UUID_EXCEPTION_RESULT_MESSAGE;
import static com.sats.api.es.enums.Locales.isLocaleContains;
import static com.sats.api.es.enums.MarketCodes.isMarketCodePresent;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sats.api.es.exception.RequestHeaderValidationException;
import com.sats.api.es.model.Restaurant;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RequestValidationUtility {

	private static ObjectMapper mapper = new ObjectMapper();

	private RequestValidationUtility() {
	}

	public static void validateMarketCode(String marketCode) throws RequestHeaderValidationException {
		if (marketCode == null || marketCode.isBlank() || !isMarketCodePresent(marketCode)) {
			log.debug("Market Code {} is not valid",marketCode);
			throw new RequestHeaderValidationException(MARKET_CODE_EXCEPTION_RESULT_MESSAGE);
		}
	}

	public static void validateLocale(String locale) throws RequestHeaderValidationException {
		if (locale == null || locale.isBlank() || !isLocaleContains(locale)) {
			log.debug("Locale {} is not valid", locale);
			throw new RequestHeaderValidationException(LOCALE_EXCEPTION_RESULT_MESSAGE);
		}
	}

	public static void validateUuid(String uuid) throws RequestHeaderValidationException {
		if (uuid == null || uuid.isBlank()) {
			log.debug("UUID {} is not valid", uuid);
			throw new RequestHeaderValidationException(UUID_EXCEPTION_RESULT_MESSAGE);
		}
	}

	public static Restaurant validateRequestBody(String body) throws JsonProcessingException {
		return mapper.readValue(body, Restaurant.class);
	}

}
