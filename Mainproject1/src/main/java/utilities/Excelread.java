package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelread
{
	static FileInputStream f;
	static XSSFWorkbook w;
	static XSSFSheet sh;
public static String readStringData(int row,int colom,String sheet) throws IOException 
{
	f=new FileInputStream("C:\\Users\\User\\eclipse-workspace\\Mainproject1\\src\\test\\resources\\7rmart\\GroceryApp.xlsx");
	w=new XSSFWorkbook(f);
	sh=w.getSheet(sheet);
	XSSFRow r=sh.getRow(row);
	XSSFCell c=r.getCell(colom);
	return c.getStringCellValue();
}
public static String readIntegerData(int row,int colom,String sheet) throws IOException
{
	f=new FileInputStream("C:\\Users\\User\\eclipse-workspace\\Mainproject1\\src\\test\\resources\\7rmart\\GroceryApp.xlsx");
	w=new XSSFWorkbook(f);
	sh=w.getSheet(sheet);
	XSSFRow r=sh.getRow(row);
	XSSFCell c=r.getCell(colom);
	int val=(int)c.getNumericCellValue();
	return String.valueOf(val);
			
	
}

}
