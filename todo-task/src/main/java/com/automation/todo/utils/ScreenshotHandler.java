package com.automation.todo.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotHandler {

	WebDriver driver;

	public ScreenshotHandler(WebDriver driver) {

		this.driver = driver;
	}

	static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");

	public void takeScreenshot(String Methodname) throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileHandler.copy(scrFile,
				new File(".\\Screenshots\\" + Methodname + "_" + dateFormat.format(new Date()) + ".png"));

	}

}
