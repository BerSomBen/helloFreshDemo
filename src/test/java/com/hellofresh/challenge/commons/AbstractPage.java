package com.hellofresh.challenge.commons;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class AbstractPage implements PageInterface {

	protected WebDriver driver;

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
	}

	public String execScript(String script) {
		return ((JavascriptExecutor) driver).executeScript(script).toString();
	}

	public boolean isAt() {
		throw new UnsupportedOperationException("Function must be overwritten");

	}

	public void goTo() {
		throw new UnsupportedOperationException("Function must be overwritten");
	}
}
