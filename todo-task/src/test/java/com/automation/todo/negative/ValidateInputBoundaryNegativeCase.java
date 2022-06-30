package com.automation.todo.negative;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.todo.driversetup.Tests;
import com.automation.todo.pages.TodoPages;
import com.automation.todo.utils.CommonUtils;
import com.automation.todo.utils.PropertyReader;
import com.automation.todo.utils.ScreenshotHandler;

public class ValidateInputBoundaryNegativeCase extends Tests {

	WebDriver driver;
	Logger log;
	ScreenshotHandler scr;
	PropertyReader prop = new PropertyReader();
	String className = this.getClass().getSimpleName();
	TodoPages todoPage;
	CommonUtils commonUtils = new CommonUtils();

	@BeforeMethod

	public void preTestExecution() {

		this.driver = super.driver;
		log = (Logger) LogManager.getLogger(ValidateInputBoundaryNegativeCase.class);
		scr = new ScreenshotHandler(driver);
		todoPage = PageFactory.initElements(driver, TodoPages.class);

	}

	String[] itemsToAdd = commonUtils.splitToArray(prop.getGenericProp("Items"), ',');

	@Test
	public void ValidateInputBoundaryNegativeCaseTest() throws Exception {

		log.info("Test case " + className + " starts Here");

		/*
		 * Step1 : Adding Longer test in Input field
		 * 
		 */

		log.info(" Step1 : Adding Longer test in Input field ");
		todoPage.addTaskFunctionality(prop.getGenericProp("LongerText"), className);

		scr.takeScreenshot(className);

		/*
		 * Step2 : Validated added text in list
		 * 
		 */
		log.info("Step2 : Validated added text in list ");
		todoPage.validateAddedTaskInList(prop.getGenericProp("LongerText"), className);

		scr.takeScreenshot(className);

	}

}
