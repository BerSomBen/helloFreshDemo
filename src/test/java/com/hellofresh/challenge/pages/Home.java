package com.hellofresh.challenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hellofresh.challenge.commons.AbstractPage;
import com.hellofresh.challenge.commons.Settings;

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
