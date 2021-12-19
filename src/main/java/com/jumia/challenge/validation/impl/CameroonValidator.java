package com.jumia.challenge.validation.impl;

import org.springframework.stereotype.Component;

import com.jumia.challenge.api.enums.CountryCodeEnum;
import com.jumia.challenge.validation.phone.CountryPhoneValidator;

@Component
public class CameroonValidator implements CountryPhoneValidator {

	private static final long serialVersionUID = 1L;

	@Override
	public boolean validate(CountryCodeEnum countryCodeEnum, String phoneNumber) {
		return countryCodeEnum.getRegex() != null && phoneNumber.matches(countryCodeEnum.getRegex());
	}

	@Override
	public CountryCodeEnum getCountryCodeEnum() {
		return CountryCodeEnum.CAMEROON;
	}

}
