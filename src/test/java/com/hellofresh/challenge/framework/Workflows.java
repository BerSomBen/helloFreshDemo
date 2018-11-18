package com.hellofresh.challenge.framework;

import static junit.framework.TestCase.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.hellofresh.challenge.entitys.Article;
import com.hellofresh.challenge.entitys.Payment;
import com.hellofresh.challenge.entitys.Shipping;
import com.hellofresh.challenge.entitys.User;

/**
 * wrapper for reusable workflows
 * 
 * @author benja
 *
 */
public class Workflows {

	/**
	 * framework instance to have access to all pages
	 */
	private AutomationPracticeFramework framework = null;

	/**
	 * constuctor to store framework
	 * 
	 * @param _framework
	 */
	public Workflows(AutomationPracticeFramework _framework) {
		framework = _framework;

	}

	/**
	 * Registration workflow.
	 * 
	 * TODO: this is a "perfect world example implementation" for real tests, this
	 * one must implement more invalid data checks like, mail is well formatted
	 * etc..
	 * 
	 * @param user user that should be registered
	 */
	public void signUpUser(User user) {
		framework.getPages().Home.goTo();
		framework.getWait().until(ExpectedConditions.visibilityOfElementLocated(framework.getPages().Home.btnLogin()))
				.click();
		assertTrue(framework.getPages().Authentication.isAt());
		framework.getDriver().findElement(framework.getPages().Authentication.inputEmail()).sendKeys(user.email);
		framework.getDriver().findElement(framework.getPages().Authentication.inputSubmitCreate()).click();

		if (user.male) {
			framework.getWait().until(
					ExpectedConditions.visibilityOfElementLocated(framework.getPages().Authentication.inputMale()))
					.click();
		} else {
			framework.getWait().until(
					ExpectedConditions.visibilityOfElementLocated(framework.getPages().Authentication.inputFemale()))
					.click();
		}
		framework.getDriver().findElement(framework.getPages().Authentication.inputCustomer_firstname())
				.sendKeys(user.name);
		framework.getDriver().findElement(framework.getPages().Authentication.inputCustomer_lastname())
				.sendKeys(user.surname);
		framework.getDriver().findElement(framework.getPages().Authentication.inputPasswd()).sendKeys(user.passwd);
		framework.getPages().Authentication.selectDays().selectByValue("" + user.birth_day);
		framework.getPages().Authentication.selectMonths().selectByValue("" + user.birth_month);
		framework.getPages().Authentication.selectYears().selectByValue("" + user.birth_year);
		framework.getDriver().findElement(framework.getPages().Authentication.inputCompany()).sendKeys(user.company);
		framework.getDriver().findElement(framework.getPages().Authentication.inputAddress1()).sendKeys(user.adress1);
		framework.getDriver().findElement(framework.getPages().Authentication.inputAddress2()).sendKeys(user.adress2);
		framework.getDriver().findElement(framework.getPages().Authentication.inputCity()).sendKeys(user.city);
		framework.getPages().Authentication.selectState().selectByVisibleText(user.state);
		framework.getDriver().findElement(framework.getPages().Authentication.inputPostcode()).sendKeys(user.zip);
		framework.getDriver().findElement(framework.getPages().Authentication.inputOther()).sendKeys(user.other);
		framework.getDriver().findElement(framework.getPages().Authentication.inputPhone()).sendKeys(user.phone);
		framework.getDriver().findElement(framework.getPages().Authentication.inputPhone_mobile())
				.sendKeys(user.phone_mobile);
		framework.getDriver().findElement(framework.getPages().Authentication.inputAlias()).sendKeys(user.alias);

		framework.getDriver().findElement(framework.getPages().Authentication.inputSubmitAccount()).click();

	}

	/**
	 * Login an exisiting user with given mail and pass
	 * 
	 * @param user user with initialized mail and pass
	 * 
	 * @return true: user is logged in now. false: is not logged in now. something
	 *         failed
	 */
	public boolean signInUser(User user) {

		if (isSignedIn())
			return true;

		framework.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.className("login"))).click();
		framework.getDriver().findElement(By.id("email")).sendKeys(user.email);
		framework.getDriver().findElement(By.id("passwd")).sendKeys(user.passwd);
		framework.getDriver().findElement(By.id("SubmitLogin")).click();

		return isSignedIn();
	}

	/**
	 * function to logout some user from the page
	 * 
	 * @return should allways return false, since user is logged out allready, or
	 *         becomes
	 */
	public boolean logoutUser() {
		if (isSignedIn()) {
			framework.getPages().Account.goTo();
			framework.getWait()
					.until(ExpectedConditions.visibilityOfElementLocated(framework.getPages().Account.input_logout()))
					.click();
		}
		return isSignedIn();
	}

	/**
	 * runs js isLogged to check wheater we are logged in or not (prestashop)
	 * 
	 * @return
	 */
	public boolean isSignedIn() {
		return framework.getPages().getAny().execScript("return isLogged").equals("1");
	}

	/**
	 * runs checkout with user, payment, shipping and products.
	 * 
	 * @param user
	 * @param payment
	 * @param shipping
	 * @param products
	 */
	public void checkout(User user, Payment payment, Shipping shipping, List<Article> products) {
		framework.getPages().Home.goTo();

		if (isSignedIn() && !isUserSignedIn(user)) {
			logoutUser();
		}
		signInUser(user);

		for (Article product : products) {

			framework.getPages().Product.goToSpecific(product.getProductId());
			if (framework.getPages().Product.isAtSpecific(product.getProductId())
					&& framework.getPages().Product.isBuyable()) {
				framework.getPages().Product.AddToCart();
			}

		}

		framework.getPages().Cart.goTo();
		framework.getPages().Cart.proceedToCheckout();

		framework.getPages().Order.Process(payment, shipping);

	}

	/**
	 * checks weather a specific user is logged in
	 * 
	 * @param user
	 * @return
	 */
	private boolean isUserSignedIn(User user) {
		String username = framework.getDriver().findElement(By.className("account")).getText();

		return username.equals(user.getFullName());
	}

}
