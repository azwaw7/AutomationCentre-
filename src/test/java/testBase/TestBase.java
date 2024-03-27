package testBase;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import com.base.MainBase;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pages.LandingPage;
import com.resources.ConfigReader;

public class TestBase extends MainBase {
	private ConfigReader coR = new ConfigReader();;
	public WebDriver driver;
	public String firtsName = coR.getfirstName();
	public String lastName = coR.getLasttName();
	public String dobday = coR.getDobday();
	public String dobMonth = coR.getDobmonth();
	public String dobyear = coR.getDobyear();
	public String email = coR.getemail();
	public String password = coR.getpwd();
	public String confirmationtxt = coR.getConfiOfRegistartiontxt();
	private String browserName = coR.getBrowser();
	private String uRl = coR.getUrl();
	LandingPage landingPage;
	String expectedTitelOfLandingPage = coR.getExpectedTitel();
	String prodcName = coR.getProductName();

	@BeforeMethod(alwaysRun = true)
	public LandingPage lunchBrowser() {
		driver = initbrowser();
		landingPage = new LandingPage(driver);
		landingPage.goTo(uRl);
		return landingPage;

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.close();
		driver.quit();

	}

	public List<HashMap<String, String>> readJsonFile(String filePath) throws IOException {
		String jsonToString = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonToString,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

	public String TakeScrennShot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, destinationFile);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";

	}

}
