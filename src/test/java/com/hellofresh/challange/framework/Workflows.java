package com.hellofresh.challange.framework;

import static junit.framework.TestCase.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;

import com.hellofresh.challange.commons.User;

public class Workflows {

	private Framework framework = null;

	public Workflows(Framework _framework) {
		framework = _framework;

	}

	public void signUpUser(User user) {
		framework.pages.Home.goTo();
		framework.getWait().until(ExpectedConditions.visibilityOfElementLocated(framework.pages.Home.btnLogin()))
				.click();
		assertTrue(framework.pages.Authentication.isAt());
		framework.getDriver().findElement(framework.pages.Authentication.inputEmail()).sendKeys(user.email);
		framework.getDriver().findElement(framework.pages.Authentication.inputSubmitCreate()).click();

		if (user.male) {
			framework.getWait()
					.until(ExpectedConditions.visibilityOfElementLocated(framework.pages.Authentication.inputMale()))
					.click();
		} else {
			framework.getWait()
					.until(ExpectedConditions.visibilityOfElementLocated(framework.pages.Authentication.inputFemale()))
					.click();
		}
		framework.getDriver().findElement(framework.pages.Authentication.inputCustomer_firstname()).sendKeys(user.name);
		framework.getDriver().findElement(framework.pages.Authentication.inputCustomer_lastname())
				.sendKeys(user.surname);
		framework.getDriver().findElement(framework.pages.Authentication.inputPasswd()).sendKeys(user.passwd);
		framework.pages.Authentication.selectDays().selectByValue("" + user.birth_day);
		framework.pages.Authentication.selectMonths().selectByValue("" + user.birth_month);
		framework.pages.Authentication.selectYears().selectByValue("" + user.birth_year);
		framework.getDriver().findElement(framework.pages.Authentication.inputCompany()).sendKeys(user.company);
		framework.getDriver().findElement(framework.pages.Authentication.inputAddress1()).sendKeys(user.adress1);
		framework.getDriver().findElement(framework.pages.Authentication.inputAddress2()).sendKeys(user.adress2);
		framework.getDriver().findElement(framework.pages.Authentication.inputCity()).sendKeys(user.city);
		framework.pages.Authentication.selectState().selectByVisibleText(user.state);
		framework.getDriver().findElement(framework.pages.Authentication.inputPostcode()).sendKeys(user.zip);
		framework.getDriver().findElement(framework.pages.Authentication.inputOther()).sendKeys(user.other);
		framework.getDriver().findElement(framework.pages.Authentication.inputPhone()).sendKeys(user.phone);
		framework.getDriver().findElement(framework.pages.Authentication.inputPhone_mobile())
				.sendKeys(user.phone_mobile);
		framework.getDriver().findElement(framework.pages.Authentication.inputAlias()).sendKeys(user.alias);

		framework.getDriver().findElement(framework.pages.Authentication.inputSubmitAccount()).click();

	}
}
