package com.sats.api.es.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.sats.api.es.model.Location;
import nl.jqno.equalsverifier.EqualsVerifier;

class LocationUnitTest {
	
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
	public void testEqualsAndHashCode() {
		EqualsVerifier.simple().forClass(Location.class).verify();
	}
	
	@Test
    public void testToString()
    {
        Location obj = new Location();
        String expected = "Location(latitude=null, longtitude=null)";
        assertEquals(expected, obj.toString());
    }
	
}
