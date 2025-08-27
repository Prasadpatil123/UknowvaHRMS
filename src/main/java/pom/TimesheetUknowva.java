package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pojo.BasePage;

public class TimesheetUknowva extends BasePage{

	public TimesheetUknowva(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath="//span[text()='Select Client']") WebElement clickClient;
	@FindBy (xpath="//span[text()='Select Project']") WebElement clickProject;
	@FindBy (xpath="//input[@data-title='07-04-2025(Monday)']") WebElement clickMonday;
	@FindBy (xpath="//input[@data-title='08-04-2025(Tuesday)']") WebElement clickTuesday;
	@FindBy (xpath="//input[@data-title='09-04-2025(Wednesday)']") WebElement clickWednesday;
	@FindBy (xpath="//input[@data-title='10-04-2025(Thursday)']") WebElement clickThursday;
	
	
}
