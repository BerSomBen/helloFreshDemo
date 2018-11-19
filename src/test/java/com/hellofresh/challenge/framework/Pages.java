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

/**
 * wrapper for all pages that are implemented in page pattern of this framework
 * 
 * @author benja
 *
 */
public class Pages {
	public Home Home = null;
	public Category Category = null;
	public Product Product = null;
	public Authentication Authentication = null;
	public Any Any = null;
	public Account Account = null;
	public Cart Cart = null;
	public Order Order = null;

	public Home getHome() {
		return Home;
	}

	public Category getCategory() {
		return Category;
	}

	public Product getProduct() {
		return Product;
	}

	public Authentication getAuthentication() {
		return Authentication;
	}

	public Any getAny() {
		return Any;
	}

	public Account getAccount() {
		return Account;
	}

	public Cart getCart() {
		return Cart;
	}

	public Order getOrder() {
		return Order;
	}

	/**
	 * constructor for all of them
	 * 
	 * @param driver initialised webdriver
	 */
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
