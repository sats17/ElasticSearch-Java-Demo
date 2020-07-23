package com.sats.es.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.api.sats.es.model.CurrentStatus;

public class CurrentStatusUnitTest {

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
	public void test_hash_code() {
		int hashcode =  new CurrentStatus("Currentstatus", "startDate", "enddate").hashCode();
		assertEquals(obj1.hashCode(), hashcode);
	}
	
	@Test
	public void test_hash_code_of_null_currentStatus() {
		CurrentStatus obj3 = new CurrentStatus(null, "startdate", "enddate");
		int hashcode = obj3.hashCode();
		assertEquals(obj3.hashCode(), hashcode);
	}
	
	@Test
	public void test_hash_code_of_null_startDate() {
		CurrentStatus obj3 = new CurrentStatus("Currentstatus", null, "enddate");
		int hashcode = obj3.hashCode();
		assertEquals(obj3.hashCode(), hashcode);
	}
	
	@Test
	public void test_hash_code_of_null_postalzip() {
		CurrentStatus obj3 = new CurrentStatus("Currentstatus", "startdate", null);
		int hashcode = obj3.hashCode();
		assertEquals(obj3.hashCode(), hashcode);
	}
	
	@Test
    public void testToString()
    {
        CurrentStatus obj = new CurrentStatus(); // you didn't supply the object, so I guessed
        String expected = "GeneralStatus [status=null, startDate=null, endDate=null]"; // put the expected value here
        assertEquals(expected, obj.toString());
    }
	
}
