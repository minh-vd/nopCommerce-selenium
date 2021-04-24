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

    @Test
    public void TC_01_Search_With_Empty_Data() {

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        //closeBrowserAndDriver(driver);
    }
}
