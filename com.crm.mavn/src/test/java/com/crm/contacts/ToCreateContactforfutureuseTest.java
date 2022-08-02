package com.crm.contacts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.commons.compress.harmony.pack200.NewAttribute;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.AddHasCasting;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.crm.POM.ContactCreatedPage;
import com.crm.POM.ContactsPage;
import com.crm.POM.CreateNewContactsPage;
import com.crm.POM.Homepage;
import com.crm.POM.LoginPage;
import com.crm.POM.SecOrganisationPage;
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
//to push
public class ToCreateContactforfutureuseTest {
	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		JavaUtility javau = new JavaUtility();
		fileUtility fileU = new fileUtility();
		webdriverUtility webdU = new webdriverUtility();
		ExcelUtility exceU = new ExcelUtility();
		
		String BROWSER = fileU.getPropertyvalue("browser");
		String URL = fileU.getPropertyvalue("url");
		String USERNAME = fileU.getPropertyvalue("user");
		String PASSWORD = fileU.getPropertyvalue("password");
		
		
		String NAME = exceU.getDataFromExcel("TC1", 1, 1);
		int random = javau.getRandomNum();
        String RandName = NAME+random;
        
        String firstName = exceU.getDataFromExcel("contacts", 1, 0);
        
        String childurl = exceU.getDataFromExcel("contacts", 2, 2);
        
		if (BROWSER.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		

		//Maximize the Browser
		webdU.maximizeTheBrowser(driver);
	
		//add waits
		webdU.waitUntilPageGetsLoaded(driver);

		//Open URL of the application
		driver.get(URL);

		//Enter Username,password,click on submit button
		LoginPage login = new LoginPage(driver);
		login.loginToApp(USERNAME, PASSWORD);
	

		//Click on Contacts in main navigation Bar
		Homepage homepage = new Homepage(driver);
		homepage.clickOnContactsButton();
		
		//Click on create icon Button
		ContactsPage contactspage = new ContactsPage(driver);
		contactspage.clickCreateContactsIcon();
		
		//Select first name
		CreateNewContactsPage createnewcontacts = new CreateNewContactsPage(driver);
		createnewcontacts.selectsalutation(firstName);
		

		//Enter last name in Last name Text field
	
		createnewcontacts.addlastname(RandName);

		//Click on Organisation Button
		createnewcontacts.clickonorganisationbutton();
		
		//switch driver control to child browser
		webdU.switchToWindow(childurl, driver);
		
		//Click on Organisation
		SecOrganisationPage secorganisation = new SecOrganisationPage(driver);
		secorganisation.selectOrganisationname();
		
		//switch back to parent window
		webdU.SwitchToWindow(driver,"Administrator");
		
		//Click on save button
		createnewcontacts.clickOnSaveBtn();
		
		//VERIFICATION
		ContactCreatedPage contactcreatedpage = new ContactCreatedPage(driver);
		String verify=contactcreatedpage.getVerificationText();
		
		if (verify.contains(RandName)) {
			System.out.println("Contact is Created");
		}
		else {
			System.out.println("Contact is Not Created");
		}
		//logout function
		homepage.Logout(driver);

		//Terminate the driver
		driver.quit();
	}

}
