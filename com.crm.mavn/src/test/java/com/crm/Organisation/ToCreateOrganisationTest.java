package com.crm.Organisation;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.compress.harmony.pack200.NewAttribute;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.crm.POM.CreateOrganisationPage;
import com.crm.POM.Homepage;
import com.crm.POM.LoginPage;
import com.crm.POM.OrganisationCreatedPage;
import com.crm.POM.OrganisationPage;
import com.crm.genericUtilitity.ExcelUtility;
import com.crm.genericUtilitity.JavaUtility;
import com.crm.genericUtilitity.fileUtility;
import com.crm.genericUtilitity.webdriverUtility;
import com.google.j2objc.annotations.Property;
import com.mysql.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author V S GIRIDHAR
 *
 */
public class ToCreateOrganisationTest  {
	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		fileUtility fileU = new fileUtility();
		ExcelUtility excelU = new ExcelUtility();
		webdriverUtility webdu = new webdriverUtility();
		JavaUtility javau = new JavaUtility();
		
		String URL = fileU.getPropertyvalue("url");
		String USERNAME = fileU.getPropertyvalue("user");
		String PASSWORD = fileU.getPropertyvalue("password");
		String BROWSER = fileU.getPropertyvalue("browser");
		
		int rand = javau.getRandomNum();
		String orgname = excelU.getDataFromExcel("TC1", 1, 3);
		String RANDOMORG = orgname+rand;
		
		
		
		//instancing browser specific class
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


		//Maximize the browser
		webdu.maximizeTheBrowser(driver);

		//adding waits
		webdu.waitUntilPageGetsLoaded(driver);

		//Get Url of an application
		driver.get(URL);

		//Enter username and password
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginToApp(USERNAME, PASSWORD);

		//click on Organisation button on main navigation bar
		Homepage homepage = new Homepage(driver);
		homepage.clickonorganisationBtn();
		
		
		//click on Create Organisation Icon
		OrganisationPage organisationpage = new OrganisationPage(driver);
		organisationpage.ClickOnCreateOrganisationBtn();
		
		//Enter Organisation name in Organisation text Field
		CreateOrganisationPage createorganisationpage = new CreateOrganisationPage(driver);
		createorganisationpage.organisationNameText(RANDOMORG);
		
		//select industry name
		String industries = excelU.getDataFromExcel("TC1", 12, 8);
		createorganisationpage.getIndustries(industries);
		

		//select Type
		String typee = excelU.getDataFromExcel("TC1", 5, 9);
		createorganisationpage.getaccountDropDown(typee);		

		//Click on save Button
		CreateOrganisationPage createorganisation = new CreateOrganisationPage(driver);
		createorganisation.ClickOnSaveBtn();
		
		//Verification
		OrganisationCreatedPage organisationcreatedpage = new OrganisationCreatedPage(driver);
	    String organisationname = organisationcreatedpage.VerifyOrganisation();
		
		if (organisationname.contains(RANDOMORG)) {
			System.out.println("Organisation is Created");
		}
		else {
			System.out.println("Organisation is Not Created");
		}

		//logout function
		homepage.Logout(driver);
	

		//terminate the Browser
		driver.quit();

	}
}
