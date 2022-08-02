package com.crm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewCampaignPage {
//intialisation
	public CreateNewCampaignPage(WebDriver driver) {
	PageFactory.initElements(driver, this);	
	}
	//decliration
	@FindBy(name = "campaignname")
	private WebElement campaignname;
	
	@FindBy(xpath = "//img[contains(@onclick,'return window.open')]")
	private WebElement productIcon;
	
	@FindBy(xpath = "//input[@class='crmbutton small save']")
	private WebElement saveBtn;
	
	public WebElement getsaveBtn() {
		return saveBtn;
	}
	
	public WebElement getcapaignname() {
		return campaignname;
	}
	public WebElement getproducticon() {
		return productIcon;
	}
	//utilisation
	public void campaignName(String campname ) {
		campaignname.sendKeys(campname);
	}
	public void productIconBtn() {
		productIcon.click();
	}
	public void ClickOnSaveBtn() {
		saveBtn.click();
	}
}
