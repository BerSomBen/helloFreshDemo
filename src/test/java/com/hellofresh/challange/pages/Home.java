package com.hellofresh.challange.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hellofresh.challange.commons.AbstractPage;
import com.hellofresh.challange.commons.Settings;

public class Home extends AbstractPage {

	public Home(WebDriver _driver) {
		super(_driver);
	}

	public void goTo() {
		this.driver.get(Settings.HOMEURL);
	}

	public boolean isAt() {
		String currPage = execScript("return page_name;");
		return currPage.equals("index");
	}
	
	
	public By btnLogin() {
		return By.className("login");

	}

}
