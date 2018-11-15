package com.hellofresh.challange.pages;

import org.openqa.selenium.WebDriver;

import com.hellofresh.challange.commons.AbstractPage;
import com.hellofresh.challange.commons.Settings;

public class Product extends AbstractPage {

	public Product(WebDriver _driver) {
		super(_driver);
		// TODO Auto-generated constructor stub
	}

	public void goTo() {
		this.driver.get(Settings.HOMEURL + "?controller=product&id_product=" + Settings.SAMPLEPRODUCTID);
	}

	public boolean isAt() {
		String currPage = execScript("return page_name;");
		return currPage.equals("product");
	}

}
