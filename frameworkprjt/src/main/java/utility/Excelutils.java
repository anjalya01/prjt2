package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutils {
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell cell;
	private static XSSFRow row;
	
	public static void setExcelFile(String path,String SheetName) throws Exception
	{
		try {
			FileInputStream Excelfile=new FileInputStream(path);
			ExcelWBook=new XSSFWorkbook(Excelfile);
			ExcelWSheet=ExcelWBook.getSheet(SheetName);
		}catch(Exception e) 
		{
			throw(e);
		}
	}
	public static int getRowContains(String sTestcaseName,int colNum) throws Exception {
		int i;
		try {
			int rowCount=ExcelWSheet.getLastRowNum();
			for(i=1;i<=rowCount;i++)
			{
				if(Excelutils.getCellData(i,colNum).equalsIgnoreCase(sTestcaseName)) 
				{
					break;
					
				}
			}
			return i;
		}catch(Exception e) 
		{
			throw(e);
		}
	}
		public static int blnakrow(int iTestCaseRow,int rCount) {
			int i;
			
			for(i=iTestCaseRow+1;i<=rCount;i++)
			{
				if(Excelutils.getCellData(i,0)!="")
				{
					break;
				}
			}
		
		System.out.println("blank="+i);
		return i;
	}
	public static String getCellData(int RowNum,int colNum )
	{
		try {
			cell=ExcelWSheet.getRow(RowNum).getCell(colNum);
			String CellData=cell.getStringCellValue();
			return CellData;
		}catch(Exception e)
		{
			return"";
		}
	}
	
	public static Object[][] getTableArray(int iTestCaseRow){
		int rCount=ExcelWSheet.getLastRowNum();
		int k=blnakrow(iTestCaseRow, rCount);
		int totalCol=(ExcelWSheet.getRow(iTestCaseRow).getLastCellNum())-1;
		String[][] tabArray=new String[k-iTestCaseRow][totalCol];
		try {
			int ci=0;
			while(iTestCaseRow<k)
			{
				int startCol=1;
				int cj=0;
				int totalCols=(ExcelWSheet.getRow(iTestCaseRow).getLastCellNum())-1;
				for(int j=startCol;j<=totalCols;j++,cj++) {
					tabArray[ci][cj]=getCellData(iTestCaseRow,j);
					System.out.println(tabArray[ci][cj]);
					
				}
				ci=ci+1;
				iTestCaseRow=iTestCaseRow+1;
			}
		}
		catch(Exception e) {
			System.out.println("Could not read the excel sheet");
			e.printStackTrace();
			
		}
		return(tabArray);
		}
	
	

}
