package com.nopcommerce.admin;

import commons.AbstractTest;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGeneratorManager;
import pageObjects.admin.*;

public class Admin_02_Customer extends AbstractTest {
    WebDriver driver;

    AdminLoginPO adminLoginPage;
    AdminHomePO adminHomePage;
    AdminCustomerPO adminCustomerPage;

    String newCustomerEmail = "automationfc+" + getRandomNumberByDateTime() + "@gmail.com";
    String newCustomerPassword = "123456";
    String newCustomerFirstName = "Automation";
    String newCustomerLastName = "FC";
    String newCustomerDOB = "1/1/2000";
    String newCustomerCompany = "Automation FC Company";
    String newCustomerAdminComment = "Add new Customer (Guest)";

    @Parameters({"browserName", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName);

        log.info("Pre-Condition - Step: Open Admin Login Page");
        driver.get(url);
        adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

        log.info("Pre-Condition - Step: Input Admin Email into \"Email\" text box");
        adminLoginPage.inputIntoTextBoxById(driver, "Email", GlobalConstants.ADMIN_EMAIL);

        log.info("Pre-Condition - Step: Input Admin Password into \"Password\" text box");
        adminLoginPage.inputIntoTextBoxById(driver, "Password", GlobalConstants.ADMIN_PASSWORD);

        log.info("Pre-Condition - Step: Click on <LOG IN> button");
        adminHomePage = adminLoginPage.clickOnLoginButton();

        log.info("Pre-Condition - Step: Click on \"Customers\" left menu");
        adminHomePage.clickOnAdminDynamicLeftMenuByLabel(driver, "Customers");

        log.info("Pre-Condition - Step: Click on \"Customers\" left sub menu");
        adminHomePage.clickOnAdminDynamicLeftSubMenuByLabel(driver, "Customers");
        adminCustomerPage = PageGeneratorManager.getAdminCustomerPage(driver);
    }

    @Test
    public void Customer_01_Create_New_Customer() {
        log.info("Customer 01 - Create New Customer - Step: Click on <Add new> button");
        adminCustomerPage.clickOnAddNewButton();

        log.info("Customer 01 - Create New Customer - Step: Input \"" + newCustomerEmail + "\" into Email text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "Email", newCustomerEmail);

        log.info("Customer 01 - Create New Customer - Step: Input \"" + newCustomerPassword + "\" into Password text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "Password", newCustomerPassword);

        log.info("Customer 01 - Create New Customer - Step: Input \"" + newCustomerFirstName + "\" into First name text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "FirstName", newCustomerFirstName);

        log.info("Customer 01 - Create New Customer - Step: Input \"" + newCustomerLastName + "\" into Last name text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "LastName", newCustomerLastName);

        log.info("Customer 01 - Create New Customer - Step: Check on Gender = \"Male\"");
        adminCustomerPage.checkOnGenderCheckbox("Male");

        log.info("Customer 01 - Create New Customer - Step: Input \"" + newCustomerDOB + "\" into Date of birth text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "DateOfBirth", newCustomerDOB);

        log.info("Customer 01 - Create New Customer - Step: Input \"" + newCustomerCompany + "\" into Company name text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "Company", newCustomerCompany);

        log.info("Customer 01 - Create New Customer - Step: Select Customer roles = \"Guests\"");
        adminCustomerPage.selectCustomerRoles("Guests");

        log.info("Customer 01 - Create New Customer - Step: Check on Active checkbox");
        adminCustomerPage.checkOnActiveCheckbox();

        log.info("Customer 01 - Create New Customer - Step: Input \"" + newCustomerAdminComment + "\" into Admin comment text area");
        adminCustomerPage.inputIntoAdminCommentTextArea(newCustomerAdminComment);

        log.info("Customer 01 - Create New Customer - Step: Click on <Save and Continue Edit> button");
        adminCustomerPage.clickOnSaveAndContinueEditButton();

        log.info("Customer 01 - Create New Customer - Step: Verify Alert message");
        verifyEquals(adminCustomerPage.getAlertMessage(), "The new customer has been added successfully.");

        log.info("Customer 01 - Create New Customer - Step: Verify New Customer Email");
        verifyEquals(adminCustomerPage.getValueTextFromTextBoxById(driver, "Email"), newCustomerEmail);

        log.info("Customer 01 - Create New Customer - Step: Verify New Customer First Name");
        verifyEquals(adminCustomerPage.getValueTextFromTextBoxById(driver, "FirstName"), newCustomerFirstName);

        log.info("Customer 01 - Create New Customer - Step: Verify New Customer Last Name");
        verifyEquals(adminCustomerPage.getValueTextFromTextBoxById(driver, "LastName"), newCustomerLastName);

        log.info("Customer 01 - Create New Customer - Step: Verify Gender Male checkbox is checked");
        verifyTrue(adminCustomerPage.isGenderCheckboxChecked("Male"));

        log.info("Customer 01 - Create New Customer - Step: Verify New Customer DOB");
        verifyEquals(adminCustomerPage.getValueTextFromTextBoxById(driver, "DateOfBirth"), newCustomerDOB);

        log.info("Customer 01 - Create New Customer - Step: Verify New Customer Company Name");
        verifyEquals(adminCustomerPage.getValueTextFromTextBoxById(driver, "Company"), newCustomerCompany);

        log.info("Customer 01 - Create New Customer - Step: Verify Customer Roles = \"Guests\" is selected");
        verifyTrue(adminCustomerPage.isCustomerRolesSelected("Guests"));

        log.info("Customer 01 - Create New Customer - Step: Verify Active checkbox is checked");
        verifyTrue(adminCustomerPage.isActiveCheckboxChecked());

        log.info("Customer 01 - Create New Customer - Step: Verify Admin Comment");
        verifyEquals(adminCustomerPage.getAdminCommentText(), newCustomerAdminComment);

        log.info("Customer 01 - Create New Customer - Step: Click on \"back to customer list\" link");
        adminCustomerPage.clickOnBackToCustomerListLink();

        log.info("Customer 01 - Create New Customer - Step: Select Customer roles = \"Guests\"");
        adminCustomerPage.selectCustomerRoles("Guests");

        log.info("Customer 01 - Create New Customer - Step: Click on <Search> button");
        adminCustomerPage.clickOnSearchButton();

        log.info("Customer 01 - Create New Customer - Step: Verify New Customer is displayed");
        verifyTrue(adminCustomerPage.isSearchedCustomerDisplayed(newCustomerFirstName + " " + newCustomerLastName, "Guests", newCustomerCompany, "true"));
    }

    @Test
    public void Customer_02_Search_Customer_With_Email() {
        log.info("Customer 02 - Search Customer With Email - Step: Input \"" + newCustomerEmail + "\" into Search Email text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "SearchEmail", newCustomerEmail);

        log.info("Customer 02 - Search Customer With Email - Step: Select Customer roles = \"Guests\"");
        adminCustomerPage.selectCustomerRoles("Guests");

        log.info("Customer 02 - Search Customer With Email - Step: Click on <Search> button");
        adminCustomerPage.clickOnSearchButton();

        log.info("Customer 02 - Search Customer With Email - Step: Verify Searched New Customer is displayed");
        verifyTrue(adminCustomerPage.isSearchedCustomerDisplayed(newCustomerFirstName + " " + newCustomerLastName, "Guests", newCustomerCompany, "true"));
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        //closeBrowserAndDriver(driver);
    }
}
