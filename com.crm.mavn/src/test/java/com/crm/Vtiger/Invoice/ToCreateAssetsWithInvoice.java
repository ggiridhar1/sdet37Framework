package com.crm.Vtiger.Invoice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToCreateAssetsWithInvoice {
public static void main(String[] args) throws Throwable {
WebDriver driver=null;
	
	FileInputStream fileInputStream=new FileInputStream("./src/main/java/Auto.properties.txt");
	Properties properties=new Properties();
	properties.load(fileInputStream);
	
	Random random=new Random();
	int ran = random.nextInt();
	
	
	
	FileInputStream fileInputStream2=new FileInputStream("./src/main/java/property.xlsx");
	Workbook workbook = WorkbookFactory.create(fileInputStream2);
	 Cell cell = workbook.getSheet("Sheet1").getRow(1).getCell(5);
	 DataFormatter dataFormatter=new DataFormatter();
	 String SERIAL = dataFormatter.formatCellValue(cell);
	 String AUTO = workbook.getSheet("Sheet1").getRow(1).getCell(6).getStringCellValue();
	
	
	String AUTOMOBILE = AUTO+ran;
	
	System.out.println(AUTOMOBILE);
	
	String URL = properties.getProperty("url");
	String USER = properties.getProperty("user");
	String PASSWORD = properties.getProperty("password");
	String BROWSER = properties.getProperty("Browser");
	
	if (BROWSER.equalsIgnoreCase("Chrome")) {
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
	//
	driver.manage().window().maximize();
	
	//
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	//
	driver.get(URL);
	
	//
	driver.findElement(By.name("user_name")).sendKeys(USER);
	
	//
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	
	//
	driver.findElement(By.id("submitButton")).click();
	
	//
	driver.findElement(By.xpath("//a[text()='More']")).click();
	
	//
	driver.findElement(By.name("Assets")).click();
	
	//
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	
	//
	driver.findElement(By.name("serialnumber")).sendKeys(SERIAL);//
	
	//
	driver.findElement(By.xpath("//img[contains(@onclick,'return window.open(\"index.php?module=\"+ document.EditView.product')]")).click();
	
	//
	Set<String> hand = driver.getWindowHandles();
	for (String wid : hand) {
		driver.switchTo().window(wid);
	}
	
	//
	driver.findElement(By.xpath("//a[text()='CARS']")).click();
	
	Set<String> hand2 = driver.getWindowHandles();
	for (String wid2 : hand2) {
		driver.switchTo().window(wid2);
	}
	
	//
	driver.findElement(By.xpath("//img[contains(@onclick,'return window.open(\"index.php?module=\"+ document.EditView.i')]")).click();
	
	Set<String> hand3 = driver.getWindowHandles();
	for (String wid3 : hand3) {
		driver.switchTo().window(wid3);
	}
	
	//
	driver.findElement(By.xpath("//a[text()='hello']")).click();
	Set<String> hand4 = driver.getWindowHandles();
	for (String wid4 : hand4) {
		driver.switchTo().window(wid4);
	}
	
	//
	driver.findElement(By.xpath("//img[contains(@onclick,'return window.open(\"index.php?module=\"+ document.EditView.a')]")).click();
	
	Set<String> hand5 = driver.getWindowHandles();
	for (String wid5 : hand5) {
		driver.switchTo().window(wid5);
	}
	
	//
	driver.findElement(By.xpath("//a[text()='AVG']")).click();
	
	Set<String> hand6 = driver.getWindowHandles();
	for (String wid6 : hand6) {
		driver.switchTo().window(wid6);
	}
	
	//
	driver.findElement(By.id("assetname")).sendKeys(AUTOMOBILE);
	
	//
	driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
	
	//
	String verification = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	
	if (verification.contains(AUTOMOBILE)) {
		System.out.println("Asset is Created");
	}
	else {
		System.out.println("Asset is Not Created");
	}
	
	//
	WebElement adminIcon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions actions=new Actions(driver);
	actions.moveToElement(adminIcon).perform();
	
	//
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	
	//
	driver.quit();
	
}
}
