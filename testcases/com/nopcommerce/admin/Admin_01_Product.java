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
import pageObjects.admin.AdminProductDetailPO;
import pageObjects.admin.AdminProductListPO;

public class Admin_01_Product extends AbstractTest {
    WebDriver driver;

    AdminLoginPO adminLoginPage;
    AdminHomePO adminHomePage;
    AdminProductListPO adminProductListPage;
    AdminProductDetailPO adminProductDetailPage;

    String productName = "Lenovo IdeaCentre 600 All-in-One PC";
    String productSku = "LE_IC_600";

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

        log.info("Pre-Condition - Step: Click on \"Catalog\" left menu");
        adminHomePage.clickOnAdminDynamicLeftMenuByLabel(driver, "Catalog");

        log.info("Pre-Condition - Step: Click on \"Product\" left sub menu");
        adminHomePage.clickOnAdminDynamicLeftSubMenuByLabel(driver, "Products");
        adminProductListPage = PageGeneratorManager.getAdminProductListPage(driver);
    }

    @Test
    public void Product_01_Search_With_Product_Name() {
        log.info("Product 01 - Search With Product Name - Step: Input keyword \"" + productName + "\" into Search Product Name text box");
        adminProductListPage.inputIntoTextBoxById(driver, "SearchProductName", productName);

        log.info("Product 01 - Search With Product Name - Step: Click on <Search> button");
        adminProductListPage.clickOnSearchButton();

        log.info("Product 01 - Search With Product Name - Step: Verify only 1 Product is displayed in Search Result");
        verifyTrue(adminProductListPage.isSearchedProductDisplayed(productName, "LE_IC_600", "500", "10000", "true"));
    }

    @Test
    public void Product_02_Search_With_Product_Name_And_Parent_Category_But_Unchecked() {
        log.info("Product 02 - Search With Product Name And Parent Category But Unchecked - Step: Input keyword \"" + productName + "\" into Search Product Name text box");
        adminProductListPage.inputIntoTextBoxById(driver, "SearchProductName", productName);

        log.info("Product 02 - Search With Product Name And Parent Category But Unchecked - Step: Select Category = \"Computers\"");
        adminProductListPage.selectCategory("Computers");

        log.info("Product 02 - Search With Product Name And Parent Category But Unchecked - Step: Uncheck Search subcategories checkbox");
        adminProductListPage.uncheckSearchSubcategoriesCheckbox();

        log.info("Product 02 - Search With Product Name And Parent Category But Unchecked - Step: Click on <Search> button");
        adminProductListPage.clickOnSearchButton();

        log.info("Product 02 - Search With Product Name And Parent Category But Unchecked - Step: Verify No Data message is displayed");
        verifyEquals(adminProductListPage.getNoDataMessage(), "No data available in table");
    }

    @Test
    public void Product_03_Search_With_Product_Name_And_Parent_Category() {
        log.info("Product 03 - Search With Product Name And Parent Category - Step: Input keyword \"" + productName + "\" into Search Product Name text box");
        adminProductListPage.inputIntoTextBoxById(driver, "SearchProductName", productName);

        log.info("Product 03 - Search With Product Name And Parent Category - Step: Select Category = \"Computers\"");
        adminProductListPage.selectCategory("Computers");

        log.info("Product 03 - Search With Product Name And Parent Category - Step: Check on Search subcategories checkbox");
        adminProductListPage.checkOnSearchSubcategoriesCheckbox();

        log.info("Product 03 - Search With Product Name And Parent Category - Step: Click on <Search> button");
        adminProductListPage.clickOnSearchButton();

        log.info("Product 03 - Search With Product Name And Parent Category - Step: Verify only 1 Product is displayed in Search Result");
        verifyTrue(adminProductListPage.isSearchedProductDisplayed(productName, "LE_IC_600", "500", "10000", "true"));
    }

    @Test
    public void Product_04_Search_With_Product_Name_And_Child_Category() {
        log.info("Product 04 - Search With Product Name And Child Category - Step: Input keyword \"" + productName + "\" into Search Product Name text box");
        adminProductListPage.inputIntoTextBoxById(driver, "SearchProductName", productName);

        log.info("Product 04 - Search With Product Name And Child Category - Step: Select Category = \"Computers >> Desktops\"");
        adminProductListPage.selectCategory("Computers >> Desktops");

        log.info("Product 04 - Search With Product Name And Child Category - Step: Check on Search subcategories checkbox");
        adminProductListPage.uncheckSearchSubcategoriesCheckbox();

        log.info("Product 04 - Search With Product Name And Child Category - Step: Click on <Search> button");
        adminProductListPage.clickOnSearchButton();

        log.info("Product 04 - Search With Product Name And Child Category - Step: Verify only 1 Product is displayed in Search Result");
        verifyTrue(adminProductListPage.isSearchedProductDisplayed(productName, "LE_IC_600", "500", "10000", "true"));
    }

    @Test
    public void Product_05_Search_With_Product_Name_And_Manufacturer() {
        log.info("Product 05 - Search With Product Name And Manufacturer - Step: Input keyword \"" + productName + "\" into Search Product Name text box");
        adminProductListPage.inputIntoTextBoxById(driver, "SearchProductName", productName);

        log.info("Product 05 - Search With Product Name And Manufacturer - Step: Uncheck Search subcategories checkbox");
        adminProductListPage.uncheckSearchSubcategoriesCheckbox();

        log.info("Product 05 - Search With Product Name And Manufacturer - Step: Select Manufacturer = \"Apple\"");
        adminProductListPage.selectManufacturer("Apple");

        log.info("Product 05 - Search With Product Name And Manufacturer - Step: Click on <Search> button");
        adminProductListPage.clickOnSearchButton();

        log.info("Product 05 - Search With Product Name And Manufacturer - Step: Verify No Data message is displayed");
        verifyEquals(adminProductListPage.getNoDataMessage(), "No data available in table");
    }

    @Test
    public void Product_06_Go_Directly_To_Product_Sku() {
        log.info("Product 06 - Go Directly To Product Sku - Step: Input Product SKU = \"" + productSku + "\" into Go directly to product SKU text box");
        adminProductListPage.inputIntoTextBoxById(driver, "GoDirectlyToSku", productSku);

        log.info("Product 06 - Go Directly To Product Sku - Step: Click on <Go> button");
        adminProductDetailPage = adminProductListPage.clickOnGoButton();

        log.info("Product 06 - Go Directly To Product Sku - Step: Verify Product Detail page is displayed");
        verifyEquals(adminProductDetailPage.getPageTitle(driver), "Edit product details / nopCommerce administration");

        log.info("Product 06 - Go Directly To Product Sku - Step: Verify Product \"" + productName + "\" is displayed");
        verifyEquals(adminProductDetailPage.getProductName(), productName);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }
}
