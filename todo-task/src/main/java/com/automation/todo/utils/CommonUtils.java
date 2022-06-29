package com.automation.todo.utils;

import java.io.File;

public class CommonUtils {

	/*
	 * Delete the files inside the Folder
	 */

	public void CleanUpFolder(String path) {
		File directory = new File(path);

		File[] files = directory.listFiles();
		for (File file : files) {

			file.delete();

		}
	}

	/*
	 * Splits the text by char and returns Array of string
	 */

	public String[] splitToArray(String text, char toSplit) {

		String[] temp = text.split(Character.toString(toSplit));

		return temp;

	}

}
