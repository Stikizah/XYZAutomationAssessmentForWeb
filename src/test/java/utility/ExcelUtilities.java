package utility;

import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
//	static HSSFWorkbook workbook;
//	static HSSFSheet sheet;
	
	public ExcelUtilities(String excelPath, String sheetName) {
		
		try {
			InputStream file = new FileInputStream(excelPath);
			
			workbook = new XSSFWorkbook(excelPath);
//			workbook = new HSSFWorkbook(new POIFSFileSystem(file)); 
			sheet = workbook.getSheet(sheetName);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		
	}
//	public static void main(String[] args) {
//		getRawCount();
//		getCellData();
//	}

	public static void getCellData(int rowNum, int cellNum) 
	{
		//To get Sting value from datasheet
		String value = sheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
		
		//To get a in value from the datasheet
//		double valueone = sheet.getRow(rowNum).getCell(cellNum).getNumericCellValue();
		
		//To change dataformatter
//		DataFormatter formatter = new DataFormatter();
		
//		Object valuetwo = formatter.formatCellValue(sheet.getRow(rowNum).getCell(cellNum));
		
		
		System.out.println(value);

	}

	public static void getRawCount()  
	{
		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println("Number or Rows :" +rowCount);

	}

}
