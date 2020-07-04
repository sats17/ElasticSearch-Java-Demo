package com.sats.es.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.api.sats.es.model.Address;


public class AddressUT {
	
	Address obj1; 
	Address obj2;
	
	@BeforeEach
	public void setUp() {
		obj1 = new Address("India", "StateProvince", 1234, "Town", "Line", "region");

		obj2 = new Address("India", "StateProvince", 1234, "Town", "Line", "region");
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
	public void test_when_Object_Country_is_different() {
		Address obj3 = new Address("America", "StateProvince", 1234, "Town", "Line", "region");
		assertFalse(obj1.equals(obj3));
	}
	
	@Test
	public void test_when_Object_Country_is_different_and_null() {
		Address obj3 = new Address(null, "StateProvince", 1234, "Town", "Line", "region");
		assertFalse(obj1.equals(obj3));
	}
	
	@Test
	public void test_when_Object_stateProvince_is_different() {
		Address obj3 = new Address("India", "Diffent", 1234, "Town", "Line", "region");
		assertFalse(obj1.equals(obj3));
	}
	
	@Test
	public void test_when_Object_stateProvince_is_different_and_null() {
		Address obj3 = new Address("India", null, 1234, "Town", "Line", "region");
		assertFalse(obj1.equals(obj3));
	}
	
	@Test
	public void test_when_Object_postalZip_is_different() {
		Address obj3 = new Address("India", "StateProvince", 2341, "Town", "Line", "region");
		assertFalse(obj1.equals(obj3)); 
	}
	
	@Test
	public void test_when_Object_postalZip_is_different_and_null() {
		Address obj3 = new Address("India", "StateProvince", null, "Town", "Line", "region");
		assertFalse(obj1.equals(obj3)); 
	}
	
	@Test
	public void test_when_Object_cityTown_is_different() {
		Address obj3 = new Address("India", "StateProvince", 1234, "DIffTown", "Line", "region");
		assertFalse(obj1.equals(obj3));
	}
	
	@Test
	public void test_when_Object_cityTown_is_different_and_null() {
		Address obj3 = new Address("India", "StateProvince", 1234, null, "Line", "region");
		assertFalse(obj1.equals(obj3));
	}
	
	@Test
	public void test_when_Object_addressLine_is_different() {
		Address obj3 = new Address("India", "StateProvince", 1234, "Town", "diffLine", "region");
		assertFalse(obj1.equals(obj3));
	}
	
	@Test
	public void test_when_Object_addressLine_is_different_and_null() {
		Address obj3 = new Address("India", "StateProvince", 1234, "Town", null, "region");
		assertFalse(obj1.equals(obj3));
	}
	
	@Test
	public void test_when_Object_region_is_different() {
		Address obj3 = new Address("India", "StateProvince", 1234, "Town", "Line", "DiffRegion");
		assertFalse(obj1.equals(obj3));
	}
	
	@Test
	public void test_when_Object_region_is_different_and_null() {
		Address obj3 = new Address("India", "StateProvince", 1234, "Town", "Line", null);
		assertFalse(obj1.equals(obj3));
	}
	
	@Test
	public void test_hash_code() {
		int hashcode = obj1.hashCode();
		assertEquals(obj1.hashCode(), hashcode);
	}
	
	@Test
	public void test_hash_code_of_null_country() {
		Address obj3 = new Address(null, "StateProvince", 1234, "Town", "Line", "region");
		int hashcode = obj3.hashCode();
		assertEquals(obj3.hashCode(), hashcode);
	}
	
	@Test
	public void test_hash_code_of_null_stateProvince() {
		Address obj3 = new Address("India", null, 1234, "Town", "Line", "region");
		int hashcode = obj3.hashCode();
		assertEquals(obj3.hashCode(), hashcode);
	}
	
	@Test
	public void test_hash_code_of_null_postalzip() {
		Address obj3 = new Address("India", "StateProvince", null, "Town", "Line", "region");
		int hashcode = obj3.hashCode();
		assertEquals(obj3.hashCode(), hashcode);
	}
	
	@Test
	public void test_hash_code_of_null_cityTown() {
		Address obj3 = new Address("India", "StateProvince", 1234, null, "Line", "region");
		int hashcode = obj3.hashCode();
		assertEquals(obj3.hashCode(), hashcode);
	}
	
	@Test
	public void test_hash_code_of_null_addressLine() {
		Address obj3 = new Address("India", "StateProvince", 1234, "Town", null, "region");
		int hashcode = obj3.hashCode();
		assertEquals(obj3.hashCode(), hashcode);
	}
	
	@Test
	public void test_hash_code_of_null_region() {
		Address obj3 = new Address("India", "StateProvince", 1234, "Town", "Line", null);
		int hashcode = obj3.hashCode();
		assertEquals(obj3.hashCode(), hashcode);
	}
	
	@Test
    public void testToString()
    {
        Address obj = new Address(); // you didn't supply the object, so I guessed
        String expected = "Address [country=null, stateProvince=null, postalZip=null, cityTown=null, addressLine=null, region=null]"; // put the expected value here
        assertEquals(expected, obj.toString());
    }
	
}
