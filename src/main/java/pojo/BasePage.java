package pojo;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public BasePage(WebDriver driver) { 
		this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
	}
	
	public void initializeDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
            driver.get("https://www.saucedemo.com");            
            
        } else if (browser.equalsIgnoreCase("edge")) {
        	
//        	System.setProperty("webdriver.edge.driver", "C:\\Users\\PRASAD\\OneDrive\\Desktop\\Automation Practice\\Source\\drivers\\edgedriver_win64\\msedgedriver.exe");
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--inprivate");
            options.addArguments("--start-maximized");
            driver = new EdgeDriver(options);        
            driver.get("https://www.saucedemo.com");
            driver.manage().window().maximize();
            
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("-private");
            driver = new FirefoxDriver(options);
            driver.manage().window().maximize();
            
        } else {
            throw new IllegalArgumentException("Browser not supported: " + browser);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }	
}