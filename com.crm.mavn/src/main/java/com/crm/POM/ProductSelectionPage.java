package com.crm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//intialisation
public class ProductSelectionPage {
public ProductSelectionPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
//declearation
@FindBy(xpath = "//a[text()='CARS']")
private WebElement productEdt;

public WebElement getProduct() {
	return productEdt;
}
//UTILISATION
public void ProductSelection() {
	productEdt.click();
}  
}
