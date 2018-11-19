package com.hellofresh.challenge.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.FirefoxDriverManager;

public class WebdriverFactory {
	/**
	 * static getter to avoid committing static chromedriver, firefoxdriver etc.
	 * towards sourcecode.
	 * 
	 * @param browser
	 * @return
	 */
	public static WebDriver getDriver(String browser) {

		if (browser == null) {
			ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
			return new ChromeDriver();
		}
		switch (browser) {
		case "FIREFOX":
			FirefoxDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
			return new FirefoxDriver();
		default:
			ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
			return new ChromeDriver();

		}
	}
}