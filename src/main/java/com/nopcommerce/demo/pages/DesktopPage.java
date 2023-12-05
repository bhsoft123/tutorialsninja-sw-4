package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DesktopPage extends Utility {

    By desktopText = By.xpath("//a[normalize-space()='Desktops']");
    By sortByFilter = By.xpath("//select[@id='input-sort']");
    By beforeSortList = By.xpath("//div[@class='caption']//h4//a");
    By afterSortList = By.xpath("//div[@class='caption']//h4//a");
    //By getAllProducts = By.xpath("//div[@class='product-layout product-grid col-lg-4 col-md-4 col-sm-6 col-xs-12']//h4"); // changed to specific product
    By selectHPLP3065 = By.xpath("//a[contains(text(),'HP LP3065')]");
    By verifyText1 = By.xpath("//h1[normalize-space()='HP LP3065']");
    By clickOnCalendar = By.cssSelector("div[class='input-group date'] button[type='button']");
    By monAndYer = By.cssSelector("div[class='datepicker-days'] th[class='picker-switch']");
    By nextMonAndYer = By.cssSelector("div[class='datepicker-days'] th[class='next']");
    By getallDates = By.xpath("//div[@class='datepicker']/div[1]//tbody/tr/td[@class='day']");
    By quantityField = By.cssSelector("#input-quantity");
    By buttonAddToCart = By.cssSelector("#button-cart");
    By verifyText2 = By.xpath("//div[@class='alert alert-success alert-dismissible']");
    By shoppingCart = By.xpath("//div[@class='alert alert-success alert-dismissible']//a[normalize-space()='shopping cart']");


public String getActualText(){ return getTextFromElement(desktopText);}
public void clickOnSortByNameZtoA(String sortByText){ selectByVisibleTextFromDropDown(sortByFilter, sortByText);}
public void clickOnSortByNameAtoZ(String sortByText1){ selectByVisibleTextFromDropDown(sortByFilter,sortByText1);}
public String verifyHPLP30651Text(){ return getTextFromElement(verifyText1);}
public void selectDeliveryDate(String year, String month, String date){
    clickOnElement(clickOnCalendar);
    while(true){
        String monthAndYear = getTextFromElement(monAndYer);
        String []arr = monthAndYear.split(" ");
        String mon= arr[0];
        String yer = arr[1];
        if(mon.equalsIgnoreCase(month)&& yer.equalsIgnoreCase(String.valueOf(year))) {
            break;
        } else {
            clickOnElement(nextMonAndYer);
        }
        }
        List <WebElement> allDates = driver.findElements(getallDates);
        for(WebElement e: allDates){
            if(e.getText().equalsIgnoreCase(date)){
                e.click();
                break;
            }
        }
    }

public void selectProduct()   { clickOnElement(selectHPLP3065);}
public void enterquantity(String quantity1){
        clearTextToElement(quantityField);
        sendTextToElement(quantityField, quantity1);    }
public void addToCart(){ clickOnElement(buttonAddToCart);}
public String verifySuccessMessageText(){ return getTextFromElement(verifyText2);}
public void clickOnShoppingCart(){ clickOnElement(shoppingCart);}


public List productsBeforeSortby() {
    List<WebElement> originalProducts = driver.findElements(beforeSortList);
    ArrayList<String> originalList = new ArrayList<>();

    for (WebElement e : originalProducts) {
        originalList.add(e.getText());
        System.out.println("originalList" + originalList);
    }
    return originalList;
    }
public List productsAfterSortBy() {
    List<WebElement> afterSortByNameZtoA = driver.findElements(afterSortList);
    ArrayList<String> sortedListZtoA = new ArrayList<>();

    for (WebElement e : afterSortByNameZtoA){
        sortedListZtoA.add(e.getText());
        System.out.println("Sorted List: " +sortedListZtoA);
    }
    return sortedListZtoA;
    }
}
/*public void selectProduct(String productname){
        List<WebElement> productList = driver.findElements(getAllProducts);
        //ArrayList<String> products = new ArrayList<>();
        for(WebElement e :productList){
            if(e.getText().equalsIgnoreCase(productname)){
                e.click();
                System.out.println("Product clicked" +e.getText());
            }break;
        }
}*/


