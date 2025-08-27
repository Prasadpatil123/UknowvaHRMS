package pojo;

import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

// log4j2.xml is used in base class because it is common class we are using in every method
public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;	//log4j
	public Properties p;	//config.properties class

	
	@BeforeClass(groups= {""})
	@Parameters({"os","browser"})
	public void setup(String os, String browser) throws Exception	//os and browser value are save in .xml
	{
		//loading config.propertiies file
		FileReader file = new FileReader("C:\\Users\\PRASAD\\OneDrive\\Desktop\\Automation Practice\\UknowvaAutomation\\src\\main\\resources\\config.properties");	//path
		p = new Properties();	// object creation
		p.load(file);	// file will load
		
		logger = LogManager.getLogger(this.getClass()); //logger variable we are using to generate the logs
		
		//Which browser we pass based on that the parameter we are passing
		switch(browser.toLowerCase())
		{
			case "chrome" : driver = new ChromeDriver(); break;
			case "edge" : driver = new EdgeDriver(); break;
			case "firefox" : driver = new FirefoxDriver(); break;
			default : System.out.println("Invalid browser name......"); return;		
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(p.getProperty("url"));	// Read the file from config properties file
		driver.manage().window().maximize();
		Thread.sleep(10000);
	}

	@AfterClass(groups= {""})	//will execute after the testing complete and close the browser
	public void closeBrowser()
	{
		driver.quit();
	}
	
	public String captureScreenSHot(String tname)
	{
		String timestamp = new SimpleDateFormat("yyyyMMddhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath = System.getProperty("user.dir")+"" + tname + "_" + timestamp + ".png";
		File destinationFile = new File(targetFilePath);
		
		sourceFile.renameTo(destinationFile);
		
		return targetFilePath;
	}
	
	//Generate data randomly
	public String randomString()
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}
	
	public String randomNumber()
	{
		String generatednumber = RandomStringUtils.randomNumeric(10);
		return generatednumber;
	}
	
	public String randomAlphaNumberic()
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(3);
		String generatednumber = RandomStringUtils.randomNumeric(3);
		return (generatedstring+"@"+generatednumber);
	}
}