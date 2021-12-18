package com.jumia.challenge.api.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jumia.challenge.api.domain.model.Customer;
import com.jumia.challenge.api.domain.vo.CustomerVo;
import com.jumia.challenge.api.service.PhoneValidatorService;

@Component
public class CustomerVoMapper implements AbstractMapper<List<Customer>, List<CustomerVo>> {

	@Autowired
	private PhoneValidatorService phoneValidatorService;

	@Override
	public List<CustomerVo> sourceToDestination(List<Customer> customers) {

		List<CustomerVo> customersVo = new ArrayList<>();

		customers.forEach(c -> customersVo.add(new CustomerVo(c)));

		customersVo.forEach(phoneValidatorService::validatePhoneInformations);

		return customersVo;
	}

	@Override
	public List<Customer> destinationToSource(List<CustomerVo> destination) {

		return null;
	}

}
