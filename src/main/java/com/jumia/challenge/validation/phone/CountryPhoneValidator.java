package com.jumia.challenge.validation.phone;

import com.jumia.challenge.api.enums.CountryCodeEnum;

public interface CountryPhoneValidator {

	boolean validate(CountryCodeEnum countryCodeEnum, String phoneNumber);

	CountryCodeEnum getCountryCodeEnum();
}
