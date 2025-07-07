package com.parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

public static String getCred(String sheetno,int rowno,int colno) {
    	
    	FileInputStream fis;
		try {
			fis = new FileInputStream("C:\\Windows\\System32\\config\\systemprofile\\SprintWorkspace\\NoBroker\\src\\test\\resource\\ExcelData\\FormData.xlsx");
		
			Workbook work=new XSSFWorkbook(fis);
	    	
	    	Sheet sheet=work.getSheet(sheetno);
	        return sheet.getRow(rowno).getCell(colno).getStringCellValue() ;
			
		}
    	
    	catch(Exception e){
    		e.printStackTrace();
    		return "";
    	}
		
    }
}
