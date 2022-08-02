package com.crm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericUtilitity.webdriverUtility;
//initialisation
public class Oppertunitypage {
public Oppertunitypage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
//Declairation
@FindBy(xpath ="//img[@title='Create Opportunity...']" )
private WebElement createOpp;

//Utilisation
public void ClickOnCreateOppertunityBtn() {
	createOpp.click();
}
}
