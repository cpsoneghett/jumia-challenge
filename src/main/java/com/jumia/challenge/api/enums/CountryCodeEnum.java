package com.jumia.challenge.api.enums;

public enum CountryCodeEnum {

	CAMEROON("Cameroon", 237, "\\(237\\)\\ ?[2368]\\d{7,8}$"), ETHIOPIA("Ethiopia", 251, "\\(251\\)\\ ?[1-59]\\d{8}$"),
	MOROCCO("Morocco", 212, "\\(212\\)\\ ?[5-9]\\d{8}$"), MOZAMBIQUE("Mozambique", 258, "\\(258\\)\\ ?[28]\\d{7,8}$"),
	UGANDA("Uganda", 256, " \\(256\\)\\ ?\\d{9}$"), COUNTRY_NOT_MAPPED("COUNTRY NOT MAPPED", 0, null);

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

	public String getCountry() {
		return country;
	}

	public String getRegex() {
		return regex;
	}

	public static boolean validadePhoneNumberByRegex(String phoneNumber) {
		for (CountryCodeEnum value : values()) {
			if (value.regex != null && phoneNumber.matches(value.regex))
				return true;
		}
		return false;
	}

	public static CountryCodeEnum getCountryCodeEnumByCountryCode(int countryCode) {

		for (CountryCodeEnum value : values()) {
			if (countryCode == value.code)
				return value;
		}
		return COUNTRY_NOT_MAPPED;
	}

}
