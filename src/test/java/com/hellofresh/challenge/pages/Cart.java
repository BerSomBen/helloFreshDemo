package com.hellofresh.challenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hellofresh.challenge.commons.AbstractPage;

public class Cart extends AbstractPage {

	public Cart(WebDriver driver) {
		super(driver);
	}

	@Override
	public boolean isAt() {
		return driver.findElements(By.id("cart_title")).size() > 0;
	}

	@Override
	public void goTo() {
		driver.findElement(By.xpath("//a[@title='View my shopping cart']")).click();
	}

	public boolean canCheckOut() {
		return driver.findElements(checkoutBtn()).size() > 0;
	}

	private By checkoutBtn() { 

		return By.xpath("//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']");
	}

	public void proceedToCheckout() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn())).click();
	}

}