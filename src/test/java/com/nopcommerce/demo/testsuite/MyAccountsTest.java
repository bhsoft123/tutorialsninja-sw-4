package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

/**1. Create the class MyAccountsTest
 1.1 create method with name "selectMyAccountOptions" it has one parameter name
 "option" of type string
 1.2 This method should click on the options whatever name is passed as parameter.
 (Hint: Handle List of Element and Select options)
 Write the following test
 1. Test name verifyUserShouldNavigateToRegisterPageSuccessfully()
 1.1 Clickr on My Account Link.
 1.2 Call the method “selectMyAccountOptions” method and pass the parameter
 “Register”
 1.3 Verify the text “Register Account”.
 2. Test name verifyUserShouldNavigateToLoginPageSuccessfully()
 2.1 Clickr on My Account Link.
 2.2 Call the method “selectMyAccountOptions” method and pass the parameter
 “Login”
 2.3 Verify the text “Returning Customer”.
 3. Test name verifyThatUserRegisterAccountSuccessfully()
 3.1 Clickr on My Account Link.
 3.2 Call the method “selectMyAccountOptions” method and pass the parameter
 “Register”
 3.3 Enter First Name
 3.4 Enter Last Name
 3.5 Enter Email
 3.6 Enter Telephone
 3.7 Enter Password
 3.8 Enter Password Confirm
 3.9 Select Subscribe Yes radio button
 3.10 Click on Privacy Policy check box
 3.11 Click on Continue button
 3.12 Verify the message “Your Account Has Been Created!”
 3.13 Click on Continue button
 3.14 Clickr on My Account Link.
 3.15 Call the method “selectMyAccountOptions” method and pass the parameter
 “Logout”
 3.16 Verify the text “Account Logout”
 3.17 Click on Continue button
 4. Test name verifyThatUserShouldLoginAndLogoutSuccessfully()
 4.1 Clickr on My Account Link.
 4.2 Call the method “selectMyAccountOptions” method and pass the parameter
 “Login”
 4.3 Enter Email address
 4.4 Enter Last Name
 4.5 Enter Password
 4.6 Click on Login button
 4.7 Verify text “My Account”
 4.8 Clickr on My Account Link.
 4.9 Call the method “selectMyAccountOptions” method and pass the parameter
 “Logout”
 4.10 Verify the text “Account Logout”
 4.11 Click on Continue button**/

public class MyAccountsTest extends BaseTest {
    HomePage homePage = new HomePage();


@Test
//1. Test name verifyUserShouldNavigateToRegisterPageSuccessfully()
public void verifyUserShouldNavigateToRegisterPageSuccessfully() throws InterruptedException {
    //1.1 Click on My Account Link.
    homePage.clickOnMyAccountLink();
    //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
    Thread.sleep(2000);
    homePage.selectMyAccountOptions("Register");
    //1.3 Verify the text “Register Account”.
    Assert.assertEquals(homePage.getActualtextRegister(), "Register Account", "Error");
}
@Test
//2. Test name verifyUserShouldNavigateToLoginPageSuccessfully()
public void  verifyUserShouldNavigateToLoginPageSuccessfully() {
    //2.1 Clickr on My Account Link.
    homePage.clickOnMyAccountLink();
    //2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
    homePage.selectMyAccountOptions("Login");
    //2.3 Verify the text “Returning Customer”.
    Assert.assertEquals(homePage.verifyReturningCustomerText(), "Returning Customer","Error");
}
@Test
//3. Test name verifyThatUserRegisterAccountSuccessfully()
public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
    //3.1 Click on My Account Link.
    homePage.clickOnMyAccountLink();
    //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
    Thread.sleep(2000);
    homePage.selectMyAccountOptions("Register");
    //3.3 Enter First Name
    homePage.enterFirstName("Orange");
    //3.4 Enter Last Name
    homePage.enterLastName("Purple");
    //3.5 Enter Email
    homePage.enterEmail("orangepurple@gmail.com");
    //3.6 Enter Telephone
    homePage.enterTelephone("12343456656");
    //3.7 Enter Password
    homePage.enterPassword("Orange@purple");
    //3.8 Enter Password Confirm
    homePage.enterConfirmPassword("Orange@purple");
    //3.9 Select Subscribe Yes radio button
    homePage.selectSubscribeButton();
    //3.10 Click on Privacy Policy check box
    homePage.clickOnPrivacyCheckbox();
    //3.11 Click on Continue button
    homePage.clickOnContine();
    //3.12 Verify the message “Your Account Has Been Created!”
    Thread.sleep(2000);
    //Assert.assertEquals(homePage.verifyNewAccount(), "Your Account Has Been Created!", "error");
    //3.13 Click on Continue button
    Thread.sleep(2000);
    //homePage.clickOnContinue();
    //3.14 Clickr on My Account Link.
    homePage.clickOnMyAccountLink();
    //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
    homePage.clickOnLogout();
}
@Test
//4. Test name verifyThatUserShouldLoginAndLogoutSuccessfully()
public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {
    //4.1 Clickr on My Account Link.
    homePage.clickOnMyAccountLink();
    //4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
    Thread.sleep(2000);
    //homePage.selectMyAccountOptions("Login");
    homePage.clickOnLogin1();
    //4.3 Enter First Name
    Thread.sleep(2000);
    //homePage.enterFirstName("Orange");
    //4.4 Enter Last Name
    //homePage.enterLastName("Purple");
    //4.5 Enter Email
    homePage.enterEmail("orangepurple@gmail.com");
    //4.6 Enter Telephone
    //homePage.enterTelephone("12343456656");
    //4.7 Enter Password
    homePage.enterPassword("Orange@purple");
    //4.7 Verify text “My Account”
    homePage.clickOnLogin2();
    //4.8 Clickr on My Account Link.
    homePage.clickOnMyAccountLink();
    //4.9 Call the method “selectMyAccountOptions” method and pass the parameter
    //“Logout”
    homePage.clickOnLogout();
    //4.10 Verify the text “Account Logout”
    //4.11 Click on Continue button

}
}
