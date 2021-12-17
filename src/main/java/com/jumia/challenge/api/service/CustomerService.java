package com.jumia.challenge.api.service;

import java.io.Serializable;
import java.util.List;

import com.jumia.challenge.api.domain.model.Customer;

public interface CustomerService extends Serializable {

	List<Customer> findAll();

	int totalCustomersCount();

}
