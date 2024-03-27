package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.pages.LandingPage;
import com.pages.RegistrePage;

import io.cucumber.java.en.*;
import testBase.TestBase;;

public class RegisterStepDefinition extends TestBase {
	public LandingPage LandingPage;
	public RegistrePage registrepage;

	@Given("user on laningPage")
	public void user_on_laningPage() {
		LandingPage = lunchBrowser();

	}

	@Given("user on register page")
	public void user_on_register_page() {
		registrepage = LandingPage.goToregistrationpage();

	}

	@When("user entre credintel on respictive filed")
	public void user_entre_credintel_on_respictive_filed() {
		registrepage = LandingPage.goToregistrationpage();
		registrepage.registration(firtsName, lastName, dobday, dobMonth, dobyear, email, password);

	}

	@When("user click on the submit button")
	public void user_click_on_the_submit_button() {
		registrepage.clickOnSubmit();

	}

	@Then("{string} message is desplayed on confirmation test")
	public void message_is_desplayed_on_confirmation_test(String expectedText) {
		String acculleText = registrepage.getConfirmationText();
		Assert.assertEquals(expectedText, acculleText);
		registrepage.finishRegestration();

	}

}
