package com.hellofresh.challenge.commons;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * This is an abstract class to provide the selenium page pattern towards all
 * extended pages
 * 
 * @author benja
 *
 */
public abstract class AbstractPage implements PageInterface {

	/**
	 * instance of webdriver of the specific page
	 */
	protected WebDriver driver;

	/**
	 * base constructor should store the driver per page
	 * 
	 * @param driver Webdriver instance initialized towards this test runner
	 */
	public AbstractPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * this function provides the ability to run js on each single page without the
	 * need of casting everytime
	 * 
	 * @param script js to be run
	 * @return interpreted js result
	 */
	public String execScript(String script) {
		return ((JavascriptExecutor) driver).executeScript(script).toString();
	}

	/**
	 * this function must be overwritten by real implementation. It must answer with
	 * true or false if the driver is currently on the expected page or not
	 */
	public boolean isAt() {
		throw new UnsupportedOperationException("Function must be overwritten");

	}

	/**
	 * This function must be overwritten by real implementation. It must provide a
	 * proven way to go to the specific page.
	 */
	public void goTo() {
		throw new UnsupportedOperationException("Function must be overwritten");
	}
}
