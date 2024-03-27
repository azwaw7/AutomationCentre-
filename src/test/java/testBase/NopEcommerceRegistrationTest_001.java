package testBase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.pages.LogoutPage;
import com.pages.RegistrePage;
import utilitiesTest.Retry;

public class NopEcommerceRegistrationTest_001 extends TestBase {
	@Test(retryAnalyzer = Retry.class)
	public void registrationTest_001() {
		String AccutilleTittel = landingPage.getAccuelTitel();
		Assert.assertEquals(expectedTitelOfLandingPage, AccutilleTittel);
		String actualProdcName = landingPage.seracheBox(prodcName);
		Assert.assertEquals(prodcName, actualProdcName);
		landingPage.changeCurruncy("Euro");
		RegistrePage regipa = landingPage.goToregistrationpage();
		regipa.registration(firtsName, lastName, dobday, dobMonth, dobyear, email, password);
		regipa.clickOnSubmit();
		String AccullConfirmationTxt = regipa.getConfirmationText();
		Assert.assertEquals(AccullConfirmationTxt, confirmationtxt);
		LoginPage loginpage = regipa.finishRegestration();
		Assert.assertTrue(loginpage.forgotPasswordIsDispakyed());
		LogoutPage logoutpage = loginpage.login(email, password);
		logoutpage.clickLogout();
	}

}
