package com.hellofresh.challange.pages;

import org.openqa.selenium.WebDriver;

import com.hellofresh.challange.commons.AbstractPage;
import com.hellofresh.challange.commons.Settings;

public class Category extends AbstractPage {

	public Category(WebDriver _driver) {
		super(_driver);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void goTo() {
		this.driver.get(Settings.HOMEURL + "?controller=category&id_category=" + Settings.SAMPLECATEGORYID);
	}

	public boolean isAt() {
		String currPage = execScript("return page_name;");
		return currPage.equals("category");
	}

}
