package com.crm.POM;

import org.apache.commons.compress.harmony.unpack200.bytecode.forms.WideForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.genericUtilitity.webdriverUtility;

public class Homepage extends webdriverUtility{
//intialization
	public Homepage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	//declairation
	@FindBy (name = "Vendors")
	private WebElement vendors;
	
	@FindBy(xpath = "//a[text()='Opportunities']")
	private WebElement opportunities;
	
	@FindBy(xpath = "//a[text()='Contacts']")
	private WebElement ContactsEdt;
	
	@FindBy(xpath = "//a[text()='Organizations']")
	private WebElement organisationEdt;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstoricon;
	
	@FindBy(xpath = "//a[text()='More']" )
	private WebElement moreOption;
	
	@FindBy(name = "Campaigns")
	private WebElement campaigns;
	
	@FindBy(name = "Sales Order")
	private WebElement saleOrder;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signOut;
	
	public WebElement Utilitygetvendors() {
		return vendors;
	}
	
	public WebElement getsalesOrder() {
		return saleOrder;
	}
	
	public WebElement getOppertunity() {
		return opportunities;
	}
	
	public WebElement getsignout() {
		return signOut;
	}
	
	public WebElement getCampaign() {
		return campaigns;
	}
	
	public WebElement getmoreOption() {
		return moreOption;
	}
	
	public WebElement getorganisationEdt() {
		return organisationEdt;
	}
	
	public WebElement getadminicon() {
		return adminstoricon;
	}
	public WebElement getContactsEdt() {
		return ContactsEdt;
	}
	
	//utilization
	public void clickOnCampaigns() {
		campaigns.click();
	}
	
	
	public void clickOnContactsButton() {
		ContactsEdt.click();
	}
	public void clickOnMoreOptions() {
		moreOption.click();
	}
	
	public void clickonorganisationBtn() {
		organisationEdt.click();
	}
	
	public void Logout(WebDriver driver) {
		mouseOveronElement(driver,adminstoricon);
		signOut.click();
	}
	public void ClickOnOppertunity() {
		opportunities.click();
	}
	public void clickOnSaleorder() {
		saleOrder.click();
	}
	public void ClickOnVendors() {
		vendors.click();
	}
	}

