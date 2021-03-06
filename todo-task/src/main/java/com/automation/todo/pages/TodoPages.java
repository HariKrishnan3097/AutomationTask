package com.automation.todo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.automation.todo.utils.PropertyReader;
import com.automation.todo.utils.ScreenshotHandler;
import com.automation.todo.utils.WebdriverUtils;

public class TodoPages {

	WebDriver driver;
	Logger log;
	ScreenshotHandler scr;
	PropertyReader prop = new PropertyReader();
	WebdriverUtils utils;

	public TodoPages(WebDriver driver) {
		this.driver = driver;
		scr = new ScreenshotHandler(driver);
		log = (Logger) LogManager.getLogger(TodoPages.class);
		utils = new WebdriverUtils(driver);
	}

	@FindBy(how = How.XPATH, using = "//input")
	WebElement inputField;

	@FindBy(how = How.XPATH, using = "//ul[@class='todo-list']")
	WebElement todoList;

	@FindBy(how = How.XPATH, using = "//button[@class='clear-completed']")
	WebElement clearCompleted;

	@FindBy(how = How.XPATH, using = "//input[@class='edit']")
	WebElement editInputField;

	public void addTaskFunctionality(String taskName, String className) {

		try {

			if (utils.fluentWait(inputField, 30)) {

				inputField.click();
				inputField.sendKeys(taskName);
				inputField.sendKeys(Keys.ENTER);
			} else {
				utils.assertFailBlock(className, "Input field not found");
			}

		}

		catch (Exception e) {

			log.info("There was an Exception " + e);
			Assert.fail("There was an Exception " + e);

		}

	}

	public void validateAddedTaskInList(String ExpectedTasks, String className) throws Exception {

		List<WebElement> tasks = driver.findElements(By.xpath("//li/div/label"));

		for (int i = 0; i < tasks.size(); i++) {

			if (ExpectedTasks.equals(tasks.get(i).getText())) {
				log.info("Added task is displayed under list " + tasks.get(i).getText());
			}

		}

	}

	public void clickCheckBoxFunctionality(String className, String TaskName) throws Exception {

		if (utils.fluentWait(todoList, 30)) {
			log.info("To do List is Displayed");
			Thread.sleep(3000);

			driver.findElement(
					By.xpath(prop.getGenericProp("CheckboxXpath1") + TaskName + prop.getGenericProp("CheckboxXpath2")))
					.click();
		} else {
			log.info("To do list is not displayed");
			utils.assertFailBlock(className, "To do list is not displayed");
		}

	}

	public void verifyTasksMarkedAsCompletedFunctionality(String className, String ExpectedTask) throws Exception {

		if (utils.fluentWait(todoList, 30)) {
			log.info("To do List is Displayed");
			Thread.sleep(3000);
			String temp = driver.findElement(By.xpath(prop.getGenericProp("completedItemsXpath1") + ExpectedTask
					+ prop.getGenericProp("completedItemsXpath2"))).getText();

			log.info("Task " + temp + " is marked as completed");

		} else {
			log.info("To do list is not displayed");
			utils.assertFailBlock(className, "To do list is not displayed");

		}

	}

	public void clickClearCompletedButton(String ClassName) throws Exception {
		if (utils.fluentWait(clearCompleted, 30)) {

			clearCompleted.click();
			log.info("Clear completed button is clicked successfully");

		} else {

			log.info("Clear completed button is not displayed");
			utils.assertFailBlock(ClassName, "Clear completed button is not displayed");

		}

	}

	public boolean validateTasksRemovedFromList(String ExpectedTasks) {

		boolean isListed = false;

		List<WebElement> tasks = driver.findElements(By.xpath("//li/div/label"));

		for (int i = 0; i < tasks.size(); i++) {

			if (ExpectedTasks.equals(tasks.get(i).getText())) {
				log.info("Added task is displayed under list " + tasks.get(i).getText());

				return isListed = true;
			} else {
				log.info("Task " + ExpectedTasks + " is successfully removed from list");
				return isListed;
			}

		}

		return isListed;

	}

	public void doubleClickOnTask(String className, String ExpectedTask) {

		List<WebElement> tasks = driver.findElements(By.xpath("//li/div/label"));
		Actions act = new Actions(driver);

		try {
			for (int i = 0; i < tasks.size(); i++) {

				if (ExpectedTask.equals(tasks.get(i).getText())) {
					log.info("Added task is displayed under list " + tasks.get(i).getText());

					act.doubleClick(tasks.get(i)).perform();

				}

			}
		} catch (Exception e) {
			log.info("There is an error " + e);
		}

	}

	public void updateTaskFunctionaity(String className, String UpdateTask) throws Exception {

		try {
			if (utils.fluentWait(editInputField, 30)) {

				editInputField.click();
				editInputField.sendKeys(UpdateTask);
				editInputField.sendKeys(Keys.ENTER);
			}
		} catch (Exception e) {

			utils.assertFailBlock(className, e.toString());
		}
	}

}
