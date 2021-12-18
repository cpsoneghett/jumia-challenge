package com.jumia.challenge.api.domain.vo;

import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.jumia.challenge.api.domain.model.Customer;

public class CustomerVo {

	private Long id;
	private String name;
	private String phone;
	private String countryName;
	private int countryCode;
	private String state;

	public CustomerVo(Customer customer) {
		BeanUtils.copyProperties(customer, this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public int getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(int countryCode) {
		this.countryCode = countryCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, phone, countryCode, state);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CustomerVo customer = (CustomerVo) o;
		return id == customer.id && Objects.equals(name, customer.name)
				&& Objects.equals(countryCode, customer.countryCode) && state == customer.state;
	}

	@Override
	public String toString() {
		return "CustomerVo [name=" + name + ", phone=" + phone + ", countryName=" + countryName + ", countryCode="
				+ countryCode + ", state=" + state + "]";
	}

}
