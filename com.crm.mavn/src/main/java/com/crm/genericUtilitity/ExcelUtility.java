package com.crm.genericUtilitity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	/**
	 * 
	 * @param Sheetname
	 * @param rowno
	 * @param cellno
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws Throwable
	 */
public String getDataFromExcel(String Sheetname,int rowno,int cellno  ) throws EncryptedDocumentException, Throwable
{
	FileInputStream fileInputStream=new FileInputStream(Iconstants.excelPathString);
	Workbook workbook = WorkbookFactory.create(fileInputStream);
	Sheet sheet = workbook.getSheet(Sheetname);
	Row row = sheet.getRow(rowno);
	Cell cell = row.getCell(cellno);
	DataFormatter dataFormatter= new DataFormatter();
	String value=dataFormatter.formatCellValue(cell);
	return value;
}
/**
 * 
 * @param Sheetname
 * @param rowno
 * @param cellno
 * @param data
 * @throws Throwable
 */
public void insertIntoExcelSheet(String Sheetname,int rowno,int cellno,String data) throws Throwable {
	FileInputStream fileInputStream=new FileInputStream(Iconstants.filePathString);
	Workbook workbook = WorkbookFactory.create(fileInputStream);
	Sheet sheet = workbook.getSheet(Sheetname);
	Row row = sheet.getRow(rowno);
	Cell cell = row.createCell(cellno);
	cell.setCellValue(data);
	FileOutputStream fileOutputStream=new FileOutputStream(Iconstants.excelPathString);
	workbook.write(fileOutputStream);
}
/**
 * 
 * @param sheetname
 * @return
 * @throws Throwable
 * @throws IOException
 */
public int getLastRowNumberFromExcel(String sheetname) throws Throwable, IOException {
	FileInputStream fileInputStream= new FileInputStream(Iconstants.excelPathString);
	Workbook workbook = WorkbookFactory.create(fileInputStream);
	Sheet sheet = workbook.getSheet(sheetname);
	int row = sheet.getLastRowNum();
	return row;
}

}
