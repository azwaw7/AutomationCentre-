package TestBase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import com.base.MainBase;
import com.resources.ConfigReader;

public class TestBase extends MainBase {
	private ConfigReader coR;
	private WebDriver driver;

	@BeforeMethod
	public void lunchBrowser() {
		coR = new ConfigReader();
		String browserName = coR.getBrowser();
		driver = initbrowser(browserName);
		driver.get(coR.getUrl());

	}

}
