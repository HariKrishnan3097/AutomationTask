package com.automation.todo.driversetup;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.automation.todo.utils.CommonUtils;
import com.automation.todo.utils.PropertyReader;

public class Tests {

	DriverFactory dFactory;
	public WebDriver driver;
	PropertyReader prop = new PropertyReader();
	Logger log = (Logger) LogManager.getLogger(Tests.class);
	CommonUtils utils = new CommonUtils();
	String pathToScreenshotFolder = prop.getConfigProp("Screenshotfolder");

	@BeforeSuite
	public void oneTimeSetup() throws Exception {

		log.info("Test starts here");
		utils.CleanUpFolder(pathToScreenshotFolder);
	}

	@BeforeMethod
	@Parameters({ "browser" })

	public void initDriver(String browser) throws Exception {
		dFactory = new DriverFactory(browser);
		driver = dFactory.getDriver();
		String Url = prop.getConfigProp("URL");
		driver.get(Url);

	}

	@AfterMethod

	public void cleanUp() {

		driver.close();
		driver.quit();
		log.info("Test ends here");

	}

}
