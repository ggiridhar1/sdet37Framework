package com.crm.mavn;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

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

import com.crm.POM.CreateSalesOrderPage;
import com.crm.POM.CreatenewsalesorderPage;
import com.crm.POM.Homepage;
import com.crm.POM.LoginPage;
import com.crm.POM.SelectContactPage;
import com.crm.genericUtilitity.ExcelUtility;
import com.crm.genericUtilitity.fileUtility;
import com.crm.genericUtilitity.webdriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author V S GIRIDHAR
 *
 */
public class TocreatesalesOrderWithOppertunityTest {
	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		webdriverUtility webdu = new webdriverUtility();
		fileUtility fileutil = new fileUtility();
		ExcelUtility excelutil = new ExcelUtility();
		

		String URL = fileutil.getPropertyvalue("url");
		String USER = fileutil.getPropertyvalue("user");
		String PASSWORD = fileutil.getPropertyvalue("password");
		String BROWSER = fileutil.getPropertyvalue("browser");

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
		driver.manage().window().maximize();

		//adding wait function
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//Entering URL of application 
		driver.get(URL);

		//Entering username in username Text Field
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginToApp(USER, PASSWORD);

		//click on more option in main navigation
		Homepage homepage = new Homepage(driver);
		homepage.clickOnMoreOptions();
		
		//click on sales order
		homepage.clickOnSaleorder();
		
		//click on add sales order icon
		CreateSalesOrderPage createsalesorderpage = new CreateSalesOrderPage(driver);
		createsalesorderpage.ClickCreateSaleOrderBtn();

		//enter subject in subject text field
		CreatenewsalesorderPage createnewsalesorderpage = new CreatenewsalesorderPage(driver);
		createnewsalesorderpage.EnterSubject("PO1");//load in xl
		
		//click on add contact icon
		createnewsalesorderpage.selectContact();
		

		//transfer driver controls to child browser
		Set<String> hand = driver.getWindowHandles();
		for (String wid : hand) {
			driver.switchTo().window(wid);
		}
		//click on required contact name
		String xl = excelutil.getDataFromExcel("contacts", 1, 5);
	    SelectContactPage selectcontactpage = new SelectContactPage(driver);
	    selectcontactpage.SelectContactAndHanndlepopUp(driver, xl);
		

		//transfer the driver controls to parent browser
		Set<String> hand2 = driver.getWindowHandles();
		for (String wid2 : hand2) {
			driver.switchTo().window(wid2);
		}

		//Handle Status drop down
		String sosdd = excelutil.getDataFromExcel("TC1", 2, 11);
	    selectcontactpage.SelectInSoStatus(driver, sosdd);

		//Click on calender icon
	    selectcontactpage.handledate();

		//click on contact icon
		driver.findElement(By.xpath("//img[@onclick='selectPotential()']")).click();
/*
		//transfer driver control to child browser
		Set<String> hand3 = driver.getWindowHandles();
		for (String wid3 : hand3) {
			driver.switchTo().window(wid3);
		}

		//click on contact
		driver.findElement(By.id("1")).click();

		//transfer driver control back to parent browser
		Set<String> hand4 = driver.getWindowHandles();
		for (String wid4 : hand4) {
			driver.switchTo().window(wid4);
		}
		//click on item icon
		driver.findElement(By.id("searchIcon1")).click();

		//transfer driver control to child browser
		Set<String> hand5 = driver.getWindowHandles();
		for (String wid5 : hand5) {
			driver.switchTo().window(wid5);
		}

		//click on product
		driver.findElement(By.id("popup_product_56")).click();

		//transfer control back to parent browser
		Set<String> hand6 = driver.getWindowHandles();
		for (String wid6 : hand6) {
			driver.switchTo().window(wid6);
		}

		//Enter quantity in quantity textField
		driver.findElement(By.id("qty1")).sendKeys("10");

		//
		driver.findElement(By.xpath("//img[contains(@onclick,'return window.open')]")).click();

		//
		Set<String> hand7 = driver.getWindowHandles();
		for (String wid7 : hand7) {
			driver.switchTo().window(wid7);
		}

		//
		driver.findElement(By.id("1")).click();

		//
		driver.switchTo().alert().accept();

		Set<String> hand8 = driver.getWindowHandles();
		for (String wid8 : hand8) {
			driver.switchTo().window(wid8);
		}
		Thread.sleep(5000);

		driver.findElement(By.name("bill_street")).sendKeys("new York City");

		//
		driver.findElement(By.name("ship_street")).sendKeys("california");

		//
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();

		//
		String verify = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();

		if (verify.contains("PO1")) {
			System.out.println("Sales Order information created");
		}
		else {
			System.out.println("Sales Order Information NOT Created");
		}

		WebElement admin = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		//Performing mouse hovering action
		Actions actions=new Actions(driver);
		actions.moveToElement(admin).perform();

		//LOGGING OUT of application
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		//terminating the driver
	driver.quit();
	*/
	}		
}

