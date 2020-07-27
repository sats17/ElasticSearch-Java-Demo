package com.sats.api.es.service.test;

import static com.sats.api.es.utilites.test.Utility.RestaruantReturnObject;
import static org.assertj.core.api.Assertions.assertThat;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sats.api.es.data.RestaurantSearchRepository;
import com.sats.api.es.exception.ElasticSearchException;
import com.sats.api.es.model.Restaurant;
import com.sats.api.es.service.ElasticSearchService;

@SpringBootTest
//@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.WARN)
class ElasticSearchServiceUnitTest {

	@Autowired
	ApplicationContext context;
	
	@Mock
	private RestaurantSearchRepository restauratRepository;
	
	@InjectMocks
	private ElasticSearchService elasticSearchService;
	
	@Test
	public void test_validateIngestRestaurantHeaders_success() throws ElasticSearchException {
			
		doReturn(RestaruantReturnObject()).when(restauratRepository).save(RestaruantReturnObject());
		
		Restaurant response = elasticSearchService.insert(RestaruantReturnObject()); 
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
