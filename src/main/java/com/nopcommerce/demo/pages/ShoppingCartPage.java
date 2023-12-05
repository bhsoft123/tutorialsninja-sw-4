package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

import java.util.Random;

public class ShoppingCartPage extends Utility {

    By verifyText3 = By.xpath("//h1[contains(text(),'Shopping Cart')]");
    By verifyText4 = By.cssSelector("body > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > form:nth-child(2) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2) > a:nth-child(1)");
    By verifyDelDateText = By.cssSelector("body > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > form:nth-child(2) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2) > small:nth-child(3)");
    By verifyModText = By.cssSelector("body > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > form:nth-child(2) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(3)");
    By verifyTotAmnt = By.cssSelector("body > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > form:nth-child(2) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(6)");
    By verifyMacbkText = By.cssSelector("body > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > form:nth-child(2) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2) > a:nth-child(1)");
    By quantityField = By.cssSelector("input[value='1']");
    By updateButton = By.cssSelector(".fa.fa-refresh");
    By successMesgForUpdate = By.cssSelector(".alert.alert-success.alert-dismissible");
    By totalMacBookAmnt = By.cssSelector("tbody tr td:nth-child(6)");
    By checkOutButton = By.cssSelector("a[class='btn btn-primary']");
    By checkOutText = By.cssSelector("div[id='content'] h1");
    By newCustomerText = By.xpath("//h2[normalize-space()='New Customer']");
    By guestCheckoutButton = By.cssSelector("input[value='guest']");
    By continueTab = By.cssSelector("#button-account");
    By continueButton = By.cssSelector("#button-guest");
    By textArea = By.xpath("//textarea[@name='comment']");
    By checkBox = By.xpath("//input[@name='agree']");
    By continueOnCheckOut = By.cssSelector("#button-payment-method");
    By warningMessage = By.cssSelector(".alert.alert-danger.alert-dismissible");

    public String verifyShoppingCartText(){ return getTextFromElement(verifyText3);}
    public String verifyHPLaptopText(){ return getTextFromElement(verifyText4);}
    public String verifyDeliveryDate(){ return getTextFromElement(verifyDelDateText);}
    public String verifyModelText(){ return getTextFromElement(verifyModText);}
    public String verifyTotalAmount(){ return getTextFromElement(verifyTotAmnt);}
    public String verifyMacBookText() { return getTextFromElement(verifyMacbkText);}
    public void changeMacBookQuantity2(String quantity2) {
        clearTextToElement(quantityField);
        sendTextToElement(quantityField, quantity2);}
    public void clickOnUpdate(){ clickOnElement(updateButton);}
    public String successMessageForUpdate(){ return getTextFromElement(successMesgForUpdate);}
    public String verifyTotalAmountMacBook(){ return getTextFromElement(totalMacBookAmnt);}
    public void clickOnCheckOutButton(){ clickOnElement(checkOutButton);}
    public String verifyCheckoutText(){ return getTextFromElement(checkOutText);}
    public String verifyNewCustomerText(){ return getTextFromElement(newCustomerText);}
    public void clickOnGuestCheckOutRadioButton(){ clickOnElement(guestCheckoutButton);}
    public void clickOnContinueTab(){ clickOnElement(continueTab);}
    public void fillMandatoryFields(){
        sendTextToElement(By.id("input-payment-firstname"),"Orange");
        sendTextToElement(By.id("input-payment-lastname"),"Purple");
        Random random = new Random();
        sendTextToElement(By.id("input-payment-email"),"orangepurple" + random.nextInt(1000)+"@gmail.com");
        sendTextToElement(By.id("input-payment-telephone"),"01234567899");
        sendTextToElement(By.id("input-payment-address-1"),"Orange Street");
        sendTextToElement(By.id("input-payment-city"),"London");
        sendTextToElement(By.name("postcode"),"AB1 2CD");
        selectByVisibleTextFromDropDown(By.id("input-payment-country"), "United Kingdom");
        selectByVisibleTextFromDropDown(By.id("input-payment-zone"), "Bristol");
    }
    public void clickOnContinueButton(){ clickOnElement(continueButton);    }
    public void addCommentsAboutOrder(){ sendTextToElement(textArea, "Please deliver to next door no- 15");}
    public void termsAndConditionsCheckBox(){ clickOnElement(checkBox); }
    public void clickOnContinueButtonOnCheckOut(){ clickOnElement(continueOnCheckOut);}
    public String verifyWarningPaymentMessage(){ return getTextFromElement(warningMessage);}

}
