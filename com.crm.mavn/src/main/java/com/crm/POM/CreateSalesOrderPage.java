package com.crm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.Advice.This;
//intialization
public class CreateSalesOrderPage {
public CreateSalesOrderPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
//Declearation
@FindBy(xpath = "//img[@title='Create Sales Order...']")
public WebElement cresaleOrdericon;

public WebElement getcreasaleorder() {
	return cresaleOrdericon;
}


//utilisation
public void ClickCreateSaleOrderBtn() {
	cresaleOrdericon.click();
}
}
