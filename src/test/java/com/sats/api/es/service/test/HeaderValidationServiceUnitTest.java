package com.sats.api.es.service.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.sats.api.es.exception.HeaderValidationException;
import com.sats.api.es.exception.RequestHeaderException;
import com.sats.api.es.service.HeaderValidationService;
import com.sats.api.es.utilites.ApiResponeUtility;
import com.sats.api.es.utilites.RequestValidationUtility;

@AutoConfigureMockMvc
@SpringBootTest
//@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.WARN)
class HeaderValidationServiceUnitTest {

	@InjectMocks
	private HeaderValidationService headerValidationService;
	
	@Mock
	private ApiResponeUtility apiResponseUtility;
	
	@Test
	public void testValidateIngestRestaurantHeadersSuccess() {
		assertDoesNotThrow(() -> {
			headerValidationService.validateIngestRestaurantHeaders("us", "en-US", "123456");
		});
	}
	
	@Test
	public void testVlidateIngestRestaurantHeadersThrowsRequestValidationException() {
		assertThrows(HeaderValidationException.class, () -> {
			headerValidationService.validateIngestRestaurantHeaders(null, "en-US", "123456");
		});
	}
	
	
}
