package com.jumia.challenge.api.domain.model;

public class Customer extends BaseModel {

	private static final long serialVersionUID = 3461149946207344878L;

	private String name;
	private String phone;

	public Customer(Long id, String name, String phone) {
		this.id = id;
		this.name = name;
		this.phone = phone;
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

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}
	
	

}
