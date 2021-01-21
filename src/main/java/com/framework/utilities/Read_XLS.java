package com.framework.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_XLS {

	public String fileName;
	public FileInputStream ipstr = null;
	public FileOutputStream opstr = null;
	private XSSFWorkbook wb = null;
	private XSSFSheet ws = null;
	List<String> list = new ArrayList<String>();

	/**
	 * This is constructor
	 * 
	 * @param fileName:
	 *            contains file name of sheet
	 * @param relativePath:
	 *            relative path of project where file is
	 */
	public Read_XLS(String fileName, String relativePath) {
		this.fileName = fileName;
		try {
			ipstr = new FileInputStream(relativePath + fileName);
			wb = new XSSFWorkbook(ipstr);
			ws = wb.getSheetAt(0);
			ipstr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * To retrieve No Of Rows from .xls file's sheets.
	 * 
	 * @param wsName
	 * @return number of row
	 */
	public int retrieveNoOfRows(String wsName) {
		int sheetIndex = wb.getSheetIndex(wsName);
		if (sheetIndex == -1)
			return 0;
		else {
			ws = wb.getSheetAt(sheetIndex);
			int rowCount = ws.getLastRowNum() + 1;
			return rowCount;
		}
	}

	/**
	 * To retrieve No Of Columns from .xls file's sheets.
	 * 
	 * @param wsName
	 * @return number of column
	 */
	public int retrieveNoOfCols(String wsName) {
		int sheetIndex = wb.getSheetIndex(wsName);
		if (sheetIndex == -1)
			return 0;
		else {
			ws = wb.getSheetAt(sheetIndex);
			int colCount = ws.getRow(0).getLastCellNum();
			return colCount;
		}
	}

	

	/**
	 * To retrieve test data from test case data sheets.
	 * 
	 * @param wsName
	 * @return return all list of test data
	 */
	@SuppressWarnings("deprecation")
	public Object[][] retrieveTestData1(String wsName) {
		int sheetIndex = wb.getSheetIndex(wsName);
		if (sheetIndex == -1)
			return null;
		else {
			int rowNum = retrieveNoOfRows(wsName);
			int colNum = retrieveNoOfCols(wsName);

			Object data[][] = new Object[rowNum - 1][colNum];

			for (int i = 0; i < rowNum - 1; i++) {
				XSSFRow row = ws.getRow(i + 1);
				for (int j = 0; j < colNum; j++) {
					if (row == null) {
						data[i][j] = "";
					} else {
						XSSFCell cell = row.getCell(j);

						if (cell == null) {
							data[i][j] = "";
						} else {
							cell.setCellType(CellType.STRING);
							String value = gFunc_ReadCellValue(cell);
							data[i][j] = value;
						}
					}
				}
			}
			return data;
		}

	}

	/**
	 * get integer value from cell
	 * 
	 * @param cell
	 * @return
	 */
	public static String gFunc_ReadCellValue(Cell cell) {
		String strResult = "";
		Cell celldata = (Cell) cell;
		try {
			switch (celldata.getCellType()) {
			case BLANK:
				strResult = "";
				break;
			case FORMULA:
				strResult = String.valueOf(cell.getCellFormula());
				break;
			case BOOLEAN:
				strResult = String.valueOf(cell.getBooleanCellValue());
				break;
			case ERROR:
				strResult = String.valueOf(cell.getErrorCellValue());
				break;
			case NUMERIC:
				strResult = String.valueOf(cell.getNumericCellValue());
				if (strResult.endsWith(".0")) {
					strResult = strResult.replace(".0", "");
				}
				break;
			case STRING:
				strResult = cell.getStringCellValue();
				break;
			default:
				strResult = "";
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			System.out.println("The cell is blank");
		}
		return strResult;
	}

}
