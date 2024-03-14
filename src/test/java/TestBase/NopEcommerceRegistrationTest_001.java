package TestBase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.RegistrePage;

public class NopEcommerceRegistrationTest_001 extends TestBase {
	@Test
	public void registrationTest_001() {
		RegistrePage regipa = new RegistrePage(driver);
		regipa.goToregistrationpage();
		regipa.registration(firtsName, lastName, dobday, dobMonth, dobyear, email, password);
		String AccullConfirmationTxt = regipa.getConfirmationText();
		Assert.assertEquals(AccullConfirmationTxt, confirmationtxt);
		regipa.finishRegestration();
	}

}
