package com.base;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.resources.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MainBase {

	private WebDriver driver;
	ConfigReader config = new ConfigReader();

	public WebDriver initbrowser() {
		String brw = System.getProperty("browser") != null ? System.getProperty("browser") : config.getBrowser();
		if (brw.contains("Chrome")) {
			ChromeOptions chOptions = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if (brw.contains("headless")) {
				chOptions.addArguments("headless");
			}
			driver = new ChromeDriver(chOptions);
			driver.manage().window().setSize(new Dimension(1440, 900));
			// need
		} else if (brw.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (brw.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		return driver;

	}

}
