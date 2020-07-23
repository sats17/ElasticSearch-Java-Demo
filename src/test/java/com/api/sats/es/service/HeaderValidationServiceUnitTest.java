package com.api.sats.es.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.api.sats.es.utilites.ApiResponeUtility;

@AutoConfigureMockMvc
@SpringBootTest
//@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.WARN)
public class HeaderValidationServiceUnitTest {

	@InjectMocks
	private HeaderValidationService headerValidationService;
	
	@Mock
	private ApiResponeUtility apiResponseUtility;
	
	@Test
	public void test_validateIngestRestaurantHeaders_success() {

		
	}
	
	
}
