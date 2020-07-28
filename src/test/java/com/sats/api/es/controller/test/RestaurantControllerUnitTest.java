package com.sats.api.es.controller.test;

import static com.sats.api.es.config.Constants.INGEST_RESTAURANT_SUCCESS_MESSAGE;
import static com.sats.api.es.config.Constants.SUCCESS_ROOT_CODE;
import static com.sats.api.es.config.Constants.SUCCESS_ROOT_TYPE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sats.api.es.controller.RestaurantController;
import com.sats.api.es.data.RestaurantSearchRepository;
import com.sats.api.es.exception.ElasticSearchException;
import com.sats.api.es.exception.RequestBodyValidationException;
import com.sats.api.es.model.Address;
import com.sats.api.es.model.CurrentStatus;
import com.sats.api.es.model.GeneralStatus;
import com.sats.api.es.model.Location;
import com.sats.api.es.model.Restaurant;
import com.sats.api.es.model.StoreType;
import com.sats.api.es.response.Status;
import com.sats.api.es.service.ElasticSearchService;
import com.sats.api.es.service.RequestValidationService;
import com.sats.api.es.service.RestaurantService;

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
	private RequestValidationService headerValidationService;

	@Mock
	private RestaurantSearchRepository restSearchRepo;

	MockHttpServletResponse expectedResponse = new MockHttpServletResponse();

	private static final String marketCode = "US";
	private static final String locale = "en-US"; 
	private static final String uuid = "12345";
	private static final Status INGEST_RESTAURANT_SUCCESS = new Status(SUCCESS_ROOT_CODE, SUCCESS_ROOT_TYPE,
			INGEST_RESTAURANT_SUCCESS_MESSAGE);

	HttpHeaders httpHeaders = new HttpHeaders();
	ObjectMapper mapper = new ObjectMapper();
	Restaurant restaurant = RestaruantIngestObject();
	String jsonBody;

	@BeforeEach
	void setup() throws JsonProcessingException {
//		this.mockMvc = MockMvcBuilders.standaloneSetup(restController).build();
		jsonBody = mapper.writeValueAsString(restaurant);
	}

	@Test
	void ingestRestaurant_Success() throws Exception {
		
		expectedResponse.setStatus(200);

		 
		ArrayList<Restaurant> responseList = new ArrayList<>();
		responseList.add(RestaruantReturnObject()); 

		when(restService.ingestRestaurant(marketCode, locale, uuid, null))
				.thenReturn(new ResponseEntity<Object>(HttpStatus.OK));

		ResponseEntity<Object> actualResponse = restController.ingestRestaurant(marketCode, locale, uuid, jsonBody);

		assertThat(expectedResponse.getStatus()).isEqualTo(actualResponse.getStatusCodeValue());
		verify(restService).ingestRestaurant(marketCode, locale, uuid, null);
	} 

	@Test
	void ingestRestaurant_Throw_HeaderValidationException_having_invalid_marketid() throws RequestBodyValidationException {


		Restaurant restaurant = RestaruantIngestObject();

		MockHttpServletResponse expectedResponse = new MockHttpServletResponse();
		expectedResponse.setStatus(400);
		
		doThrow(new RequestBodyValidationException()).when(headerValidationService)
									   .validateIngestRestaurantRequest("invalid", locale, uuid, jsonBody);
		
		assertThrows(RequestBodyValidationException.class, () -> {
			restController.ingestRestaurant("invalid", locale, uuid, jsonBody);
		});
		
		verify(headerValidationService).validateIngestRestaurantRequest("invalid", locale, uuid, jsonBody);

	}
	
	@Test
	void ingestRestaurant_Throw_HeaderValidationException_having_invalid_locale() throws RequestBodyValidationException {

		Restaurant restaurant = RestaruantIngestObject();

		MockHttpServletResponse expectedResponse = new MockHttpServletResponse();
		expectedResponse.setStatus(400);
		
		doThrow(new RequestBodyValidationException()).when(headerValidationService)
									   .validateIngestRestaurantRequest(marketCode, "invalid", uuid, jsonBody);
		
		assertThrows(RequestBodyValidationException.class, () -> {
			restController.ingestRestaurant(marketCode, "invalid", uuid, jsonBody);
		});
		
		verify(headerValidationService).validateIngestRestaurantRequest(marketCode, "invalid", uuid, jsonBody);

	}
	
	@Test
	void ingestRestaurant_Throw_HeaderValidationException_having_invalid_uuid() throws RequestBodyValidationException {

		Restaurant restaurant = RestaruantIngestObject();

		MockHttpServletResponse expectedResponse = new MockHttpServletResponse();
		expectedResponse.setStatus(400);
		
		doThrow(new RequestBodyValidationException()).when(headerValidationService)
									   .validateIngestRestaurantRequest(marketCode, locale, "invalid", jsonBody);
		
		assertThrows(RequestBodyValidationException.class, () -> {
			restController.ingestRestaurant(marketCode, locale, "invalid", jsonBody);
		});
		
		verify(headerValidationService).validateIngestRestaurantRequest(marketCode, locale, "invalid", jsonBody);

	}
	
	@Test
	void ingestRestaurant_Throw_ElasticSearchException() throws ElasticSearchException, JsonMappingException, JsonProcessingException {

		Restaurant restaurant = RestaruantIngestObject();

		MockHttpServletResponse expectedResponse = new MockHttpServletResponse();
		expectedResponse.setStatus(400);
		
		doThrow(new ElasticSearchException()).when(restService)
												.ingestRestaurant(marketCode, locale, uuid, null);
		
		assertThrows(ElasticSearchException.class, () -> {
			restController.ingestRestaurant(marketCode, locale, uuid, jsonBody);
		});
		
		verify(restService).ingestRestaurant(marketCode, locale, uuid, null);


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
