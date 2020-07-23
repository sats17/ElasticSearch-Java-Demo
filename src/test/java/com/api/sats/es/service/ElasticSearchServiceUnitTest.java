package com.api.sats.es.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.api.sats.es.data.RestaurantSearchRepository;
import com.api.sats.es.exception.ElasticSearchException;
import com.api.sats.es.exception.HeaderValidationException;
import com.api.sats.es.model.Restaurant;

import static com.api.sats.es.utilities.UtilityUnitTest.RestaruantReturnObject;

@SpringBootTest
//@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.WARN)
public class ElasticSearchServiceUnitTest {

	@Autowired
	ApplicationContext context;
	
	@Mock
	private RestaurantSearchRepository restauratRepository;
	
	@InjectMocks
	private ElasticSearchService elasticSearchService;
	
	@Test
	public void test_validateIngestRestaurantHeaders_success() throws ElasticSearchException {
			
		System.out.println(RestaruantReturnObject().toString());
		
		
		doReturn(RestaruantReturnObject()).when(restauratRepository).save(RestaruantReturnObject());
		
		Restaurant response = elasticSearchService.insert(RestaruantReturnObject());
		System.out.println(response);
		assertThat(response).isEqualTo(RestaruantReturnObject());
		
	}
	
	@Test 
	public void test_validateIngestRestaurantHeaders_Throws_ElasticSearchException() {
		
		doThrow(new RuntimeException()).when(restauratRepository).save(new Restaurant());
		
		assertThrows(RuntimeException.class, () -> {
			elasticSearchService.insert(new Restaurant());
		});
		
	}
	
}
