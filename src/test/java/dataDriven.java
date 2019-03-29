import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {
	
	public ArrayList<String> getData(String testCaseName) throws IOException
	{
		ArrayList<String> a = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("D:\\Pramod\\Projects\\BRT Portal\\WhatsApp\\EmpWhatsApp.xlsx");
		
		//Passing file to XSSFWorkbook as argument
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		//Counting number of sheets present in Excel File
		int sheets = workbook.getNumberOfSheets();
		
		for(int i=0;i<sheets;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("Employees"))
			{
				XSSFSheet sheet = workbook.getSheetAt(i);
				
				Iterator<Row> rows = sheet.iterator();
				Row firstRow = rows.next();
				Iterator<Cell> ce = firstRow.cellIterator();
				
				int k = 0;
				int column = 0;
				while(ce.hasNext())
				{
					Cell value = ce.next();
					if(value.getStringCellValue().equalsIgnoreCase(testCaseName))
					{
						//desired column
						column = k;
					}
					k++;
				}
				System.out.println(column);
				
				while(rows.hasNext())
				{
					Row r = rows.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase("Pramod Kshirsagar"))
					{
						Iterator <Cell> cv = r.cellIterator();
						while(cv.hasNext())
						{
							Cell c = cv.next();
							if(c.getCellType()==CellType.STRING)	
								a.add(c.getStringCellValue());
							else
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));								
						}
					}
				}
			}
		}
		return a;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//FileInputStream used for accessing file from computer
		

	}

}
