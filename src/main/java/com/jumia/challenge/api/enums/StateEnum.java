package com.jumia.challenge.api.enums;

public enum StateEnum {

	VALID("Valid"), NOT_VALID("Not valid");

	private String description;

	private StateEnum(String state) {
		this.description = state;
	}

	public String getDescription() {
		return description;
	}
}
