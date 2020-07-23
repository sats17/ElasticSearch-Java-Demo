package com.api.sats.es.utilities;

import com.api.sats.es.model.Address;
import com.api.sats.es.model.CurrentStatus;
import com.api.sats.es.model.GeneralStatus;
import com.api.sats.es.model.Location;
import com.api.sats.es.model.Restaurant;
import com.api.sats.es.model.StoreType;

public class UtilityUnitTest {

	public static Restaurant RestaruantIngestObject() {
		Restaurant restaurant = new Restaurant();
//		restaurant.setId("195500273006:en-US");
		restaurant.setNationalStoreNumber(1349);
		restaurant.setStoreIdentifierType("NATLSTRNUMBER");
//		restaurant.setLocalization("en-US");
		restaurant.setGblNumber("195500273006");
		restaurant.setCountryCode("US");
//		restaurant.setMarketCode("US");
		restaurant.setAddress(new Address("USA", "MO", 64119, "Claycomo", "290 E 69 Hwy", "DENVER FIELD OFFICE"));
		restaurant.setGeneralStatus(new GeneralStatus("OPEN", "26-02-2019", "15-02-2025"));
		restaurant.setCurrentStatus(new CurrentStatus("OPEN", "26-02-2019", "15-02-2025"));
		restaurant.setLocation(new Location(39.200516, -94.499097));
		restaurant.setStoreType(new StoreType("FREESTANDING", "partyHere"));

		return restaurant;
	}

	public static Restaurant RestaruantReturnObject() {
		Restaurant restaurant = new Restaurant();
		restaurant.setId("195500273006:en-US");
		restaurant.setNationalStoreNumber(1349);
		restaurant.setStoreIdentifierType("NATLSTRNUMBER");
		restaurant.setLocalization("en-US");
		restaurant.setGblNumber("195500273006");
		restaurant.setCountryCode("US");
		restaurant.setMarketCode("US");
		restaurant.setAddress(new Address("USA", "MO", 64119, "Claycomo", "290 E 69 Hwy", "DENVER FIELD OFFICE"));
		restaurant.setGeneralStatus(new GeneralStatus("OPEN", "26-02-2019", "15-02-2025"));
		restaurant.setCurrentStatus(new CurrentStatus("OPEN", "26-02-2019", "15-02-2025"));
		restaurant.setLocation(new Location(39.200516, -94.499097));
		restaurant.setStoreType(new StoreType("FREESTANDING", "partyHere"));

		return restaurant;
	}
}
