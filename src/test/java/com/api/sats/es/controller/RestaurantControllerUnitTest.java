package com.api.sats.es.controller;

import static com.api.sats.es.config.Constants.INGEST_RESTAURANT_SUCCESS_MESSAGE;
import static com.api.sats.es.config.Constants.SUCCESS_ROOT_CODE;
import static com.api.sats.es.config.Constants.SUCCESS_ROOT_TYPE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.assertj.ApplicationContextAssert;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.NestedServletException;

import com.api.sats.es.data.RestaurantSearchRepository;
import com.api.sats.es.exception.ElasticSearchException;
import com.api.sats.es.exception.HeaderValidationException;
import com.api.sats.es.model.Address;
import com.api.sats.es.model.CurrentStatus;
import com.api.sats.es.model.GeneralStatus;
import com.api.sats.es.model.Location;
import com.api.sats.es.model.Restaurant;
import com.api.sats.es.model.StoreType;
import com.api.sats.es.response.Status;
import com.api.sats.es.service.ElasticSearchService;
import com.api.sats.es.service.HeaderValidationService;
import com.api.sats.es.service.RestaurantService;
import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@SpringBootTest
//@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.WARN)
class RestaurantControllerUnitTest {
	
	@Autowired
	ApplicationContext context;

	@Mock
	private RestaurantService restService;

	@Autowired
	private WebApplicationContext wac;

	@Mock
	private ElasticSearchService esService;

	@InjectMocks
	private RestaurantController restController;

	@Mock
	private HeaderValidationService headerValidationService;

	@Mock
	private RestaurantSearchRepository restSearchRepo;

	MockHttpServletResponse expectedResponse = new MockHttpServletResponse();

	private static final String marketCode = "US";
	private static final String locale = "en-US";
	private static final String uuid = "12345";
	private static final Status INGEST_RESTAURANT_SUCCESS = new Status(SUCCESS_ROOT_CODE, SUCCESS_ROOT_TYPE,
			INGEST_RESTAURANT_SUCCESS_MESSAGE);

	HttpHeaders httpHeaders = new HttpHeaders();

	@BeforeEach
	void setup() {
//		this.mockMvc = MockMvcBuilders.standaloneSetup(restController).build();
	}

	@Test
	void ingestRestaurant_Success() throws Exception {

		expectedResponse.setStatus(200);

		Restaurant restaurant = RestaruantIngestObject();
		ArrayList<Restaurant> responseList = new ArrayList<>();
		responseList.add(RestaruantReturnObject()); 

		when(restService.ingestRestaurant(marketCode, locale, uuid, restaurant))
				.thenReturn(new ResponseEntity<Object>(HttpStatus.OK));

		ResponseEntity<Object> actualResponse = restController.ingestRestaurant(marketCode, locale, uuid, restaurant);

		assertThat(expectedResponse.getStatus()).isEqualTo(actualResponse.getStatusCodeValue());
		verify(restService).ingestRestaurant(marketCode, locale, uuid, restaurant);
	}

	@Test
	void ingestRestaurant_Throw_HeaderValidationException_having_invalid_marketid() throws HeaderValidationException {


		Restaurant restaurant = RestaruantIngestObject();

		MockHttpServletResponse expectedResponse = new MockHttpServletResponse();
		expectedResponse.setStatus(400);
		
		doThrow(new HeaderValidationException()).when(headerValidationService)
									   .validateIngestRestaurantHeaders("invalid", locale, uuid);
		
		assertThrows(HeaderValidationException.class, () -> {
			restController.ingestRestaurant("invalid", locale, uuid, restaurant);
		});
		
		verify(headerValidationService).validateIngestRestaurantHeaders("invalid", locale, uuid);

	}
	
	@Test
	void ingestRestaurant_Throw_HeaderValidationException_having_invalid_locale() throws HeaderValidationException {

		Restaurant restaurant = RestaruantIngestObject();

		MockHttpServletResponse expectedResponse = new MockHttpServletResponse();
		expectedResponse.setStatus(400);
		
		doThrow(new HeaderValidationException()).when(headerValidationService)
									   .validateIngestRestaurantHeaders(marketCode, "invalid", uuid);
		
		assertThrows(HeaderValidationException.class, () -> {
			restController.ingestRestaurant(marketCode, "invalid", uuid, restaurant);
		});
		
		verify(headerValidationService).validateIngestRestaurantHeaders(marketCode, "invalid", uuid);

	}
	
	@Test
	void ingestRestaurant_Throw_HeaderValidationException_having_invalid_uuid() throws HeaderValidationException {

		Restaurant restaurant = RestaruantIngestObject();

		MockHttpServletResponse expectedResponse = new MockHttpServletResponse();
		expectedResponse.setStatus(400);
		
		doThrow(new HeaderValidationException()).when(headerValidationService)
									   .validateIngestRestaurantHeaders(marketCode, locale, "invalid");
		
		assertThrows(HeaderValidationException.class, () -> {
			restController.ingestRestaurant(marketCode, locale, "invalid", restaurant);
		});
		
		verify(headerValidationService).validateIngestRestaurantHeaders(marketCode, locale, "invalid");

	}
	
	@Test
	void ingestRestaurant_Throw_ElasticSearchException() throws ElasticSearchException {

		Restaurant restaurant = RestaruantIngestObject();

		MockHttpServletResponse expectedResponse = new MockHttpServletResponse();
		expectedResponse.setStatus(400);
		
		doThrow(new ElasticSearchException()).when(restService)
												.ingestRestaurant(marketCode, locale, uuid, restaurant);
		
		assertThrows(ElasticSearchException.class, () -> {
			restController.ingestRestaurant(marketCode, locale, uuid, restaurant);
		});
		
		verify(restService).ingestRestaurant(marketCode, locale, uuid, restaurant);

	}

	Restaurant RestaruantIngestObject() {
		Restaurant restaurant = new Restaurant();
//		restaurant.setId("195500273006:en-US");
		restaurant.setNationalStoreNumber(1349);
		restaurant.setStoreIdentifierType("NATLSTRNUMBER");
//		restaurant.setLocalization("en-US");
		restaurant.setGblNumber("195500273006");
		restaurant.setCountryCode("US");
//		restaurant.setMarketCode("US");
		restaurant.setAddress(new Address("USA", "MO", 64119, "Claycomo", "290 E 69 Hwy", "DENVER FIELD OFFICE"));
		restaurant.setGeneralStatus(new GeneralStatus("OPEN", "26-02-2019", "15-02-2025"));
		restaurant.setCurrentStatus(new CurrentStatus("OPEN", "26-02-2019", "15-02-2025"));
		restaurant.setLocation(new Location(39.200516, -94.499097));
		restaurant.setStoreType(new StoreType("FREESTANDING", "partyHere"));

		return restaurant;
	}

	Restaurant RestaruantReturnObject() {
		Restaurant restaurant = new Restaurant();
		restaurant.setId("195500273006:en-US");
		restaurant.setNationalStoreNumber(1349);
		restaurant.setStoreIdentifierType("NATLSTRNUMBER");
		restaurant.setLocalization("en-US");
		restaurant.setGblNumber("195500273006");
		restaurant.setCountryCode("US");
		restaurant.setMarketCode("US");
		restaurant.setAddress(new Address("USA", "MO", 64119, "Claycomo", "290 E 69 Hwy", "DENVER FIELD OFFICE"));
		restaurant.setGeneralStatus(new GeneralStatus("OPEN", "26-02-2019", "15-02-2025"));
		restaurant.setCurrentStatus(new CurrentStatus("OPEN", "26-02-2019", "15-02-2025"));
		restaurant.setLocation(new Location(39.200516, -94.499097));
		restaurant.setStoreType(new StoreType("FREESTANDING", "partyHere"));

		return restaurant;
	}


}
