package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pojo.BasePage;

public class InventoryPage extends BasePage{
    @FindBy (xpath= "(//button[text()='Add to cart'])[1]") private WebElement addtocart1;
    @FindBy (xpath= "(//button[text()='Add to cart'])[2]") private WebElement addtocart2;
    @FindBy (xpath= "//div[@id='shopping_cart_container']") private WebElement cartpage;
	
	public InventoryPage(WebDriver driver) {
		super(driver);
	}

    public void addItemToCart1() {
    	addtocart1.click();
    }

    public void addItemToCart2() {
    	addtocart2.click();
    }
    
    public void clickCart() {
    	cartpage.click();
    }

	public void addItemToCart() {
		addItemToCart1();
		addItemToCart2();
		clickCart();
	}
}