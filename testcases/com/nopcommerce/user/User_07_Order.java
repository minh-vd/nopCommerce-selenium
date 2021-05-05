package com.nopcommerce.user;

import com.nopcommerce.common.Common_01_Register;
import commons.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

public class User_07_Order extends AbstractTest {
    WebDriver driver;

    UserHomePO userHomePage;
    UserLoginPO userLoginPage;
    ProductListPO productListPage;
    ProductDetailPO productDetailPage;

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

        log.info("Pre-Condition - Step: Click on Login button");
        userHomePage = userLoginPage.clickOnLoginButton();
    }

    @Test
    public void Order_01_Add_Product_To_Cart() {
        log.info("Order 01 - Add Product To Cart - Step: Hover on Computers top menu");
        userHomePage.hoverMouseOnDynamicHeaderMenuByText(driver, "Computers");

        log.info("Order 01 - Add Product To Cart - Step: Click on Desktops sub menu");
        productListPage = userHomePage.clickOnDynamicHeaderSubmenuByText(driver, "Desktops");

        log.info("Order 01 - Add Product To Cart - Step: Click on \"Build your own Computer\" product");
        productDetailPage = productListPage.clickOnDynamicProductTitleByProductName("Build your own computer");

        log.info("Order 01 - Add Product To Cart - Step: Select \"2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]\" Processor option");
        productDetailPage.selectProcessor("2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]");

        log.info("Order 01 - Add Product To Cart - Step: Select \"8GB [+$60.00]\" Ram option");
        productDetailPage.selectRam("8GB [+$60.00]");

        log.info("Order 01 - Add Product To Cart - Step: Select \"400 GB [+$100.00]\" HDD option");
        productDetailPage.selectDynamicCheckboxByGroupLabelAndText("HDD","400 GB [+$100.00]");

        log.info("Order 01 - Add Product To Cart - Step: Select \"Vista Premium [+$60.00]\" OS option");
        productDetailPage.selectDynamicCheckboxByGroupLabelAndText("OS", "Vista Premium [+$60.00]");

        log.info("Order 01 - Add Product To Cart - Step: Select \"Microsoft Office [+$50.00]\" Software option");
        productDetailPage.selectDynamicCheckboxByGroupLabelAndText("Software", "Microsoft Office [+$50.00]");

        log.info("Order 01 - Add Product To Cart - Step: Select \"Acrobat Reader [+$10.00]\" Software option");
        productDetailPage.selectDynamicCheckboxByGroupLabelAndText("Software", "Acrobat Reader [+$10.00]");

        log.info("Order 01 - Add Product To Cart - Step: Select \"Total Commander [+$5.00]\" Software option");
        productDetailPage.selectDynamicCheckboxByGroupLabelAndText("Software", "Total Commander [+$5.00]");

        log.info("Order 01 - Add Product To Cart - Step: Click on <ADD TO CART> button");
        productDetailPage.clickOnAddToCartButton();

        log.info("Order 01 - Add Product To Cart - Step: Verify Add to Cart success message on Notification Bar");
        verifyEquals(productDetailPage.getNotificationBarMessage(driver), "The product has been added to your shopping cart");

        log.info("Order 01 - Add Product To Cart - Step: Close Notification Bar");
        productDetailPage.clickOnCloseNotificationBarIcon(driver);

        log.info("Order 01 - Add Product To Cart - Step: Hover on Shopping Cart on Header link");
        productDetailPage.hoverOnDynamicHeaderLinkByText(driver, "Shopping cart");

        log.info("Order 01 - Add Product To Cart - Step: Verify Shopping Cart - Count Product text \"There are 1 item(s) in your cart.\"");
        verifyEquals(productDetailPage.getMiniShoppingCartCountProductText(driver), "1 item(s)");

        log.info("Order 01 - Add Product To Cart - Step: Verify Shopping Cart - Product Info");
        verifyTrue(productDetailPage.isMiniShoppingCartProductDisplayed(driver, "Build your own computer", "$1,500.00", "1", "2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]", "8GB [+$60.00]", "400 GB [+$100.00]", "Vista Premium [+$60.00]", "Microsoft Office [+$50.00]", "Acrobat Reader [+$10.00]", "Total Commander [+$5.00]"));

        log.info("Order 01 - Add Product To Cart - Step: Verify Shopping Cart - Sub-Total Price");
        verifyEquals(productDetailPage.getMiniShoppingCartSubTotalPrice(driver), "$1,500.00");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        //closeBrowserAndDriver(driver);
    }
}
