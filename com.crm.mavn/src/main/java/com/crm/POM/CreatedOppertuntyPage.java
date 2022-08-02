package com.crm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//initalisation 
public class CreatedOppertuntyPage {
public CreatedOppertuntyPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
//Declairation
@FindBy(xpath = "//span[@class='dvHeaderText']")
private WebElement verification;

public WebElement getverificationEdt() {
	return verification;
}
//Utilsation
public String verificationOfText() {
	return verification.getText();
}
}
