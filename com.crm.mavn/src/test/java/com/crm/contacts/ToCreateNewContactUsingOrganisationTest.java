package com.crm.contacts;

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
import org.openqa.selenium.support.ui.Select;

import com.crm.POM.ContactCreatedPage;
import com.crm.POM.ContactsPage;
import com.crm.POM.CreateNewContactsPage;
import com.crm.POM.Homepage;
import com.crm.POM.LoginPage;
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
public class ToCreateNewContactUsingOrganisationTest {
	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		JavaUtility javau = new JavaUtility();
		ExcelUtility excelu = new ExcelUtility();
		fileUtility fileu = new fileUtility();
		webdriverUtility webdu=new webdriverUtility();
		
		String URL=fileu.getPropertyvalue("url");
		String USERNAME=fileu.getPropertyvalue("user");
		String PASSWORD=fileu.getPropertyvalue("password");
		String BROWSER=fileu.getPropertyvalue("browser");
		
		int ran=javau.getRandomNum();
		
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


		//maximize the window
		webdu.maximizeTheBrowser(driver);

		//Add waits
		webdu.waitUntilPageGetsLoaded(driver);

		//Open URL of a application
		driver.get(URL);

		//Enter User name in Username Textfield
		LoginPage login = new LoginPage(driver);
		login.loginToApp(USERNAME, PASSWORD);
		
		
		//Click on contacts
		Homepage homepage = new Homepage(driver);
		homepage.clickOnContactsButton();

		//Click on createContacts Icon
		ContactsPage contactspage = new ContactsPage(driver);
		contactspage.clickCreateContactsIcon();
		

		//Select First Name
		WebElement FN = driver.findElement(By.name("salutationtype"));
		String option = excelu.getDataFromExcel("contacts", 1, 0);
		webdu.selectByVisible(option, FN);
		

		//Enter last Name
		String namee = excelu.getDataFromExcel("contacts", 1, 1);
		String name = namee+ran;
		CreateNewContactsPage createnewcontactspage = new CreateNewContactsPage(driver);
		createnewcontactspage.addlastname(name);
		

		//Click on save Button
		createnewcontactspage.clickOnSaveBtn();
		
		//vefication
		ContactCreatedPage contactcreatedpage = new ContactCreatedPage(driver);
		 String verify = contactcreatedpage.getVerificationText();
		
		if (verify.contains(name)) {
			System.out.println("The Contact is Created");
		}
		else {
			System.out.println("The Contact is Not Created");
		}

		//mouse hoving on admin icon
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		webdu.mouseOveronElement(driver, ele);

		//Click on sign Out Button
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

		//Terminate the Driver
		driver.quit();
	}

}
