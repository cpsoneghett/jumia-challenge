package com.jumia.challenge.api.domain.vo;

import org.springframework.beans.BeanUtils;

import com.jumia.challenge.api.domain.entity.Customer;
import com.jumia.challenge.api.enums.CountryCodeEnum;

public class CustomerVo {

	private Long id;
	private String name;
	private String phone;
	private CountryCodeEnum countryCode;
	
	

	public CustomerVo(Customer customer) {
		BeanUtils.copyProperties(customer, this);
		this.countryCode = CountryCodeEnum.getCountryCodeEnumByPhoneNumber(customer.getPhone());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public CountryCodeEnum getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(CountryCodeEnum countryCode) {
		this.countryCode = countryCode;
	}

}
