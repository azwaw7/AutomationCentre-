package com.utilites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AbstarctClass {
	private WebDriver driver;

	public AbstarctClass(WebDriver driver) {
		this.driver = driver;

	}
	public void selectbyvibiltextMe(WebElement ele,String visibilText) {
		Select select = new Select(ele);
		select.selectByVisibleText(visibilText);
		
		
	}

}
