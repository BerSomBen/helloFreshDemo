package com.hellofresh.challenge.enums;

public enum Shipping {
	STANDARD("delivery_option_59258_0");

	private String action;

	// getter method
	public String getAction() {
		return this.action;
	}

	// enum constructor - cannot be public or protected
	private Shipping(String action) {
		this.action = action;
	}
}
