package com.hellofresh.challenge.tests;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.PropertyConfigurator;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hellofresh.challenge.commons.Article;
import com.hellofresh.challenge.commons.ScreenshotTestRule;
import com.hellofresh.challenge.commons.Settings;
import com.hellofresh.challenge.commons.User;
import com.hellofresh.challenge.enums.Payment;
import com.hellofresh.challenge.enums.Shipping;
import com.hellofresh.challenge.framework.Framework;
import com.hellofresh.challenge.utils.WebdriverFactory;

public class TaskTests {

	static WebDriver driver;
	static WebDriverWait wait;
	static Framework framework;
	static User user;

	@Rule
	public ScreenshotTestRule screenshotTestRule = new ScreenshotTestRule(driver);

	@BeforeClass
	public static void setUp() {
		PropertyConfigurator.configure("log4j.properties");
		Settings.load();
		
		driver = WebdriverFactory.getDriver(Settings.browser);
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

	@Test
	public void logInTest() {
		User user = User.getExistingUser();

		if (framework.workflows.isSignedIn())
			framework.workflows.logoutUser();

		if (framework.workflows.signInUser(user)) {

			WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));
			assertEquals("MY ACCOUNT", heading.getText());
			assertEquals(user.getFullName(), driver.findElement(By.className("account")).getText());
			assertTrue(driver.findElement(By.className("info-account")).getText().contains("Welcome to your account."));
			assertTrue(driver.findElement(By.className("logout")).isDisplayed());
			assertTrue(driver.getCurrentUrl().contains("controller=my-account"));
		} else
			fail("not logged in");
	}

	@Test
	public void checkoutTest() {
		User user = User.getExistingUser();
		Payment bank = Payment.BANKWIRE;
		Shipping std = Shipping.STANDARD;
		List<Article> articles = new ArrayList<Article>();
		articles.add(Article.getDefaultArticle());

		framework.workflows.checkout(user, bank, std, articles);

		WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));

		assertEquals("ORDER CONFIRMATION", heading.getText());
		assertTrue(driver.findElement(By.xpath("//li[@class='step_done step_done_last four']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//li[@id='step_end' and @class='step_current last']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//*[@class='cheque-indent']/strong")).getText()
				.contains("Your order on My Store is complete."));
		assertTrue(driver.getCurrentUrl().contains("controller=order-confirmation"));

	}

}
