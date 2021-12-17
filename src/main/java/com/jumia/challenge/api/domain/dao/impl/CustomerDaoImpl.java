package com.jumia.challenge.api.domain.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.jumia.challenge.api.domain.dao.CustomerDao;
import com.jumia.challenge.api.domain.model.Customer;

@Component
public class CustomerDaoImpl implements CustomerDao {

	private static final long serialVersionUID = 1L;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Customer> findAll() {

		return jdbcTemplate.query("select * from customer", (resultSet, rowNum) -> new Customer(resultSet.getLong("id"),
				resultSet.getString("name"), resultSet.getString("phone")));
	}

	@Override
	public int totalCustomersCount() {
		var sql = "select count(1) from customer";
		return jdbcTemplate.queryForList(sql, Integer.class).get(0);
	}

}
