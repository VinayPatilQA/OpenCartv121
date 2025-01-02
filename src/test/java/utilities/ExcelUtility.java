package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public  FileInputStream fi;
	public  FileOutputStream fo;

	public  XSSFWorkbook workbook;
	public  XSSFSheet sheet;
	public  XSSFRow row;
	public  XSSFCell cell;
	public  CellStyle style;
	String path;
	
	
	public ExcelUtility(String path)
	{
		this.path=path;
	}

	// Get Row Counts
	public int getrowCount(String sheetName) throws IOException {

		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);// Passed file location
		sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowCount;

	}

	// Get Cell Counts
	public  int getcellCount(String sheetName,int rownum) throws IOException {

		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);// Passed file location
		sheet = workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		int cellCount =row.getLastCellNum();
		
		workbook.close();
		fi.close();
		return cellCount;
		
		
		
		
		
	}

	// get the data from the cell

	public  String getcelData(String sheetName, int rownum, int coulumn) throws IOException {

		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);// Passed file location
		sheet = workbook.getSheet(sheetName);// getsheet
		row = sheet.getRow(rownum);
		cell=row.getCell(coulumn);
		
		
		DataFormatter formatter =new DataFormatter();
		String data;
		try
		{
			
			data=formatter.formatCellValue(cell);
			
		}
		catch(Exception e)
		{
			data="";
		}
		workbook.close();
		fi.close();
		return data;
		
	}

	
	

	public static void main(String[] args) {

	}


}