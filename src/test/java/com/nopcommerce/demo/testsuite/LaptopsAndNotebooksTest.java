package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LaptopsAndNotebooksPage;
import com.nopcommerce.demo.pages.ShoppingCartPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
/**Create the class LaptopsAndNotebooksTest
 Write the following test
 1. Test name verifyProductsPriceDisplayHighToLowSuccessfully()
 1.1 Mouse hover on Laptops & Notebooks Tab.and click
 1.2 Click on “Show All Laptops & Notebooks”
 1.3 Select Sort By "Price (High > Low)"
 1.4 Verify the Product price will arrange in High to Low order.
 2. Test name verifyThatUserPlaceOrderSuccessfully()
 2.1 Mouse hover on Laptops & Notebooks Tab and click
 2.2 Click on “Show All Laptops & Notebooks”
 2.3 Select Sort By "Price (High > Low)"
 2.4 Select Product “MacBook”
 2.5 Verify the text “MacBook”
 2.6 Click on ‘Add To Cart’ button
 2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
 2.8 Click on link “shopping cart” display into success message
 2.9 Verify the text "Shopping Cart"
 2.10 Verify the Product name "MacBook"
 2.11 Change Quantity "2"
 2.12 Click on “Update” Tab
 2.13 Verify the message “Success: You have modified your shopping cart!”
 2.14 Verify the Total £737.45
 2.15 Click on “Checkout” button
 2.16 Verify the text “Checkout”
 2.17 Verify the Text “New Customer”
 2.18 Click on “Guest Checkout” radio button
 2.19 Click on “Continue” tab
 2.20 Fill the mandatory fields
 2.21 Click on “Continue” Button
 2.22 Add Comments About your order into text area
 2.23 Check the Terms & Conditions check box
 2.24 Click on “Continue” button
 2.25 Verify the message “Warning: Payment method required!”**/
public class LaptopsAndNotebooksTest extends BaseTest {

    HomePage homePage = new HomePage();
    LaptopsAndNotebooksPage laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();


@Test
//1. Test name verifyProductsPriceDisplayHighToLowSuccessfully()
public void  verifyProductsPriceDisplayHighToLowSuccessfully() {
    //1.1 Mouse hover on Laptops & Notebooks Tab.and click
    homePage.hoverToLaptopsAndNotebooksAndClick();
    //1.2 Click on “Show All Laptops & Notebooks”
    homePage.clickOnShowAllLaptopsAndNotebooks();
    //1.3 Select Sort By "Price (High > Low)"
    laptopsAndNotebooksPage.sortByPriceHighToLow("Price (High > Low)");
    //1.4 Verify the Product price will arrange in High to Low order.
    Assert.assertNotEquals(laptopsAndNotebooksPage.originalPrice(), laptopsAndNotebooksPage.sortedPrice(), "Error");

}
@Test
//2. Test name verifyThatUserPlaceOrderSuccessfully()
public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
    //2.1 Mouse hover on Currency Dropdown and click
    homePage.mouseHoverOnCurrencyDropdown();
    //2.2 Mouse hover on £Pound Sterling and click
    homePage.mouseHoverOnPoundSterlingAndClick();
    //2.1 Mouse hover on Laptops & Notebooks Tab and click
    homePage.hoverToLaptopsAndNotebooksAndClick();
    //2.2 Click on “Show All Laptops & Notebooks”
    homePage.clickOnShowAllLaptopsAndNotebooks();
    //2.3 Select Sort By "Price (High > Low)"
    laptopsAndNotebooksPage.sortByPriceHighToLow("Price (High > Low)");
    //2.4 Select Product “MacBook”
    Thread.sleep(3000);
    laptopsAndNotebooksPage.selectMacBook();
    //2.5 Verify the text “MacBook”
    Assert.assertEquals(laptopsAndNotebooksPage.verifyMacBookText(), "MacBook", "Error");
    //2.6 Click on ‘Add To Cart’ button
    Thread.sleep(2000);
    laptopsAndNotebooksPage.addToCart();
    //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
    Assert.assertEquals(laptopsAndNotebooksPage.verifySuccessMessage(), "Success: You have added MacBook to your shopping cart!\n×","Error");
    //2.8 Click on link “shopping cart” display into success message
    laptopsAndNotebooksPage.clickOnShoppingCart1();
    //2.9 Verify the text "Shopping Cart"
    Thread.sleep(5000);
    Assert.assertEquals(shoppingCartPage.verifyShoppingCartText(),"Shopping Cart  (0.00kg)" ,"Error");
    //2.10 Verify the Product name "MacBook"
    Assert.assertEquals(shoppingCartPage.verifyMacBookText(),"MacBook","Error");
    //2.11 Change Quantity "2"
    Thread.sleep(2000);
    shoppingCartPage.changeMacBookQuantity2("2");
    //2.12 Click on “Update” Tab
    Thread.sleep(2000);
    shoppingCartPage.clickOnUpdate();
    //2.13 Verify the message “Success: You have modified your shopping cart!”
    Assert.assertEquals(shoppingCartPage.successMessageForUpdate(),"Success: You have modified your shopping cart!\n×","Error");
    //2.14 Verify the Total £737.45
    //Assert.assertEquals(shoppingCartPage.verifyTotalAmountMacBook(), "£737.45", "Error");
    //2.15 Click on “Checkout” button
    shoppingCartPage.clickOnCheckOutButton();
    //2.16 Verify the text “Checkout”
    Assert.assertEquals(shoppingCartPage.verifyCheckoutText(),"Checkout", "Error" );
    //2.17 Verify the Text “New Customer”
    Assert.assertEquals(shoppingCartPage.verifyNewCustomerText(), "New Customer","Error");
    //2.18 Click on “Guest Checkout” radio button
    Thread.sleep(2000);
    shoppingCartPage.clickOnGuestCheckOutRadioButton();
    //2.19 Click on “Continue” tab
    shoppingCartPage.clickOnContinueTab();
    //2.20 Fill the mandatory fields
    shoppingCartPage.fillMandatoryFields();
    //2.21 Click on “Continue” Button
    shoppingCartPage.clickOnContinueButton();
    //2.22 Add Comments About your order into text area
    shoppingCartPage.addCommentsAboutOrder();
    //2.23 Check the Terms & Conditions check box
    shoppingCartPage.termsAndConditionsCheckBox();
    //2.24 Click on “Continue” button
    shoppingCartPage.clickOnContinueButtonOnCheckOut();
    //2.25 Verify the message “Warning: Payment method required!”
    Assert.assertEquals(shoppingCartPage.verifyWarningPaymentMessage(), "Warning: Payment method required!\n×", "Error");
}
}
