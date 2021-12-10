package com.jumia.challenge.api.service.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.jumia.challenge.api.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	private final JdbcTemplate jdbcTemplate;

	public CustomerServiceImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void validateTelephoneNumbers() {
		SqlRowSet resultSet = jdbcTemplate.queryForRowSet("SELECT * FROM customer");
		while (resultSet.next()) {
			System.out.println(resultSet.getString("name"));
		}

	}

}
