package com.jumia.challenge.api.domain.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.jumia.challenge.api.domain.dao.CustomerDao;
import com.jumia.challenge.api.domain.entity.Customer;

@Component
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Customer> findAll() {

		List<Customer> customers = jdbcTemplate.query("SELECT * FROM customer",
				(resultSet, rowNum) -> new Customer(resultSet.getLong("id"), resultSet.getString("name"),
						resultSet.getString("phone")));

		customers.forEach(System.out::println);

		return customers;
	}

}
