package com.crm.Vtiger.Invoice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.checkerframework.checker.i18nformatter.qual.I18nFormat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.This;

public class ToCreateInvoiceWithSaleOrder {
public static void main(String[] args) throws Throwable {
	WebDriver driver=null;
	
	FileInputStream fileInputStream=new FileInputStream("./src/main/java/Auto.properties.txt");
	Properties properties=new Properties();
	properties.load(fileInputStream);
	
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
	driver.findElement(By.name("Invoice")).click();
	
	//
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	
	//
	driver.findElement(By.name("subject")).sendKeys("hello");//
	
	//
	driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
	
	//
	Set<String> hand = driver.getWindowHandles();
	for (String wid : hand) {
		driver.switchTo().window(wid);
	}
	
	//
	driver.findElement(By.id("1")).click();
	
	//
	Set<String> hand2 = driver.getWindowHandles();
	for (String wid2 : hand2) {
		driver.switchTo().window(wid2);
	}
	
	//
	driver.findElement(By.xpath("//img[contains(@onclick,'return window.open(\"index.php?')]")).click();
	
	Set<String> hand3 = driver.getWindowHandles();
	for (String wid3 : hand3) {
		driver.switchTo().window(wid3);
	}
	
	//
	driver.findElement(By.xpath("//a[text()='AVG']")).click();//
	
	//
	driver.switchTo().alert().accept();
	
	//
	Set<String> hand4 = driver.getWindowHandles();
	for (String wid4 : hand4) {
		driver.switchTo().window(wid4);
	}
	
	//
	driver.findElement(By.name("bill_street")).sendKeys("123");//
	
	//
	driver.findElement(By.name("ship_street")).sendKeys("321");//
	
	//
	driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
	
	//
	String verification = driver.findElement(By.xpath("//span[text()='hello -  Invoice Information']")).getText();
	
	if (verification.contains("hello")) {
		System.out.println("Invoice is Created");
	}
	else {
		System.out.println("Invoice is not Created");
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
