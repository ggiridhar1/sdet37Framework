package com.crm.mavn;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author V S GIRIDHAR
 *
 */
public class ToUploadfileTest {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		FileInputStream fileInputStream=new FileInputStream("./src/main/java/Auto.properties.txt");
		Properties properties=new Properties();
		properties.load(fileInputStream);

		String URL = properties.getProperty("url");
		String USER = properties.getProperty("user");
		String PASSWORD = properties.getProperty("password");
		String BROWSER = properties.getProperty("Browser");

		//instance browser specific file
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

		//maximize the window
		driver.manage().window().maximize();

		//Adding Waits
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//Enter Url of the application 
		driver.get(URL);

		//Enter user name in user name Text Field
		driver.findElement(By.name("user_name")).sendKeys(USER);

		//Enter password in password Text field
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);

		//click on submit button
		driver.findElement(By.id("submitButton")).click();

		//click on documents in main navigation bar
		driver.findElement(By.xpath("//a[text()='Documents']")).click();

		//click on create Documents button
		driver.findElement(By.xpath("//img[@title='Create Document...']")).click();

		//enter notes in notes text field
		driver.findElement(By.name("notes_title")).sendKeys("notes_title");

		//switching the control to the frame
		driver.switchTo().frame(0);

		//Enter text in the body
		driver.findElement(By.xpath("//body[@class='cke_show_borders']")).sendKeys("Hello world");

		//transfer control to the parent frame
		driver.switchTo().parentFrame();

		//Upload the Documents
		driver.findElement(By.id("filename_I__")).sendKeys("C:\\Users\\91900\\OneDrive\\Desktop\\New folder (3)\\job\\10th.pdf");

		//click on save button
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();

		WebElement admin = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		//Performing mouse hovering action
		Actions actions=new Actions(driver);
		actions.moveToElement(admin).perform();

		//LOGGING OUT of application
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

		driver.quit();

	}

}
