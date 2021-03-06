package com.automation.todo.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
	
	Properties prop = new Properties();

	public String getConfigProp(String key) {
		try {
			InputStream input = new FileInputStream("./Properties/config.properties");
			prop.load(input);
			String value = prop.getProperty(key);
			return value;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		}

	}

	public String getGenericProp(String key) {
		try {
			InputStream input = new FileInputStream("./Properties/generic.properties");
			prop.load(input);
			String value = prop.getProperty(key);
			return value;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		}

	}



}
