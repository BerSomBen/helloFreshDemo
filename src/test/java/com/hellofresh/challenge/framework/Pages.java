package com.hellofresh.challenge.framework;

import org.openqa.selenium.WebDriver;

import com.hellofresh.challenge.pages.Account;
import com.hellofresh.challenge.pages.Any;
import com.hellofresh.challenge.pages.Authentication;
import com.hellofresh.challenge.pages.Cart;
import com.hellofresh.challenge.pages.Category;
import com.hellofresh.challenge.pages.Home;
import com.hellofresh.challenge.pages.Order;
import com.hellofresh.challenge.pages.Product;

public class Pages {
	public Home Home = null;
	public Category Category = null;
	public Product Product = null;
	public Authentication Authentication = null;
	public Any Any = null;
	public Account Account;
	public Cart Cart;
	public Order Order;

	public Pages(WebDriver driver) {
		Home = new Home(driver);
		Product = new Product(driver);
		Authentication = new Authentication(driver);
		Any = new Any(driver);
		Account = new Account(driver);
		Cart = new Cart(driver);
		Order = new Order(driver);
	}
}
