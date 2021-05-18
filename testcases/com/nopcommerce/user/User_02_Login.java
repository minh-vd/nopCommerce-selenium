package com.nopcommerce.user;

import com.nopcommerce.common.Common_01_Register;
import commons.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

public class User_02_Login extends AbstractTest {
    WebDriver driver;

    UserHomePO userHomePage;
    UserLoginPO userLoginPage;

    @Parameters({"browserName", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName);

        log.info("Pre-Condition - Step: Open User Home Page");
        driver.get(url);
        userHomePage = PageGeneratorManager.getUserHomePage(driver);

        log.info("Pre-Condition - Step: Click on Login Link");
        userLoginPage = userHomePage.clickOnLoginLink();
    }

    @Test
    public void TC_01_Login_With_Empty_Data() {
        log.info("TC 01 - Login With Empty Data - Step: Click on Login button");
        userLoginPage.clickOnLoginButton();

        log.info("TC 01 - Login With Empty Data - Step: Verify Required Email Error Message");
        verifyEquals(userLoginPage.getTextOfEmailErrorMessage(), "Please enter your email");
    }

    @Test
    public void TC_02_Login_With_Invalid_Email() {
        log.info("TC 02 - Login With Invalid Email - Step: Input Invalid Email");
        userLoginPage.inputIntoEmailField("abc.com");

        log.info("TC 02 - Login With Invalid Email - Step: Click on Login button");
        userLoginPage.clickOnLoginButton();

        log.info("TC 02 - Login With Invalid Email - Step: Verify Invalid Email Error Message");
        verifyEquals(userLoginPage.getTextOfEmailErrorMessage(), "Wrong email");
    }

    @Test
    public void TC_03_Login_With_Unregistered_Email() {
        log.info("TC 03 - Login With Unregistered Email - Step: Input unregistered Email");
        userLoginPage.inputIntoEmailField("abc@mail.com");

        log.info("TC 03 - Login With Unregistered Email - Step: Click on Login button");
        userLoginPage.clickOnLoginButton();

        log.info("TC 03 - Login With Unregistered Email - Step: Verify Unregistered Email Error Message");
        verifyEquals(userLoginPage.getTextOfLoginValidationErrorMessage(), "Login was unsuccessful. Please correct the errors and try again. No customer account found");
    }

    @Test
    public void TC_04_Login_With_Registered_Email_But_Not_Input_Password() {
        log.info("TC 04 - Login With Registered Email But Not Input Password - Step: Input registered Email");
        userLoginPage.inputIntoEmailField(Common_01_Register.email);

        log.info("TC 04 - Login With Registered Email But Not Input Password - Step: Click on Login button");
        userLoginPage.clickOnLoginButton();

        log.info("TC 04 - Login With Registered Email But Not Input Password - Step: Verify Email Error Message");
        verifyEquals(userLoginPage.getTextOfLoginValidationErrorMessage(), "Login was unsuccessful. Please correct the errors and try again. The credentials provided are incorrect");
    }

    @Test
    public void TC_05_Login_With_Registered_Email_But_Wrong_Password() {
        log.info("TC 05 - Login With Registered Email But Wrong Password - Step: Input registered Email");
        userLoginPage.inputIntoEmailField(Common_01_Register.email);

        log.info("TC 05 - Login With Registered Email But Wrong Password - Step: Input wrong Password");
        userLoginPage.inputIntoPasswordField("1234567");

        log.info("TC 05 - Login With Registered Email But Wrong Password - Step: Click on Login button");
        userLoginPage.clickOnLoginButton();

        log.info("TC 05 - Login With Registered Email But Wrong Password - Step: Verify Email Error Message");
        verifyEquals(userLoginPage.getTextOfLoginValidationErrorMessage(), "Login was unsuccessful. Please correct the errors and try again. The credentials provided are incorrect");
    }

    @Test
    public void TC_06_Login_With_Correct_Email_And_Password() {
        log.info("TC 06 - Login With Correct Email And Password - Step: Input correct Email");
        userLoginPage.inputIntoEmailField(Common_01_Register.email);

        log.info("TC 06 - Login With Correct Email And Password - Step: Input correct Password");
        userLoginPage.inputIntoPasswordField(Common_01_Register.password);

        log.info("TC 06 - Login With Correct Email And Password - Step: Click on Login button");
        userLoginPage.clickOnLoginButton();
        userHomePage = PageGeneratorManager.getUserHomePage(driver);

        log.info("TC 06 - Login With Correct Email And Password - Step: Verify showing My Account on top bar");
        verifyTrue(userHomePage.isMyAccountLinkDisplayed());
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }
}
