package com.hellofresh.challenge.entitys;

/**
 * enum for shipping type. Since only one option, no matter how to store... to
 * be open for more, make use of enum. since name and id are different , added
 * action method to enable mapping
 * 
 * @author benja
 *
 */
public enum Shipping {
	STANDARD("delivery_option_59258_0");

	private String action;

	/**
	 * getter method of action name
	 * 
	 * @return
	 */
	public String getAction() {
		return this.action;
	}

	/**
	 * enum constructor - cannot be public or protected
	 * 
	 * @param action
	 */
	private Shipping(String action) {
		this.action = action;
	}
}
