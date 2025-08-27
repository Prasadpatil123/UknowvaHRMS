package test;

import org.testng.annotations.Test;

import pojo.BaseClass;
import pom.LoginUknowva;

public class TC001_AccountLogin extends BaseClass {
	@Test(groups= {""})
	public void verify_login()
	{
		
		logger.info("******* Starting TC001_AccountLogin *******");
		//LoginPage
		LoginUknowva lu = new LoginUknowva(driver); 
		lu.setUsername(p.getProperty("username"));
		lu.setPassword(p.getProperty("password"));
		lu.clickLogin();
		
		logger.info("******* Ending TC001_AccountLogin *******");
	}

	
	
}
