package com.crm.POM;

import org.checkerframework.checker.units.qual.s;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//intialization
public class CreateNewOppertunityPage {
	public CreateNewOppertunityPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}
	//declairation
	@FindBy(name = "potentialname")
	private WebElement pottential;

	@FindBy(xpath = "//img[contains(@onclick,'return window.open')]")
	private WebElement relatedTo;
	
	@FindBy(id = "jscal_trigger_closingdate")
	private WebElement closingdate;
	
	@FindBy(xpath = "//td[@class='day' and text()='15']")
	private WebElement secDate;
	
	@FindBy(xpath = "//input[@class='crmbutton small save']")
	private WebElement saveBtn;
	
	public WebElement getsavebtn() {
		return saveBtn;
	}
	
	public WebElement getsecDate() {
		return secDate;
	}
	public WebElement getClosingdate() {
		return closingdate; 
	}

	public WebElement getPottential() {
		return pottential;
	}
	public WebElement getrelatedtoo() {
		return relatedTo;
	}
	//Utilization
	public void selectCalenderDate() {
		secDate.click();
	}
	public void getPottentialname(String orgname ) {
		pottential.sendKeys(orgname);
	}
	public void CLickOnRelated() {
		relatedTo.click();
	}
	public void ClickOnCalenderDate() {
		closingdate.click();
	}
	public void ClickOnSaveBtn() {
		saveBtn.click();
	}
}