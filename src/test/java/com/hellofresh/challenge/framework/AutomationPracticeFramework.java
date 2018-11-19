package com.hellofresh.challenge.framework;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hellofresh.challenge.commons.Settings;

/**
 * Framework that implements the page pattern to automate the demo application
 * 
 * @author benja
 *
 */
public class AutomationPracticeFramework {

	/**
	 * logger instance
	 */
	private Logger logger;

	/**
	 * Pages object to wrap all pages, implemented in page pattern
	 */
	private Pages pages = null;

	/**
	 * Workflows to divide logical actions from hardcoded identss
	 */
	private Workflows workflows = null;
	/**
	 * driver instance
	 */
	private WebDriver driver;

	/**
	 * Wait instance
	 */
	private WebDriverWait wait;

	/**
	 * getter for driver
	 * 
	 * @return
	 */
	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * getter for wait
	 * 
	 * @return
	 */
	public WebDriverWait getWait() {
		return wait;

	}

	/**
	 * Constructor with Wait and Driver, initialized outsite to loose couple
	 * 
	 * @param _driver
	 * @param _wait
	 */
	public AutomationPracticeFramework(WebDriver _driver, WebDriverWait _wait) {
		this.wait = _wait;
		this.driver = _driver;

		logger = Logger.getLogger(this.getClass().getName());
		logger.info("Driver: " + Settings.BROWSER + " loaded");

		pages = new Pages(driver);
		workflows = new Workflows(this);
	}

	/**
	 * getter for pages
	 * 
	 * @return
	 */
	public Pages getPages() {
		return pages;
	}

	/**
	 * getter for workflows
	 * 
	 * @return
	 */
	public Workflows getWorkflows() {
		return workflows;
	}

}
