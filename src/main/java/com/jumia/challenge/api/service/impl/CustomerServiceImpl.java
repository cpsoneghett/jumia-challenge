package com.jumia.challenge.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jumia.challenge.api.domain.dao.CustomerDao;
import com.jumia.challenge.api.domain.model.Customer;
import com.jumia.challenge.api.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	private static final long serialVersionUID = 1L;

	@Autowired
	private CustomerDao customerDao;

	@Override
	public List<Customer> findAll() {
		return customerDao.findAll();
	}

	@Override
	public int totalCustomersCount() {
		return customerDao.totalCustomersCount();
	}

}
