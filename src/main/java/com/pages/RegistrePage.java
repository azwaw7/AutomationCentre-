package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilites.AbstarctClass;

public class RegistrePage extends AbstarctClass {

	private WebDriver driver;

	public RegistrePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "gender-male")
	private WebElement gendreManRadio;
	@FindBy(id = "FirstName")
	private WebElement FirstNameBx;
	@FindBy(id = "LastName")
	private WebElement lastNameBx;
	@FindBy(css = "select[name='DateOfBirthDay']")
	private WebElement dOBDay;
	@FindBy(css = "select[name='DateOfBirthMonth']")
	private WebElement dobMonth;
	@FindBy(css = "select[name='DateOfBirthYear']")
	private WebElement dOBYear;
	@FindBy(id = "Email")
	private WebElement emailBx;
	@FindBy(id = "Password")
	private WebElement passwordBx;
	@FindBy(id = "ConfirmPassword")
	private WebElement confirmPasswordBx;
	@FindBy(id = "register-button")
	private WebElement registerBtn;
	@FindBy(css = "div[class='result']")
	private WebElement registrationConf;
	@FindBy(css = "a[class*='register-continue-button']")
	private WebElement FinalRegContinueBtn;

	public void registration(String firstName, String lastName, String dobdy, String dobMon, String dobyear,
			String email, String pawssord) {
		gendreManRadio.click();
		FirstNameBx.sendKeys(firstName);
		lastNameBx.sendKeys(lastName);
		selectbyvibiltextMe(dOBDay, dobdy);
		selectbyvibiltextMe(dobMonth, dobMon);
		selectbyvibiltextMe(dOBYear, dobyear);
		emailBx.sendKeys(email);
		passwordBx.sendKeys(pawssord);
		confirmPasswordBx.sendKeys(pawssord);
		// registerBtn.click();

	}

	public void clickOnSubmit() {
		registerBtn.click();
	}

	public String getConfirmationText() {
		String confiText = registrationConf.getText();
		return confiText;
	}

	public LoginPage finishRegestration() {
		FinalRegContinueBtn.click();
		return new LoginPage(driver);

	}

}
