package week5day2.Assignment;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

public static String[][] read(String file) throws IOException
{
	XSSFWorkbook wb=new XSSFWorkbook("./data/"+ file +".xlsx");
	XSSFSheet ws = wb.getSheet("Sheet1");
	int rowcount=ws.getLastRowNum();
	int colcount=ws.getRow(0).getLastCellNum();
	String[][] data = new String[rowcount][colcount];
	
	for(int i=1;i<=rowcount;i++)
	{
		XSSFRow row = ws.getRow(i);
		for (int j = 0; j < colcount; j++) 
		{
			XSSFCell cell = row.getCell(j);
			String value = cell.getStringCellValue();
			data[i-1][j] = value;
		}
	}
	wb.close();
	return data;
}
}
