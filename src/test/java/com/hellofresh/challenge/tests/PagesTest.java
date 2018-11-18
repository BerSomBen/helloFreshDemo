package com.hellofresh.challenge.tests;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hellofresh.challenge.framework.AutomationPracticeFramework;

/**
 * Tests the page pattern implemented
 * 
 * @author benja
 *
 */
public class PagesTest {

	static WebDriver driver;
	static WebDriverWait wait;
	static AutomationPracticeFramework framework;

	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10, 50);

		driver.get("http://www.google.de");
		framework = new AutomationPracticeFramework(driver, wait);
	}

	@Test
	public void test_Index_GoTo() {
		framework.getPages().Home.goTo();
		assertTrue(framework.getPages().Home.isAt());
	}

	@Test
	public void test_Category_GoTo() {
		framework.getPages().Category.goTo();
		assertTrue(framework.getPages().Category.isAt());
	}

	@Test
	public void test_Product_GoTo() {
		framework.getPages().Product.goTo();
		assertTrue(framework.getPages().Product.isAt());
	}

	@Test
	public void test_Authentification_GoTo() {
		framework.getPages().Authentication.goTo();
		assertTrue(framework.getPages().Authentication.isAt());
	}

}
