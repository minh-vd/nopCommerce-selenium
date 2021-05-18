package com.nopcommerce.user;

import com.nopcommerce.common.Common_01_Register;
import commons.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

public class User_01_Register extends AbstractTest {
    WebDriver driver;

    UserHomePO userHomePage;
    UserRegisterPO userRegisterPage;
    UserRegisterResultPO userRegisterResultPage;

    String firstName, lastName, dayOfBirth, monthOfBirth, yearOfBirth, email, company, password, confirmPassword;

    @Parameters({"browserName", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName);

        firstName = "Vu";
        lastName = "Minh";
        dayOfBirth = "1";
        monthOfBirth = "January";
        yearOfBirth = "1990";
        email = "minh.selenium" + getRandomNumberByDateTime() + "@mail.com";
        company = "Minh Company";
        password = "123456";
        confirmPassword = "123456";

        log.info("Pre-Condition - Step: Open User Home Page");
        driver.get(url);
        userHomePage = PageGeneratorManager.getUserHomePage(driver);

        log.info("Pre-Condition - Step: Click on Register Link");
        userRegisterPage = userHomePage.clickOnRegisterLink();
    }

    @Test
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

    @Test
    public void TC_03_Register_With_Existing_Email() {
        log.info("TC 03 Register With Existing Email - Step: Input into First Name field");
        userRegisterPage.inputIntoField("FirstName", firstName);

        log.info("TC 03 Register With Existing Email - Step: Input into Last Name field");
        userRegisterPage.inputIntoField("LastName", lastName);
        
        log.info("TC 03 Register With Existing Email - Step: Input existing email into Email field");
        userRegisterPage.inputIntoField("Email", Common_01_Register.email);

        log.info("TC 03 Register With Existing Email - Step: Input into Password field");
        userRegisterPage.inputIntoField("Password", password);

        log.info("TC 03 Register With Existing Email - Step: Input into Confirm Password field");
        userRegisterPage.inputIntoField("ConfirmPassword", confirmPassword);

        log.info("TC 03 Register With Existing Email - Step: Click on Register button");
        userRegisterPage.clickOnRegisterButton();

        log.info("TC 03 Register With Existing Email - Step: Verify Error Message of Email field");
        verifyEquals(userRegisterPage.getTextOfExistingEmailErrorMessage(), "The specified email already exists");
    }

    @Test
    public void TC_04_Register_With_Password_Below_6_Characters() {
        log.info("TC 04 Register With Password Below 6 Characters - Step: Input Password below 6 characters into Password field");
        userRegisterPage.inputIntoField("Password", "12345");

        log.info("TC 04 Register With Password Below 6 Characters - Step: Click on Register button");
        userRegisterPage.clickOnRegisterButton();

        log.info("TC 04 Register With Password Below 6 Characters - Step: Verify Error Message of Password field");
        verifyEquals(userRegisterPage.getTextOfPasswordUnderSixCharactersErrorMessage(), "Password must meet the following rules: must have at least 6 characters");
    }

    @Test
    public void TC_05_Register_With_Not_Matching_Password_And_Confirm_Password() {
        log.info("TC 05 Register With Not Matching Password And Confirm Password - Step: Input Password into Password field");
        userRegisterPage.inputIntoField("Password", "123456");

        log.info("TC 05 Register With Not Matching Password And Confirm Password - Step: Input NOT matching Password into Confirm Password field");
        userRegisterPage.inputIntoField("ConfirmPassword", "1234567");

        log.info("TC 05 Register With Not Matching Password And Confirm Password - Step: Click on Register button");
        userRegisterPage.clickOnRegisterButton();

        log.info("TC 05 Register With Not Matching Password And Confirm Password - Step: Verify Error Message of Confirm Password field");
        verifyEquals(userRegisterPage.getTextOfErrorMessageDisplayedAtFieldName("ConfirmPassword"), "The password and confirmation password do not match.");
    }

    @Test
    public void TC_06_Register_With_Valid_Data() {
        log.info("TC 06 Register With Valid Data - Step: Check on Gender Male checkbox");
        userRegisterPage.checkOnGenderMaleCheckbox();

        log.info("TC 06 Register With Valid Data - Step: Input into First Name field");
        userRegisterPage.inputIntoField("FirstName", firstName);

        log.info("TC 06 Register With Valid Data - Step: Input into Last Name field");
        userRegisterPage.inputIntoField("LastName", lastName);

        log.info("TC 06 Register With Valid Data - Step: Select Day of Birth");
        userRegisterPage.selectDayOfBirth(dayOfBirth);

        log.info("TC 06 Register With Valid Data - Step: Select Month of Birth");
        userRegisterPage.selectMonthOfBirth(monthOfBirth);

        log.info("TC 06 Register With Valid Data - Step: Select Year of Birth");
        userRegisterPage.selectYearOfBirth(yearOfBirth);

        log.info("TC 06 Register With Valid Data - Step: Input into Email field");
        userRegisterPage.inputIntoField("Email", email);

        log.info("TC 06 Register With Valid Data - Step: Input into Company Name field");
        userRegisterPage.inputIntoField("Company", company);

        log.info("TC 06 Register With Valid Data - Step: Input into Password field");
        userRegisterPage.inputIntoField("Password", password);

        log.info("TC 06 Register With Valid Data - Step: Input into Confirm Password field");
        userRegisterPage.inputIntoField("ConfirmPassword", confirmPassword);

        log.info("TC 06 Register With Valid Data - Step: Click on Register button");
        userRegisterPage.clickOnRegisterButton();
        userRegisterResultPage = PageGeneratorManager.getUserRegisterResultPage(driver);

        log.info("TC 06 Register With Valid Data - Step: Verify Register Success Message");
        verifyEquals(userRegisterResultPage.getRegisterResultText(), "Your registration completed");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }
}
