import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class dataDriven2 {
	
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.io.InputStream;
	import java.util.Iterator;

	import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

		public void readXLSXFile(String fileName) {
			InputStream XlsxFileToRead = null;
			XSSFWorkbook workbook = null;
			try {
				XlsxFileToRead = new FileInputStream(fileName);
				
				//Getting the workbook instance for xlsx file
				workbook = new XSSFWorkbook(XlsxFileToRead);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			//getting the first sheet from the workbook using sheet name. 
			// We can also pass the index of the sheet which starts from '0'.
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			XSSFRow row;
			XSSFCell cell;
			
			//Iterating all the rows in the sheet
			Iterator rows = sheet.rowIterator();

			while (rows.hasNext()) {
				row = (XSSFRow) rows.next();
				
				//Iterating all the cells of the current row
				Iterator cells = row.cellIterator();

				while (cells.hasNext()) {
					cell = (XSSFCell) cells.next();

					
					if (cell.getCellType() == CellType.STRING) {
						System.out.print(cell.getStringCellValue() + " ");
					} else if (cell.getCellType() == CellType.NUMERIC) {
						System.out.print(cell.getNumericCellValue() + " ");
					} else if (cell.getCellType() == CellType.BOOLEAN) {
						System.out.print(cell.getBooleanCellValue() + " ");

					} else { // //Here if require, we can also add below methods to
								// read the cell content
								// XSSFCell.CELL_TYPE_BLANK
								// XSSFCell.CELL_TYPE_FORMULA
								// XSSFCell.CELL_TYPE_ERROR
					}
				}
				System.out.println();
				try {
					XlsxFileToRead.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		public static void main(String[] args) {
			dataDriven2 readXlsx = new dataDriven2();
			readXlsx.readXLSXFile("C:/testXlsxRead.xlsx");	
		}