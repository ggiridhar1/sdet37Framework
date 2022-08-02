package com.crm.assginment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author V S GIRIDHAR
 *
 */
public class InsertMultipleDataIntoExcel {
	public static void main(String[] args) throws EncryptedDocumentException, FileNotFoundException, Throwable {
		Workbook workbook = WorkbookFactory.create(new FileInputStream("./src/main/java/practice.xlsx"));
		Sheet sheet = workbook.getSheet("Sheet2");

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		driver.get("http://localhost:8888/");

		driver.findElement(By.name("user_name")).sendKeys("admin");

		driver.findElement(By.name("user_password")).sendKeys("admin");

		driver.findElement(By.id("submitButton")).click();

		List<WebElement> links = driver.findElements(By.xpath("//a"));
		int count = links.size();
		for (int i = 0; i < count; i++) {
			Row row = sheet.createRow(i);
			Cell cell = row.createCell(0);
			cell.setCellValue(links.get(i).getAttribute("href"));
		}
		FileOutputStream fileOutputStream=new FileOutputStream("./src/main/java/practice.xlsx");
		workbook.write(fileOutputStream);


	}
}
