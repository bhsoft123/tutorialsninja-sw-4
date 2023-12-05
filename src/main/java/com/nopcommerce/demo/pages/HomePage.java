package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends Utility {

    By topMenuLink = By.cssSelector("body > div:nth-child(3) > nav:nth-child(1) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(1) > div:nth-child(2) > a:nth-child(2)");
    By desktops = By.xpath("//li[@class='dropdown']//a[normalize-space()='Desktops']");
    By laptopsAndNotebooks = By.xpath("//li[@class='dropdown']//a[normalize-space()='Laptops & Notebooks']");
    By showAllLaptops = By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]");
    By components = By.cssSelector("div.container:nth-child(3) nav.navbar div.collapse.navbar-collapse.navbar-ex1-collapse ul.nav.navbar-nav li.dropdown:nth-child(3) > a.dropdown-toggle");
    By showAllComponents = By.xpath("//a[contains(text(),'Show AllComponents')]");
    By showAllDesktops = By.cssSelector("div.container:nth-child(3) nav.navbar div.collapse.navbar-collapse.navbar-ex1-collapse ul.nav.navbar-nav li.dropdown:nth-child(1) div.dropdown-menu > a.see-all");
    By currencyDropDown = By.xpath("//body/nav[@id='top']/div[1]/div[1]/form[1]/div[1]/button[1]");
    By poundSterling = By.xpath("//button[contains(text(),'£Pound Sterling')]");
    //from MyAccountsTest
    By myAccountLink = By.xpath("//span[normalize-space()='My Account']");
    By menulist = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']");
    By actualTextRegister = By.xpath("//h1[normalize-space()='Register Account']");
    By returningtext = By.xpath("//h2[normalize-space()='Returning Customer']");
    By firstName = By.id("input-firstname");
    By lastName = By.id("input-lastname");
    By email = By.id("input-email");
    By phone = By.id("input-telephone");
    By pass = By.id("input-password");
    By confirm =By.xpath("//input[@id='input-confirm']");
    By subscribe = By.xpath("//label[normalize-space()='Yes']");
    By privacy = By.cssSelector("input[value='1'][name='agree']");
    By cont= By.xpath("//input[@value='Continue']");
    By conti = By.xpath("//a[normalize-space()='Continue']");
    By logout =By.xpath("//a[normalize-space()='Logout']");
    By newaccount = By.xpath("//h1[normalize-space()='Your Account Has Been Created!']");
    By login2 = By.xpath("//input[@value='Login']");
    By login1 = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']");


    public void selectMenu(String menu) {
        List<WebElement> topMenuList = getLstOfElements(topMenuLink);
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = getLstOfElements(topMenuLink);
        }
    }
    public void hoverOnDesktopsAndClick() { mouseHoverToElementAndClick(desktops);}
    public void hoverToLaptopsAndNotebooksAndClick(){ mouseHoverToElementAndClick(laptopsAndNotebooks);    }
    public void clickOnShowAllLaptopsAndNotebooks(){ mouseHoverToElementAndClick(showAllLaptops);}
    public void hoverToComponents() {mouseHoverToElementAndClick(components);}
    public void clickOnShowAllComponents(){mouseHoverToElementAndClick(showAllComponents);}
    public void clickOnShowAllDesktops(){ mouseHoverToElementAndClick(showAllDesktops);}
    public void mouseHoverOnCurrencyDropdown() { mouseHoverToElementAndClick(currencyDropDown);}
    public void mouseHoverOnPoundSterlingAndClick(){mouseHoverToElementAndClick(poundSterling);}
    //From MyAccountsTest
    public void clickOnMyAccountLink(){ clickOnElement(myAccountLink);}
    public void selectMyAccountOptions(String menu1){
        List<WebElement> options = getLstOfElements(menulist);
        try{
            for(WebElement element : options){
                if(element.getText().equalsIgnoreCase(menu1)){
                    element.click();
                }
            }
        }catch (StaleElementReferenceException e) {
            options = getLstOfElements(menulist);
        }
    }
    public String getActualtextRegister(){ return getTextFromElement(actualTextRegister) ;}
    public String verifyReturningCustomerText(){ return getTextFromElement(returningtext);}
    public void enterFirstName(String name1){ sendTextToElement(firstName,name1);}
    public void enterLastName(String name2){ sendTextToElement(lastName,name2);}
    public void enterEmail(String name3){sendTextToElement(email, name3);}
    public void enterTelephone(String telephone){sendTextToElement(phone, telephone);}
    public void enterPassword(String password){sendTextToElement(pass, password);}
    public void enterConfirmPassword(String confirmpassword){sendTextToElement(confirm, confirmpassword);}
    public void selectSubscribeButton(){clickOnElement(subscribe);}
    public void clickOnPrivacyCheckbox(){clickOnElement(privacy);}
    public void clickOnContine(){clickOnElement(cont);}
    public String verifyNewAccount(){return getTextFromElement(newaccount);}
    public void clickOnContinue(){ clickOnElement(conti);};
    public void clickOnLogout(){clickOnElement(logout);};
    public void clickOnLogin1(){ clickOnElement(login1);}
    public void clickOnLogin2(){ clickOnElement(login2);}

}