package com.AlliedInsulation.excelUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class ExcelUtils {

	public String[][] getExcelData(String excelName, String sheetName) throws IOException {
		
		FileInputStream file = new FileInputStream(new File("./data/"+excelName+".xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		int totalRows = sheet.getLastRowNum(); // It ignore header in sheet
		int totalColumns = sheet.getRow(0).getLastCellNum(); // It get total count of columns in a row(Cell Contains Data Only)	
		String data[][] = new String[totalRows][totalColumns];

		for(int i=1; i < totalRows+1; i++) {
			XSSFRow row= sheet.getRow(i);//Get the row	 by loop
			for(int j=0; j<totalColumns; j++) {
				String getData = row.getCell(j).getStringCellValue();//Get the all cell value by loop
				data[i-1][j] = getData; // Get data from excel sheet and store it into two dimension array	
			}
		}
		workbook.close();
		file.close();
		return data;
	}
	
}

