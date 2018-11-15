package com.hellofresh.challange.tests;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hellofresh.challange.framework.Framework;

public class PagesTests {

	static WebDriver driver;
	static WebDriverWait wait;
	static Framework framework;

	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10, 50);

		driver.get("http://www.google.de");
		framework = new Framework(driver, wait);
	}

	@Test
	public void test_Index_GoTo() {
		framework.pages.Home.goTo();
		assertTrue(framework.pages.Home.isAt());
	}

	@Test
	public void test_Category_GoTo() {
		framework.pages.Category.goTo();
		assertTrue(framework.pages.Category.isAt());
	}

	@Test
	public void test_Product_GoTo() {
		framework.pages.Product.goTo();
		assertTrue(framework.pages.Product.isAt());
	}

	@Test
	public void test_Authentification_GoTo() {
		framework.pages.Authentication.goTo();
		assertTrue(framework.pages.Authentication.isAt());
	}

}
