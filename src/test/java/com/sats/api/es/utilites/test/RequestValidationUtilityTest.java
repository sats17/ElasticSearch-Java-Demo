package com.sats.api.es.utilites.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.sats.api.es.exception.RequestHeaderException;
import com.sats.api.es.utilites.RequestValidationUtility;

public class RequestValidationUtilityTest {

	
	@Test
	public void TestCorrectMarketCode() throws RequestHeaderException {
		assertDoesNotThrow(() -> {
			RequestValidationUtility.validateMarketCode("us");
		});
	}
	
	@Test
	public void TestCorrectLocale() throws RequestHeaderException {
		assertDoesNotThrow(() -> {
			RequestValidationUtility.validateLocale("en-US");
		});
	}
	
	@Test
	public void TestCorrectUuid() throws RequestHeaderException {
		assertDoesNotThrow(() -> {
			RequestValidationUtility.validateUuid("12345");
		});
	}

	@Test
	public void TestMarketCodeIsNull() {
		assertThrows(RequestHeaderException.class, () -> {
			RequestValidationUtility.validateMarketCode(null);
		});
	}
	
	@Test
	public void TestMarketCodeIsBlank() {
		assertThrows(RequestHeaderException.class, () -> {
			RequestValidationUtility.validateMarketCode("");
		});
	}
	
	@Test
	public void TestMarketCodeIsWrong() {
		assertThrows(RequestHeaderException.class, () -> {
			RequestValidationUtility.validateMarketCode("MY");
		});
	}
	
	@Test
	public void TestLocaleIsNull() {
		assertThrows(RequestHeaderException.class, () -> {
			RequestValidationUtility.validateLocale(null);
		});
	}
	
	@Test
	public void TestLocaleIsBlank() {
		assertThrows(RequestHeaderException.class, () -> {
			RequestValidationUtility.validateLocale("");
		});
	}
	
	@Test
	public void TestLocaleIsWrong() {
		assertThrows(RequestHeaderException.class, () -> {
			RequestValidationUtility.validateLocale("en-MY");
		});
	}
	
	@Test
	public void TestUuidIsNull() {
		assertThrows(RequestHeaderException.class, () -> {
			RequestValidationUtility.validateUuid(null);
		});
	}
	
	@Test
	public void TestUuidIsBlank() {
		assertThrows(RequestHeaderException.class, () -> {
			RequestValidationUtility.validateUuid("");
		});
	}
	
}
