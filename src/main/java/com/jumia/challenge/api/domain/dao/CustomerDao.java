package com.jumia.challenge.api.domain.dao;

import java.util.List;

import com.jumia.challenge.api.domain.entity.Customer;

public interface CustomerDao {

	List<Customer> findAll();
}
