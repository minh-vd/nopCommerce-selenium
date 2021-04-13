package com.nopcommerce.common;

import commons.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.PageGeneratorManager;
import pageObjects.UserHomePO;
import pageObjects.UserRegisterPO;
import pageObjects.UserRegisterResultPO;

public class Common_01_Register extends AbstractTest {
    WebDriver driver;

    UserHomePO userHomePage;
    UserRegisterPO userRegisterPage;
    UserRegisterResultPO userRegisterResultPage;

    public static String firstName, lastName, dayOfBirth, monthOfBirth, yearOfBirth, email, company, password, confirmPassword;

    @Parameters({"browserName", "url"})
    @BeforeTest
    public void beforeTest(String browserName, String url) {
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

        log.info("Pre-Condition: Register - Step: Open User Home Page");
        driver.get(url);
        userHomePage = PageGeneratorManager.getUserHomePage(driver);

        log.info("Pre-Condition: Register - Step: Click on Register Link");
        userRegisterPage = userHomePage.clickOnRegisterLink();

        log.info("Pre-Condition: Register - Step: Check on Gender Male checkbox");
        userRegisterPage.checkOnGenderMaleCheckbox();

        log.info("Pre-Condition: Register - Step: Input into First Name field");
        userRegisterPage.inputIntoField("FirstName", firstName);

        log.info("Pre-Condition: Register - Step: Input into Last Name field");
        userRegisterPage.inputIntoField("LastName", lastName);

        log.info("Pre-Condition: Register - Step: Select Day of Birth");
        userRegisterPage.selectDayOfBirth(dayOfBirth);

        log.info("Pre-Condition: Register - Step: Select Month of Birth");
        userRegisterPage.selectMonthOfBirth(monthOfBirth);

        log.info("Pre-Condition: Register - Step: Select Year of Birth");
        userRegisterPage.selectYearOfBirth(yearOfBirth);

        log.info("Pre-Condition: Register - Step: Input into Email field");
        userRegisterPage.inputIntoField("Email", email);

        log.info("Pre-Condition: Register - Step: Input into Company Name field");
        userRegisterPage.inputIntoField("Company", company);

        log.info("Pre-Condition: Register - Step: Input into Password field");
        userRegisterPage.inputIntoField("Password", password);

        log.info("Pre-Condition: Register - Step: Input into Confirm Password field");
        userRegisterPage.inputIntoField("ConfirmPassword", confirmPassword);

        log.info("Pre-Condition: Register - Step: Click on Register button");
        userRegisterPage.clickOnRegisterButton();
        userRegisterResultPage = PageGeneratorManager.getUserRegisterResultPage(driver);
    }
}
