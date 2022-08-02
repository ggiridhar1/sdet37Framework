package com.crm.assginment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

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
public class ToInsertDataIntoExcel {
	public static void main(String[] args) throws Throwable {
		FileInputStream fileInputStream=new FileInputStream("./src/main/java/practice.xlsx");
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workbook.getSheet("Sheet1");
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(2);

		cell.setCellValue("santosh");

		FileOutputStream fileOutputStream= new FileOutputStream("./src/main/java/practice.xlsx");
		workbook.write(fileOutputStream);

	}
}
