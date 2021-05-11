package com.nopcommerce.admin;

import com.nopcommerce.common.Common_01_Register;
import commons.AbstractTest;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;
import pageObjects.admin.AdminHomePO;
import pageObjects.admin.AdminLoginPO;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Admin_01 extends AbstractTest {
    WebDriver driver;

    AdminLoginPO adminLoginPage;
    AdminHomePO adminHomePage;

    @Parameters({"browserName", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName);

        log.info("Pre-Condition - Step: Open Admin Login Page");
        driver.get(url);
        adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

        log.info("Pre-Condition - Step: Input Admin Email into \"Email\" text box");
        adminLoginPage.inputIntoTextBoxByID(driver, "Email", GlobalConstants.ADMIN_EMAIL);

        log.info("Pre-Condition - Step: Input Admin Password into \"Password\" text box");
        adminLoginPage.inputIntoTextBoxByID(driver, "Password", GlobalConstants.ADMIN_PASSWORD);

        log.info("Pre-Condition - Step: Click on <LOG IN> button");
        adminHomePage = adminLoginPage.clickOnLoginButton();
    }

    @Test
    public void Order_01_Add_Product_To_Cart() {

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        //closeBrowserAndDriver(driver);
    }
}
