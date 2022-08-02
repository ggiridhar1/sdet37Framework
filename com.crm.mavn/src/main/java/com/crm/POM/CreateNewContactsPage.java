package com.crm.POM;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.AddHasCasting;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.genericUtilitity.webdriverUtility;

public class CreateNewContactsPage extends webdriverUtility {
//intialization
	public CreateNewContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// declarization
	@FindBy (name = "salutationtype")
	private WebElement salutationtype;
	
	@FindBy(name = "lastname")
	private WebElement lastname;
	
	@FindBy(xpath = "//img[contains(@onclick,'return window.open')]")
	private WebElement organbutton;
	
	@FindBy(xpath = "//input[@class='crmButton small save']")
	private WebElement saveButton;
	
	
	
	public WebElement getsalutationtype(){
		return salutationtype; 
	}
	
	public WebElement getlastname() {
		return lastname;
	}
	
	public WebElement getorganisationbutton() {
		return organbutton;
	}
	public WebElement getsaveBtn() {
		return saveButton;
	}
	
	//utilization
	public void addlastname(String randomname) {
		lastname.sendKeys(randomname);
	}
	public void clickonorganisationbutton() {
		organbutton.click();
	}
	public void clickOnSaveBtn() {
		saveButton.click();
	}
	
public void selectsalutation(String firstName) {
	 select(salutationtype,firstName);
	 
}
		
	}

