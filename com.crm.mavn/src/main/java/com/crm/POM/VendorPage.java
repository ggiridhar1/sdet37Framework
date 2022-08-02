package com.crm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericUtilitity.webdriverUtility;

public class VendorPage {
public VendorPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(name = "//img[@title='Create Vendor...']")
private WebElement createvendorBtn;

public WebElement getcreatevendorBtn() {
	return createvendorBtn;
}
public void ClickOnCreateVendorBtn() {
	createvendorBtn.click();
}
}
