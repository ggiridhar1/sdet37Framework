package com.crm.mavn;

import static org.testng.Assert.expectThrows;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.checkerframework.checker.units.qual.s;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.POM.CampaignInformationPage;
import com.crm.POM.CampaignPage;
import com.crm.POM.CreateNewCampaignPage;
import com.crm.POM.Homepage;
import com.crm.POM.LoginPage;
import com.crm.POM.ProductSelectionPage;
import com.crm.genericUtilitity.ExcelUtility;
import com.crm.genericUtilitity.JavaUtility;
import com.crm.genericUtilitity.fileUtility;
import com.crm.genericUtilitity.webdriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author V S GIRIDHAR
 *
 */
public class ToCreateCampainWithProductTest {
	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		 JavaUtility javau = new JavaUtility();
		 ExcelUtility excelu=new ExcelUtility();
		 fileUtility fileu=new fileUtility();
		 webdriverUtility webdu=new webdriverUtility();
		
		String URL=fileu.getPropertyvalue("url");
		String USERNAME=fileu.getPropertyvalue("user");
		String PASSWORD=fileu.getPropertyvalue("password");
		String BROWSER=fileu.getPropertyvalue("browser");
		

		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}

		//maximise the browser
		webdu.maximizeTheBrowser(driver);

		//adding wait function
		webdu.waitUntilPageGetsLoaded(driver);

		//Entering URL of application 
		driver.get(URL);

		//Entering username in username Text Field
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginToApp(USERNAME, PASSWORD);

		//click on more option in main navigation
		Homepage homepage = new Homepage(driver);
		homepage.clickOnMoreOptions();
		
		//click on campaigns button
		homepage.clickOnCampaigns();

		//click on create options button
		CampaignPage campaignpage = new CampaignPage(driver);
		campaignpage.createCampaignBtn();
		
		//Entering campaign name in campaigname text field
		String campname = excelu.getDataFromExcel("contacts", 1, 4);
		CreateNewCampaignPage createnewcampaignpage = new CreateNewCampaignPage(driver);
		createnewcampaignpage.campaignName(campname);

		//click on add product button
		createnewcampaignpage.productIconBtn();
		
		//transfering driver controls to new window
		String childurl = excelu.getDataFromExcel("contacts", 3, 2);
		webdu.switchToWindow(childurl, driver);
	
		//click on product 
		ProductSelectionPage productselectionpage = new ProductSelectionPage(driver);
		productselectionpage.ProductSelection();
		
		//transfering control back to parent browser
		String Campain = excelu.getDataFromExcel("contacts", 2, 3);
		webdu.SwitchToWindow(driver, Campain);

		//click on save button 
		createnewcampaignpage.ClickOnSaveBtn();
		        //VERIFICATION
		CampaignInformationPage campaigninformationpage = new CampaignInformationPage(driver);
		String text = campaigninformationpage.verification();
		
		if (text.contains(campname)) {
			System.out.println("CAMPAIN IS CREATED");
		}
		else {
			System.out.println("CAMPAIN IS NOT CREATED");
		}
		//Performing logout 
		homepage.Logout(driver);
		
		
		//Terminate the driver
		driver.quit();

	}

}
