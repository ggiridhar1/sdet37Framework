package com.crm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecOrganisationPage {
	//initialisation
	public SecOrganisationPage(WebDriver driver) {
	PageFactory.initElements(driver, this);	
	}
	//Declaration
	@FindBy(xpath = "//a[text()='AVG']")
	public WebElement organame;
	
	public WebElement getorganame() {
		return organame;
	}
	//utilisation
	public void selectOrganisationname() {
		organame.click();
	}
	
}

