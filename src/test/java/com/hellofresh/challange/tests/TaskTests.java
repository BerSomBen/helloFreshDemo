package com.hellofresh.challange.tests;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hellofresh.challange.commons.User;
import com.hellofresh.challange.framework.Framework;

public class TaskTests {

	static WebDriver driver;
	static WebDriverWait wait;
	static Framework framework;
	static User user;

	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10, 50);

		framework = new Framework(driver, wait);

		user = User.generateUnique();
	}

	@Test
	public void signInTest() {

		framework.workflows.signUpUser(user);

		WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));
		assertEquals(heading.getText(), "MY ACCOUNT");
		assertEquals(driver.findElement(By.className("account")).getText(), user.name + " " + user.surname);
		assertTrue(driver.findElement(By.className("info-account")).getText().contains("Welcome to your account."));
		assertTrue(driver.findElement(By.className("logout")).isDisplayed());
		assertTrue(driver.getCurrentUrl().contains("controller=my-account"));
		assertEquals("1", framework.pages.Authentication.execScript("return isLogged;"));
	}

}
