package com.api.sats.es.controller;

import static com.api.sats.es.config.Constants.INGEST_RESTAURANT_SUCCESS_MESSAGE;
import static com.api.sats.es.config.Constants.SUCCESS_ROOT_CODE;
import static com.api.sats.es.config.Constants.SUCCESS_ROOT_TYPE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
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
class EsControllerTest {
	
	
	private MockMvc mockMvc;
	
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

	@BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(restController).build();
    }

	@Test
	void ingestRestaurant_Success() throws Exception { 
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("sats-marketid", marketCode);
		httpHeaders.add("sats-locale", locale);
		httpHeaders.add("sats-uuid", uuid);
		
		
		expectedResponse.setStatus(200);
		
		Restaurant restaurant = RestaruantIngestObject();
		ArrayList<Restaurant> responseList = new ArrayList<>();
		responseList.add(RestaruantReturnObject());
		String jsonString = mapper.writeValueAsString(restaurant);
		
		ResponseEntity<Object> ret = new ResponseEntity<Object>(restaurant,HttpStatus.BAD_REQUEST);
		
//		when(headerValidationService.validateIngestRestaurantHeaders(marketCode, locale, uuid)).th;
		
		when(restService.ingestRestaurant(marketCode, locale, uuid, restaurant))
						.thenReturn(new ResponseEntity<Object>(HttpStatus.BAD_GATEWAY));
		
		
		MockHttpServletResponse actualResponse = mockMvc.perform(post("/api/restaurants/ingest")
									  .contentType(MediaType.APPLICATION_JSON)
									  .headers(httpHeaders)
									  .content(jsonString))
									  .andDo(print())
									  .andReturn().getResponse();
		
		System.out.println(context.toString());
		assertThat(expectedResponse.getStatus()).isEqualTo(actualResponse.getStatus());
	}
	
	
//	@Test
//	void ingestRestaurant_Throw_HeaderValidationException() throws Exception {
//	
//	ObjectMapper mapper = new ObjectMapper();
//	
//	HttpHeaders httpHeaders = new HttpHeaders();
//	httpHeaders.add("sats-marketid", "IND");
//	httpHeaders.add("sats-locale", locale);
//	httpHeaders.add("sats-uuid", uuid);
//	
//	Restaurant restaurant = RestaruantIngestObject();
//	String jsonString = mapper.writeValueAsString(restaurant);
//	
//	MockHttpServletResponse expectedResponse = new MockHttpServletResponse();
//	expectedResponse.setStatus(400);
//	
//	doThrow(HeaderValidationException.class).when(headerValidationService)
//											.validateIngestRestaurantHeaders(marketCode, locale, uuid);
//	MockHttpServletResponse actualResponse = mockMvc.perform(post("/api/restaurants/ingest")
//													.contentType(MediaType.APPLICATION_JSON)
//													.headers(httpHeaders)
//													.content(jsonString))
//													.andDo(print())
//													.andReturn()
//													.getResponse();
//	
//	assertThrows(NestedServletException.class, ()-> mockMvc.perform(post("/api/restaurants/ingest")));
//	
////	assertThat(expectedResponse.getStatus()).isEqualTo(actualResponse.getStatus());
//	
//}
	
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
	
	private HttpHeaders getHttpHeaders(String uuid) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("sats-uuid", uuid);
		return headers;
		
	}

}
