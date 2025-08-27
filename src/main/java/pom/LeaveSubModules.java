package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pojo.BasePage;

public class LeaveSubModules extends BasePage{

	public LeaveSubModules(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath="//a[@id='NjA5']") WebElement leaveMenu;
	@FindBy (xpath="//a[@id='NjAy']") WebElement applyForLeaveMenu;
	@FindBy (xpath="//a[@id='NjAz']") WebElement leaveHistoryMenu;
	@FindBy (xpath="//a[@id='Njgx']") WebElement leaveRuleMenu;
	@FindBy (xpath="//a[@id='NjAw']") WebElement holidayMenu;
	@FindBy (xpath="//a[@id='Njgy']") WebElement balanceLogMenu;
	@FindBy (xpath="//a[@id='NjA0']") WebElement myLeaveBalanceMenu;
	@FindBy (xpath="//a[@id='Njg1']") WebElement applyForCompOffMenu;
	@FindBy (xpath="//a[@id='OTM3']") WebElement applyForOptionalHolidayMenu;
	//Apply for the leave page
	@FindBy (xpath="//input[@id='for_user_me']") WebElement radioMe;
	@FindBy (xpath="//input[@id='for_user_other']") WebElement radioOtherUser;
	@FindBy (xpath="//select[@id='leave_type']") WebElement selectLeaveType;
	@FindBy (xpath="//input[@id='full_day']") WebElement radioFullDayType;
	@FindBy (xpath="//input[@id='HalfDay']") WebElement radioHalfDayType;
	@FindBy (xpath="//input[@id='other']") WebElement radioMultipleDayType;
	
	//Multiple days
	@FindBy (xpath="//input[@id='first_half_from']") WebElement radioFromDateFirstHalf;
	@FindBy (xpath="//input[@id='second_half_from']") WebElement radioFromDateSecondHalf;
	@FindBy (xpath="//input[@id='first_half_to']") WebElement radioToDateFirstHalf;
	@FindBy (xpath="//input[@id='second_half_to']") WebElement radioToDateSecondHalf;
	
	@FindBy (xpath="//input[@id='from']") WebElement calendarFromDate;
	@FindBy (xpath="//input[@id='to']") WebElement calendarToDate;
	
	@FindBy (xpath="//textarea[@id='leave_reason']") WebElement textareaReason;
	
	@FindBy (xpath="//button[@id='resetsearch']") WebElement cancelButton;
	@FindBy (xpath="//input[@class='button']") WebElement saveButton;
		
	public void clickOnLeaveMenu()
	{
		leaveMenu.click();
	}
	
	public void clickOnApplyForLeaveMenu()
	{
		applyForLeaveMenu.click();
	}
	
	public void clickOnLeaveHistoryMenu()
	{
		leaveHistoryMenu.click();
	}
	
	public void clickOnLeaveRuleMenu()
	{
		leaveRuleMenu.click();
	}
	
	public void clickOnHolidayMenu()
	{
		holidayMenu.click();
	}

	public void clickOnBalanceLogMenu()
	{
		balanceLogMenu.click();
	}

	public void clickOnMyLeaveBalanceMenu()
	{
		myLeaveBalanceMenu.click();
	}

	public void clickOnapplyForCompOffMenu()
	{
		applyForCompOffMenu.click();
	}
	
	public void clickOnApplyForOptionalHoliday(){
		applyForOptionalHolidayMenu.click();
	}

	public void clickOnRadioButtonMe(){
		radioMe.click();
	}
	
	public void clickRadioOnButtonOtherUser() {
		radioOtherUser.click();
	}
	
	public void clickOnLeaveType() {
		selectLeaveType.click();
	}
	
	public void clickOnRadioButtonDayTypeFullDay() {
		radioFullDayType.click();
	}
	
	public void clickOnRadiobuttonDayTypeHalfDay() {
		radioHalfDayType.click();
	}

	public void clickOnRadiobuttonDayTypeMultipleDay() {
		radioMultipleDayType.click();
	}

	public void clickOnRadioButtonFromDateFirstHalf() {
		radioFromDateFirstHalf.click();
	}
	
	public void clickOnRadioButtonFromDateSecondHalf() {
		radioFromDateSecondHalf.click();
	}
	
	public void clickOnRadioButtonToDateFirstHalf() {
		radioToDateFirstHalf.click();
	}
	
	public void clickOnRadioButtonToDateSecondHalf() {
		radioToDateSecondHalf.click();
	}
	
	public void clickOnCalendarFrom() {
		calendarFromDate.click();
	}
	
	public void clickOnCalendarTo() {
		calendarToDate.click();
	}
	
	public void textAreaReason(String reason) {
		textareaReason.sendKeys(reason);
	}

	public void clickOnCancelButton() {
		
	}

	public void clickOnSaveButton() {
		
	}
}