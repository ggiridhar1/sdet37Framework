package com.crm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {
//intialization
	public OrganisationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//declairation
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createorgnbtnElement;
	
	//utilization
	public void ClickOnCreateOrganisationBtn() {
		createorgnbtnElement.click();
	}
	
}
