package com.jumia.challenge.api.service;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jumia.challenge.api.domain.model.Customer;

@SpringBootTest
class CustomerServiceTest {

	@Autowired
	private CustomerService customerService;

	@Test
	void gettingListOfCustomersTest() {

		List<Customer> customers = customerService.findAll();

		for (Customer c : customers) {
			assertNotEquals(null, c.getId());
			assertNotEquals(null, c.getName());
			assertNotEquals(null, c.getPhone());
		}
	}

}
