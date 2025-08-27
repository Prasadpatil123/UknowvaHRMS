package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pojo.BaseClass;

public class DropDown extends BaseClass {

	
	public void dropDown(By path)
	{		
		WebElement product = driver.findElement(path);
		Select s1 = new Select(product);	
		s1.selectByVisibleText("text");
	}	
}