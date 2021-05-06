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
    CartPO cartPage;

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

        log.info("Order 01 - Add Product To Cart - Step: Select \"8GB [+$60.00]\" RAM option");
        productDetailPage.selectRam("8GB [+$60.00]");

        log.info("Order 01 - Add Product To Cart - Step: Select \"400 GB [+$100.00]\" HDD option");
        productDetailPage.checkOnDynamicCheckboxByGroupLabelAndText("HDD","400 GB [+$100.00]");

        log.info("Order 01 - Add Product To Cart - Step: Select \"Vista Premium [+$60.00]\" OS option");
        productDetailPage.checkOnDynamicCheckboxByGroupLabelAndText("OS", "Vista Premium [+$60.00]");

        log.info("Order 01 - Add Product To Cart - Step: Select \"Microsoft Office [+$50.00]\" Software option");
        productDetailPage.checkOnDynamicCheckboxByGroupLabelAndText("Software", "Microsoft Office [+$50.00]");

        log.info("Order 01 - Add Product To Cart - Step: Select \"Acrobat Reader [+$10.00]\" Software option");
        productDetailPage.checkOnDynamicCheckboxByGroupLabelAndText("Software", "Acrobat Reader [+$10.00]");

        log.info("Order 01 - Add Product To Cart - Step: Select \"Total Commander [+$5.00]\" Software option");
        productDetailPage.checkOnDynamicCheckboxByGroupLabelAndText("Software", "Total Commander [+$5.00]");

        log.info("Order 01 - Add Product To Cart - Step: Click on <ADD TO CART> button");
        productDetailPage.clickOnAddToCartButton();

        log.info("Order 01 - Add Product To Cart - Step: Verify Add to Cart success message on Notification Bar");
        verifyEquals(productDetailPage.getNotificationBarMessage(driver), "The product has been added to your shopping cart");

        log.info("Order 01 - Add Product To Cart - Step: Close Notification Bar");
        productDetailPage.clickOnCloseNotificationBarIcon(driver);

        log.info("Order 01 - Add Product To Cart - Step: Hover on Shopping Cart on Header link");
        productDetailPage.hoverOnDynamicHeaderLinkByText(driver, "Shopping cart");

        log.info("Order 01 - Add Product To Cart - Step: Verify Mini Shopping Cart - Count Product text \"There are 1 item(s) in your cart.\"");
        verifyEquals(productDetailPage.getMiniShoppingCartCountProductText(driver), "1 item(s)");

        log.info("Order 01 - Add Product To Cart - Step: Verify Mini Shopping Cart - Product Info");
        verifyTrue(productDetailPage.isMiniShoppingCartProductDisplayed(driver, "Build your own computer", "$1,500.00", "1", "Processor: 2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]", "RAM: 8GB [+$60.00]", "HDD: 400 GB [+$100.00]", "OS: Vista Premium [+$60.00]", "Software: Microsoft Office [+$50.00]", "Software: Acrobat Reader [+$10.00]", "Software: Total Commander [+$5.00]"));

        log.info("Order 01 - Add Product To Cart - Step: Verify Mini Shopping Cart - Sub-Total Price");
        verifyEquals(productDetailPage.getMiniShoppingCartSubTotalPrice(driver), "$1,500.00");
    }

    @Test
    public void Order_02_Edit_Product_In_Cart() {
        log.info("Order 02 - Edit Product In Cart - Step: Click on Shopping Cart on Header link");
        productDetailPage.clickOnDynamicHeaderLinkByText(driver, "Shopping cart");
        cartPage = PageGeneratorManager.getCartPage(driver);

        log.info("Order 02 - Edit Product In Cart - Step: Click on Edit link");
        productDetailPage = cartPage.clickOnDynamicEditLinkByProductName("Build your own computer");

        log.info("Order 02 - Edit Product In Cart - Step: Select \"2.2 GHz Intel Pentium Dual-Core E2200\" Processor option");
        productDetailPage.selectProcessor("2.2 GHz Intel Pentium Dual-Core E2200");

        log.info("Order 02 - Edit Product In Cart - Step: Select \"4GB [+$20.00]\" RAM option");
        productDetailPage.selectRam("4GB [+$20.00]");

        log.info("Order 02 - Edit Product In Cart - Step: Select \"320 GB\" HDD option");
        productDetailPage.checkOnDynamicCheckboxByGroupLabelAndText("HDD", "320 GB");

        log.info("Order 02 - Edit Product In Cart - Step: Select \"Vista Home [+$50.00]\" OS option");
        productDetailPage.checkOnDynamicCheckboxByGroupLabelAndText("OS", "Vista Home [+$50.00]");

        log.info("Order 02 - Edit Product In Cart - Step: Uncheck \"Acrobat Reader [+$10.00]\" Software option");
        productDetailPage.uncheckOnDynamicCheckboxByGroupLabelAndText("Software", "Acrobat Reader [+$10.00]");

        log.info("Order 02 - Edit Product In Cart - Step: Uncheck \"Total Commander [+$5.00]\" Software option");
        productDetailPage.uncheckOnDynamicCheckboxByGroupLabelAndText("Software", "Total Commander [+$5.00]");

        log.info("Order 02 - Edit Product In Cart - Step: Input 2 into Quantity text box");
        productDetailPage.inputIntoQuantityTextBox("2");

        log.info("Order 02 - Edit Product In Cart - Step: Verify Product Price = \"$1,320.00\"");
        verifyEquals(productDetailPage.getProductPrice(), "$1,320.00");

        log.info("Order 02 - Edit Product In Cart - Step: Click on <Update> button");
        productDetailPage.clickOnUpdateButton();

        log.info("Order 02 - Edit Product In Cart - Step: Verify Add to Cart success message on Notification Bar");
        verifyEquals(productDetailPage.getNotificationBarMessage(driver), "The product has been added to your shopping cart");

        log.info("Order 02 - Edit Product In Cart - Step: Close Notification Bar");
        productDetailPage.clickOnCloseNotificationBarIcon(driver);

        log.info("Order 02 - Edit Product In Cart - Step: Hover on Shopping Cart on Header link");
        productDetailPage.hoverOnDynamicHeaderLinkByText(driver, "Shopping cart");

        log.info("Order 02 - Edit Product In Cart - Step: Verify Mini Shopping Cart - Product Info");
        verifyTrue(productDetailPage.isMiniShoppingCartProductDisplayed(driver, "Build your own computer", "$1,320.00", "2", "Processor: 2.2 GHz Intel Pentium Dual-Core E2200", "RAM: 4GB [+$20.00]", "HDD: 320 GB", "OS: Vista Home [+$50.00]", "Software: Microsoft Office [+$50.00]"));

        log.info("Order 02 - Edit Product In Cart - Step: Verify Mini Shopping Cart - Sub-Total Price");
        verifyEquals(productDetailPage.getMiniShoppingCartSubTotalPrice(driver), "$2,640.00");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        //closeBrowserAndDriver(driver);
    }
}
