package com.jumia.challenge.api.domain.dao;

import java.io.Serializable;
import java.util.List;

import com.jumia.challenge.api.domain.model.Customer;

public interface CustomerDao extends Serializable {

	List<Customer> findAll();

	int totalCustomersCount();
}
