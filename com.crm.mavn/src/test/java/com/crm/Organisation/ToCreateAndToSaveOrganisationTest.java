package com.crm.Organisation;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

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

import com.crm.POM.CreateOrganisationPage;
import com.crm.POM.Homepage;
import com.crm.POM.LoginPage;
import com.crm.POM.OrganisationCreatedPage;
import com.crm.POM.OrganisationPage;
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
public class ToCreateAndToSaveOrganisationTest {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
	fileUtility fileu = new fileUtility();
	ExcelUtility excelu = new ExcelUtility();
	webdriverUtility webdu = new webdriverUtility();
	JavaUtility javau = new JavaUtility();
	
	String URL = fileu.getPropertyvalue("url");
	String USERNAME = fileu.getPropertyvalue("user");
	String PASSWORD = fileu.getPropertyvalue("password");
	String BROWSER = fileu.getPropertyvalue("browser");
	
	int rannum = javau.getRandomNum();
	String org = excelu.getDataFromExcel("TC1", 1, 3);
	String randomorg = org+rannum;
	

		if (BROWSER.equalsIgnoreCase("chrome")) {
			//To instanciate Chrome browser specific class
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



		//maxizing the window
		webdu.maximizeTheBrowser(driver);

		//adding waits
		webdu.waitUntilPageGetsLoaded(driver);

		//Open Url of the Application
		driver.get(URL);

		//Enter User name in User name Textfield
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginToApp(USERNAME, PASSWORD);

		//click on organisations button main navigation bar
		Homepage homepage = new Homepage(driver);
		homepage.clickonorganisationBtn();
		

		//click on create organisation button
		OrganisationPage organisationpage = new OrganisationPage(driver);
		organisationpage.ClickOnCreateOrganisationBtn();
		
		//Enter orgainaisation name in organisation Text field
		CreateOrganisationPage createorganisationpage = new CreateOrganisationPage(driver);
		createorganisationpage.organisationNameText(randomorg);
		
		//click on save button
		createorganisationpage.ClickOnSaveBtn();
		
		//verfication
		OrganisationCreatedPage organisationcreatedpage = new OrganisationCreatedPage(driver);
		String verify = organisationcreatedpage.VerifyOrganisation();

		if (verify.contains(randomorg)) {
			System.out.println("The organisation is created");
		}
		else {
			System.out.println("The Organisation is Not Created");
		}

		//Logout Function
		homepage.Logout(driver);
	

		//Terminating the Browser
		driver.quit();

	}

}
