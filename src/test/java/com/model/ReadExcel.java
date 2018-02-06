package com.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	String[][] data;

	@SuppressWarnings("resource")
	public String[][] readExcel(String fileName) {

		try {
			FileInputStream excelFile = new FileInputStream(new File(fileName));
			XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
			XSSFSheet sheet = workbook.getSheetAt(0);
			int rowNum = sheet.getLastRowNum() + 1;
			int colNum = sheet.getRow(0).getLastCellNum();
			data = new String[rowNum][colNum];
			int x = 0;
			for (int i = 1; i < rowNum; i++) {
				int y = 1;
				XSSFRow row = sheet.getRow(i);
				for (int j = 1; j < colNum; j++) {
					XSSFCell cell = row.getCell(j, Row.CREATE_NULL_AS_BLANK);
					String value = String.valueOf(cell);
					data[x][y] = value;
					y++;
					x++;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
}