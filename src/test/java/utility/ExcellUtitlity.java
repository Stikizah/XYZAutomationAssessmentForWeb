package utility;

public class ExcellUtitlity {

	public static void main(String[] args) {
		String Path =  "src/test/resources/TestData/testData.xlsx";
		String sheetName = "Sheet1";
		
		ExcelUtilities excel = new ExcelUtilities(Path, sheetName);
		
		excel.getRawCount();
		excel.getCellData(1, 0);
		excel.getCellData(1, 1);
	}
}
