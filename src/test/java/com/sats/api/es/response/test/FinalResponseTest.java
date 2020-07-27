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
	
	@Test
	public void test_toString() {
		System.out.println(obj1.toString());
		String expected = "FinalResponse(status=Status(code=0, type=null, message=null), restaurnts=[Restaurant(id=195500273006:en-US, nationalStoreNumber=1349, storeIdentifierType=NATLSTRNUMBER, localization=en-US, gblNumber=195500273006, countryCode=US, marketCode=US, address=Address(country=USA, stateProvince=MO, postalZip=64119, cityTown=Claycomo, addressLine=290 E 69 Hwy, region=DENVER FIELD OFFICE), generalStatus=GeneralStatus(status=OPEN, startDate=26-02-2019, endDate=15-02-2025), currentStatus=CurrentStatus(status=OPEN, startDate=26-02-2019, endDate=15-02-2025), location=Location(latitude=39.200516, longtitude=-94.499097), storeType=StoreType(storeTypeCode=FREESTANDING, partyName=partyHere))])";
		assertEquals(expected, obj1.toString());
	}
	
}
