package com.nopcommerce.user;

//import com.nopcommerce.common.Common_01_Register_User;

import commons.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

public class Login extends AbstractTest {
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
        log.info("TC 01 Login With Empty Data - Step: Click on Login button");
        userLoginPage.clickOnLoginButton();

        log.info("TC 01 Login With Empty Data - Step: Verify Required Email Error Message");
        verifyEquals(userLoginPage.getTextOfEmailErrorMessage(), "Please enter your email");
    }

    @Test
    public void TC_02_Login_With_Invalid_Email() {
        log.info("TC 02 Login With Invalid Email - Step: Input Invalid Email");
        userLoginPage.inputIntoEmailField("abc.com");

        log.info("TC 02 Login With Invalid Email - Step: Click on Login button");
        userLoginPage.clickOnLoginButton();

        log.info("TC 02 Login With Invalid Email - Step: Verify Invalid Email Error Message");
        verifyEquals(userLoginPage.getTextOfEmailErrorMessage(), "Wrong email");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        //closeBrowserAndDriver(driver);
    }
}
