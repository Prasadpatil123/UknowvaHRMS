package utility;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener{

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;	
	String repName;
	
	public void onStart(ITestContext testContext)
	{
		 String timestamp = new SimpleDateFormat("yyyyy.MM.dd.HH.mm.ss").format(new Date());	//time stamp
		 repName = "Test-Report-" + timestamp + ".html";
		 sparkReporter = new ExtentSparkReporter("./reports/" + repName);
		
//		String timestamp = new SimpleDateFormat("yyyyy.MM.dd.HH.mm.ss").format(new Date(0)); //time stamp line 29
		
//		repName = "Test-Report-" + timestamp + ".html";	//report name						//line 30
//		sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);	//Specify location of the report	//line 31
		
		sparkReporter.config().setDocumentTitle("demo Report");	//Title of the report
		sparkReporter.config().setReportName("regression Testing");	//Name of the report
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "demo");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub Module", "Admin");
		extent.setSystemInfo("User Name", System.getProperty("user.name"));	//Current user name of system
		extent.setSystemInfo("Environement", "QA");
		
		//for below line
		 extent.setSystemInfo("Operating System", System.getProperty("os.name")); // CHANGED
		 extent.setSystemInfo("Browser", "chrome"); // CHANGED: Set here directly
		 extent.setSystemInfo("Groups", "default"); // CHANGED: Set here directly
		
//		String os = testContext.getCurrentXmlTest().getParameter("os");	//capture from master,xml file
//		extent.setSystemInfo("Operating System", os);
//		
//		String browser = testContext.getCurrentXmlTest().getParameter("browser");	//capture from master,xml file
//		extent.setSystemInfo("Browser", browser);
//		
//		List<String> includededGroups = testContext.getCurrentXmlTest().getIncludedGroups();
//		//Condition : if List is not empty it will print then value else not
//		if(!includededGroups.isEmpty())	//add all group name to the method before that it check groups available or not if not then it get add
//		{
//			extent.setSystemInfo("Groups", includededGroups.toString());
//		}		
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
	
	@Override
	public void onFinish(ITestContext context) {
	    extent.flush();  // Flush all info into the report file when all tests complete

	    // Optional: Open the report automatically after finishing all tests
	    String pathOfExtentReport = System.getProperty("user.dir") + "/reports/" + repName;
	    File extentReport = new File(pathOfExtentReport);
	    try {
	        Desktop.getDesktop().browse(extentReport.toURI());
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
