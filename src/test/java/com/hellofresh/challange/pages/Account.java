package com.hellofresh.challange.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hellofresh.challange.commons.AbstractPage;
import com.hellofresh.challange.commons.Settings;

public class Account extends AbstractPage {

	public Account(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void goTo() {
		driver.get(Settings.HOMEURL + "?controller=my-account");
	}

	@Override
	public boolean isAt() {
		// TODO Auto-generated method stub
		return execScript("return page_name;").equals("my_account");
	}
	
	public By input_logout() {
		return (By.className("logout"));
	}

}
