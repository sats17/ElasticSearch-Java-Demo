package com.sats.api.es.response.test;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sats.api.es.response.Status;

import nl.jqno.equalsverifier.EqualsVerifier;

public class StatusTest {

	Status obj1;
	Status obj2;
	
	@BeforeEach
	public void setUp() {
		obj1 = new Status();
		obj1.setCode(40001);
		obj1.setMessage("message");
		obj1.setType("type");
	}
	
	@Test
	public void test_when_Object_is_Null() {
		assertFalse(obj1.equals(null));
	}
	
	@Test
	public void simpleEqualsContract() {
	    EqualsVerifier.simple().forClass(Status.class).verify();
	}
	
}
