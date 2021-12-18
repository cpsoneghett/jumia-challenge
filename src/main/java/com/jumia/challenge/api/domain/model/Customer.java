package com.jumia.challenge.api.domain.model;

import javax.persistence.Entity;

@Entity
public class Customer extends BaseModel {

	private static final long serialVersionUID = 3461149946207344878L;

	private String name;
	private String phone;

	public Customer() {
	}

	public Customer(Long id, String name, String phone) {
		this.id = id;
		this.name = name;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

}
