package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class automate {
	public static void main(String[] args) throws Throwable  {
		//instancing chrome driver
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		//maximize the browser
		driver.manage().window().maximize();
		//Implicitly wait for 10sec
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Enter the Url for RMG Yantra
		driver.get("http://localhost:8084/");
		//enter to Username in Username textfield
        driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		//Enter to password text field
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		//click on Sign in button
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		//click on projects link
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		//click on create project
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		//Update Project Name
		driver.findElement(By.name("projectName")).sendKeys("NYKA");
		//Update Creator Name
		driver.findElement(By.name("createdBy")).sendKeys("V.S.GIRIDHAR");
		//handling dropDrown
		WebElement Dropdown = driver.findElement(By.name("status"));
		Select status = new Select(Dropdown);
		status.selectByVisibleText("Created");
		//click on Add project button
		driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
		Connection connect = null;
		try {
			//get register for mySql
				Driver driverrefrance = new Driver();
				DriverManager.registerDriver(driverrefrance);
				//connect to my Sql
				 connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
				//create statement
			    Statement statement = connect.createStatement();
			    //write a query
			    String query="select * from project";
			    //fetch all column in DB
			     ResultSet Result = statement.executeQuery(query);
			     boolean flag =false;
			    //Verify data in DB
			     while (Result.next()) {
			    	 String allProjects = Result.getString(4);
					if (allProjects.contains(allProjects))
					{
						System.out.println("Project is created");
						break;
					}
				}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			connect.close();	
		}
		driver.quit();
	}
}
