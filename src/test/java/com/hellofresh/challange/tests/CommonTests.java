package com.hellofresh.challange.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hellofresh.challange.commons.Settings;
import com.hellofresh.challange.framework.Framework;

public class CommonTests {

	ChromeDriver driver;

	@Test
	public void test_settingRead() {
		assertEquals(new String(), Settings.browser);
		Settings.load();
		assertEquals("chrome", Settings.browser);
	}

	@Test
	public void test_startChromedriver() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://automationpractice.com/index.php");
		assertEquals("http://automationpractice.com/index.php", driver.getCurrentUrl());
		driver.close();
	}

	@Test
	public void test_initFramework() {

		new Framework(driver, new WebDriverWait(driver, 10 * 1000));
		assertTrue(new File(".\\logging.log").exists());
	}
}
