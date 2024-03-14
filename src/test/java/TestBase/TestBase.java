package TestBase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.base.MainBase;
import com.resources.ConfigReader;

public class TestBase extends MainBase {
	private ConfigReader coR = new ConfigReader();;
	WebDriver driver;
	String firtsName = coR.getfirstName();
	String lastName = coR.getLasttName();
	String dobday = coR.getDobday();
	String dobMonth = coR.getDobmonth();
	String dobyear = coR.getDobyear();
	String email = coR.getemail();
	String password = coR.getpwd();
	String confirmationtxt = coR.getConfiOfRegistartiontxt();
	private String browserName = coR.getBrowser();
	private String uRl = coR.getUrl();

	@BeforeMethod
	public void lunchBrowser() {
		driver = initbrowser(browserName);
		driver.get(uRl);

	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		
	}

}
