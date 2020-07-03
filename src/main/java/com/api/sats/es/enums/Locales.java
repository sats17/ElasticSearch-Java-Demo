package com.api.sats.es.enums;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Enums;

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
