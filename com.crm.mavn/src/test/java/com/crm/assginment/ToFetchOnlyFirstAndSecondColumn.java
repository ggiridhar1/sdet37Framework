package com.crm.assginment;

import java.io.FileInputStream;

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
public class ToFetchOnlyFirstAndSecondColumn {
	public static void main(String[] args) throws Throwable {
		FileInputStream fileInputStream=new FileInputStream("./src/main/java/Practice.xlsx");
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workbook.getSheet("Sheet3");
		for (int i = 0; i < 4; i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < 2; j++) {
				Cell cell = row.getCell(j);

				System.out.print(cell+" ");
			}
			System.out.println("");
		}






	}
}
