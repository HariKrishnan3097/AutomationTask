package com.automation.todo.driversetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	private String browser;
	static WebDriver driver;

	public DriverFactory(String browser) {

		this.browser = browser;

	}

	public WebDriver getDriver() {

		if (browser.equalsIgnoreCase("Chrome")) {

			System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

			driver = new ChromeDriver();

			driver.manage().window().maximize();

			return driver;

		} else if (browser.equalsIgnoreCase("Firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");

			driver = new FirefoxDriver();

			driver.manage().window().maximize();

			return driver;

		}

		else {

			return driver = null;
		}

	}


}
