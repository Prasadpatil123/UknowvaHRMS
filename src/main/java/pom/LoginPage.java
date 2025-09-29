package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pojo.BasePage;

public class LoginPage extends BasePage{
	public String actualError;
	@FindBy (xpath="//input[@id='user-name']") private WebElement username;
	@FindBy (xpath="//input[@id='password']") private WebElement password;
	@FindBy (xpath="//input[@id='login-button']") private WebElement loginButton;
	@FindBy (xpath= "//h3[text()='Epic sadface: Username and password do not match any user in this service']") private WebElement errorElement;

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void enterUsername(String loginusername)
	{
        username.sendKeys(loginusername);
	}
	
	public void enterPassword(String loginpassword)
	{
		password.sendKeys(loginpassword);
	}
	
	public void clickLogin() {
        loginButton.click();
    }
	
//	public String login(String loginusername, String loginpassword) {
//        enterUsername(loginusername);
//        enterPassword(loginpassword);
//        clickLogin();
//        actualError = errorElement.getText();
//        return actualError;
//    }
	
	public void login(String loginusername, String loginpassword) {
		System.out.println("login");
		enterUsername(loginusername);
        enterPassword(loginpassword);
        System.out.println("loginpassword");
        clickLogin(); 
        System.out.println("clicklogin");
    }
}