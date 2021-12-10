package com.jumia.challenge.api.enums;

public enum CountryCodeEnum {

	CAMEROON("Cameroon", 237, "\\(237\\)\\ ?[2368]\\d{7,8}$"), ETHIOPIA("Ethiopia", 251, "\\(251\\)\\ ?[1-59]\\d{8}$"),
	MOROCCO("Morocco", 212, "\\(212\\)\\ ?[5-9]\\d{8}$"), MOZAMBIQUE("Mozambique", 258, "\\(258\\)\\ ?[28]\\d{7,8}$"),
	UGANDA("Uganda", 256, " \\(256\\)\\ ?\\d{9}$");

	private String country;
	private int code;
	private String regex;

	CountryCodeEnum(String country, int code, String regex) {
		this.country = country;
		this.code = code;
		this.regex = regex;
	}

	public int getCode() {
		return code;
	}

	public String getRegex() {
		return regex;
	}

	public String getCountry() {
		return country;
	}

	public static CountryCodeEnum getCountryCodeEnumByPhoneNumber(String phoneNumber) {
		for (CountryCodeEnum value : values()) {
			if (phoneNumber.matches(value.regex))
				return value;
		}
		return null;
	}

}
