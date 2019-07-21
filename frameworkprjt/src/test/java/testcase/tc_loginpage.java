package testcase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseclass.driverinstatnce;
import pages.loginpage;
import utility.Excelutils;

public class tc_loginpage extends driverinstatnce {
	private String sTestCaseName;
	private int iTestCaseRow;
	
	@Test(dataProvider="Authentication")
	  public void loginpage(String username, String password) throws IOException {
		
		loginpage login=new loginpage(driver);
		login.enterusername(username);
		login.enterpassword(password);
		login.clicksignin();
		 Assert.assertTrue(driver.getTitle().contains("Find a Flight"));
		
	}

 @DataProvider
 public Object[][]Authentication() throws Exception{
	 utility.Excelutils.setExcelFile("./Testdata/testdata.xlsx", "testdata");
	 String sTestcaseName="DataProviderWithExcel";
	 iTestCaseRow=Excelutils.getRowContains(sTestcaseName, 0);
	 Object[][] testObjarray=Excelutils.getTableArray(iTestCaseRow);
	 return(testObjarray);
	 
	 
	 
 }
}
/* @DataProvider(name="authentication")
 public static Object[][] credentials(){
	 return new Object[][] {{"arjun","arjun"}};
 }
}*/
		  
/* @Test
  public void login_test() throws IOException {
	  loginpage login=new loginpage(driver);
	  login.enterusername("arjun");
	  login.enterpassword("arjun");
	  login.clicksignin();
	  Assert.assertTrue(driver.getTitle().contains("Find a Flight"));
  }*/

	
/*  @DataProvider(name="authentication")
	 public static Object[][] credentials(){
		 return new Object[][] {{"arjun","arjun"},{"akhil","arjun"}};
		 
	 }

  
@Test(name="authentication")
  public void test(String username, String password) {
	  
		 driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(username);
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
			driver.findElement(By.xpath("//input[@name='login']")).click();
	  
  }*/
	
	// }
  
