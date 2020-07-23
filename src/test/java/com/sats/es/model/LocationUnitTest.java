package com.sats.es.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.api.sats.es.model.Location;

public class LocationUnitTest {
	
	Location obj1; 
	Location obj2;
	
	@BeforeEach
	public void setUp() {
		obj1 = new Location(18.0, 19.0);

		obj2 = new Location(18.0, 19.0);
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
	public void test_when_Object_Latitude_is_different() {
		Location obj3 = new Location(17.0, 19.0);
		assertFalse(obj1.equals(obj3));
	}
	
	@Test
	public void test_when_Object_Latitude_is_different_null() {
		Location obj3 = new Location(null, 19.0);
		assertFalse(obj1.equals(obj3));
	}
	
	@Test
	public void test_when_Object_Longitiude_is_different() {
		Location obj3 = new Location(18.0, 20.0);
		assertFalse(obj1.equals(obj3));
	}
	
	@Test
	public void test_when_Object_Longitiude_is_different_null() {
		Location obj3 = new Location(18.0, null);
		assertFalse(obj1.equals(obj3));
	}
	
	@Test
	public void test_hash_code() {
		int hashcode =  new Location(18.0, 19.0).hashCode();
		assertEquals(obj1.hashCode(), hashcode);
	}
	
	@Test
	public void test_hash_code_of_null_Latitude() {
		Location obj3 = new Location(null, 19.0);
		int hashcode = obj3.hashCode();
		assertEquals(obj3.hashCode(), hashcode); 
	}
	
	@Test
	public void test_hash_code_of_null_Logntitude() {
		Location obj3 = new Location(18.0, null);
		int hashcode = obj3.hashCode();
		assertEquals(obj3.hashCode(), hashcode);
	}
	
	@Test
    public void testToString()
    {
        Location obj = new Location(); // you didn't supply the object, so I guessed
        String expected = "Location [latitude=null, longtitude=null]"; // put the expected value here
        assertEquals(expected, obj.toString());
    }
	
}
