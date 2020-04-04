package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.format.CellDateFormatter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import demo.Log4jDemo;
import initialise.InitialiseBrowser;

public class ExcelDataProvider {

	private static Logger logger = LogManager.getLogger(ExcelDataProvider.class);

	public static void main(String[] args) {

	}
/*	
	@Test(dataProvider = "test1data")
	public void test1(String username, String password) {
		
	}
*/	
	@Test(dataProvider = "test2data")
	public void test2(String browser, String url) {
		InitialiseBrowser.SetupBrowser(browser, url);
	}
	
	@DataProvider(name = "test1data")
	public static Object[][] getData() {
		String excelPath = System.getProperty("user.dir") + "//data//data.xlsx";
		String sheetName = "Sheet1";
		Object [][] data = testData(excelPath, sheetName);
		return data;
	}
	
	@DataProvider(name = "test2data")
	public static Object[][] getData2() {
		String excelPath = System.getProperty("user.dir") + "//data//googletest.xlsx";
		String sheetName = "Sheet1";
		Object [][] data = testData(excelPath, sheetName);
		return data;
	}

	public static Object[][] testData(String excelPath, String sheetName) {
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		int rowCount = excel.getTotalRows();
		int colCount = excel.getTotalColumn();
		logger.debug("Number of rows = " +rowCount);
		logger.debug("Number of column = " +colCount);

		Object [][] data = new Object[rowCount-1][colCount];					// rowCount-1 to offset the heading


		for (int i = 1; i < rowCount; i++) {									// skip row 1 (index 0) (top row reserve for 
			logger.debug("Iterate Row Index: " +(i-1));
			for (int j = 0; j < colCount; j++) {
				String cellData = excel.readCellString(i, j);					// stay at each row and iterate the columns
				logger.debug("Column " +j+ " = " +cellData);					// i-1 index to compensate for the header row
				data[i-1][j] = cellData;

			}
			logger.debug("Next Row");			
		}
		return data;															// return 2D data array
	}

}
