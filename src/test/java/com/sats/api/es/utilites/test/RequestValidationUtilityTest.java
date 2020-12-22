package com.sats.api.es.utilites.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.sats.api.es.exception.RequestHeaderValidationException;
import com.sats.api.es.utilites.RequestValidationUtility;

public class RequestValidationUtilityTest {

	
	@Test
	public void TestCorrectMarketCode() throws RequestHeaderValidationException {
		assertDoesNotThrow(() -> {
			RequestValidationUtility.validateMarketCode("us");
		});
	}
	
	@Test
	public void TestCorrectLocale() throws RequestHeaderValidationException {
		assertDoesNotThrow(() -> {
			RequestValidationUtility.validateLocale("en-US");
		});
	}
	
	@Test
	public void TestCorrectUuid() throws RequestHeaderValidationException {
		assertDoesNotThrow(() -> {
			RequestValidationUtility.validateUuid("12345");
		});
	}

	@Test
	public void TestMarketCodeIsNull() {
		assertThrows(RequestHeaderValidationException.class, () -> {
			RequestValidationUtility.validateMarketCode(null);
		});
	}
	
	@Test
	public void TestMarketCodeIsBlank() {
		assertThrows(RequestHeaderValidationException.class, () -> {
			RequestValidationUtility.validateMarketCode("");
		});
	}
	
	@Test
	public void TestMarketCodeIsWrong() {
		assertThrows(RequestHeaderValidationException.class, () -> {
			RequestValidationUtility.validateMarketCode("MY");
		});
	}
	
	@Test
	public void TestLocaleIsNull() {
		assertThrows(RequestHeaderValidationException.class, () -> {
			RequestValidationUtility.validateLocale(null);
		});
	}
	
	@Test
	public void TestLocaleIsBlank() {
		assertThrows(RequestHeaderValidationException.class, () -> {
			RequestValidationUtility.validateLocale("");
		});
	}
	
	@Test
	public void TestLocaleIsWrong() {
		assertThrows(RequestHeaderValidationException.class, () -> {
			RequestValidationUtility.validateLocale("en-MY");
		});
	}
	
	@Test
	public void TestUuidIsNull() {
		assertThrows(RequestHeaderValidationException.class, () -> {
			RequestValidationUtility.validateUuid(null);
		});
	}
	
	@Test
	public void TestUuidIsBlank() {
		assertThrows(RequestHeaderValidationException.class, () -> {
			RequestValidationUtility.validateUuid("");
		});
	}
	
}
