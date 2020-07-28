package com.sats.api.es.enums;

import java.util.ArrayList;
import java.util.List;

public enum Locales {

	enUS("en-US"), enUK("en-UK"), enCA("en-CA"), enAU("en-AU");
	
	private String value;
	
	private static final List<String> enums = new ArrayList<String>(Locales.values().length);
	
	private Locales(String value) {
		this.value = value;
	}
	
	static {
		for(Locales locale: Locales.values()) {
			enums.add(locale.value);
		}
	}
	
	public static boolean isLocaleContains(String value) {
		return enums.contains(value);
	}
	
}
