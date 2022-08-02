package com.crm.assginment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author V S GIRIDHAR
 *
 */
public class Tofetchsingledata {
	public static void main(String[] args) throws Throwable {
		FileInputStream fileInputStream=new FileInputStream("./src/main/java/practice.xlsx");
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workbook.getSheet("Sheet1");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		String value = cell.getStringCellValue();

		System.out.println(value);


	}
}
