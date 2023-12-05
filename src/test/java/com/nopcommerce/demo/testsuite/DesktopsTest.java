package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.DesktopPage;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.ShoppingCartPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DesktopsTest extends BaseTest {
    HomePage homePage = new HomePage();
    DesktopPage desktopPage = new DesktopPage();
    ShoppingCartPage shoppingCartPage =new ShoppingCartPage();


    @Test
    //1.Test name verifyProductArrangeInAlphaBaticalOrder()
    public void verifyProductArrangeInAlphaBaticalOrder() {
        //1.1 Mouse hover on Desktops Tab.and click
        homePage.hoverOnDesktopsAndClick();
        //1.2 Click on “Show All Desktops”
        homePage.clickOnShowAllDesktops();
        //Call a method to store original product display list
        desktopPage.productsBeforeSortby();
        //1.3 Select Sort By position "Name: Z to A"
        desktopPage.clickOnSortByNameZtoA("Name (Z - A)");
        desktopPage.productsAfterSortBy();
        //1.4 Verify the Product will arrange in Descending order. check again
        Assert.assertEquals(desktopPage.productsBeforeSortby(),desktopPage.productsAfterSortBy(),"Products in descending order");
    }
    @Test
    //2. Test name verifyProductAddedToShoppingCartSuccessFully()
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Mouse hover on Currency Dropdown and click
        homePage.mouseHoverOnCurrencyDropdown();
        //2.2 Mouse hover on £Pound Sterling and click
        homePage.mouseHoverOnPoundSterlingAndClick();
        //2.3 Mouse hover on Desktops Tab.
        homePage.hoverOnDesktopsAndClick();
        //2.4 Click on “Show All Desktops”
        homePage.clickOnShowAllDesktops();
        //2.5 Select Sort By position "Name: A to Z"
        desktopPage.clickOnSortByNameAtoZ("Name (A - Z)");
        //2.6 Select product “HP LP3065”
        desktopPage.selectProduct();
        //2.7 Verify the Text "HP LP3065" // could add another page named HPLaptopPage
        Assert.assertEquals(desktopPage.verifyHPLP30651Text(), "HP LP3065","error");
        //2.8 Select Delivery Date "2023-11-27"
        desktopPage.selectDeliveryDate("2023", "November", "27");
        //2.9.Enter Qty "1” using Select class.
        desktopPage.enterquantity("1");
        //2.10 Click on “Add to Cart” button
        desktopPage.addToCart();
        //2.11 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        Thread.sleep(2000);
        Assert.assertEquals(desktopPage.verifySuccessMessageText(), "Success: You have added HP LP3065 to your shopping cart!\n×","Error");
        //2.12 Click on link “shopping cart” display into success message
        desktopPage.clickOnShoppingCart();
        //2.13 Verify the text "Shopping Cart"
        Thread.sleep(5000);
        Assert.assertEquals(shoppingCartPage.verifyShoppingCartText(),"Shopping Cart  (1.00kg)" ,"Error");
        //2.14 Verify the Product name "HP LP3065"
        Assert.assertEquals(shoppingCartPage.verifyHPLaptopText(), "HP LP3065", "Error");
        //2.15 Verify the Delivery Date "2023-11-27"
        Assert.assertEquals(shoppingCartPage.verifyDeliveryDate(), "Delivery Date:2023-11-27","Error");
        //2.16 Verify the Model "Product21"
        Assert.assertEquals(shoppingCartPage.verifyModelText(),"Product 21");
        //2.17 Verify the Todal "£74.73"
        Assert.assertEquals(shoppingCartPage.verifyTotalAmount(),"£74.73","Error");
    }
}
