package com.hellofresh.challenge.framework;

import static junit.framework.TestCase.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.hellofresh.challenge.commons.Article;
import com.hellofresh.challenge.commons.User;
import com.hellofresh.challenge.enums.Payment;
import com.hellofresh.challenge.enums.Shipping;

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

	public boolean signInUser(User user) {

		if (isSignedIn())
			return true;

		framework.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.className("login"))).click();
		framework.getDriver().findElement(By.id("email")).sendKeys(user.email);
		framework.getDriver().findElement(By.id("passwd")).sendKeys(user.passwd);
		framework.getDriver().findElement(By.id("SubmitLogin")).click();

		return isSignedIn();
	}

	public boolean logoutUser() {
		if (isSignedIn()) {
			framework.pages.Account.goTo();
			framework.getWait()
					.until(ExpectedConditions.visibilityOfElementLocated(framework.pages.Account.input_logout()))
					.click();
		}
		return false;
	}

	public boolean isSignedIn() {
		return framework.pages.Any.execScript("return isLogged").equals("1");
	}

	public void checkout(User user, Payment payment, Shipping shipping, List<Article> products) {
		framework.pages.Home.goTo();

		if (isSignedIn() && !isUserSignedIn(user)) {
			logoutUser();
		}
		signInUser(user);

		for (Article product : products) {

			framework.pages.Product.goToSpecific(product.productId);
			if (framework.pages.Product.isAtSpecific(product.productId) && framework.pages.Product.isBuyable()) {
				framework.pages.Product.AddToCart();
			}

		}

		framework.pages.Cart.goTo();
		framework.pages.Cart.proceedToCheckout();

		framework.pages.Order.Process(payment, shipping);

	}

	private boolean isUserSignedIn(User user) {
		String username = framework.getDriver().findElement(By.className("account")).getText();

		return username.equals(user.getFullName());
	}

}
