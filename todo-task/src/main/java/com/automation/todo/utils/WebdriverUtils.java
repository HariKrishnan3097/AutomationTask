package com.automation.todo.utils;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import com.google.common.base.Function;

public class WebdriverUtils {

	WebDriver driver;
	ScreenshotHandler scr;
	Logger log;

	public WebdriverUtils(WebDriver driver) {

		try {

			this.driver = driver;
			scr = new ScreenshotHandler(this.driver);
			log = (Logger) LogManager.getLogger(WebdriverUtils.class);
		} catch (Exception e) {
			System.out.print("Selenium Utils Error " + e);
		}
	}

	public boolean fluentWait(final WebElement object, int seconds) {

		boolean elementAvailablityStatus;
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(seconds))
				.pollingEvery(Duration.ofMillis(1000)).ignoring(NoSuchElementException.class);
		try {
			wait.until(new Function<WebDriver, WebElement>() {

				public WebElement apply(WebDriver input) {
					if (object.isDisplayed()) {
						// highlightWebelement(object);
						return object;
					} else {
						return null;
					}
				}
			});
			elementAvailablityStatus = object.isDisplayed();
		} catch (Exception e) {
			elementAvailablityStatus = false;
		}
		return elementAvailablityStatus;

	}

	/*
	 * Wait for the element until given number of seconds
	 * 
	 * Findng element by By class
	 */
	public boolean fluentWait(final By by, Integer seconds) {

		WebElement element;
		boolean elementAvailablityStatus;
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(seconds))
				.pollingEvery(Duration.ofMillis(250)).ignoring(NoSuchElementException.class);
		log.info("Inside fluent wait " + seconds + " seconds");
		try {
			element = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {

					return driver.findElement(by);
				}
			});
			elementAvailablityStatus = element.isDisplayed();
			log.info("fluentWait Return : " + element.isDisplayed());
		} catch (Exception e) {
			elementAvailablityStatus = false;
			log.info("fluentWait Return : " + elementAvailablityStatus);

		}
		return elementAvailablityStatus;

	}

	/*
	 * Assert fail block to use inside else method idf element is not present
	 */

	public void assertFailBlock(String className, String message) throws Exception {
		try {
			log.error(message + "  - " + className);
			scr.takeScreenshot("Failure " + className);
			Assert.fail(message + "  - " + className);
		} catch (Exception e) {
			scr.takeScreenshot("Failure " + className);
			throw new Exception("Exception : " + e);
		}
	}

	/*
	 * To send keys to the input field
	 */

	public void sendKeys(final WebElement object, String keys) {
		object.sendKeys(keys);
	}

	/*
	 * Returns boolean if element is enabled
	 */

	public boolean isEnabled(final WebElement object) {
		return object.isEnabled();
	}

	/*
	 * Returns boolean if element is displayed
	 */

	public boolean isDisplayed(final WebElement object) {
		return object.isDisplayed();
	}

}
