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

    String editedCustomerEmail = "edit_automationfc+" + getRandomNumberByDateTime() + "@gmail.com";
    String editedCustomerFirstName = "Edit Automation";
    String editedCustomerLastName = "Edit FC";
    String editedCustomerDOB = "2/2/2000";
    String editedCustomerCompany = "Edit Automation FC Company";
    String editedCustomerAdminComment = "Edit Customer (Guest)";

    String newAddressFirstName = newCustomerFirstName;
    String newAddressLastName = newCustomerLastName;
    String newAddressEmail = newCustomerEmail;
    String newAddressCompany = newCustomerCompany;
    String newAddressCountry = "Viet Nam";
    String newAddressState = "Other";
    String newAddressCity = "HCM";
    String newAddress1 = "1 De La Thanh";
    String newAddress2 = "2 De La Thanh";
    String newAddressZipCode = "00001";
    String newAddressPhone = "0123456789";
    String newAddressFax = "0987456321";

    String editedAddressFirstName = editedCustomerFirstName;
    String editedAddressLastName = editedCustomerLastName;
    String editedAddressEmail = editedCustomerEmail;
    String editedAddressCompany = editedCustomerCompany;
    String editedAddressCountry = "United States";
    String editedAddressState = "California";
    String editedAddressCity = "Albany";
    String editedAddress1 = "123 PO Box";
    String editedAddress2 = "356 Los Bancos";
    String editedAddressZipCode = "986589";
    String editedAddressPhone = "0987654666";
    String editedAddressFax = "+441619998888";

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

    //@Test
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

    //@Test
    public void Customer_03_Search_Customer_With_First_Name_And_Last_Name() {
        log.info("Customer 03 - Search Customer With First Name And Last Name - Step: Refresh Page");
        adminCustomerPage.refreshPage(driver);

        log.info("Customer 03 - Search Customer With First Name And Last Name - Step: Input \"" + newCustomerFirstName + "\" into Search First name text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "SearchFirstName", newCustomerFirstName);

        log.info("Customer 03 - Search Customer With First Name And Last Name - Step: Input \"" + newCustomerLastName + "\" into Search Last name text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "SearchLastName", newCustomerLastName);

        log.info("Customer 03 - Search Customer With First Name And Last Name - Step: Select Customer roles = \"Guests\"");
        adminCustomerPage.selectCustomerRoles("Guests");

        log.info("Customer 03 - Search Customer With First Name And Last Name - Step: Click on <Search> button");
        adminCustomerPage.clickOnSearchButton();

        log.info("Customer 03 - Search Customer With First Name And Last Name - Step: Verify Searched New Customer is displayed");
        verifyTrue(adminCustomerPage.isSearchedCustomerDisplayed(newCustomerFirstName + " " + newCustomerLastName, "Guests", newCustomerCompany, "true"));
    }

    //@Test
    public void Customer_04_Search_Customer_With_Company_Name() {
        log.info("Customer 04 - Search Customer With Company Name - Step: Refresh Page");
        adminCustomerPage.refreshPage(driver);

        log.info("Customer 04 - Search Customer With Company Name - Step: Input \"" + newCustomerCompany + "\" into Search Company text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "SearchCompany", newCustomerCompany);

        log.info("Customer 04 - Search Customer With Company Name - Step: Select Customer roles = \"Guests\"");
        adminCustomerPage.selectCustomerRoles("Guests");

        log.info("Customer 04 - Search Customer With Company Name - Step: Click on <Search> button");
        adminCustomerPage.clickOnSearchButton();

        log.info("Customer 04 - Search Customer With Company Name - Step: Verify Searched New Customer is displayed");
        verifyTrue(adminCustomerPage.isSearchedCustomerDisplayed(newCustomerFirstName + " " + newCustomerLastName, "Guests", newCustomerCompany, "true"));
    }

    //@Test
    public void Customer_05_Search_Customer_With_Full_Data() {
        log.info("Customer 05 - Search Customer With Full Data - Step: Refresh Page");
        adminCustomerPage.refreshPage(driver);

        log.info("Customer 05 - Search Customer With Full Data - Step: Input \"" + newCustomerEmail + "\" into Search Email text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "SearchEmail", newCustomerEmail);

        log.info("Customer 05 - Search Customer With Full Data - Step: Input \"" + newCustomerFirstName + "\" into Search First name text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "SearchFirstName", newCustomerFirstName);

        log.info("Customer 05 - Search Customer With Full Data - Step: Input \"" + newCustomerLastName + "\" into Search Last name text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "SearchLastName", newCustomerLastName);

        log.info("Customer 05 - Search Customer With Full Data - Step: Select Month of Birth = \"1\"");
        adminCustomerPage.selectDefaultDropdownById(driver, "SearchMonthOfBirth", "1");

        log.info("Customer 05 - Search Customer With Full Data - Step: Select Day of Birth = \"1\"");
        adminCustomerPage.selectDefaultDropdownById(driver, "SearchDayOfBirth", "1");

        log.info("Customer 05 - Search Customer With Full Data - Step: Input \"" + newCustomerCompany + "\" into Search Company text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "SearchCompany", newCustomerCompany);

        log.info("Customer 05 - Search Customer With Full Data - Step: Select Customer roles = \"Guests\"");
        adminCustomerPage.selectCustomerRoles("Guests");

        log.info("Customer 05 - Search Customer With Full Data - Step: Click on <Search> button");
        adminCustomerPage.clickOnSearchButton();

        log.info("Customer 05 - Search Customer With Full Data - Step: Verify Searched New Customer is displayed");
        verifyTrue(adminCustomerPage.isSearchedCustomerDisplayed(newCustomerFirstName + " " + newCustomerLastName, "Guests", newCustomerCompany, "true"));
    }

    @Test
    public void Customer_06_Edit_Customer() {
        log.info("Customer 06 - Edit Customer - Step: Refresh Page");
        adminCustomerPage.refreshPage(driver);

        log.info("Customer 06 - Edit Customer - Step: Input \"" + newCustomerEmail + "\" into Search Email text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "SearchEmail", newCustomerEmail);

        log.info("Customer 06 - Edit Customer - Step: Input \"" + newCustomerFirstName + "\" into Search First name text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "SearchFirstName", newCustomerFirstName);

        log.info("Customer 06 - Edit Customer - Step: Input \"" + newCustomerLastName + "\" into Search Last name text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "SearchLastName", newCustomerLastName);

        log.info("Customer 06 - Edit Customer - Step: Select Month of Birth = \"1\"");
        adminCustomerPage.selectDefaultDropdownById(driver, "SearchMonthOfBirth", "1");

        log.info("Customer 06 - Edit Customer - Step: Select Day of Birth = \"1\"");
        adminCustomerPage.selectDefaultDropdownById(driver, "SearchDayOfBirth", "1");

        log.info("Customer 06 - Edit Customer - Step: Input \"" + newCustomerCompany + "\" into Search Company text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "SearchCompany", newCustomerCompany);

        log.info("Customer 06 - Edit Customer - Step: Select Customer roles = \"Guests\"");
        adminCustomerPage.selectCustomerRoles("Guests");

        log.info("Customer 06 - Edit Customer - Step: Click on <Search> button");
        adminCustomerPage.clickOnSearchButton();

        log.info("Customer 06 - Edit Customer - Step: Click on <Edit> icon of Searched Customer \"" + newCustomerFirstName + newCustomerLastName + "\"");
        adminCustomerPage.clickOnDynamicEditIconByCustomerInfo(newCustomerFirstName + " " + newCustomerLastName, "Guests", newCustomerCompany, "true");

        log.info("Customer 06 - Edit Customer - Step: Input \"" + editedCustomerEmail + "\" into Email text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "Email", editedCustomerEmail);

        log.info("Customer 06 - Edit Customer - Step: Input \"" + editedCustomerFirstName + "\" into First name text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "FirstName", editedCustomerFirstName);

        log.info("Customer 06 - Edit Customer - Step: Input \"" + editedCustomerLastName + "\" into Last name text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "LastName", editedCustomerLastName);

        log.info("Customer 06 - Edit Customer - Step: Input \"" + editedCustomerDOB + "\" into Date of birth text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "DateOfBirth", editedCustomerDOB);

        log.info("Customer 06 - Edit Customer - Step: Input \"" + editedCustomerCompany + "\" into Company name text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "Company", editedCustomerCompany);

        log.info("Customer 06 - Edit Customer - Step: Input \"" + editedCustomerAdminComment + "\" into Admin comment text area");
        adminCustomerPage.inputIntoAdminCommentTextArea(editedCustomerAdminComment);

        log.info("Customer 06 - Edit Customer - Step: Click on <Save and Continue Edit> button");
        adminCustomerPage.clickOnSaveAndContinueEditButton();

        log.info("Customer 06 - Edit Customer - Step: Verify Alert message");
        verifyEquals(adminCustomerPage.getAlertMessage(), "The customer has been updated successfully.");

        log.info("Customer 06 - Edit Customer - Step: Click on \"back to customer list\" link");
        adminCustomerPage.clickOnBackToCustomerListLink();

        log.info("Customer 06 - Edit Customer - Step: Input \"" + editedCustomerEmail + "\" into Search Email text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "SearchEmail", editedCustomerEmail);

        log.info("Customer 06 - Edit Customer - Step: Input \"" + editedCustomerFirstName + "\" into Search First name text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "SearchFirstName", editedCustomerFirstName);

        log.info("Customer 06 - Edit Customer - Step: Input \"" + editedCustomerLastName + "\" into Search Last name text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "SearchLastName", editedCustomerLastName);

        log.info("Customer 06 - Edit Customer - Step: Select Month of Birth = \"2\"");
        adminCustomerPage.selectDefaultDropdownById(driver, "SearchMonthOfBirth", "2");

        log.info("Customer 06 - Edit Customer - Step: Select Day of Birth = \"2\"");
        adminCustomerPage.selectDefaultDropdownById(driver, "SearchDayOfBirth", "2");

        log.info("Customer 06 - Edit Customer - Step: Input \"" + editedCustomerCompany + "\" into Search Company text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "SearchCompany", editedCustomerCompany);

        log.info("Customer 06 - Edit Customer - Step: Select Customer roles = \"Guests\"");
        adminCustomerPage.selectCustomerRoles("Guests");

        log.info("Customer 06 - Edit Customer - Step: Click on <Search> button");
        adminCustomerPage.clickOnSearchButton();

        log.info("Customer 06 - Edit Customer - Step: Verify Edited Customer is displayed");
        verifyTrue(adminCustomerPage.isSearchedCustomerDisplayed(editedCustomerFirstName + " " + editedCustomerLastName, "Guests", editedCustomerCompany, "true"));
    }

    @Test
    public void Customer_07_Add_New_Address_In_Customer_Detail() {
        log.info("Customer 07 - Add New Address In Customer Detail - Step: Refresh Page");
        adminCustomerPage.refreshPage(driver);

        log.info("Customer 07 - Add New Address In Customer Detail - Step: Input \"" + editedCustomerEmail + "\" into Search Email text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "SearchEmail", editedCustomerEmail);

        log.info("Customer 07 - Add New Address In Customer Detail - Step: Input \"" + editedCustomerFirstName + "\" into Search First name text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "SearchFirstName", editedCustomerFirstName);

        log.info("Customer 07 - Add New Address In Customer Detail - Step: Input \"" + editedCustomerLastName + "\" into Search Last name text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "SearchLastName", editedCustomerLastName);

        log.info("Customer 07 - Add New Address In Customer Detail - Step: Select Month of Birth = \"2\"");
        adminCustomerPage.selectDefaultDropdownById(driver, "SearchMonthOfBirth", "2");

        log.info("Customer 07 - Add New Address In Customer Detail - Step: Select Day of Birth = \"2\"");
        adminCustomerPage.selectDefaultDropdownById(driver, "SearchDayOfBirth", "2");

        log.info("Customer 07 - Add New Address In Customer Detail - Step: Input \"" + editedCustomerCompany + "\" into Search Company text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "SearchCompany", editedCustomerCompany);

        log.info("Customer 07 - Add New Address In Customer Detail - Step: Select Customer roles = \"Guests\"");
        adminCustomerPage.selectCustomerRoles("Guests");

        log.info("Customer 07 - Add New Address In Customer Detail - Step: Click on <Search> button");
        adminCustomerPage.clickOnSearchButton();

        log.info("Customer 07 - Add New Address In Customer Detail - Step: Click on <Edit> icon of Searched Customer \"" + editedCustomerFirstName + editedCustomerLastName + "\"");
        adminCustomerPage.clickOnDynamicEditIconByCustomerInfo(editedCustomerFirstName + " " + editedCustomerLastName, "Guests", editedCustomerCompany, "true");

        log.info("Customer 07 - Add New Address In Customer Detail - Step: Click on \"Address\" section title");
        adminCustomerPage.clickOnDynamicSectionTitleById("customer-address");

        log.info("Customer 07 - Add New Address In Customer Detail - Step: Click on <Add new address> button");
        adminCustomerPage.clickOnAddNewAddressButton();

        log.info("Customer 07 - Add New Address In Customer Detail - Step: Input \"" + newAddressFirstName + "\" into First name text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "Address_FirstName", newAddressFirstName);

        log.info("Customer 07 - Add New Address In Customer Detail - Step: Input \"" + newAddressLastName + "\" into Last name text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "Address_LastName", newAddressLastName);

        log.info("Customer 07 - Add New Address In Customer Detail - Step: Input \"" + newAddressEmail + "\" into Email text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "Address_Email", newAddressEmail);

        log.info("Customer 07 - Add New Address In Customer Detail - Step: Input \"" + newAddressCompany + "\" into Company text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "Address_Company", newAddressCompany);

        log.info("Customer 07 - Add New Address In Customer Detail - Step: Select \"" + newAddressCountry + "\"");
        adminCustomerPage.selectDefaultDropdownById(driver, "Address_CountryId", newAddressCountry);

        log.info("Customer 07 - Add New Address In Customer Detail - Step: Select \"" + newAddressState + "\"");
        adminCustomerPage.selectDefaultDropdownById(driver, "Address_StateProvinceId", newAddressState);

        log.info("Customer 07 - Add New Address In Customer Detail - Step: Input \"" + newAddressCity + "\" into City text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "Address_City", newAddressCity);

        log.info("Customer 07 - Add New Address In Customer Detail - Step: Input \"" + newAddress1 + "\" into Address 1 text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "Address_Address1", newAddress1);

        log.info("Customer 07 - Add New Address In Customer Detail - Step: Input \"" + newAddress2 + "\" into Address 2 text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "Address_Address2", newAddress2);

        log.info("Customer 07 - Add New Address In Customer Detail - Step: Input \"" + newAddressZipCode + "\" into Zip / postal code text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "Address_ZipPostalCode", newAddressZipCode);

        log.info("Customer 07 - Add New Address In Customer Detail - Step: Input \"" + newAddressPhone + "\" into Phone number text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "Address_PhoneNumber", newAddressPhone);

        log.info("Customer 07 - Add New Address In Customer Detail - Step: Input \"" + newAddressFax + "\" into Fax number text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "Address_FaxNumber", newAddressFax);

        log.info("Customer 07 - Add New Address In Customer Detail - Step: Click on <Save> button");
        adminCustomerPage.clickOnSaveButton();

        log.info("Customer 07 - Add New Address In Customer Detail - Step: Verify Alert message");
        verifyEquals(adminCustomerPage.getAlertMessage(), "The new address has been added successfully.");

        log.info("Customer 07 - Add New Address In Customer Detail - Step: Verify New Address First Name");
        verifyEquals(adminCustomerPage.getValueTextFromTextBoxById(driver, "Address_FirstName"), newAddressFirstName);

        log.info("Customer 07 - Add New Address In Customer Detail - Step: Verify New Address Last Name");
        verifyEquals(adminCustomerPage.getValueTextFromTextBoxById(driver, "Address_LastName"), newAddressLastName);

        log.info("Customer 07 - Add New Address In Customer Detail - Step: Verify New Address Email");
        verifyEquals(adminCustomerPage.getValueTextFromTextBoxById(driver, "Address_Email"), newAddressEmail);

        log.info("Customer 07 - Add New Address In Customer Detail - Step: Verify New Address Company");
        verifyEquals(adminCustomerPage.getValueTextFromTextBoxById(driver, "Address_Company"), newAddressCompany);

        log.info("Customer 07 - Add New Address In Customer Detail - Step: Verify New Address Country");
        verifyEquals(adminCustomerPage.getSelectedTextInDefaultDropdownById(driver, "Address_CountryId"), newAddressCountry);

        log.info("Customer 07 - Add New Address In Customer Detail - Step: Verify New Address State");
        verifyEquals(adminCustomerPage.getSelectedTextInDefaultDropdownById(driver, "Address_StateProvinceId"), newAddressState);

        log.info("Customer 07 - Add New Address In Customer Detail - Step: Verify New Address City");
        verifyEquals(adminCustomerPage.getValueTextFromTextBoxById(driver, "Address_City"), newAddressCity);

        log.info("Customer 07 - Add New Address In Customer Detail - Step: Verify New Address Address 1");
        verifyEquals(adminCustomerPage.getValueTextFromTextBoxById(driver, "Address_Address1"), newAddress1);

        log.info("Customer 07 - Add New Address In Customer Detail - Step: Verify New Address Address 2");
        verifyEquals(adminCustomerPage.getValueTextFromTextBoxById(driver, "Address_Address2"), newAddress2);

        log.info("Customer 07 - Add New Address In Customer Detail - Step: Verify New Address Zip Code");
        verifyEquals(adminCustomerPage.getValueTextFromTextBoxById(driver, "Address_ZipPostalCode"), newAddressZipCode);

        log.info("Customer 07 - Add New Address In Customer Detail - Step: Verify New Address Phone number");
        verifyEquals(adminCustomerPage.getValueTextFromTextBoxById(driver, "Address_PhoneNumber"), newAddressPhone);

        log.info("Customer 07 - Add New Address In Customer Detail - Step: Verify New Address Fax number");
        verifyEquals(adminCustomerPage.getValueTextFromTextBoxById(driver, "Address_FaxNumber"), newAddressFax);

        log.info("Customer 07 - Add New Address In Customer Detail - Step: Click on \"back to customer details\" link");
        adminCustomerPage.clickOnBackToCustomerDetailLink();

        log.info("Customer 07 - Add New Address In Customer Detail - Step: Verify New Address is displayed");
        verifyTrue(adminCustomerPage.isAddressDisplayed(newAddressFirstName, newAddressLastName, newAddressEmail, newAddressPhone, newAddressFax, newAddressCompany, newAddress1, newAddress2, newAddressCity, "", newAddressZipCode, newAddressCountry));
    }

    @Test
    public void Customer_08_Edit_Address_In_Customer_Detail() {
        log.info("Customer 08 - Edit Address In Customer Detail - Step: Click on \"back to customer list\" link");
        adminCustomerPage.clickOnBackToCustomerListLink();

        log.info("Customer 08 - Edit Address In Customer Detail - Step: Input \"" + editedCustomerEmail + "\" into Search Email text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "SearchEmail", editedCustomerEmail);

        log.info("Customer 08 - Edit Address In Customer Detail - Step: Input \"" + editedCustomerFirstName + "\" into Search First name text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "SearchFirstName", editedCustomerFirstName);

        log.info("Customer 08 - Edit Address In Customer Detail - Step: Input \"" + editedCustomerLastName + "\" into Search Last name text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "SearchLastName", editedCustomerLastName);

        log.info("Customer 08 - Edit Address In Customer Detail - Step: Select Month of Birth = \"2\"");
        adminCustomerPage.selectDefaultDropdownById(driver, "SearchMonthOfBirth", "2");

        log.info("Customer 08 - Edit Address In Customer Detail - Step: Select Day of Birth = \"2\"");
        adminCustomerPage.selectDefaultDropdownById(driver, "SearchDayOfBirth", "2");

        log.info("Customer 08 - Edit Address In Customer Detail - Step: Input \"" + editedCustomerCompany + "\" into Search Company text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "SearchCompany", editedCustomerCompany);

        log.info("Customer 08 - Edit Address In Customer Detail - Step: Select Customer roles = \"Guests\"");
        adminCustomerPage.selectCustomerRoles("Guests");

        log.info("Customer 08 - Edit Address In Customer Detail - Step: Click on <Search> button");
        adminCustomerPage.clickOnSearchButton();

        log.info("Customer 08 - Edit Address In Customer Detail - Step: Click on <Edit> icon of Searched Customer \"" + editedCustomerFirstName + editedCustomerLastName + "\"");
        adminCustomerPage.clickOnDynamicEditIconByCustomerInfo(editedCustomerFirstName + " " + editedCustomerLastName, "Guests", editedCustomerCompany, "true");

        log.info("Customer 08 - Edit Address In Customer Detail - Step: Click on <Edit> icon of new Address");
        adminCustomerPage.clickOnDynamicEditAddressIcon(newAddressFirstName, newAddressLastName, newAddressEmail, newAddressPhone, newAddressFax);

        log.info("Customer 08 - Edit Address In Customer Detail - Step: Input \"" + editedAddressFirstName + "\" into First name text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "Address_FirstName", editedAddressFirstName);

        log.info("Customer 08 - Edit Address In Customer Detail - Step: Input \"" + editedAddressLastName + "\" into Last name text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "Address_LastName", editedAddressLastName);

        log.info("Customer 08 - Edit Address In Customer Detail - Step: Input \"" + editedAddressEmail + "\" into Email text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "Address_Email", editedAddressEmail);

        log.info("Customer 08 - Edit Address In Customer Detail - Step: Input \"" + editedAddressCompany + "\" into Company text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "Address_Company", editedAddressCompany);

        log.info("Customer 08 - Edit Address In Customer Detail - Step: Select \"" + editedAddressCountry + "\"");
        adminCustomerPage.selectDefaultDropdownById(driver, "Address_CountryId", editedAddressCountry);

        log.info("Customer 08 - Edit Address In Customer Detail - Step: Select \"" + editedAddressState + "\"");
        adminCustomerPage.selectDefaultDropdownById(driver, "Address_StateProvinceId", editedAddressState);

        log.info("Customer 08 - Edit Address In Customer Detail - Step: Input \"" + editedAddressCity + "\" into City text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "Address_City", editedAddressCity);

        log.info("Customer 08 - Edit Address In Customer Detail - Step: Input \"" + editedAddress1 + "\" into Address 1 text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "Address_Address1", editedAddress1);

        log.info("Customer 08 - Edit Address In Customer Detail - Step: Input \"" + editedAddress2 + "\" into Address 2 text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "Address_Address2", editedAddress2);

        log.info("Customer 08 - Edit Address In Customer Detail - Step: Input \"" + editedAddressZipCode + "\" into Zip / postal code text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "Address_ZipPostalCode", editedAddressZipCode);

        log.info("Customer 08 - Edit Address In Customer Detail - Step: Input \"" + editedAddressPhone + "\" into Phone number text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "Address_PhoneNumber", editedAddressPhone);

        log.info("Customer 08 - Edit Address In Customer Detail - Step: Input \"" + editedAddressFax + "\" into Fax number text box");
        adminCustomerPage.inputIntoTextBoxById(driver, "Address_FaxNumber", editedAddressFax);

        log.info("Customer 08 - Edit Address In Customer Detail - Step: Click on <Save> button");
        adminCustomerPage.clickOnSaveButtonOnEditAddressPage();

        log.info("Customer 08 - Edit Address In Customer Detail - Step: Verify Alert message");
        verifyEquals(adminCustomerPage.getAlertMessage(), "The address has been updated successfully.");

        log.info("Customer 08 - Edit Address In Customer Detail - Step: Verify Edited Address First Name");
        verifyEquals(adminCustomerPage.getValueTextFromTextBoxById(driver, "Address_FirstName"), editedAddressFirstName);

        log.info("Customer 08 - Edit Address In Customer Detail - Step: Verify Edited Address Last Name");
        verifyEquals(adminCustomerPage.getValueTextFromTextBoxById(driver, "Address_LastName"), editedAddressLastName);

        log.info("Customer 08 - Edit Address In Customer Detail - Step: Verify Edited Address Email");
        verifyEquals(adminCustomerPage.getValueTextFromTextBoxById(driver, "Address_Email"), editedAddressEmail);

        log.info("Customer 08 - Edit Address In Customer Detail - Step: Verify Edited Address Company");
        verifyEquals(adminCustomerPage.getValueTextFromTextBoxById(driver, "Address_Company"), editedAddressCompany);

        log.info("Customer 08 - Edit Address In Customer Detail - Step: Verify Edited Address Country");
        verifyEquals(adminCustomerPage.getSelectedTextInDefaultDropdownById(driver, "Address_CountryId"), editedAddressCountry);

        log.info("Customer 08 - Edit Address In Customer Detail - Step: Verify Edited Address State");
        verifyEquals(adminCustomerPage.getSelectedTextInDefaultDropdownById(driver, "Address_StateProvinceId"), editedAddressState);

        log.info("Customer 08 - Edit Address In Customer Detail - Step: Verify Edited Address City");
        verifyEquals(adminCustomerPage.getValueTextFromTextBoxById(driver, "Address_City"), editedAddressCity);

        log.info("Customer 08 - Edit Address In Customer Detail - Step: Verify Edited Address Address 1");
        verifyEquals(adminCustomerPage.getValueTextFromTextBoxById(driver, "Address_Address1"), editedAddress1);

        log.info("Customer 08 - Edit Address In Customer Detail - Step: Verify Edited Address Address 2");
        verifyEquals(adminCustomerPage.getValueTextFromTextBoxById(driver, "Address_Address2"), editedAddress2);

        log.info("Customer 08 - Edit Address In Customer Detail - Step: Verify Edited Address Zip Code");
        verifyEquals(adminCustomerPage.getValueTextFromTextBoxById(driver, "Address_ZipPostalCode"), editedAddressZipCode);

        log.info("Customer 08 - Edit Address In Customer Detail - Step: Verify Edited Address Phone number");
        verifyEquals(adminCustomerPage.getValueTextFromTextBoxById(driver, "Address_PhoneNumber"), editedAddressPhone);

        log.info("Customer 08 - Edit Address In Customer Detail - Step: Verify Edited Address Fax number");
        verifyEquals(adminCustomerPage.getValueTextFromTextBoxById(driver, "Address_FaxNumber"), editedAddressFax);

        log.info("Customer 08 - Edit Address In Customer Detail - Step: Click on \"back to customer details\" link");
        adminCustomerPage.clickOnBackToCustomerDetailLink();

        log.info("Customer 08 - Edit Address In Customer Detail - Step: Verify Edited Address is displayed");
        verifyTrue(adminCustomerPage.isAddressDisplayed(editedAddressFirstName, editedAddressLastName, editedAddressEmail, editedAddressPhone, editedAddressFax, editedAddressCompany, editedAddress1, editedAddress2, editedAddressCity, editedAddressState, editedAddressZipCode, editedAddressCountry));
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        //closeBrowserAndDriver(driver);
    }
}
