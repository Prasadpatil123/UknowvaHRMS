package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pojo.BasePage;

public class LoginUknowva extends BasePage{

	public LoginUknowva(WebDriver driver) 
	{
		super(driver);
	}

	@FindBy (xpath="//input[@id='username']") WebElement textUsername;
	@FindBy (xpath="//input[@id='password']") WebElement textPassword;
	@FindBy (xpath="//button[text()='Login']") WebElement buttonLogin;
	
	public void setUsername(String username)
	{
		textUsername.sendKeys(username);
	}

	public void setPassword(String password)
	{
		textPassword.sendKeys(password);
	}
	
	public void clickLogin()
	{
		buttonLogin.click();
	}
}
