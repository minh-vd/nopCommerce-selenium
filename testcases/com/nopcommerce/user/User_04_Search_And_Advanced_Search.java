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

public class User_04_Search_And_Advanced_Search extends AbstractTest {
    WebDriver driver;

    UserHomePO userHomePage;
    UserLoginPO userLoginPage;
    SearchPO searchPage;

    @Parameters({"browserName", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName);

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
        userHomePage.sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);

        log.info("Pre-Condition - Step: Click on Search link at Footer");
        userHomePage.clickOnDynamicLinkAtFooterByText(driver, "Search");
        searchPage = PageGeneratorManager.getSearchPage(driver);
    }

    @Test
    public void TC_01_Search_With_Empty_Data() {
        log.info("TC 01 - Search With Empty Data - Step: Click on Search button right away");
        searchPage.clickOnSearchButton();

        log.info("TC 01 - Search With Empty Data - Step: Verify Search Warning Message");
        verifyEquals(searchPage.getTextOfSearchWarningMessage(), "Search term minimum length is 3 characters");
    }

    @Test
    public void TC_02_Search_With_Non_Existing_Data() {
        log.info("TC 02 - Search With Non Existing Data - Step: Input into Search Keyword with non existing data");
        searchPage.inputIntoTextBoxById(driver, "q", "Macbook Pro 2050");

        log.info("TC 02 - Search With Non Existing Data - Step: Click on Search button");
        searchPage.clickOnSearchButton();

        log.info("TC 02 - Search With Non Existing Data - Step: Verify No Result message");
        verifyEquals(searchPage.getTextOfSearchNoResultMessage(), "No products were found that matched your criteria.");
    }

    @Test
    public void TC_03_Relative_Search_With_Product_Name() {
        log.info("TC 03 - Relative Search With Product Name - Step: Input into Search Keyword with related keyword");
        searchPage.inputIntoTextBoxById(driver, "q", "Lenovo");

        log.info("TC 03 - Relative Search With Product Name - Step: Click on Search button");
        searchPage.clickOnSearchButton();

        log.info("TC 03 - Relative Search With Product Name - Step: Verify related Products displayed");
        verifyTrue(searchPage.isRelatedProductsDisplayedByAbsoluteKeyword("Lenovo"));
    }

    @Test
    public void TC_04_Absolute_Search_With_Product_Name() {
        log.info("TC 04 - Absolute Search With Product Name - Step: Input into Search Keyword with absolute keyword");
        searchPage.inputIntoTextBoxById(driver, "q", "Thinkpad X1 Carbon");

        log.info("TC 04 - Absolute Search With Product Name - Step: Click on Search button");
        searchPage.clickOnSearchButton();

        log.info("TC 04 - Absolute Search With Product Name - Step: Verify related Products displayed");
        verifyTrue(searchPage.isRelatedProductsDisplayedByAbsoluteKeyword("Lenovo Thinkpad X1 Carbon Laptop"));
    }

    @Test
    public void TC_05_Advanced_Search_With_Parent_Categories() {
        log.info("TC 05 - Advanced Search With Parent Categories - Step: Input into Search Keyword text box");
        searchPage.inputIntoTextBoxById(driver, "q", "Apple MacBook Pro");

        log.info("TC 05 - Advanced Search With Parent Categories - Step: Check on Advanced search checkbox");
        searchPage.checkOnAdvancedSearchCheckbox();

        log.info("TC 05 - Advanced Search With Parent Categories - Step: Select Computers category");
        searchPage.selectCategory("Computers");

        log.info("TC 05 - Advanced Search With Parent Categories - Step: Uncheck Automatically search sub categories checkbox");
        searchPage.uncheckAutomaticallySearchSubCategoriesCheckbox();

        log.info("TC 05 - Advanced Search With Parent Categories - Step: Click on Search button");
        searchPage.clickOnSearchButton();

        log.info("TC 05 - Advanced Search With Parent Categories - Step: Verify No Product message");
        verifyEquals(searchPage.getTextOfSearchNoResultMessage(), "No products were found that matched your criteria.");
    }

    @Test
    public void TC_06_Advanced_Search_With_Sub_Categories() {
        log.info("TC 06 - Advanced Search With Sub Categories - Step: Input into Search Keyword text box");
        searchPage.inputIntoTextBoxById(driver, "q", "Apple MacBook Pro");

        log.info("TC 06 - Advanced Search With Sub Categories - Step: Check on Advanced search checkbox");
        searchPage.checkOnAdvancedSearchCheckbox();

        log.info("TC 06 - Advanced Search With Sub Categories - Step: Select Computers category");
        searchPage.selectCategory("Computers");

        log.info("TC 06 - Advanced Search With Sub Categories - Step: Check on Automatically search sub categories checkbox");
        searchPage.checkOnAutomaticallySearchSubCategoriesCheckbox();

        log.info("TC 06 - Advanced Search With Sub Categories - Step: Click on Search button");
        searchPage.clickOnSearchButton();

        log.info("TC 06 - Advanced Search With Sub Categories - Step: Verify 1 Product is displayed in Search Result");
        verifyTrue(searchPage.isRelatedProductsDisplayedByAbsoluteKeyword("Apple MacBook Pro 13-inch"));
    }

    @Test
    public void TC_07_Advanced_Search_With_Incorrect_Manufacturer() {
        log.info("TC 07 - Advanced Search With Incorrect Manufacturer - Step: Input into Search Keyword text box");
        searchPage.inputIntoTextBoxById(driver, "q", "Apple MacBook Pro");

        log.info("TC 07 - Advanced Search With Incorrect Manufacturer - Step: Check on Advanced search checkbox");
        searchPage.checkOnAdvancedSearchCheckbox();

        log.info("TC 07 - Advanced Search With Incorrect Manufacturer - Step: Select Computers category");
        searchPage.selectCategory("Computers");

        log.info("TC 07 - Advanced Search With Incorrect Manufacturer - Step: Check on Automatically search sub categories checkbox");
        searchPage.checkOnAutomaticallySearchSubCategoriesCheckbox();

        log.info("TC 07 - Advanced Search With Incorrect Manufacturer - Step: Select HP manufacturer");
        searchPage.selectManufacturer("HP");

        log.info("TC 07 - Advanced Search With Incorrect Manufacturer - Step: Click on Search button");
        searchPage.clickOnSearchButton();

        log.info("TC 07 - Advanced Search With Incorrect Manufacturer - Step: Verify No Product message");
        verifyEquals(searchPage.getTextOfSearchNoResultMessage(), "No products were found that matched your criteria.");
    }

    @Test
    public void TC_08_Advanced_Search_With_Correct_Manufacturer() {
        log.info("TC 08 - Advanced Search With Correct Manufacturer - Step: Input into Search Keyword text box");
        searchPage.inputIntoTextBoxById(driver, "q", "Apple MacBook Pro");

        log.info("TC 08 - Advanced Search With Correct Manufacturer - Step: Check on Advanced search checkbox");
        searchPage.checkOnAdvancedSearchCheckbox();

        log.info("TC 08 - Advanced Search With Correct Manufacturer - Step: Select Computers category");
        searchPage.selectCategory("Computers");

        log.info("TC 08 - Advanced Search With Correct Manufacturer - Step: Check on Automatically search sub categories checkbox");
        searchPage.checkOnAutomaticallySearchSubCategoriesCheckbox();

        log.info("TC 08 - Advanced Search With Correct Manufacturer - Step: Select Apple manufacturer");
        searchPage.selectManufacturer("Apple");

        log.info("TC 08 - Advanced Search With Correct Manufacturer - Step: Click on Search button");
        searchPage.clickOnSearchButton();

        log.info("TC 08 - Advanced Search With Correct Manufacturer - Step: Verify 1 Product is displayed in Search Result");
        verifyTrue(searchPage.isRelatedProductsDisplayedByAbsoluteKeyword("Apple MacBook Pro 13-inch"));
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }
}
