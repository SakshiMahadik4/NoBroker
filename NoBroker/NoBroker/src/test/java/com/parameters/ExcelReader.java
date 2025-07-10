package com.parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.cucumber.datatable.DataTable;

public class ExcelReader {
	public String readCityFromSheet(String fileName, String sheetName) {
    String city = "";
    try {
        String path = "src/test/resource/ExcelData/" + fileName;
        FileInputStream fis = new FileInputStream(path);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) throw new RuntimeException("Sheet " + sheetName + " not found");
        Row row = sheet.getRow(1); // 2nd row (index 1)
        Cell cell = row.getCell(0); // 1st column
        city = cell.getStringCellValue();

        workbook.close();
    } catch (Exception e) {
        throw new RuntimeException("Failed to read city from Excel: " + e.getMessage());
    }
    return city;
	}
	
	public static String getCityFromDataTable(DataTable dataTable) {
		List<List<String>> data = dataTable.asLists(String.class);
		String fileName = data.get(0).get(0); // First row, first column = file name
		ExcelReader reader = new ExcelReader();
		return reader.readCityFromSheet(fileName, "CityData"); // Sheet name is hardcoded
	}
	
	
	public Map<String, String> getRowData(int sheetIndex, int rowNumber) {
        Map<String, String> data = new HashMap<>();
        DataFormatter formatter = new DataFormatter(); // Converts any type to String
 
        try (FileInputStream fis = new FileInputStream("src/test/resource/ExcelData/Data.xlsx");
             Workbook workbook = new XSSFWorkbook(fis)) {
 
            Sheet sheet = workbook.getSheetAt(sheetIndex); // Access by index
            Row headerRow = sheet.getRow(0);
            Row dataRow = sheet.getRow(rowNumber);
 
            if (dataRow == null) throw new RuntimeException("Row " + rowNumber + " not found in sheet " + sheetIndex);
 
            for (int i = 0; i < headerRow.getLastCellNum(); i++) {
                String key = formatter.formatCellValue(headerRow.getCell(i)).trim();
                String value = formatter.formatCellValue(dataRow.getCell(i)).trim();
                data.put(key, value);
            }
 
        } catch (IOException e) {
            throw new RuntimeException("Excel reading failed: " + e.getMessage());
        }
 
        return data;
    }
	
	
}