package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class LaptopsAndNotebooksPage extends Utility {

    By actualTextShowAllLaptops = By.xpath("//h2[contains(text(),'Laptops & Notebooks')]");
    //By laptopsAndNotebooks = By.xpath("//li[@class='dropdown']//a[normalize-space()='Laptops & Notebooks']");
    //By showAllLaptops = By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]");
    By sortByHighToLowfilter = By.cssSelector("#input-sort");
    By productPrice1 = By.xpath("(//p[@class='price'])[1]");
    By macBook = By.cssSelector("body div[id='product-category'] div[class='row'] div[class='row'] div:nth-child(4) div:nth-child(1) div:nth-child(2) div:nth-child(1) h4:nth-child(1) a:nth-child(1)");
    By macBookText = By.xpath("//h1[normalize-space()='MacBook']");
    By addToCartButton = By.cssSelector("#button-cart");
    By successMessage = By.xpath("//div[@class='alert alert-success alert-dismissible']");
    By shoppingCart = By.xpath("//div[@class='alert alert-success alert-dismissible']//a[normalize-space()='shopping cart']");


    public String getActualText(){ return getTextFromElement(actualTextShowAllLaptops); }
    //public void hoverToLaptopsAndNotebooksAndClick(){ mouseHoverToElementAndClick(laptopsAndNotebooks);    }
    //public void clickOnShowAllLaptopsAndNotebooks(){ mouseHoverToElementAndClick(showAllLaptops);}
    public void sortByPriceHighToLow(String text){ selectByVisibleTextFromDropDown(sortByHighToLowfilter,text);}
    public void selectMacBook(){ clickOnElement(macBook);}
    public String verifyMacBookText(){ return getTextFromElement(macBookText);}
    public void addToCart(){ clickOnElement(addToCartButton);}
    public String verifySuccessMessage(){ return getTextFromElement(successMessage);}
    public void clickOnShoppingCart1(){ clickOnElement(shoppingCart);}

    //products already sorted in High to low, so storing into array
    public ArrayList<Double> originalPrice() {
        List<WebElement> productPrice = driver.findElements(productPrice1);
        ArrayList<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : productPrice) {
            System.out.println("Original price: " + e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
            System.out.println("After replacement" + originalProductsPrice);
        } return originalProductsPrice;
    }
    //sorting the products by Default value, which will give original order and then storing into array
    public ArrayList<Double> sortedPrice(){
        selectByVisibleTextFromDropDown(sortByHighToLowfilter,"Default");
        List<WebElement> productPrice = driver.findElements(productPrice1);
        ArrayList<Double> sortedProductsPrice = new ArrayList<>();
        for (WebElement e : productPrice){
            String []arr = e.getText().split("Ex Tax:");
            sortedProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",","")));
            System.out.println("Default:" +sortedProductsPrice);
        }return sortedProductsPrice;
    }

}
