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

import com.sats.api.es.exception.RequestValidationException;
import com.sats.api.es.model.Restaurant;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sats.api.es.service.RequestValidationService;
import com.sats.api.es.utilites.ApiResponeUtility;

import static com.sats.api.es.utilites.test.Utility.RestaruantIngestObject;

@AutoConfigureMockMvc
@SpringBootTest
//@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.WARN)
class HeaderValidationServiceUnitTest {

	@InjectMocks
	private RequestValidationService headerValidationService;
	
	@Mock
	private ApiResponeUtility apiResponseUtility;
	
	ObjectMapper mapper = new ObjectMapper();
	Restaurant restaurant = RestaruantIngestObject();
	
	
	@Test
	public void testValidateIngestRestaurantHeadersSuccess() throws JsonProcessingException {
		String jsonBody = mapper.writeValueAsString(restaurant);
		assertDoesNotThrow(() -> {
			headerValidationService.validateIngestRestaurantRequest("us", "en-US", "123456", jsonBody);
		});
	}
	
	@Test
	public void testVlidateIngestRestaurantHeadersThrowsRequestValidationException() throws JsonProcessingException {
		String jsonBody = mapper.writeValueAsString(restaurant);
		assertThrows(RequestValidationException.class, () -> {
			headerValidationService.validateIngestRestaurantRequest(null, "en-US", "123456", jsonBody);
		});
	}
	
	
}
