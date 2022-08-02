package com.crm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//Intialisation
public class CreatenewsalesorderPage {
public CreatenewsalesorderPage(WebDriver driver) {
PageFactory.initElements(driver, this);	
}
//declearation
@FindBy(name = "subject")
private WebElement subject;

@FindBy(xpath = "//img[@onclick='selectContact(\"false\",\"general\",document.EditView)']")
private WebElement seccontact;

public WebElement getseccontact() {
	return seccontact;
}

public WebElement getsubject() {
	return subject;
}
//utilasation
public void EnterSubject(String PO1) {
	subject.sendKeys(PO1);
}
public void selectContact() {
seccontact.click();
}
}
