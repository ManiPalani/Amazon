package com.Maven_Amazon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Write_Data {
	public static void write() throws IOException
	{
		
		File f = new File("C:\\Users\\Manikandaprabu\\Desktop\\Book1.xlsx");
		
		FileInputStream fi = new FileInputStream(f);
		
		Workbook wb = new XSSFWorkbook(fi);
		
		Sheet s =wb.createSheet("IPT");
		Row r = s.createRow(0);
		Cell c =r.createCell(0);
		c.setCellValue("DataDriven");
		wb.getSheet("IPT").createRow(1).createCell(2).setCellValue("Freamework");
		FileOutputStream fo = new FileOutputStream(f);
		wb.write(fo);
		wb.close();
		
		
	}
	
public static void main(String[] args) throws IOException {
	write();
	System.out.println("Done Greate Job!!!");
}
}
