package com.crm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactCreatedPage {
//intialisation
	public ContactCreatedPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//declaration
	@FindBy (xpath = "//span[@class='dvHeaderText']")
	private WebElement verify;
	
	public WebElement getverification() {
		return verify;
	}
	//utilisation
	public String getVerificationText() {
		return verify.getText();
	}
}
