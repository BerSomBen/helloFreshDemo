package com.hellofresh.challenge.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hellofresh.challenge.commons.AbstractPage;
import com.hellofresh.challenge.commons.Settings;
import com.hellofresh.challenge.enums.Payment;
import com.hellofresh.challenge.enums.Shipping;

public class Order extends AbstractPage {

	public Order(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public int Process(Payment payment, Shipping shipping) {
		// Order Step 1
		if (isAt() && getStep() == 3) {
			driver.findElement(By.name("processAddress")).click();
		} else {
			return 3;
		}

		if (isAt() && getStep() == 4) {
			driver.findElement(By.id(shipping.getAction())).click();
			driver.findElement(By.id("cgv")).click();
			driver.findElement(By.name("processCarrier")).click();
		} else {
			return 4;
		}

		if (isAt() && getStep() == 5) {
			driver.findElement(By.className(payment.name().toLowerCase())).click();
			WebDriverWait wait = new WebDriverWait(driver, 3);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cart_navigation']/button"))).click();

		} else {
			return 5;
		}

		return 0;
	}

	@Override
	public boolean isAt() {
		return driver.getCurrentUrl().contains("controller=order");
	}

	@Override
	public void goTo() {
		driver.get(Settings.HOMEURL + "?controller=order");
	}

	private int getStep() {
		if (isAt()) {
			List<WebElement> lis = driver.findElements(By.xpath("//ul[@id='order_step']/li"));
			for (WebElement webElement : lis) {

				if (webElement.getAttribute("class").contains("step_current")) {
					WebElement em = webElement.findElement(By.xpath(".//em"));
					String txt = em.getAttribute("textContent");
					
					return Integer.parseInt(txt.substring(0, 2));
				}
			}

		}
		return 0;
	}

}
