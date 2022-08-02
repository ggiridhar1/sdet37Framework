package com.crm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.Advice.This;

public class CampaignPage {
//intialisation
	public CampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//declairation
	@FindBy (xpath = "//img[@title='Create Campaign...']")
	private WebElement createcampaignBtn;
	
	public WebElement getcreatecampaign() {
		return createcampaignBtn;
	}
	//utilisation
	public void createCampaignBtn() {
		createcampaignBtn.click();
	}
}
