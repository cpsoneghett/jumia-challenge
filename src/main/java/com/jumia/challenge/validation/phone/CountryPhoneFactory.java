package com.jumia.challenge.validation.phone;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jumia.challenge.api.enums.CountryCodeEnum;
import com.jumia.challenge.exception.CountryValidatorNotFoundException;

@Component
public class CountryPhoneFactory {

	private Map<CountryCodeEnum, CountryPhoneValidator> strategies;

	@Autowired
	public CountryPhoneFactory(Set<CountryPhoneValidator> strategiesImpl) {
		createStrategy(strategiesImpl);
	}

	private void createStrategy(Set<CountryPhoneValidator> strategiesImpl) {
		strategies = new EnumMap<>(CountryCodeEnum.class);

		strategiesImpl.forEach(strategy -> strategies.put(strategy.getCountryCodeEnum(), strategy));
	}

	public CountryPhoneValidator getStrategy(CountryCodeEnum countryCodeEnum) throws CountryValidatorNotFoundException {
		CountryPhoneValidator validator = strategies.get(countryCodeEnum);

		if (validator != null)
			return validator;
		else
			throw new CountryValidatorNotFoundException("It wasn't found any validator for the country "
					+ countryCodeEnum.getCountry() + ". It has to be implemented.");
	}

}
