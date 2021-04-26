package com.nopcommerce.user;

import commons.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

public class TC_05_Sort_Display_Paging extends AbstractTest {
    WebDriver driver;

    UserHomePO userHomePage;
    SearchPO searchPage;
    ProductListPO productListPage;

    @Parameters({"browserName", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName);

        log.info("Pre-Condition - Step: Open User Home Page");
        driver.get(url);
        userHomePage = PageGeneratorManager.getUserHomePage(driver);

        log.info("Pre-Condition - Step: Hover mouse on Header Menu Computers");
        userHomePage.hoverMouseOnDynamicHeaderMenuByText(driver, "Computers");

        log.info("Pre-Condition - Step: Click on Submenu Notebooks ");
        productListPage = userHomePage.clickOnDynamicHeaderSubmenuByText(driver, "Notebooks");
    }

    //@Test
    public void TC_01_Sort_By_Product_Name_A_To_Z() {
        log.info("TC 01 - Sort By Product Name A To Z - Step: Select Sort By Name: A to Z");
        productListPage.selectSortBy("Name: A to Z");

        log.info("TC 01 - Sort By Product Name A To Z - Step: Verify Product List is sorted");
        verifyTrue(productListPage.isProductListSortedByName("ASC"));
    }

    //@Test
    public void TC_02_Sort_By_Product_Name_Z_To_A() {
        log.info("TC 02 - Sort By Product Name Z To A - Step: Select Sort By Name: Z to A");
        productListPage.selectSortBy("Name: Z to A");

        log.info("TC 02 - Sort By Product Name Z To A - Step: Verify Product List is sorted");
        verifyTrue(productListPage.isProductListSortedByName("DESC"));
    }

    //@Test
    public void TC_03_Sort_By_Product_Price_Low_To_High() {
        log.info("TC 03 - Sort By Product Price Low To High - Step: Select Sort by Price: Low to High");
        productListPage.selectSortBy("Price: Low to High");

        log.info("TC 03 - Sort By Product Price Low To High - Step: Verify Product List is sorted");
        verifyTrue(productListPage.isProductListSortedByPrice("ASC"));
    }

    //@Test
    public void TC_04_Sort_By_Product_Price_High_To_Low() {
        log.info("TC 04 - Sort By Product Price High To Low - Step: Select Sort by Price: High to Low");
        productListPage.selectSortBy("Price: High to Low");

        log.info("TC 04 - Sort By Product Price High To Low - Step: Verify Product List is sorted");
        verifyTrue(productListPage.isProductListSortedByPrice("DESC"));
    }

    @Test
    public void TC_05_Check_Display_With_Only_Three_Products_Per_Page() {
        log.info("TC 05 Check Display With Only Three Products Per Page - Step: Select Display 3 Products per page");
        productListPage.selectNumberOfProductsToDisplay("3");

        log.info("TC 05 Check Display With Only Three Products Per Page - Step: Verify only 3 or fewer products are displayed");
        verifyTrue(productListPage.isNumberOfProductsDisplayedFewerThan(3));

        log.info("TC 05 Check Display With Only Three Products Per Page - Step: Verify Next Page icon displayed");
        verifyTrue(productListPage.isNextPageIconDisplayed());

        log.info("TC 05 Check Display With Only Three Products Per Page - Step: Click on Next Page icon");
        productListPage.clickOnNextPageIcon();

        log.info("TC 05 Check Display With Only Three Products Per Page - Step: Verify Previous Page icon displayed");
        verifyTrue(productListPage.isPreviousPageIconDisplayed());
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        //closeBrowserAndDriver(driver);
    }
}
