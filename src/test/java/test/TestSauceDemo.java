package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pojo.BasePage;
import pom.*;

public class TestSauceDemo {
	
 private WebDriver driver;
 private LoginPage loginpage;
 private InventoryPage inventoryPage;
 private CartPage cartPage;
 private CheckoutPage checkoutPage;
 private BasePage basepage;
 
 @Parameters("browser")
 @BeforeClass
 public void setUp(@Optional("chrome") String browser) {
	 basepage = new BasePage(driver);
	 basepage.initializeDriver(browser); 
 }

 @BeforeMethod
 public void pageSetup() {
	 loginpage = new LoginPage(driver);
     inventoryPage = new InventoryPage(driver);
     cartPage = new CartPage(driver);
     checkoutPage = new CheckoutPage(driver);
 }

 @Test
 public void validLoginAndCheckout() throws InterruptedException {
	 
     loginpage.login("standard_user", "secret_sauce");
     inventoryPage.addItemToCart1();
     inventoryPage.addItemToCart2();
     inventoryPage.clickCart();
     
     cartPage.checkout();
     checkoutPage.enterPersonalInfo("John", "Doe", "12345");
     checkoutPage.finishOrder();
 }

// @Test
// public void invalidLogin() {
//     loginpage.login("invalid_user", "wrong_password");
//     String expectedError = "Epic sadface: Username and password do not match any user in this service";
//     
//     Assert.assertEquals(loginpage.actualError, expectedError, "❌ Error message mismatch!");
//
//     System.out.println("✅ Error message is correct!");
//
// }

// @Test
// public void checkoutWithEmptyCart() {
//	 loginpage.login("standard_user", "secret_sauce");
//	 inventoryPage.clickCart();
//     cartPage.checkout();
//     checkoutPage.enterPersonalInfo("John", "Doe", "12345");
//     checkoutPage.finishOrder();


//     Assert.assertTrue(cartPage.isCartEmpty(), "Cart should be empty");

//     Try interacting with checkout button if present, SauceDemo allows but proceeds with empty
//     cartPage.checkout();
     
     // Optionally validate navigation or messages here (SauceDemo behavior)
     // Since no explicit error on empty cart, test passes if no crash occurs
 //}

 @AfterClass
 public void tearDown() {
     if(driver != null) {
         driver.quit();
     }
 }
}

