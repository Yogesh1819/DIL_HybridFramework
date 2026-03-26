package utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener
{
	public ExtentSparkReporter sparkReport;
	public ExtentReports extentReport;
	public ExtentTest Test;
	String repName;
	
	
	 public void onStart(ITestContext context) 
	 {
		 String timestamp=new SimpleDateFormat("yyyy.mm.dd.HH.mm.ss").format(new Date());
		 
		 repName="Test_Report"+ timestamp+".html";
		 
		 
		 sparkReport=new ExtentSparkReporter(".\\Report\\" +repName);   
		 
		 sparkReport.config().setDocumentTitle("Automation Testing");
		 sparkReport.config().setReportName("Functional Testing");
		 sparkReport.config().setTheme(Theme.DARK);
		 
		 extentReport=new ExtentReports();
		 extentReport.attachReporter(sparkReport);
		 
		 extentReport.setSystemInfo("Application", "Data Inspired Living");
		 extentReport.setSystemInfo("Module name", "Admin");
		 extentReport.setSystemInfo("User name", System.getProperty("user.name"));
		 extentReport.setSystemInfo("Environment", "QA");
		 
		
		String os=context.getCurrentXmlTest().getParameter("os");
		extentReport.setSystemInfo("operating system", os);
		
		String browser=context.getCurrentXmlTest().getParameter("browser");
		extentReport.setSystemInfo("browser name", browser);
		
		List<String> includedGroups=context.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty())
		{
			extentReport.setSystemInfo("Groups", includedGroups.toString());
		}
		 
	 }

	
	 public void onTestStart(ITestResult result) 
	 {
		    // not implemented
	  }
	 
	 public void onTestSuccess(ITestResult result)
	 {
		  
		 Test=extentReport.createTest(result.getName());
		 Test.assignCategory(result.getMethod().getGroups());
		 Test.log(Status.PASS, result.getName());
		 
	  }
	 
	 public void onTestFailure(ITestResult result) 
	 {
		 Test=extentReport.createTest(result.getName());
		 Test.assignCategory(result.getMethod().getGroups());
		 
		 Test.log(Status.FAIL, result.getName());
		 Test.log(Status.INFO, result.getThrowable().getMessage());
		 
		 try
		 {
			 
			
			String imgpath=new BaseClass().captureScreen(result.getName());
			Test.addScreenCaptureFromPath(imgpath);
			 
		 }
		 catch(IOException e1)
		 {
			 e1.printStackTrace();
		 }
		 
		  
	 }
	 
	 public void onTestSkipped(ITestResult result) 
	 {
		 Test=extentReport.createTest(result.getClass().getName());
		 Test.assignCategory(result.getMethod().getGroups());
		 Test.log(Status.SKIP, result.getName());
		 Test.log(Status.INFO, result.getThrowable().getMessage());
		 
	  }
	 
	 public void onFinish(ITestContext context) 
	 {
		   extentReport.flush();
	 }
	 

}
