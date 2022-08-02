package com.crm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


//intialisation
public class CampaignInformationPage {
public CampaignInformationPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
//Declairation
@FindBy(xpath = "//span[contains(text(),'99%OFF')]")
private WebElement verificationElement;

public WebElement getverification() {
	return verificationElement;
}
//Utilisation
public String verification() {
	return verificationElement.getText();
}

}
