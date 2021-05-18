package com.nopcommerce.user;

import com.nopcommerce.common.Common_01_Register;
import commons.AbstractTest;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

public class User_03_My_Account extends AbstractTest {
    WebDriver driver;

    UserHomePO userHomePage;
    UserLoginPO userLoginPage;
    MyAccountPO myAccountPage;
    ProductDetailPO productDetailPage;
    ProductReviewPO productReviewPage;

    String firstName, lastName, dayOfBirth, monthOfBirth, yearOfBirth, email, company, password, confirmPassword, city, address1, address2, zipPostalCode, phone, fax, country, state;

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
        password = "12345678";
        confirmPassword = "12345678";
        city = "Da Nang";
        address1 = "123/04 Le Lai";
        address2 = "234/05 Hai Phong";
        zipPostalCode = "550000";
        phone = "0123456789";
        fax = "0987654321";
        country = "Viet Nam";
        state = "Other";

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
        myAccountPage = userHomePage.clickOnMyAccountLinkAtTopBar(driver);
    }

    @Test
    public void TC_01_Edit_Customer_Info() {
        log.info("TC 01 - Edit Customer Info - Step: Check on Gender Female checkbox");
        myAccountPage.checkOnGenderFemaleCheckbox();

        log.info("TC 01 - Edit Customer Info - Step: Input into First Name text box");
        myAccountPage.inputIntoTextBoxById(driver, "FirstName", firstName);

        log.info("TC 01 - Edit Customer Info - Step: Input into Last Name text box");
        myAccountPage.inputIntoTextBoxById(driver, "LastName", lastName);

        log.info("TC 01 - Edit Customer Info - Step: Select Day of Birth");
        myAccountPage.selectDayOfBirth(dayOfBirth);

        log.info("TC 01 - Edit Customer Info - Step: Select Month Of Birth");
        myAccountPage.selectMonthOfBirth(monthOfBirth);

        log.info("TC 01 - Edit Customer Info - Step: Select Year Of Birth");
        myAccountPage.selectYearOfBirth(yearOfBirth);

        log.info("TC 01 - Edit Customer Info - Step: Input into Email text box");
        myAccountPage.inputIntoTextBoxById(driver, "Email", email);

        log.info("TC 01 - Edit Customer Info - Step: Input into Company text box");
        myAccountPage.inputIntoTextBoxById(driver, "Company", company);

        log.info("TC 01 - Edit Customer Info - Step: Click on Save button");
        myAccountPage.clickOnSaveButton();

        log.info("TC 01 - Edit Customer Info - Step: Refresh Page");
        myAccountPage.refreshPage(driver);

        log.info("TC 01 - Edit Customer Info - Step: Verify edited First Name");
        verifyEquals(myAccountPage.getValueTextFromTextBoxById(driver, "FirstName"), firstName);

        log.info("TC 01 - Edit Customer Info - Step: Verify edited Last Name");
        verifyEquals(myAccountPage.getValueTextFromTextBoxById(driver, "LastName"), lastName);

        log.info("TC 01 - Edit Customer Info - Step: Verify edited Day of Birth");
        verifyEquals(myAccountPage.getDayOfBirth(), dayOfBirth);

        log.info("TC 01 - Edit Customer Info - Step: Verify edited Month of Birth");
        verifyEquals(myAccountPage.getMonthOfBirth(), monthOfBirth);

        log.info("TC 01 - Edit Customer Info - Step: Verify edited Year of Birth");
        verifyEquals(myAccountPage.getYearOfBirth(), yearOfBirth);

        log.info("TC 01 - Edit Customer Info - Step: Verify edited Email");
        verifyEquals(myAccountPage.getValueTextFromTextBoxById(driver, "Email"), email);

        log.info("TC 01 - Edit Customer Info - Step: Verify edited Company");
        verifyEquals(myAccountPage.getValueTextFromTextBoxById(driver, "Company"), company);

        log.info("TC 01 - Edit Customer Info - Step: Change back Email");
        myAccountPage.inputIntoTextBoxById(driver, "Email", Common_01_Register.email);

        log.info("TC 01 - Edit Customer Info - Step: Click on Save button");
        myAccountPage.clickOnSaveButton();
    }

    @Test
    public void TC_02_Add_New_Address() {
        log.info("TC 02 - Add New Address - Step: Click on Left Menu -> Addresses");
        myAccountPage.clickOnDynamicLeftMenuLinkByClassName("customer-addresses");

        log.info("TC 02 - Add New Address - Step: Click on ADD NEW button");
        myAccountPage.clickOnAddNewAddressButton();

        log.info("TC 02 - Add New Address - Step: Input into First Name text box");
        myAccountPage.inputIntoTextBoxById(driver, "Address_FirstName", firstName);

        log.info("TC 02 - Add New Address - Step: Input into Last Name text box");
        myAccountPage.inputIntoTextBoxById(driver, "Address_LastName", lastName);

        log.info("TC 02 - Add New Address - Step: Input into Email text box");
        myAccountPage.inputIntoTextBoxById(driver, "Address_Email", email);

        log.info("TC 02 - Add New Address - Step: Input into Company text box");
        myAccountPage.inputIntoTextBoxById(driver, "Address_Company", company);

        log.info("TC 02 - Add New Address - Step: Select Country");
        myAccountPage.selectAddressCountry(country);

        log.info("TC 02 - Add New Address - Step: Select State/Province");
        myAccountPage.selectAddressStateProvince(state);

        log.info("TC 02 - Add New Address - Step: Input into City text box");
        myAccountPage.inputIntoTextBoxById(driver, "Address_City", city);

        log.info("TC 02 - Add New Address - Step: Input into Address 1 text box");
        myAccountPage.inputIntoTextBoxById(driver, "Address_Address1", address1);

        log.info("TC 02 - Add New Address - Step: Input into Address 2 text box");
        myAccountPage.inputIntoTextBoxById(driver, "Address_Address2", address2);

        log.info("TC 02 - Add New Address - Step: Input into Zip/Postal Code text box");
        myAccountPage.inputIntoTextBoxById(driver, "Address_ZipPostalCode", zipPostalCode);

        log.info("TC 02 - Add New Address - Step: Input into Phone Number text box");
        myAccountPage.inputIntoTextBoxById(driver, "Address_PhoneNumber", phone);

        log.info("TC 02 - Add New Address - Step: Input into Fax Number text box");
        myAccountPage.inputIntoTextBoxById(driver, "Address_FaxNumber", fax);

        log.info("TC 02 - Add New Address - Step: Click on Save button");
        myAccountPage.clickOnSaveAddressButton();

        log.info("TC 02 - Add New Address - Step: Verify Address Name");
        verifyEquals(myAccountPage.getTextOfDynamicAddressInfoFieldByClass("name"), firstName + " " + lastName);

        log.info("TC 02 - Add New Address - Step: Verify Address Email");
        verifyEquals(myAccountPage.getTextOfDynamicAddressInfoFieldByClass("email"), "Email: " + email);

        log.info("TC 02 - Add New Address - Step: Verify Address Phone");
        verifyEquals(myAccountPage.getTextOfDynamicAddressInfoFieldByClass("phone"), "Phone number: " + phone);

        log.info("TC 02 - Add New Address - Step: Verify Address Fax");
        verifyEquals(myAccountPage.getTextOfDynamicAddressInfoFieldByClass("fax"), "Fax number: " + fax);

        log.info("TC 02 - Add New Address - Step: Verify Address Company");
        verifyEquals(myAccountPage.getTextOfDynamicAddressInfoFieldByClass("company"), company);

        log.info("TC 02 - Add New Address - Step: Verify Address Address 1");
        verifyEquals(myAccountPage.getTextOfDynamicAddressInfoFieldByClass("address1"), address1);

        log.info("TC 02 - Add New Address - Step: Verify Address Address 2");
        verifyEquals(myAccountPage.getTextOfDynamicAddressInfoFieldByClass("address2"), address2);

        log.info("TC 02 - Add New Address - Step: Verify Address City - State - Zip");
        verifyEquals(myAccountPage.getTextOfDynamicAddressInfoFieldByClass("city-state-zip"), city + ", " + zipPostalCode);

        log.info("TC 02 - Add New Address - Step: Verify Address Country");
        verifyEquals(myAccountPage.getTextOfDynamicAddressInfoFieldByClass("country"), country);
    }

    @Test
    public void TC_03_Change_Password() {
        log.info("TC 03 - Change Password - Step: Click on Left Menu -> Change Password");
        myAccountPage.clickOnDynamicLeftMenuLinkByClassName("change-password");

        log.info("TC 03 - Change Password - Step: Input old Password");
        myAccountPage.inputIntoTextBoxById(driver, "OldPassword", Common_01_Register.password);

        log.info("TC 03 - Change Password - Step: Input new Password");
        myAccountPage.inputIntoTextBoxById(driver, "NewPassword", password);

        log.info("TC 03 - Change Password - Step: Input new confirm Password");
        myAccountPage.inputIntoTextBoxById(driver, "ConfirmNewPassword", confirmPassword);

        log.info("TC 03 - Change Password - Step: Click Change Password button");
        myAccountPage.clickOnChangePasswordButton();

        log.info("TC 03 - Change Password - Step: Verify Password changed successfully Notification Banner display");
        verifyEquals(myAccountPage.getTextOfNotificationBar(), "Password was changed");

        log.info("TC 03 - Change Password - Step: Close Notification Banner");
        myAccountPage.clickOnCloseButtonOfNotificationBanner();

        log.info("TC 03 - Change Password - Step: Click on Log out link on top");
        userHomePage = myAccountPage.clickOnLogoutLinkAtTopBar(driver);

        log.info("TC 03 - Change Password - Step: Click on Log in link on top");
        userLoginPage = userHomePage.clickOnLoginLink();

        log.info("TC 03 - Change Password - Step: Input login Email");
        userLoginPage.inputIntoTextBoxById(driver, "Email", Common_01_Register.email);

        log.info("TC 03 - Change Password - Step: Input old Password");
        userLoginPage.inputIntoTextBoxById(driver, "Password", Common_01_Register.password);

        log.info("TC 03 - Change Password - Step: Click on Login button");
        userLoginPage.clickOnLoginButton();

        log.info("TC 03 - Change Password - Step: Verify wrong Password message");
        verifyEquals(userLoginPage.getTextOfLoginValidationErrorMessage(), "Login was unsuccessful. Please correct the errors and try again. The credentials provided are incorrect");

        log.info("TC 03 - Change Password - Step: Re-input new Password");
        userLoginPage.inputIntoTextBoxById(driver, "Password", password);

        log.info("TC 03 - Change Password - Step: Click on Login button");
        userLoginPage.clickOnLoginButton();
        userHomePage = PageGeneratorManager.getUserHomePage(driver);

        log.info("TC 03 - Change Password - Step: Verify showing My Account on top bar");
        verifyTrue(userHomePage.isMyAccountLinkDisplayed());
    }

    @Test
    public void TC_04_Add_New_Product_Review() {
        log.info("TC 04 - Add New Product Review - Step: Navigate to Home page");
        driver.get(GlobalConstants.HOME_URL);
        userHomePage = PageGeneratorManager.getUserHomePage(driver);
        userHomePage.sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);

        log.info("TC 04 - Add New Product Review - Step: Click on Title of 2nd product in Featured list to navigate to it's detail page");
        productDetailPage = userHomePage.clickOnTitleOfDynamicProductInFeaturedListByIndex("2");

        log.info("TC 04 - Add New Product Review - Step: Click on Add your review link");
        productReviewPage = productDetailPage.clickOnAddYourReviewLink();

        log.info("TC 04 - Add New Product Review - Step: Input Review Title");
        productReviewPage.inputIntoTextBoxById(driver, "AddProductReview_Title", "This is a Review Title");

        log.info("TC 04 - Add New Product Review - Step: Input Review Text");
        productReviewPage.inputIntoReviewTextTextArea("This is a Review Content");

        log.info("TC 04 - Add New Product Review - Step: Click Submit Review button");
        productReviewPage.clickOnSubmitReviewButton();

        log.info("TC 04 - Add New Product Review - Step: Click My Account link on top bar");
        myAccountPage = productReviewPage.clickOnMyAccountLinkAtTopBar(driver);

        log.info("TC 04 - Add New Product Review - Step: Click on My product reviews on Left Menu");
        myAccountPage.clickOnDynamicLeftMenuLinkByClassName("customer-reviews");

        log.info("TC 04 - Add New Product Review - Step: Verify Review Title displayed");
        verifyEquals(myAccountPage.getTextOfReviewTitle(), "This is a Review Title");

        log.info("TC 04 - Add New Product Review - Step: Verify Review Text displayed");
        verifyEquals(myAccountPage.getTextOfReviewText(), "This is a Review Content");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }
}
