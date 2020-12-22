package com.sats.api.es.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.sats.api.es.model.CurrentStatus;
import nl.jqno.equalsverifier.EqualsVerifier;

class CurrentStatusUnitTest {

	CurrentStatus obj1; 
	CurrentStatus obj2;
	
	@BeforeEach
	public void setUp() {
		obj1 = new CurrentStatus("Currentstatus", "startDate", "enddate");

		obj2 = new CurrentStatus("Currentstatus", "startDate", "enddate");
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
	public void test_when_Object_CurrentStatus_is_different() {
		CurrentStatus obj3 = new CurrentStatus("differentStatus", "startDate", "enddate");
		assertFalse(obj1.equals(obj3));
	}
	
	@Test
	public void test_when_Object_CurrentStatus_is_different_null() {
		CurrentStatus obj3 = new CurrentStatus("null", "startDate", "enddate");
		assertFalse(obj1.equals(obj3));
	}
	
	@Test
	public void test_when_Object_startDate_is_different() {
		CurrentStatus obj3 = new CurrentStatus("Currentstatus", "diffstartDate", "enddate");
		assertFalse(obj1.equals(obj3));
	}
	
	@Test
	public void test_when_Object_startDate_is_different_and_null() {
		CurrentStatus obj3 = new CurrentStatus("Currentstatus", "null", "enddate");
		assertFalse(obj1.equals(obj3));
	}
	
	@Test
	public void test_when_Object_endDate_is_different() {
		CurrentStatus obj3 = new CurrentStatus("Currentstatus", "startDate", "diffenddate");
		assertFalse(obj1.equals(obj3));
	}
	
	@Test
	public void test_when_Object_endDate_is_different_and_null() {
		CurrentStatus obj3 = new CurrentStatus("Currentstatus", "startDate", "null");
		assertFalse(obj1.equals(obj3)); 
	}
	
	@Test
	public void testEqualsAndHashCode() {
		EqualsVerifier.simple().forClass(CurrentStatus.class).verify();
	}
	
	@Test
    public void testToString() 
    {
        CurrentStatus obj = new CurrentStatus();
        String expected = "CurrentStatus(status=null, startDate=null, endDate=null)";
        assertEquals(expected, obj.toString());
    }
	
}
