package com.nopcommerce.user;

import com.nopcommerce.common.Common_01_Register;
import commons.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.MyAccountPO;
import pageObjects.PageGeneratorManager;
import pageObjects.UserHomePO;
import pageObjects.UserLoginPO;

public class TC_03_My_Account extends AbstractTest {
    WebDriver driver;

    UserHomePO userHomePage;
    UserLoginPO userLoginPage;
    MyAccountPO myAccountPage;

    String firstName, lastName, dayOfBirth, monthOfBirth, yearOfBirth, email, company, password, confirmPassword;

    @Parameters({"browserName", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName);

        firstName = "Automation";
        lastName = "FC";
        dayOfBirth = "1";
        monthOfBirth = "January";
        yearOfBirth = "1999";
        email = "automationfc.vn+" + getRandomNumberByDateTime() + "@gmail.com";
        company = "Automation FC";
        password = "123456";
        confirmPassword = "123456";

        log.info("Pre-Condition - Step: Open User Home Page");
        driver.get(url);
        userHomePage = PageGeneratorManager.getUserHomePage(driver);

        log.info("Pre-Condition - Step: Click on Login Link");
        userLoginPage = userHomePage.clickOnLoginLink();

        log.info("Pre-Condition - Step: Input Email");
        userLoginPage.inputIntoEmailField(Common_01_Register.email);

        log.info("Pre-Condition - Step: Input Password");
        userLoginPage.inputIntoPasswordField(Common_01_Register.password);

        log.info("Pre-Condition - Step: Click Login button");
        userLoginPage.clickOnLoginButton();
        userHomePage = PageGeneratorManager.getUserHomePage(driver);

        log.info("Pre-Condition - Step: Click on My Account link on top bar");
        myAccountPage = userHomePage.clickOnMyAccountLink();
    }

    @Test
    public void TC_01_Edit_Customer_Info() {
        log.info("TC 01 Edit Customer Info - Step: Check on Gender Female checkbox");
        myAccountPage.checkOnGenderFemaleCheckbox();

        log.info("TC 01 Edit Customer Info - Step: Input into First Name text box");
        myAccountPage.inputIntoTextBoxByID(driver, "FirstName", firstName);

        log.info("TC 01 Edit Customer Info - Step: Input into Last Name text box");
        myAccountPage.inputIntoTextBoxByID(driver, "LastName", lastName);

        log.info("TC 01 Edit Customer Info - Step: Select Day of Birth");
        myAccountPage.selectDayOfBirth(dayOfBirth);

        log.info("TC 01 Edit Customer Info - Step: Select Month Of Birth");
        myAccountPage.selectMonthOfBirth(monthOfBirth);

        log.info("TC 01 Edit Customer Info - Step: Select Year Of Birth");
        myAccountPage.selectYearOfBirth(yearOfBirth);

        log.info("TC 01 Edit Customer Info - Step: Input into Email text box");
        myAccountPage.inputIntoTextBoxByID(driver, "Email", email);

        log.info("TC 01 Edit Customer Info - Step: Input into Company text box");
        myAccountPage.inputIntoTextBoxByID(driver, "Company", company);

        log.info("TC 01 Edit Customer Info - Step: Click on Save button");
        myAccountPage.clickOnSaveButton();

        log.info("TC 01 Edit Customer Info - Step: Refresh Page");
        myAccountPage.refreshPage(driver);

        log.info("TC 01 Edit Customer Info - Step: Verify edited First Name");
        verifyEquals(myAccountPage.getValueTextFromTextBoxByID(driver, "FirstName"), firstName);

        log.info("TC 01 Edit Customer Info - Step: Verify edited Last Name");
        verifyEquals(myAccountPage.getValueTextFromTextBoxByID(driver, "LastName"), lastName);

        log.info("TC 01 Edit Customer Info - Step: Verify edited Day of Birth");
        verifyEquals(myAccountPage.getDayOfBirth(), dayOfBirth);

        log.info("TC 01 Edit Customer Info - Step: Verify edited Month of Birth");
        verifyEquals(myAccountPage.getMonthOfBirth(), monthOfBirth);

        log.info("TC 01 Edit Customer Info - Step: Verify edited Year of Birth");
        verifyEquals(myAccountPage.getYearOfBirth(), yearOfBirth);

        log.info("TC 01 Edit Customer Info - Step: Verify edited Email");
        verifyEquals(myAccountPage.getValueTextFromTextBoxByID(driver, "Email"), email);

        log.info("TC 01 Edit Customer Info - Step: Verify edited Company");
        verifyEquals(myAccountPage.getValueTextFromTextBoxByID(driver, "Company"), company);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        //closeBrowserAndDriver(driver);
    }
}
