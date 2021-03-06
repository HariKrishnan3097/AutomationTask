package com.automation.todo.positive;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import com.automation.todo.driversetup.Tests;
import com.automation.todo.pages.TodoPages;
import com.automation.todo.utils.CommonUtils;
import com.automation.todo.utils.PropertyReader;
import com.automation.todo.utils.ScreenshotHandler;
import org.apache.logging.log4j.Logger;

import org.apache.logging.log4j.LogManager;

public class CreateNewTodoItemValidation extends Tests {

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
		log = (Logger) LogManager.getLogger(CreateNewTodoItemValidation.class);
		scr = new ScreenshotHandler(driver);
		todoPage = PageFactory.initElements(driver, TodoPages.class);

	}

	String[] itemsToAdd = commonUtils.splitToArray(prop.getGenericProp("Items"), ',');

	@Test
	public void CreateNewTodoItemValidationTest() throws Exception {

		log.info("Test case " + className + " starts Here");

		for (int i = 0; i < itemsToAdd.length; i++) {

			todoPage.addTaskFunctionality(itemsToAdd[i], className);

			scr.takeScreenshot(className);

			todoPage.validateAddedTaskInList(itemsToAdd[i], className);

			scr.takeScreenshot(className);

		}

	}

}
