package com.sats.api.es.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.sats.api.es.model.StoreType;
import nl.jqno.equalsverifier.EqualsVerifier;

class StoreTypeUnitTest {

	StoreType obj1; 
	StoreType obj2;
	
	@BeforeEach
	public void setUp() {
		obj1 = new StoreType("storeTypeCode", "partyName");

		obj2 = new StoreType("storeTypeCode", "partyName");
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
	public void test_when_Object_StoryType_is_different() {
		StoreType obj3 = new StoreType("diffstoreTypeCode", "partyName");
		assertFalse(obj1.equals(obj3));
	}
	
	@Test
	public void test_when_Object_StoryType_is_different_null() {
		StoreType obj3 = new StoreType(null, "partyName");
		assertFalse(obj1.equals(obj3));
	}
	
	@Test
	public void test_when_Object_partyName_is_different() {
		StoreType obj3 =  new StoreType("storeTypeCode", "diffpartyName");
		assertFalse(obj1.equals(obj3));
	}
	
	@Test
	public void test_when_Object_partName_is_different_null() {
		StoreType obj3 =  new StoreType("storeTypeCode", null);
		assertFalse(obj1.equals(obj3));
	}
	
	@Test
	public void testEqualsAndHashCode() {
		EqualsVerifier.simple().forClass(StoreType.class).verify();
	}
	
	@Test
    public void testToString()
    {
        StoreType obj = new StoreType();
        String expected = "StoreType(storeTypeCode=null, partyName=null)";
        assertEquals(expected, obj.toString());
    }
}
