package com.jumia.challenge.api.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.jumia.challenge.api.domain.model.Customer;
import com.jumia.challenge.api.domain.vo.CustomerVo;

@SpringBootTest
class CustomerVoTest {

	@Test
	void comparingCustomersTest() {

		Customer customer = new Customer(1L, "Christiano Soneghett", "(55) 27992944048");
		CustomerVo c1 = new CustomerVo(customer);
		CustomerVo c2 = new CustomerVo(customer);

		assertEquals(c1, c2);
		assertEquals(true, c1.equals(c1));
		assertNotEquals(null, c1);
		assertEquals(c1.hashCode(), c2.hashCode());
	}

}
