package com.api.sats.es.controller;

import static com.api.sats.es.config.Constants.INGEST_RESTAURANT_SUCCESS_MESSAGE;
import static com.api.sats.es.config.Constants.SUCCESS_ROOT_CODE;
import static com.api.sats.es.config.Constants.SUCCESS_ROOT_TYPE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.isA;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.api.sats.es.data.RestaurantSearchRepository;
import com.api.sats.es.exception.HeaderValidationException;
import com.api.sats.es.model.Address;
import com.api.sats.es.model.CurrentStatus;
import com.api.sats.es.model.GeneralStatus;
import com.api.sats.es.model.Location;
import com.api.sats.es.model.Restaurant;
import com.api.sats.es.model.StoreType;
import com.api.sats.es.service.HeaderValidationService;
import com.api.sats.es.service.RestaurantService;
import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
//@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RestaurantControllerIT {

	@Autowired
	private MockMvc mockMvc;
	
//	@Mock
//	private RestaurantSearchRepository restaurantRepository;
	
	@Autowired
    private WebApplicationContext wac;
	
//	@InjectMocks
	private RestaurantController restController;
	
	private static final String marketCode = "US";
	private static final String locale = "en-US";
	private static final String uuid = "12345";
	
	MockHttpServletResponse expectedResponse = new MockHttpServletResponse();
	
	Restaurant restaurantInput;
	
	@BeforeEach
	void setUp() {
		restaurantInput = RestaruantIngestObject();
//		this.mockMvc = MockMvcBuilders.standaloneSetup(restController).build();
	}
	
	
//	@Test
//	void ingestRestaurant_Success() throws Exception {
//		ObjectMapper mapper = new ObjectMapper();
//		
//		HttpHeaders httpHeaders = new HttpHeaders();
//		httpHeaders.add("sats-marketid", marketCode);
//		httpHeaders.add("sats-locale", locale);
//		httpHeaders.add("sats-uuid", uuid);
//		
//		
//		expectedResponse.setStatus(200);
//		
//		
//		String jsonRestInput = mapper.writeValueAsString(restaurantInput);
//		
//		MockHttpServletResponse actualResponse = mockMvc.perform(post("/api/restaurants/ingest")
//														.contentType(MediaType.APPLICATION_JSON)
//														.headers(httpHeaders)
//														.content(jsonRestInput))
//														.andDo(print())
//														.andReturn()
//														.getResponse();
//		
//		assertThat(expectedResponse.getStatus()).isEqualTo(actualResponse.getStatus());
//		
//	}
	
	@Test
	void ingestRestaurant_Throw_HeaderValidationException() throws Exception {
		
		ObjectMapper mapper = new ObjectMapper();
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("sats-marketid", "IND");
		httpHeaders.add("sats-locale", locale);
		httpHeaders.add("sats-uuid", uuid);
		
		Restaurant restaurant = RestaruantIngestObject();
		String jsonString = mapper.writeValueAsString(restaurant);
		
		MockHttpServletResponse expectedResponse = new MockHttpServletResponse();
		expectedResponse.setStatus(400);
		
		MockHttpServletResponse actualResponse = mockMvc.perform(post("/api/restaurants/ingest")
				.contentType(MediaType.APPLICATION_JSON).headers(httpHeaders).content(jsonString)).andDo(print())
				.andReturn().getResponse();
		System.out.println("Actual Response is "+actualResponse);
		assertThat(expectedResponse.getStatus()).isEqualTo(actualResponse.getStatus());
		
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
