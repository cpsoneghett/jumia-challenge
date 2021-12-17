package com.jumia.challenge.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jumia.challenge.api.domain.model.Customer;
import com.jumia.challenge.api.domain.vo.CustomerVo;

@SpringBootTest
class PhoneValidatorServiceTest {

	@Autowired
	private PhoneValidatorService phoneValidatorService;

	@Test
	void phoneValidationInformationInvalidCustomerTest() {
		CustomerVo customer = invalidCustomerMock();

		phoneValidatorService.validatePhoneInformations(customer);

		assertEquals(55, customer.getCountryCode());
		assertEquals("Not valid", customer.getState());
		assertEquals("COUNTRY NOT MAPPED", customer.getCountryName());

	}

	@Test
	void phoneValidationInformationValidCustomerTest() {
		CustomerVo customer = validCustomerMock();

		phoneValidatorService.validatePhoneInformations(customer);

		assertEquals(237, customer.getCountryCode());
		assertEquals("Valid", customer.getState());
		assertEquals("Cameroon", customer.getCountryName());
	}

	@Test
	void phoneValidationInformationInvalidPhoneNumberTest() {

		CustomerVo customer = invalidCustomerMock01();

		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> phoneValidatorService.validatePhoneInformations(customer));

		assertTrue(
				thrown.getMessage().contains("During the parse of phone number, the number didn't match the pattern."));

	}

	private CustomerVo validCustomerMock() {
		Customer c = new Customer(1L, "Christiano Soneghett", "(237) 673122155");

		return new CustomerVo(c);
	}

	private CustomerVo invalidCustomerMock() {
		Customer c = new Customer(999L, "Weird Customer", "(55) 111122333");

		return new CustomerVo(c);
	}

	private CustomerVo invalidCustomerMock01() {
		Customer c = new Customer(1111L, "Weird Customer 01", "1111111122333");

		return new CustomerVo(c);
	}
}
