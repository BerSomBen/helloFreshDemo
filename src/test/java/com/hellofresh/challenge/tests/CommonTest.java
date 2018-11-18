package com.hellofresh.challenge.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hellofresh.challenge.commons.Settings;
import com.hellofresh.challenge.framework.AutomationPracticeFramework;

/**
 * these tests should verify global aspects of the given task, like logging,
 * starting driver, reading config file etc..
 * 
 * @author benja
 *
 */
public class CommonTest {

	ChromeDriver driver;

	/**
	 * test verifies that reading config file is working
	 */
	@Test
	public void test_settingRead() {
		assertEquals(new String(), Settings.BROWSER);
		Settings.load();
		assertEquals("chrome", Settings.BROWSER);
	}

	/**
	 * when setting up chromedriver on windows, executable file is missing... test
	 * to check that out.. crap should use dynamic factory and get all dependencies
	 * on runtime
	 */

	@Test
	public void test_startChromedriver() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://automationpractice.com/index.php");
		assertEquals("http://automationpractice.com/index.php", driver.getCurrentUrl());
		driver.close();
	}

	/**
	 * checkes logging of framework
	 */
	@Test
	public void test_initFramework() {

		new AutomationPracticeFramework(driver, new WebDriverWait(driver, 10 * 1000));
		assertTrue(new File(".\\logging.log").exists());
	}
}
