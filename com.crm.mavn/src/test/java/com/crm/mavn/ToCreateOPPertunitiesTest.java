package com.crm.mavn;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Network.UserAgent;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.crm.POM.CreateNewOppertunityPage;
import com.crm.POM.CreatedOppertuntyPage;
import com.crm.POM.Homepage;
import com.crm.POM.LoginPage;
import com.crm.POM.Oppertunitypage;
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
public class ToCreateOPPertunitiesTest {
	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		JavaUtility	javau=new JavaUtility();
		ExcelUtility excelu = new ExcelUtility();
		fileUtility fileu=new fileUtility();
		webdriverUtility webdu=new webdriverUtility();

		String URL=fileu.getPropertyvalue("url");
		String USERNAME = fileu.getPropertyvalue("user");
		String PASSWORD = fileu.getPropertyvalue("password");
		String BROWSER=fileu.getPropertyvalue("browser");

		int ran=javau.getRandomNum();

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


		//maximizing the browser 
		webdu.maximizeTheBrowser(driver);

		//Adding implicit wait
		webdu.waitUntilPageGetsLoaded(driver);

		//Enter the Url of the application
		driver.get(URL);

		//Enter User name in the Username Text field
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginToApp(USERNAME, PASSWORD);


		//CLICK ON OPERTUNIES
		Homepage homepage = new Homepage(driver);
		homepage.ClickOnOppertunity();
		
		//CLICK ON CREATE OPPORTUNITY BUTTON
		Oppertunitypage oppertunitypage = new Oppertunitypage(driver);
		oppertunitypage.ClickOnCreateOppertunityBtn();
		
		//enter potentialname in potentialname text field  
		String name = excelu.getDataFromExcel("TC1", 2, 3);
		String orgname = name+ran;
		CreateNewOppertunityPage createnewopprtunity = new CreateNewOppertunityPage(driver);
		createnewopprtunity.getPottentialname(orgname);


		//click on related icon
		createnewopprtunity.CLickOnRelated();
		
		//switch control to child window
		Set<String> hand = driver.getWindowHandles();
		for (String windowid : hand) {
			driver.switchTo().window(windowid);
		}

		//Select organisation name
		SecOrganisationPage secorganisation = new SecOrganisationPage(driver);
		secorganisation.selectOrganisationname();
		

		//transferControl to parent window
		Set<String> hand2 = driver.getWindowHandles();
		for (String windowid2 : hand2) {
			driver.switchTo().window(windowid2);
		}

		//Click on calender 
		createnewopprtunity.ClickOnCalenderDate();
		

		//select the date in calender
		createnewopprtunity.selectCalenderDate();
		

		//click on savebtn
		createnewopprtunity.ClickOnSaveBtn();
		

		//geting text for verification
		CreatedOppertuntyPage createdoppertuntypage = new CreatedOppertuntyPage(driver);
		 String verification = createdoppertuntypage.verificationOfText();
		
		if (verification.contains("GOOGLE")) {
			System.out.println("The Oppertunity is Created");
		}
		else {
			System.out.println("The Oppertunity is NOT Created");
		}
		//performing logout function
        homepage.Logout(driver);
				
		//terminating the driver 
		driver.quit();

	}

}
