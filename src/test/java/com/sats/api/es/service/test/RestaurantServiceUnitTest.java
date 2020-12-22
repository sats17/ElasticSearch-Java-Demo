package com.sats.api.es.service.test;

import static org.assertj.core.api.Assertions.assertThat;
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
import com.sats.api.es.data.RestaurantSearchRepository;
import com.sats.api.es.exception.ElasticSearchException;
import com.sats.api.es.model.Restaurant;
import com.sats.api.es.service.ElasticSearchService;
import com.sats.api.es.service.RestaurantService;
import com.sats.api.es.utilites.ApiResponeUtility;

import static com.sats.api.es.config.Constants.INGEST_RESTAURANT_SUCCESS_MESSAGE;
import static com.sats.api.es.utilites.test.Utility.RestaruantIngestObject;
import static com.sats.api.es.utilites.test.Utility.RestaruantReturnObject;
import static com.sats.api.es.utilites.test.Utility.FinalResponseObject;

@AutoConfigureMockMvc
@SpringBootTest
//@ExtendWith(MockitoExtension.class)
//@MockitoSettings(strictness = Strictness.WARN)
public class RestaurantServiceUnitTest {
	
	@Autowired
	ApplicationContext context;
	
	@Autowired
	private WebApplicationContext wac;
	
	
	@Mock
	private ElasticSearchService elasticSearchService;
	
	@Mock
	private ApiResponeUtility apiResponseUtility;
	
	@Mock
	private RestaurantSearchRepository restSearchRepo;
	
	@InjectMocks
	private RestaurantService restaurantService;
	
	ObjectMapper mapper = new ObjectMapper();
	String jsonBody;
	
	private static final String marketCode = "US";
	private static final String locale = "en-US"; 
	private static final String uuid = "12345";
	HttpHeaders httpHeaders = new HttpHeaders();
	MockHttpServletResponse expectedResponse = new MockHttpServletResponse();
	
	@BeforeEach
	void setup() throws JsonProcessingException {
		jsonBody = mapper.writeValueAsString(RestaruantIngestObject());
		httpHeaders.set("sats-uuid", uuid);
		
	}
	
	@Test
	void testIngestRestaurantSuccess() throws ElasticSearchException, JsonMappingException, JsonProcessingException {
		
		expectedResponse.setStatus(200);
		
		ArrayList<Restaurant> list = new ArrayList<>();
		list.add(RestaruantReturnObject());
		
		when(elasticSearchService.insert(null))
								 .thenReturn(RestaruantReturnObject());
		
		when(apiResponseUtility.successResponseCreator(null, INGEST_RESTAURANT_SUCCESS_MESSAGE, uuid))
							   .thenReturn(new ResponseEntity<Object>(HttpStatus.OK));
		
		ResponseEntity<Object> actualResponse = restaurantService.ingestRestaurant(marketCode, locale, uuid, RestaruantIngestObject());
		System.out.println(actualResponse);
		
		assertThat(expectedResponse.getStatus()).isEqualTo(actualResponse.getStatusCodeValue());
		
	}
	
}
