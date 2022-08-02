package com.crm.POM;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.genericUtilitity.webdriverUtility;

import net.bytebuddy.asm.Advice.This;
//INTIALISATION
public class CreateOrganisationPage extends webdriverUtility {
public CreateOrganisationPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
//DECALIRATION
@FindBy(name="industry")
private WebElement industry;

@FindBy(name = "accountname")
private WebElement organname;

@FindBy(xpath = "//input[@class='crmbutton small save']")
private WebElement savebtn;

@FindBy(xpath = "accounttype")
private WebElement accountTY;
//UTILISATION
public WebElement getaccounty() {
	return accountTY;
}
public WebElement getindustry() {
	return industry;
}
public WebElement getorganisationname() {
	return organname;
}
public WebElement getsavebtn() {
	return savebtn;
}
//Utilisation
public void getaccountDropDown(String typee) {
	select(typee, accountTY);
}
public void getIndustries(String industries) {
	select(industry,industries);
}
public void organisationNameText(String RANDOMORG) {
	organname.sendKeys(RANDOMORG);
}
public void ClickOnSaveBtn() {
	savebtn.click();
}

}
