package com.crm.mavn;

import java.io.FileInputStream;
import java.sql.DriverManager;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.crm.POM.Homepage;
import com.crm.POM.LoginPage;
import com.crm.POM.VendorPage;
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
public class ToCreateVendorAndVerifyTest {
	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		fileUtility fileu = new fileUtility();
		ExcelUtility excelu = new ExcelUtility();
		webdriverUtility webdu = new webdriverUtility();
		JavaUtility javau = new JavaUtility();

		String URL = fileu.getPropertyvalue("url");
		String USER = fileu.getPropertyvalue("user");
		String PASSWORD = fileu.getPropertyvalue("password");
		String BROWSER = fileu.getPropertyvalue("browser");

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

		//applying implicitly wait
		webdu.waitUntilPageGetsLoaded(driver);
		
		//login to vtiger webpage
		driver.get(URL);

		//enter username in username textfeild
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginToApp(USER, PASSWORD);

		//click on more option in main bar
		Homepage homepage = new Homepage(driver);
		homepage.clickOnMoreOptions();
		
		//click on vender button
		homepage.ClickOnVendors();
		
		//click on create vendor icon
		VendorPage vendorPage = new VendorPage(driver);
		vendorPage.ClickOnCreateVendorBtn();
		
		//enter vendername in vendor name textfeild
		
		driver.findElement(By.name("vendorname")).sendKeys("DHL");

		//click on save button
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();

		String vendorCreated = driver.findElement(By.xpath("//span[text()='DHL -  Vendor Information']")).getText();

		if (vendorCreated.contains("DHL")) {
			System.out.println("Vendor is Created");
		}
		else {
			System.out.println("vendor is Not Created");
		}

		//click on products on main bar 
		driver.findElement(By.xpath("//a[text()='Products']")).click();

		//click on create projects icon
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();

		//enter product name into product name text field
		driver.findElement(By.name("productname")).sendKeys("CARS");

		//click on "+" icon on button of vendor name
		driver.findElement(By.xpath("//img[contains(@onclick,'return window.open')]")).click();

		//switching browser
		Set<String> hand = driver.getWindowHandles();
		for (String eachwindow : hand) {
			driver.switchTo().window(eachwindow);
		}

		//clicking on vendor name
		driver.findElement(By.xpath("//a[text()='DHL']")).click();

		//getting control back to  
		Set<String> prarentbro = driver.getWindowHandles();
		for (String eachwindow2 : prarentbro) {
			driver.switchTo().window(eachwindow2);
		}

		//click on save button
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();

		String product = driver.findElement(By.xpath("//span[text()='CARS -  Product Information']")).getText();
		if (product.contains("CARS")) {
			System.out.println("The Product Is Created");
		}
		else {
			System.out.println("The Product Is Not Created");
		}
		homepage.Logout(driver);


		driver.quit();


	}

}
