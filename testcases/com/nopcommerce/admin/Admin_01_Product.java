package com.nopcommerce.admin;

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
import pageObjects.admin.AdminProductListPO;

public class Admin_01_Product extends AbstractTest {
    WebDriver driver;

    AdminLoginPO adminLoginPage;
    AdminHomePO adminHomePage;
    AdminProductListPO adminProductListPage;

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

        log.info("Pre-Condition - Step: Click on \"Catalog\" left menu");
        adminHomePage.clickOnAdminDynamicLeftMenuByLabel(driver, "Catalog");

        log.info("Pre-Condition - Step: Click on \"Product\" left sub menu");
        adminHomePage.clickOnAdminDynamicLeftSubMenuByLabel(driver, "Products");
        adminProductListPage = PageGeneratorManager.getAdminProductListPage(driver);
    }

    //@Test
    public void Product_01_Search_With_Product_Name() {
        String productName = "Lenovo IdeaCentre 600 All-in-One PC";

        log.info("Product 01 - Search With Product Name - Step: Input keyword \"" + productName + "\" into Search Product Name text box");
        adminProductListPage.inputIntoTextBoxByID(driver, "SearchProductName", productName);

        log.info("Product 01 - Search With Product Name - Step: Click on <Search> button");
        adminProductListPage.clickOnSearchButton();

        log.info("Product 01 - Search With Product Name - Step: Verify only 1 Product is displayed in Search Result");
        verifyTrue(adminProductListPage.isSearchedProductDisplayed(productName, "LE_IC_600", "500", "10000", "true"));
    }

    //@Test
    public void Product_02_Search_With_Product_Name_And_Parent_Category_But_Unchecked() {
        String productName = "Lenovo IdeaCentre 600 All-in-One PC";

        log.info("Product 02 Search With Product Name And Parent Category But Unchecked - Step: Input keyword \"" + productName + "\" into Search Product Name text box");
        adminProductListPage.inputIntoTextBoxByID(driver, "SearchProductName", productName);

        log.info("Product 02 Search With Product Name And Parent Category But Unchecked - Step: Select Category = \"Computers\"");
        adminProductListPage.selectCategory("Computers");

        log.info("Product 02 Search With Product Name And Parent Category But Unchecked - Step: Uncheck Search subcategories checkbox");
        adminProductListPage.uncheckSearchSubcategoriesCheckbox();

        log.info("Product 02 Search With Product Name And Parent Category But Unchecked - Step: Click on <Search> button");
        adminProductListPage.clickOnSearchButton();

        log.info("Product 02 Search With Product Name And Parent Category But Unchecked - Step: Verify No Data message is displayed");
        verifyEquals(adminProductListPage.getNoDataMessage(), "No data available in table");
    }

    //@Test
    public void Product_03_Search_With_Product_Name_And_Parent_Category() {
        String productName = "Lenovo IdeaCentre 600 All-in-One PC";

        log.info("Product 03 Search With Product Name And Parent Category - Step: Input keyword \"" + productName + "\" into Search Product Name text box");
        adminProductListPage.inputIntoTextBoxByID(driver, "SearchProductName", productName);

        log.info("Product 03 Search With Product Name And Parent Category - Step: Select Category = \"Computers\"");
        adminProductListPage.selectCategory("Computers");

        log.info("Product 03 Search With Product Name And Parent Category - Step: Check on Search subcategories checkbox");
        adminProductListPage.checkOnSearchSubcategoriesCheckbox();

        log.info("Product 03 Search With Product Name And Parent Category - Step: Click on <Search> button");
        adminProductListPage.clickOnSearchButton();

        log.info("Product 03 Search With Product Name And Parent Category - Step: Verify only 1 Product is displayed in Search Result");
        verifyTrue(adminProductListPage.isSearchedProductDisplayed(productName, "LE_IC_600", "500", "10000", "true"));
    }

    @Test
    public void Product_04_Search_With_Product_Name_And_Child_Category() {
        String productName = "Lenovo IdeaCentre 600 All-in-One PC";

        log.info("Product 04 Search With Product Name And Child Category - Step: Input keyword \"" + productName + "\" into Search Product Name text box");
        adminProductListPage.inputIntoTextBoxByID(driver, "SearchProductName", productName);

        log.info("Product 04 Search With Product Name And Child Category - Step: Select Category = \"Computers\"");
        adminProductListPage.selectCategory("Computers >> Desktops");

        log.info("Product 04 Search With Product Name And Child Category - Step: Check on Search subcategories checkbox");
        adminProductListPage.uncheckSearchSubcategoriesCheckbox();

        log.info("Product 04 Search With Product Name And Child Category - Step: Click on <Search> button");
        adminProductListPage.clickOnSearchButton();

        log.info("Product 04 Search With Product Name And Child Category - Step: Verify only 1 Product is displayed in Search Result");
        verifyTrue(adminProductListPage.isSearchedProductDisplayed(productName, "LE_IC_600", "500", "10000", "true"));
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        //closeBrowserAndDriver(driver);
    }
}
