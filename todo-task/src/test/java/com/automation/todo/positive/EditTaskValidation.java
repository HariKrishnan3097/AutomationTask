package com.automation.todo.positive;

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

public class EditTaskValidation extends Tests {

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
		log = (Logger) LogManager.getLogger(EditTaskValidation.class);
		scr = new ScreenshotHandler(driver);
		todoPage = PageFactory.initElements(driver, TodoPages.class);

	}

	String[] itemsToAdd = commonUtils.splitToArray(prop.getGenericProp("Items"), ',');

	@Test
	public void EditTaskValidationTest() throws Exception {

		log.info("Test case " + className + " starts Here");

		/*
		 * Step1 : Adding multiple to do tasks
		 * 
		 */
		log.info("Step1 : Adding multiple to do tasks");

		for (int i = 0; i < itemsToAdd.length; i++) {

			todoPage.addTaskFunctionality(itemsToAdd[i], className);

			scr.takeScreenshot(className);

			todoPage.validateAddedTaskInList(itemsToAdd[i], className);

			scr.takeScreenshot(className);

		}

		/*
		 * Step2 : Double click on tasks
		 * 
		 */

		log.info("Step2 : Double click on tasks");

		todoPage.doubleClickOnTask(className, "TodoTesting3");

		/*
		 * Step3 : Update the task in edit mode
		 * 
		 */
		log.info("Step3 : Update the task in edit mode");
		todoPage.updateTaskFunctionaity(className, "Updated");

		/*
		 * Step4 : Validate updated task
		 * 
		 */

		log.info("Step4 : Validate updated task ");

		todoPage.validateAddedTaskInList("TodoTesting3Updated", className);

	}
}
