package utility;

import java.awt.Desktop;
import java.io.File;
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

import pojo.BaseClass;

public class ExtentReportManager implements ITestListener{

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repName;
	
	public void onStart(ITestContext testContext)
	{
		String timestamp = new SimpleDateFormat("yyyyy.MM.dd.HH.mm.ss").format(new Date(0)); //time stamp
		
		repName = "Test-Report-" + timestamp + ".html";	//report name
		sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);	//Specify location of the report
		
		sparkReporter.config().setDocumentTitle("Uknowva Report");	//Title of the report
		sparkReporter.config().setReportName("Functional Testing");	//Name of the report
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "uknowva");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub Module", "Admin");
		extent.setSystemInfo("User Name", System.getProperty("user.name"));	//Current user name of system
		extent.setSystemInfo("Environement", "QA");
		
		String os = testContext.getCurrentXmlTest().getParameter("os");	//capture from master,xml file
		extent.setSystemInfo("Operating System", os);
		
		String browser = testContext.getCurrentXmlTest().getParameter("browser");	//capture from master,xml file
		extent.setSystemInfo("Browser", browser);
		
		List<String> includededGroups = testContext.getCurrentXmlTest().getIncludedGroups();
		//Condition : if List is not empty it will print then value else not
		if(!includededGroups.isEmpty())	//add all group name to the method before that it check groups available or not if not then it get add
		{
			extent.setSystemInfo("Groups", includededGroups.toString());
		}		
	}
	
	public void onTestSuccess(ITestResult result)
	{
		test = extent.createTest(result.getTestClass().getName());	//From the class get the class name
		test.assignCategory(result.getMethod().getGroups());	//To display groups in report
		test.log(Status.PASS, result.getName()+"got successfully executed");
	}
	
	public void onTestFailure(ITestResult result)
	{
		test = extent.createTest(result.getTestClass().getName());	//From the class get the class name
		test.assignCategory(result.getMethod().getGroups());	//To display groups in report
		
		test.log(Status.FAIL, result.getName()+"got failed");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
		try
		{
			String imgPath = new BaseClass().captureScreenSHot(result.getName());
			test.addScreenCaptureFromPath(imgPath);
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult result)
	{
		extent.flush();
		//open the report automatically
		String pathOfExtentReport = System.getProperty("user.dir")+"\\reports\\" +repName; //Path of report
		File extentReport = new File(pathOfExtentReport);
		
		try
		{
			Desktop.getDesktop().browse(extentReport.toURI());
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
