package com.jumia.challenge.validation.phone;

import java.io.Serializable;

import com.jumia.challenge.api.enums.CountryCodeEnum;

public interface CountryPhoneValidator extends Serializable {

	boolean validate(CountryCodeEnum countryCodeEnum, String phoneNumber);

	CountryCodeEnum getCountryCodeEnum();
}
