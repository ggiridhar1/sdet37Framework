package com.crm.mavn;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.x.protobuf.MysqlxCrud.Find;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author V S GIRIDHAR
 *
 */
public class VtigerTest {
	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("http://localhost:8888/");

		driver.findElement(By.name("user_name")).sendKeys("admin");

		driver.findElement(By.name("user_password")).sendKeys("admin");

		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.linkText("Organizations")).click();

		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		driver.findElement(By.name("accountname")).sendKeys("TYSS");

		WebElement dropdown = driver.findElement(By.name("industry"));
		Select select= new Select(dropdown);
		select.selectByValue("Construction");

		WebElement dropdowntype = driver.findElement(By.name("accounttype"));
		Select select2= new Select(dropdowntype);
		select2.selectByValue("Customer");

		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();

		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		driver.findElement(By.name("lastname")).sendKeys("Giridhar");

		driver.findElement(By.xpath("//img[contains(@onclick,'return window.open')]")).click();



		Set<String> hand = driver.getWindowHandles();
		for (String handles : hand) {
			System.out.println(handles);
			driver.switchTo().window(handles);
		}
		driver.findElement(By.id("1")).click();
		Thread.sleep(5000);

		Set<String> hand2 = driver.getWindowHandles();
		for (String string : hand2) {
			driver.switchTo().window(string);
			System.out.println(string);
		}

		driver.findElement(By.xpath("//input[@class ='crmButton small save']")).click();


		Thread.sleep(5000);
		driver.quit();

	}
}
