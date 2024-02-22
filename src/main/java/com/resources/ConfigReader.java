package com.resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;

	public ConfigReader() {
		prop = new Properties();
		try {
			FileInputStream input = new FileInputStream(
					"C://Users//azwaw//Desktop//AutomationCentre//AutomationCentre//src//main//java//com//resources//conig.properties");
			prop.load(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getBrowser() {
		String browsern = prop.getProperty("Browser");
		return browsern;
	}

	public String getUrl() {
		String url = prop.getProperty("url");
		return url;
	}
}
