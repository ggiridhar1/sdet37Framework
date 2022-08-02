package com.crm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericUtilitity.webdriverUtility;

import net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName;
//intialisation
public class SelectContactPage extends webdriverUtility{
public SelectContactPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
//Decleairation
@FindBy(xpath = "//a[text()=' Giridhar']")
private WebElement seccontact;

@FindBy(name = "sostatus")
private WebElement sostatus; 

@FindBy(id = "jscal_trigger_duedate")
private WebElement date;

@FindBy(xpath = "//td[@class='day' and text()='15']")
private WebElement exactdate;

@FindBy(xpath = "//img[@onclick='selectPotential()']")
private WebElement secoppurtuntyicon;

public WebElement getsecoppurtuntyicon() {
	return secoppurtuntyicon;
}
public WebElement getexactdate() {
	return exactdate; 
}
public WebElement getdate() {
return date;
}
public WebElement getSostatus() {
	return sostatus;
}
public WebElement getseccontact() {
	return seccontact;
}
//utilisation
public void SelectContactAndHanndlepopUp(WebDriver driver ,String expectedmsg) {
	seccontact.click();
	switchToAlertPopupAndAcceptIt(driver, expectedmsg);
}
public void SelectInSoStatus(WebDriver driver,String value) {
select(sostatus,value);	
}
public void handledate() {
	date.click();
	exactdate.click();
}
public void 
}
