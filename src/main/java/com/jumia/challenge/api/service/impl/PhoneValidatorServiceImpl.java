package com.jumia.challenge.api.service.impl;

import org.springframework.stereotype.Service;

import com.jumia.challenge.api.domain.vo.CustomerVo;
import com.jumia.challenge.api.enums.CountryCodeEnum;
import com.jumia.challenge.api.enums.StateEnum;
import com.jumia.challenge.api.service.PhoneValidatorService;

@Service
public class PhoneValidatorServiceImpl implements PhoneValidatorService {

	private static final long serialVersionUID = 1L;

	@Override
	public void validatePhoneInformations(CustomerVo customer) {

		var phoneNumber = customer.getPhone();

		var countryCode = Integer.parseInt(phoneNumber.substring(1, 4));
		var cce = CountryCodeEnum.getCountryCodeEnumByCountryCode(countryCode);

		customer.setCountryCode(cce.getCode());
		customer.setCountryName(cce.getCountry());
		customer.setState(validateState(phoneNumber));
	}

	private String validateState(String phoneNumber) {

		var isValid = CountryCodeEnum.validadePhoneNumberByRegex(phoneNumber);

		if (isValid)
			return StateEnum.VALID.getDescription();
		else
			return StateEnum.NOT_VALID.getDescription();
	}

}
