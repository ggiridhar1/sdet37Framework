package com.crm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//intialisation
public class CreateNewVendorPage {
public CreateNewVendorPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
//declairation
@FindBy(name = "vendorname")
private WebElement vendorname;

public WebElement getvendorname() {
	return vendorname;
}
//utilisation
public void enterVendorName() {

}
}
