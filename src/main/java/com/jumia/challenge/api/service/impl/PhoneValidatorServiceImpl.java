package com.jumia.challenge.api.service.impl;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jumia.challenge.api.domain.vo.CustomerVo;
import com.jumia.challenge.api.enums.CountryCodeEnum;
import com.jumia.challenge.api.enums.StateEnum;
import com.jumia.challenge.api.service.PhoneValidatorService;
import com.jumia.challenge.exception.CountryValidatorNotFoundException;
import com.jumia.challenge.validation.phone.CountryPhoneFactory;

@Service
public class PhoneValidatorServiceImpl implements PhoneValidatorService {

	private static final long serialVersionUID = 1L;

	private static final String NUMBER_BETWEEN_PARENTHESIS_REGEX = "^.*?\\([^\\d]*(\\d+)[^\\d]*\\).*$";

	@Autowired
	private CountryPhoneFactory countryPhoneFactory;

	@Override
	public void validatePhoneInformations(CustomerVo customer) {

		var phoneNumber = customer.getPhone();

		var pattern = Pattern.compile(NUMBER_BETWEEN_PARENTHESIS_REGEX);
		var matches = pattern.matcher(phoneNumber);

		if (matches.matches()) {
			var countryCode = Integer.parseInt(matches.group(1));
			var cce = CountryCodeEnum.getCountryCodeEnumByCountryCode(countryCode);

			customer.setCountryCode(cce.getCode() == 0 ? countryCode : cce.getCode());
			customer.setCountryName(cce.getCountry());
			customer.setState(validateState(cce, phoneNumber));

		} else {
			throw new IllegalArgumentException(
					"During the parse of phone number, the number didn't match the pattern. Please verify the number input of the following Customer: \n"
							+ customer.toString());
		}

	}

	private String validateState(CountryCodeEnum cce, String phoneNumber) {

		try {
			var countryPhoneValidator = countryPhoneFactory.getStrategy(cce);

			if (countryPhoneValidator.validate(cce, phoneNumber))
				return StateEnum.VALID.getDescription();
			else
				return StateEnum.NOT_VALID.getDescription();
		} catch (CountryValidatorNotFoundException e) {
			return StateEnum.NOT_VALID.getDescription();
		}
	}

}
