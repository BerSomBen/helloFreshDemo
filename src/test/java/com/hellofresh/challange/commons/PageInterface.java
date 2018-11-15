package com.hellofresh.challange.commons;

/**
 * Interface of all pages that must be implemented for the tests
 * 
 * @author benja
 *
 */
public interface PageInterface {

	/**
	 * This function must realize, that your webdriver is going to the specific
	 * page, no matter where we are right now.
	 */
	public void goTo();

	/**
	 * This function must return true if we are on the given page and return false,
	 * if not.
	 * 
	 * @return {@link Boolean} true: we are on that page false: we are not
	 */
	public boolean isAt();
	
	
}
