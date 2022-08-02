package com.crm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
//intialization
	 public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//declaration
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createContactEdt;
	
	public WebElement getcreateContactEdt() {
		return createContactEdt;
	}
	
	//utilization
	public void clickCreateContactsIcon() {
		createContactEdt.click();
	}
}

