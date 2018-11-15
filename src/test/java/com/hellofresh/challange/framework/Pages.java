package com.hellofresh.challange.framework;

import org.openqa.selenium.WebDriver;

import com.hellofresh.challange.pages.Authentication;
import com.hellofresh.challange.pages.Category;
import com.hellofresh.challange.pages.Home;
import com.hellofresh.challange.pages.Product;

public class Pages {
	public Home Home = null;
	public Category Category = null;
	public Product Product = null;
	public Authentication Authentication = null;

	public Pages(WebDriver driver) {
		Home = new Home(driver);
		Product = new Product(driver);
		Authentication = new Authentication(driver);

	}
}
