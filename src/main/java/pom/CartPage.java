package pom;
//CartPage.java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import pojo.BasePage;

import java.util.List;

public class CartPage extends BasePage{
 private WebDriver driver;
 @FindBy (xpath="//button[text()='Checkout']") private WebElement checkoutButton;
 @FindBy (xpath="//div[@class='cart_item']") private WebElement cartItems;
 
 public CartPage(WebDriver driver) {
    super(driver);
 }

// public boolean isCartEmpty() {
//     List items = driver.findElements((By) cartItems);
//     return items.isEmpty();
// }

 public void checkout() {
	 try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	checkoutButton.click();
 }
}