package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".ico-login")
	private WebElement loginLink;
	@FindBy(id = "Email")
	private WebElement emailbx;
	@FindBy(id = "Password")
	private WebElement passwordlbx;
	@FindBy(css = "button[class*='login-button']")
	private WebElement loginBtn;
	@FindBy(linkText = "Forgot password?")
	private WebElement ForgotPasswordLink;

	public boolean forgotPasswordIsDispakyed() {
		loginLink.click();
		return ForgotPasswordLink.isDisplayed();

	}

	public LogoutPage login(String username, String pwd) {
		loginLink.click();
		emailbx.sendKeys(username);
		passwordlbx.sendKeys(pwd);
		loginBtn.click();
		return new LogoutPage(driver);

	}

}
