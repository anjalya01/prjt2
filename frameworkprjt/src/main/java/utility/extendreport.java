package utility;

import java.util.Date;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class extendreport {

	
		ExtentReports extent;
		ExtentTest logger;
		WebDriver driver;
		
public static void finalreport(ITestResult result,WebDriver driver,String className) throws IOException
{
	DateFormat format=new SimpleDateFormat("DD-MM-YYYY_hh-mm-ss");
	String timestamp=format.format(new Date());
	long millistsrt=Calendar.getInstance().getTimeInMillis();
	 ExtentHtmlReporter reporter=new ExtentHtmlReporter("./extentReport/"+className+"_"+millistsrt+".html");
	 	ExtentReports extent=new ExtentReports();
	
	  extent.attachReporter(reporter);
	  ExtentTest logger=extent.createTest("LoginTest"+timestamp);
	  reporter.config().setReportName("Sample report");
	  if(result.getStatus()==ITestResult.FAILURE)
	  {
		  String temp=Screenshotutility.getScreenshot(driver);
		  logger.log(Status.FAIL, MarkupHelper.createLabel(result.getMethod().getMethodName()+"test case failed due to below issue:", ExtentColor.RED)); 
         
	logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
      }

else if(result.getStatus()==ITestResult.SUCCESS)
{

	 logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+"test case passed:", ExtentColor.GREEN)); 


}
extent.flush();

}
}




		

