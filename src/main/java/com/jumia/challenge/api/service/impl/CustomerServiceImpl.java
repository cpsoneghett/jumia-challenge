package com.jumia.challenge.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jumia.challenge.api.domain.model.Customer;
import com.jumia.challenge.api.domain.repository.CustomerRepository;
import com.jumia.challenge.api.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	private static final long serialVersionUID = 1L;

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

}
