package com.hellofresh.challenge.framework;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hellofresh.challenge.commons.Settings;

public class Framework {

	private Logger logger;

	public Pages pages = null;
	public Workflows workflows = null;
	private WebDriver driver;
	private WebDriverWait wait;

	public WebDriver getDriver() {
		return driver;
	}

	public WebDriverWait getWait() {
		return wait;
	}

	public Framework(WebDriver _driver, WebDriverWait _wait) {
		this.wait = _wait;
		this.driver = _driver;

		logger = Logger.getLogger(this.getClass().getName());
		logger.info("Driver: " + Settings.browser + " loaded");

		pages = new Pages(driver);
		workflows = new Workflows(this);
	}

}
