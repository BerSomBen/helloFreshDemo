package com.hellofresh.challenge.commons;

import java.io.File;
import java.io.FileOutputStream;

import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * This rule should make a screenshot whenever a test fails
 * 
 * @author benja
 *
 */
public class ScreenshotTestRule implements MethodRule {

	/**
	 * instance of webDriver
	 */
	private WebDriver driver;

	/**
	 * constructor to store driver
	 * 
	 * @param driver
	 */
	public ScreenshotTestRule(WebDriver driver) {
		this.driver = driver;

	}

	/**
	 * the finial rule, evaluate the test, if fail, catch, screenshot, throw again.
	 */
	public Statement apply(final Statement statement, final FrameworkMethod frameworkMethod, final Object o) {
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				try {
					statement.evaluate();
				} catch (Throwable t) {
					captureScreenshot(frameworkMethod.getName());
					throw t; // rethrow to allow the failure to be reported to JUnit
				}
			}

			/**
			 * writes a screenshot of the driver towards the disk
			 * 
			 * @param fileName name to be used
			 */
			public void captureScreenshot(String fileName) {
				try {
					new File("target/reports/").mkdirs(); // Insure directory is there
					FileOutputStream out = new FileOutputStream("target/reports/screenshot-" + fileName + ".png");
					out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
					out.close();
				} catch (Exception e) {
					// No need to crash the tests if the screenshot fails
				}
			}
		};
	}

}
