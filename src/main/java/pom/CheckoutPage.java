package pom;
//CheckoutPage.java

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pojo.BasePage;

public class CheckoutPage extends BasePage {
 private WebDriver driver;
 @FindBy (xpath="//input[@id='first-name']") private WebElement firstname;
 @FindBy (xpath="//input[@id='last-name']") private WebElement lastname;
 @FindBy (xpath="//input[@id='postal-code']") private WebElement zipcode;
 @FindBy (xpath="//button[@id='cancel']") private WebElement cancelButton;
 @FindBy (xpath="//input[@id='continue']") private WebElement continueButton;
 @FindBy (xpath="//button[@id='finish']") private WebElement finishButton;

 public CheckoutPage(WebDriver driver) {
     super(driver);
 }

 public void enterPersonalInfo(String firstName, String lastName, String postalCode) {
	 firstname.sendKeys(firstName);
     lastname.sendKeys(lastName);
     zipcode.sendKeys(postalCode);
     continueButton.click();
 }

 public void finishOrder() {
     finishButton.click();
 }

// public String getConfirmationMessage() {
//     WebDriverWait wait = new WebDriverWait(driver, 10);
//     return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessage)).getText();
// }
}

