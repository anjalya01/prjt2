package baseclass;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utility.extendreport;

public class driverinstatnce {
	
public WebDriver driver;
	
  @BeforeMethod
  public void intiateDriverinstatnce() throws IOException {
	  if(utility.UtilityFetchproperty.fetchpropertyvalue("browserName").toString().equalsIgnoreCase("chrome")) {
		  
		  //System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		  System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.get(utility.UtilityFetchproperty.fetchpropertyvalue("url").toString());

	  }
	  else if(utility.UtilityFetchproperty.fetchpropertyvalue("browserName").toString().equals("firefox")) {
		  driver=new FirefoxDriver();
		//  System.setProperty("webdriver.geko.driver", "./driver/gekodriver.exe");
		  System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
		  driver.get(utility.UtilityFetchproperty.fetchpropertyvalue("url").toString());
		  
	  }
	
	  
  }
  @AfterMethod
  public void closeDriverInstance(ITestResult result) throws IOException
  {
	  String className=this.getClass().getSimpleName();
	  extendreport.finalreport(result, driver, className);
	  driver.close();
	  
  }
  public void closeDriverInstance()
  {
	  driver.close();
  }
  
}
