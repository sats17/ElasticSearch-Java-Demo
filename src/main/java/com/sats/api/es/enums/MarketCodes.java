package com.sats.api.es.enums;

import java.util.ArrayList;
import java.util.List;

public enum MarketCodes {
	US, CA, UK, DE, AU;
	
	private static List<String> enums = new ArrayList<String>(MarketCodes.values().length);
	
	static {
		for(MarketCodes code: MarketCodes.values()) {
			enums.add(code.name());
		}
	}
	
	public static boolean isMarketCodePresent(String marketCode) {
		return enums.contains(marketCode.toUpperCase());
	}
}
