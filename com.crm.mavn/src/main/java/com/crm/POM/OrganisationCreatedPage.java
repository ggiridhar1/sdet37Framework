package com.crm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationCreatedPage {
	//intialisation
public OrganisationCreatedPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
//declairation
@FindBy (xpath = "//span[@class='dvHeaderText']")
private WebElement verify;

public WebElement getTextverification() {
	return verify;
}

//utilisation
public String VerifyOrganisation() {
	return verify.getText();
}
}
