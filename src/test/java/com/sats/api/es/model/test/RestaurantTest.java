package com.sats.api.es.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.sats.api.es.model.Restaurant;

import nl.jqno.equalsverifier.EqualsVerifier;

public class RestaurantTest {
	
	@Test
	public void testAllArgsConstructor() {
		Restaurant obj1 = new Restaurant(null, null, null, null, null, null, null, null, null, null, null, null);
		Restaurant obj2 = new Restaurant(null, null, null, null, null, null, null, null, null, null, null, null);
		assertEquals(obj1, obj2);
	}

	@Test
	public void testEqualsAndHashCode() {
		EqualsVerifier.simple().forClass(Restaurant.class).verify();
	}
	
}
