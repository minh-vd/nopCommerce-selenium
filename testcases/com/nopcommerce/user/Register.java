package com.nopcommerce.user;

//import com.nopcommerce.common.Common_01_Register_User;
import commons.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

public class Register extends AbstractTest {
    WebDriver driver;

    UserHomePO userHomePage;
    UserRegisterPO userRegisterPage;

    @Parameters({"browserName", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName);

        log.info("Pre-Condition - Step: Open User Home Page");
        driver.get(url);
        userHomePage = PageGeneratorManager.getUserHomePage(driver);

        log.info("Pre-Condition - Step: Click on Register Link");
        userRegisterPage = userHomePage.clickOnRegisterLink();
    }

    //@Test
    public void TC_01_Register_With_Empty_Data() {
        log.info("TC 01 - Register With Empty Data - Step: Click on Register button");
        userRegisterPage.clickOnRegisterButton();

        log.info("TC 01 - Register With Empty Data - Step: Verify Error Message of First Name field");
        verifyEquals(userRegisterPage.getTextOfErrorMessageDisplayedAtFieldName("FirstName"), "First name is required.");

        log.info("TC 01 - Register With Empty Data - Step: Verify Error Message of Last Name field");
        verifyEquals(userRegisterPage.getTextOfErrorMessageDisplayedAtFieldName("LastName"), "Last name is required.");

        log.info("TC 01 - Register With Empty Data - Step: Verify Error Message of Email field");
        verifyEquals(userRegisterPage.getTextOfErrorMessageDisplayedAtFieldName("Email"), "Email is required.");

        log.info("TC 01 - Register With Empty Data - Step: Verify Error Message of Password field");
        verifyEquals(userRegisterPage.getTextOfErrorMessageDisplayedAtFieldName("Password"), "Password is required.");

        log.info("TC 01 - Register With Empty Data - Step: Verify Error Message of Confirm Password field");
        verifyEquals(userRegisterPage.getTextOfErrorMessageDisplayedAtFieldName("ConfirmPassword"), "Password is required.");
    }

    @Test
    public void TC_02_Register_With_Invalid_Email() {
        log.info("TC 02 - Register With Invalid Email - Step: Input Invalid Email into Email field");
        userRegisterPage.inputIntoField("Email", "abc.com");

        log.info("TC 02 - Register With Invalid Email - Step: Click on Register button");
        userRegisterPage.clickOnRegisterButton();

        log.info("TC 02 - Register With Invalid Email - Step: Verify Error Message of Email field");
        verifyEquals(userRegisterPage.getTextOfErrorMessageDisplayedAtFieldName("Email"), "Wrong email");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        //closeBrowserAndDriver(driver);
    }
}
