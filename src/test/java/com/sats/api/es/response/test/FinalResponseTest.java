package com.sats.api.es.response.test;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sats.api.es.model.Restaurant;
import com.sats.api.es.response.FinalResponse;
import com.sats.api.es.response.Status;
import static com.sats.api.es.utilites.test.Utility.RestaruantReturnObject;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FinalResponseTest {

	FinalResponse obj1;
	FinalResponse obj2;
	
	@BeforeEach
	public void setUp() {
		Status status = new Status();
		ArrayList<Restaurant> list = new ArrayList<>();
		list.add(RestaruantReturnObject());
		obj1 = new FinalResponse(status, list);
		obj2 = new FinalResponse(status, list);
	}
	
	@Test
	public void test_when_Object_is_Same() {
		assertTrue(obj1.equals(obj1));
	}
	
	@Test
	public void test_when_Object_is_Null() {
		assertFalse(obj1.equals(null));
	}
		
	@Test
	public void test_when_Object_is_Equals() {
		assertTrue(obj1.equals(obj2));
	}
	
	@Test
	public void test_hash_code() {
		int hashcode =  obj2.hashCode();
		assertEquals(obj1.hashCode(), hashcode);
	}
	
	@Test
	public void test_hash_code_when_status_is_null() {
		obj2.setStatus(null);
		int hashcode =  obj2.hashCode();
		assertEquals(obj2.hashCode(), hashcode);
	}
	
	@Test
	public void test_hash_code_when_restaurants_is_null() {
		obj2.setRestaurnts(null);
		int hashcode = obj2.hashCode();
		assertEquals(obj2.hashCode(), hashcode);
	}
	
}
