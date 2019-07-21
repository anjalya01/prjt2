package testcase;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;


public class Softassert {
  @Test
  public void pass() {
	  System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.gotechmasters.com/index.php");
		System.out.println("title"+driver.getTitle());
		SoftAssert as=new SoftAssert();
		as.assertTrue(driver.getTitle().contains("Aktech"));
		driver.close();
		as.assertAll();
	   
  }
  @Test
  public void fail() {
	  System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.gotechmasters.com/index.php");
		System.out.println("title"+driver.getTitle());
		SoftAssert as=new SoftAssert();
		as.assertTrue(driver.getTitle().contains("Tech"));
		driver.close();
		//as.assertAll();
	   
  }
  
}
