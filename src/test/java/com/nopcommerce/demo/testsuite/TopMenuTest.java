package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.ComponentsPage;
import com.nopcommerce.demo.pages.DesktopPage;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LaptopsAndNotebooksPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TopMenuTest extends BaseTest {

//1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
//1.2 This method should click on the menu whatever name is passed as parameter.



    HomePage homePage = new HomePage();
    DesktopPage desktopPage = new DesktopPage();
    LaptopsAndNotebooksPage laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
    ComponentsPage componentsPage = new ComponentsPage();

@Test
public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
    //1.1 Mouse hover on “Desktops” Tab and click
    homePage.hoverOnDesktopsAndClick();
    //1.2 call selectMenu method and pass the menu = “Show All Desktops”
    homePage.selectMenu("Show All Desktops");
    //1.3 Verify the text ‘Desktops’
    Assert.assertEquals(desktopPage.getActualText(), "Desktops", "Error");
}
@Test
//2. verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully()
public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
    //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
    homePage.hoverToLaptopsAndNotebooksAndClick();
    //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
    //homePage.selectMenu("Show All Laptops & Notebooks");
    homePage.clickOnShowAllLaptopsAndNotebooks();
    //2.3 Verify the text ‘Laptops & Notebooks’
    Assert.assertEquals(laptopsAndNotebooksPage.getActualText(), "Laptops & Notebooks","Error");


    }
@Test
//3. verifyUserShouldNavigateToComponentsPageSuccessfully()
public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
    //3.1 Mouse hover on “Components” Tab and click
    homePage.hoverToComponents();
    //3.2 call selectMenu method and pass the menu = “Show All Components”
    homePage.clickOnShowAllComponents();
    //3.3 Verify the text ‘Components
    Assert.assertEquals(componentsPage.getActualText(),"Components","Error");
}
}




