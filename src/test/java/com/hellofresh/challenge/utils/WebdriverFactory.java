package com.hellofresh.challenge.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.hellofresh.challenge.commons.Settings;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;

public class WebdriverFactory {

	// Get a new WebDriver Instance.
	// There are various implementations for this depending on browser. The required
	// browser can be set as an environment variable.
	// Refer
	// http://getgauge.io/documentation/user/current/managing_environments/README.html
	public static WebDriver getDriver(String browser ) {

		if (browser == null) {
			ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
			return new ChromeDriver();
		}
		switch (browser) {
		case "IE":
			InternetExplorerDriverManager.getInstance(DriverManagerType.IEXPLORER).setup();
			return new InternetExplorerDriver();
		case "FIREFOX":
			FirefoxDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
			return new FirefoxDriver();
		default:
			ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
			return new ChromeDriver();

		}
	}
}