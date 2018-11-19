package com.hellofresh.challenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hellofresh.challenge.commons.AbstractPage;
import com.hellofresh.challenge.commons.Settings;

public class Product extends AbstractPage {

	public Product(WebDriver _driver) {
		super(_driver);
		// TODO Auto-generated constructor stub
	}

	public void goTo() {
		goToSpecific(Integer.parseInt(Settings.SAMPLEPRODUCTID));
	}

	public boolean isAt() {
		String currPage = execScript("return page_name;");
		return currPage.equals("product");
	}

	public void goToSpecific(int productId) {
		this.driver.get(Settings.HOMEURL + "?controller=product&id_product=" + productId);
	}

	public boolean isAtSpecific(int productId) {
		boolean isAtSpecific = Boolean
				.parseBoolean(execScript("return page_name === \"product\" && id_product === " + productId + ";"));
		return isAtSpecific;
	}

	public boolean isBuyable() {
		return driver.findElement(toCartBtn()).isEnabled();

	}

	private By toCartBtn() {
		return By.xpath("//p[@id='add_to_cart']/button");
	}

	public void closeLayerCart() {
		driver.findElement(By.xpath("//span[@class='cross']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("layer_cart")));
	}

	public boolean AddToCart() {
		driver.findElement(toCartBtn()).click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("layer_cart")));
		closeLayerCart();

		return true;

	}
}
