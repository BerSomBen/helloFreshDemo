package com.hellofresh.challange.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.hellofresh.challange.commons.AbstractPage;
import com.hellofresh.challange.commons.Settings;

public class Authentication extends AbstractPage {

	public Authentication(WebDriver _driver) {
		super(_driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void goTo() {
		this.driver.get(Settings.HOMEURL + "?controller=authentication&back=my-account");
	}

	public boolean isAt() {
		String currPage = execScript("return page_name;");
		return currPage.equals("authentication");
	}

	public By inputEmail() {
		return By.id("email_create");
	}

	public By inputMale() {
		return By.id("id_gender1");
	}

	public By inputFemale() {
		return By.id("id_gender2");
	}

	public By inputSubmitCreate() {
		return By.id("SubmitCreate");
	}

	public By inputCustomer_firstname() {
		return By.id("customer_firstname");
	}

	public By inputCustomer_lastname() {
		return By.id("customer_lastname");
	}

	public By inputPasswd() {
		return By.id("passwd");
	}

	public Select selectDays() {
		return new Select(driver.findElement(By.id("days")));
	}

	public Select selectMonths() {
		return new Select(driver.findElement(By.id("months")));
	}

	public Select selectYears() {
		return new Select(driver.findElement(By.id("years")));
	}

	public Select selectState() {
		return new Select(driver.findElement(By.id("id_state")));
	}

	public By inputCompany() {
		return (By.id("company"));
	}

	public By inputCity() {
		return (By.id("city"));
	}

	
	public By inputAddress1() {
		return (By.id("address1"));
	}

	public By inputAddress2() {
		return (By.id("address2"));
	}

	public By inputPhone_mobile() {
		return (By.id("phone_mobile"));
	}

	public By inputPhone() {
		return (By.id("phone"));
	}

	public By inputOther() {
		return (By.id("other"));
	}

	public By inputPostcode() {
		return (By.id("postcode"));
	}

	public By inputAlias() {
		return (By.id("alias"));
	}

	public By inputSubmitAccount() {
		return (By.id("submitAccount"));

	}

}
