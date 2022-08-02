package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToVerifyTheDataAddedIntoRmgyantra {
public static void main(String[] args) throws SQLException {
	String projectID="TY_PROJ_905";
	//Step1: Register to DB
	Driver driverref = new Driver();
	DriverManager.registerDriver(driverref);
	
	//Step 2:Connect to mySQL
	Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
	
	//Step 3:Create Statement Query
	Statement statement=connection.createStatement();
	
	
		
	String query = "insert into project values('"+projectID+"','Giridhar','10/07/2022','assign','created','0');";
	
	
	//Step 4: Execute the Query
	 int result = statement.executeUpdate(query);
	 
	//Step 5: Launch the Browser
	 	WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		//maximize the browser
		driver.manage().window().maximize();
		
		//implicitly wait for 10 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Open the Web Application
		driver.get("http://localhost:8084/");
		
		//Login
		//Find username textfield
		WebElement username = driver.findElement(By.id("usernmae"));
		username.sendKeys("rmgyantra");
		
		//Find Password textfield
		WebElement password = driver.findElement(By.id("inputPassword"));
		password.sendKeys("rmgy@9999");
		
		//Click on Login Button
		driver.findElement(By.tagName("button")).click();
		
		//click on Projects
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		WebElement createdProject = driver.findElement(By.xpath("//td[text()='"+projectID+"']"));
		if(createdProject.isDisplayed())
		{
			System.out.println("Project is created");
		}
		else {
			System.out.println("Project is not created");
		}
			
	connection.close();
	driver.quit();
}
}
