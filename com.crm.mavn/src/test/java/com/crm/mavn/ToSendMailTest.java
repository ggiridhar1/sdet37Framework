package com.crm.mavn;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.compress.harmony.pack200.NewAttribute;
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
public class ToSendMailTest {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;

		FileInputStream fileInputStream=new FileInputStream("./src/main/java/Auto.properties.txt");
		Properties properties=new Properties();
		properties.load(fileInputStream);

		String URL = properties.getProperty("url");
		String USER = properties.getProperty("user");
		String PASSWORD = properties.getProperty("password");
		String BROWSER = properties.getProperty("Browser");

		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		//maximizing the browser 
		driver.manage().window().maximize();

		//Adding implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//Enter the Url of the application
		driver.get(URL);

		//Enter User name in the Username Text field
		driver.findElement(By.name("user_name")).sendKeys(USER);

		//Enter Password in Password Text field
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);

		//click on Login Button
		driver.findElement(By.id("submitButton")).click();

		//click on Email in main navigation bar
		driver.findElement(By.xpath("//a[text()='Email']")).click();

		//click on compose link
		driver.findElement(By.xpath("//a[text()='Compose']")).click();

		//switching control to child window
		Set<String> hand = driver.getWindowHandles();
		for (String windowid : hand) {
			driver.switchTo().window(windowid);
		}
		//click on add Email button
		driver.findElement(By.xpath("//img[contains(@onclick,'return window.open')]")).click();

		//Switching control to child Browser
		Set<String> hand2 = driver.getWindowHandles();
		for (String windowid2 : hand2) {
			driver.switchTo().window(windowid2);
		}

		//click on contact for Email address
		driver.findElement(By.xpath("//a[text()=' Giridhar']")).click();

		//switch back control to the previous browser
		Set<String> hand3 = driver.getWindowHandles();
		for (String windowid3 : hand3) {
			driver.switchTo().window(windowid3);
		}

		//Enter subject in subject text field
		driver.findElement(By.name("subject")).sendKeys("Document");

		//Import file from local computer
		driver.findElement(By.id("my_file_element")).sendKeys("C:\\Users\\91900\\OneDrive\\Desktop\\New folder (3)\\job\\10th.pdf");

		//click on save button
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();

		WebElement admin = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		//Performing mouse hovering action
		Actions actions=new Actions(driver);
		actions.moveToElement(admin).perform();

		//LOGGING OUT of application
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

		//TEMINATE DRIVER
		driver.quit();





	}

}
