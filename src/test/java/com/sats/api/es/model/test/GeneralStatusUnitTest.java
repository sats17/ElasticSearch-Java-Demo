package com.sats.api.es.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sats.api.es.model.GeneralStatus;

public class GeneralStatusUnitTest {

	GeneralStatus obj1; 
	GeneralStatus obj2;
	
	@BeforeEach
	public void setUp() {
		obj1 = new GeneralStatus("GeneralStatus", "startDate", "enddate");

		obj2 = new GeneralStatus("GeneralStatus", "startDate", "enddate");
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
	public void test_when_Object_GeneralStatus_is_different() {
		GeneralStatus obj3 = new GeneralStatus("differentStatus", "startDate", "enddate");
		assertFalse(obj1.equals(obj3));
	}
	
	@Test
	public void test_when_Object_GeneralStatus_is_different_null() {
		GeneralStatus obj3 = new GeneralStatus("null", "startDate", "enddate");
		assertFalse(obj1.equals(obj3));
	}
	
	@Test
	public void test_when_Object_startDate_is_different() {
		GeneralStatus obj3 = new GeneralStatus("GeneralStatus", "diffstartDate", "enddate");
		assertFalse(obj1.equals(obj3));
	}
	
	@Test
	public void test_when_Object_startDate_is_different_and_null() {
		GeneralStatus obj3 = new GeneralStatus("GeneralStatus", "null", "enddate");
		assertFalse(obj1.equals(obj3));
	}
	
	@Test
	public void test_when_Object_endDate_is_different() {
		GeneralStatus obj3 = new GeneralStatus("GeneralStatus", "startDate", "diffenddate");
		assertFalse(obj1.equals(obj3));
	}
	
	@Test
	public void test_when_Object_endDate_is_different_and_null() {
		GeneralStatus obj3 = new GeneralStatus("GeneralStatus", "startDate", "null");
		assertFalse(obj1.equals(obj3)); 
	}
	
	@Test
	public void test_hash_code() {
		int hashcode =  new GeneralStatus("GeneralStatus", "startDate", "enddate").hashCode();
		assertEquals(obj1.hashCode(), hashcode);
	}
	
	@Test
	public void test_hash_code_of_null_GeneralStatus() {
		GeneralStatus obj3 = new GeneralStatus(null, "startdate", "enddate");
		int hashcode = obj3.hashCode();
		assertEquals(obj3.hashCode(), hashcode);
	}
	
	@Test
	public void test_hash_code_of_null_startDate() {
		GeneralStatus obj3 = new GeneralStatus("GeneralStatus", null, "enddate");
		int hashcode = obj3.hashCode();
		assertEquals(obj3.hashCode(), hashcode);
	}
	
	@Test
	public void test_hash_code_of_null_postalzip() {
		GeneralStatus obj3 = new GeneralStatus("GeneralStatus", "startdate", null);
		int hashcode = obj3.hashCode();
		assertEquals(obj3.hashCode(), hashcode);
	}
	
	@Test
    public void testToString()
    {
        GeneralStatus obj = new GeneralStatus();
        String expected = "GeneralStatus(status=null, startDate=null, endDate=null)";
        assertEquals(expected, obj.toString());
    }
	
}
