package utils;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	private Logger logger = LogManager.getLogger(ExcelUtils.class);
	private String file_directory =  null;
	private String sheet = null;
	XSSFWorkbook workbook = null;
	XSSFSheet cur_sheet = null;

	
	public ExcelUtils() {
		logger.debug("Empty constructor");
		String projectPath = System.getProperty("user.dir");
		this.file_directory = projectPath+ "\\data\\data.xlsx";
		this.sheet = "Sheet1";
		try {
			workbook = new XSSFWorkbook(this.file_directory);
			cur_sheet = workbook.getSheet(this.sheet);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("No such file or sheet");
		}
	}
	
	public ExcelUtils(String file_directory, String sheet) {
		logger.debug("Constructor with file_directory and sheet initialised");
		this.file_directory = file_directory;
		this.sheet = sheet;
		try {
			workbook = new XSSFWorkbook(this.file_directory);
			cur_sheet = workbook.getSheet(this.sheet);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("No such file or sheet");
		}
	}
	
	public int getTotalColumn() {
		try {
			return cur_sheet.getRow(0).getPhysicalNumberOfCells();						// no. of defined cells
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception at return total column, returning 0");
			return 0;																	// return 0 for eror/exception
		}
	}
	
	public int getTotalRows() {
		try {
			return cur_sheet.getPhysicalNumberOfRows();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception at return total rows, returning 0");
			return 0;																	// return 0 for eror/exception
		}
	}

	public String readCellString(int row, int column) {
		try {
			DataFormatter df = new DataFormatter();
			return df.formatCellValue(cur_sheet.getRow(row).getCell(column));			//format all cells to string before return
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception at reading cell, converting and returning string");
			return null;																	// return 0 for eror/exception
		}	
	}
	
	public double readCellNumeric(int row, int column) {
		try {
			return cur_sheet.getRow(row).getCell(column).getNumericCellValue();
		} catch (IllegalStateException e) {
			e.printStackTrace();
			logger.error("Non Numeric Cell, return 0");
			return 0;																//return 0 if cell is not numeric
		}
	}
/*	
	public void writeCellValue(int row, int column, String value) {
		
		try {
			FileOutputStream output = new FileOutputStream(projectPath+ "\\data\\data.xlsx");
			XSSFSheet cur_sheet = workbook.getSheet(this.sheet);
			cur_sheet.createRow(row).createCell(column).setCellValue(value);
			this.workbook.write(output);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
*/
}
