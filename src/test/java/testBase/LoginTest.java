package testBase;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.pages.LogoutPage;

public class LoginTest extends TestBase {
	String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\resources\\NopEcommerceData.json";

	@Test(dataProvider = "data")
	public void loginTest_001(HashMap<String, String> input) {
		LoginPage loginpg = new LoginPage(driver);
		loginpg.login(input.get("email"), input.get("password"));

	}

	@DataProvider
	public Object[][] data() throws IOException {
		List<HashMap<String, String>> data = readJsonFile(filePath);
		return new Object[][] { { data.get(0) }, { data.get(1) } };

	}

}
