package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilites.AbstarctClass;

public class LandingPage extends AbstarctClass {

	private WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Register")
	private WebElement registrelink;
	@FindBy(id = "small-searchterms")
	private WebElement searchBx;
	@FindBy(id = "customerCurrency")
	WebElement currenciesDropDown;
	@FindBy(css = "button[type='submit']")
	private WebElement searchBtn;
	@FindBy(css = "h2[class='product-title'] a")
	private WebElement productName;

	public String getAccuelTitel() {
		String titel = driver.getTitle();
		return titel;

	}

	public String seracheBox(String productnameToserch) {
		searchBx.sendKeys(productnameToserch);
		searchBtn.click();
		return productName.getText();

	}

	public RegistrePage changeCurruncy(String currencyType) {
		selectbyvibiltextMe(currenciesDropDown, currencyType);
		return new RegistrePage(driver);

	}

	public RegistrePage goToregistrationpage() {
		registrelink.click();
		return new RegistrePage(driver);

	}
	public void goTo(String url) {
		driver.get(url);
	}

}
