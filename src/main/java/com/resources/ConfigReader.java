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
					"C:\\Users\\azwaw.AZ\\AutomationCentre-\\src\\main\\java\\com\\resources\\conig.properties");
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

	public String getfirstName() {
		String firstname = prop.getProperty("firstName");
		return firstname;
	}

	public String getLasttName() {
		String lastName = prop.getProperty("lastname");
		return lastName;
	}

	public String getemail() {
		String email = prop.getProperty("email");
		return email;
	}

	public String getpwd() {
		String pwd = prop.getProperty("password");
		return pwd;
	}

	public String getDobday() {
		String dobday = prop.getProperty("dobday");
		return dobday;
	}

	public String getDobmonth() {
		String dobmonth = prop.getProperty("dobMonth");
		return dobmonth;
	}

	public String getDobyear() {
		String dobyear = prop.getProperty("dobyear");
		return dobyear;
	}
	public String getConfiOfRegistartiontxt() {
		String confirmationtxt = prop.getProperty("registrationExpectedText");
		return confirmationtxt;
	}

}
