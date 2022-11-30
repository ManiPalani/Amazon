package com.Maven_Amazon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SingleData {
	
	static String value;
	public static String singledata_Value(String name,int rowNo,int cellNo) throws IOException {
		
		File f = new File("C:\\Users\\Manikandaprabu\\eclipse-workspace\\Maven_Amazon\\Sheet\\Book1.xlsx");
		FileInputStream fs= new FileInputStream(f);
		Workbook wb =new XSSFWorkbook(fs);
		Sheet s = wb.getSheet(name);
		Row r = s.getRow(rowNo);
		Cell c = r.getCell(cellNo);
		CellType type = c.getCellType();
		if(type.equals(CellType.STRING))
		{
			value = c.getStringCellValue();
		}
		else if(type.equals(CellType.NUMERIC))
		{
			double n = c.getNumericCellValue();
			int value1 =(int)n;
			value = String.valueOf(value1);
		}
		return value;
		
	}
	public static void all_Data() throws IOException
	{
		File f = new File("C:\\Users\\Manikandaprabu\\eclipse-workspace\\Maven_Amazon\\Sheet\\Book1.xlsx");
		FileInputStream fs = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fs);
		Sheet s = wb.getSheet("Sheet1");
		int numberOfRows = s.getPhysicalNumberOfRows();
		for(int i=0;i<numberOfRows;i++)
		{
			Row r =s.getRow(i);
			int numberOfCells = r.getPhysicalNumberOfCells();
			for(int j=0;j<numberOfCells;j++)
			{
				Cell c = r.getCell(j);
				CellType type = c.getCellType();
				if(type.equals(CellType.STRING))
				{
					String st = c.getStringCellValue();
					System.out.print(st);
				}
				else if(type.equals(CellType.NUMERIC))
				{
					double n = c.getNumericCellValue();
					int value =(int)n;
					System.out.print(value);
				}
				
				System.out.print("-");
				
			}
			System.out.println();
		}
		
		
		
	}
	public static void main(String[] args) throws IOException {
		//singledata_Value();
		all_Data();
	}

}
