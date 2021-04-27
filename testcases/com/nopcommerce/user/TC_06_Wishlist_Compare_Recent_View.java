package com.nopcommerce.user;

import com.nopcommerce.common.Common_01_Register;
import commons.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

public class TC_06_Wishlist_Compare_Recent_View extends AbstractTest {
    WebDriver driver;

    UserHomePO userHomePage;
    UserLoginPO userLoginPage;
    ProductDetailPO productDetailPage;
    WishlistPO wishlistPage;

    String productName;

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

        log.info("Pre-Condition - Step: Click on random Product Title in Featured List");
        productDetailPage = userHomePage.clickOnRandomProductTitleInFeaturedList();
    }

    @Test
    public void TC_01_Add_Product_To_Wishlist() {
        log.info("TC 01 Add Product To Wishlist - Step: Get current Product Name");
        productName = productDetailPage.getProductName();

        log.info("TC 01 Add Product To Wishlist - Step: Click on <Add to wishlist> button");
        productDetailPage.clickOnAddToWishlistButton();

        log.info("TC 01 Add Product To Wishlist - Step: Verify add successfully message on Notification Bar");
        verifyEquals(productDetailPage.getNotificationBarMessage(driver), "The product has been added to your wishlist");

        log.info("TC 01 Add Product To Wishlist - Step: Click on Wishlist link in Footer");
        productDetailPage.clickOnDynamicLinkAtFooterByText(driver, "Wishlist");
        wishlistPage = PageGeneratorManager.getWishlistPage(driver);

        log.info("TC 01 Add Product To Wishlist - Step: Verify Product is added to Wishlist");
        verifyTrue(wishlistPage.isAddedProductDisplayed(productName));

        log.info("TC 01 Add Product To Wishlist - Step: Click on Wishlist URL for sharing");
        wishlistPage.clickOnWishlistUrlForSharing();

        log.info("TC 01 Add Product To Wishlist - Step: Verify Wishlist of {User} is displayed correctly");
        verifyEquals(wishlistPage.getWishlistTitle(), "Wishlist of " + Common_01_Register.firstName + " " + Common_01_Register.lastName);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        //closeBrowserAndDriver(driver);
    }
}
