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
    CartPO cartPage;
    CompareProductsPO compareProductsPage;
    ProductListPO productListPage;
    RecentlyViewedProductsPO recentlyViewedProductsPage;

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

        log.info("Pre-Condition - Step: Click on Product Title of 2nd Product in Featured List");
        productDetailPage = userHomePage.clickOnTitleOfDynamicProductInFeaturedListByIndex("2");
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

    @Test
    public void TC_02_Add_Product_From_Wishlist_To_Cart() {
        log.info("TC 02 Add Product From Wishlist To Cart - Step: Click on Logo to navigate to HomePage");
        userHomePage = wishlistPage.clickOnLogo(driver);

        log.info("TC 02 Add Product From Wishlist To Cart - Step: Click on Wishlist link in Footer");
        userHomePage.clickOnDynamicLinkAtFooterByText(driver, "Wishlist");
        wishlistPage = PageGeneratorManager.getWishlistPage(driver);

        log.info("TC 02 Add Product From Wishlist To Cart - Step: Click on Checkbox Add to cart");
        wishlistPage.checkOnCheckboxAddToCartByProductName(productName);

        log.info("TC 02 Add Product From Wishlist To Cart - Step: Click on <ADD TO CART> button");
        cartPage = wishlistPage.clickOnAddToCartButton();

        log.info("TC 02 Add Product From Wishlist To Cart - Step: Verify Product is added to Cart");
        verifyTrue(cartPage.isAddedProductDisplayed(productName));

        log.info("TC 02 Add Product From Wishlist To Cart - Step: Click on Wishlist link in Footer");
        cartPage.clickOnDynamicLinkAtFooterByText(driver, "Wishlist");
        wishlistPage = PageGeneratorManager.getWishlistPage(driver);

        log.info("TC 02 Add Product From Wishlist To Cart - Step: Verify Product is removed from Wishlist");
        verifyTrue(wishlistPage.isAddedProductNotDisplayed(productName));
    }

    @Test
    public void TC_03_Remove_Product_From_Wishlist() {
        log.info("TC 03 Remove Product From Wishlist - Step: Click on Logo to navigate to HomePage");
        userHomePage = wishlistPage.clickOnLogo(driver);

        log.info("TC 03 Remove Product From Wishlist - Step: Click on Product Title of 2nd Product in Featured List");
        productDetailPage = userHomePage.clickOnTitleOfDynamicProductInFeaturedListByIndex("2");

        log.info("TC 03 Remove Product From Wishlist - Step: Get current Product Name");
        productName = productDetailPage.getProductName();

        log.info("TC 03 Remove Product From Wishlist - Step: Add Product to Wishlist");
        productDetailPage.clickOnAddToWishlistButton();

        log.info("TC 03 Remove Product From Wishlist - Step: Click on Wishlist link in Footer");
        productDetailPage.clickOnDynamicLinkAtFooterByText(driver, "Wishlist");
        wishlistPage = PageGeneratorManager.getWishlistPage(driver);

        log.info("TC 03 Remove Product From Wishlist - Step: Click on Remove Icon");
        wishlistPage.clickOnRemoveIconByProductName(productName);

        log.info("TC 03 Remove Product From Wishlist - Step: Verify Wishlist empty message");
        verifyEquals(wishlistPage.getTextOfNoDataMessage(), "The wishlist is empty!");

        log.info("TC 03 Remove Product From Wishlist - Step: Verify Product is removed from Wishlist");
        verifyTrue(wishlistPage.isAddedProductNotDisplayed(productName));
    }

    @Test
    public void TC_04_Add_Product_To_Compare() {
        log.info("TC 04 Add Product To Compare - Step: Click on Logo to navigate to HomePage");
        userHomePage = wishlistPage.clickOnLogo(driver);

        log.info("TC 04 Add Product To Compare - Step: Add 1st Product in Featured List to Compare List");
        userHomePage.clickOnDynamicAddToCompareListByProductIndex("1");

        log.info("TC 04 Add Product To Compare - Step: Get Product Name of 1st Product in Featured List");
        String product1Name = userHomePage.getDynamicTitleOfProductInFeaturedListByProductIndex("1");

        log.info("TC 04 Add Product To Compare - Step: Get Price of 1st Product in Featured List");
        String product1Price = userHomePage.getDynamicPriceOfProductInFeaturedListByProductIndex("1");

        log.info("TC 04 Add Product To Compare - Step: Close Add Successfully Notification Bar");
        userHomePage.clickOnCloseNotificationBarIcon(driver);

        log.info("TC 04 Add Product To Compare - Step: Add 2nd Product in Featured List to Compare List");
        userHomePage.clickOnDynamicAddToCompareListByProductIndex("2");

        log.info("TC 04 Add Product To Compare - Step: Get Product Name of 2nd Product in Featured List");
        String product2Name = userHomePage.getDynamicTitleOfProductInFeaturedListByProductIndex("2");

        log.info("TC 04 Add Product To Compare - Step: Get Price of 2nd Product in Featured List");
        String product2Price = userHomePage.getDynamicPriceOfProductInFeaturedListByProductIndex("2");

        log.info("TC 04 Add Product To Compare - Step: Verify Message Add Successfully on Notification Bar");
        verifyEquals(userHomePage.getNotificationBarMessage(driver), "The product has been added to your product comparison");

        log.info("TC 04 Add Product To Compare - Step: Click on Compare products list link in Footer");
        userLoginPage.clickOnDynamicLinkAtFooterByText(driver, "Compare products list");
        compareProductsPage = PageGeneratorManager.getCompareProductsPage(driver);

        log.info("TC 04 Add Product To Compare - Step: Verify Product 1 displayed");
        verifyTrue(compareProductsPage.isRemoveProductIconDisplayedByNameAndPrice(product1Name, product1Price));

        log.info("TC 04 Add Product To Compare - Step: Verify Product 2 displayed");
        verifyTrue(compareProductsPage.isRemoveProductIconDisplayedByNameAndPrice(product2Name, product2Price));

        log.info("TC 04 Add Product To Compare - Step: Verify <Clear List> button displayed");
        verifyTrue(compareProductsPage.isClearListButtonDisplayed());

        log.info("TC 04 Add Product To Compare - Step: Click <Clear List> button");
        compareProductsPage.clickOnClearListButton();

        log.info("TC 04 Add Product To Compare - Step: Verify No Data message");
        verifyEquals(compareProductsPage.getTextOfNoDataMessage(), "You have no items to compare.");

        log.info("TC 04 Add Product To Compare - Step: Verify Product 1 NOT displayed");
        verifyTrue(compareProductsPage.isProductNotDisplayedByNameAndPrice(product1Name, product1Price));

        log.info("TC 04 Add Product To Compare - Step: Verify Product 2 NOT displayed");
        verifyTrue(compareProductsPage.isProductNotDisplayedByNameAndPrice(product2Name, product2Price));
    }

    @Test
    public void TC_05_Recently_Viewed_Products() {
        log.info("TC 05 Recently Viewed Products - Step: Click on Logo to navigate to HomePage");
        userHomePage = compareProductsPage.clickOnLogo(driver);

        log.info("TC 05 Recently Viewed Products - Step: Hover on Computers tab");
        userHomePage.hoverMouseOnDynamicHeaderMenuByText(driver, "Computers");

        log.info("TC 05 Recently Viewed Products - Step: Click on Notebooks submenu");
        productListPage = userHomePage.clickOnDynamicHeaderSubmenuByText(driver, "Notebooks");

        log.info("TC 05 Recently Viewed Products - Step: Click on Product Title of 1st Product in list");
        productDetailPage = productListPage.clickOnDynamicProductTitleByProductIndex("1");

        log.info("TC 05 Recently Viewed Products - Step: Click Browser Back button to back to Product List page");
        productDetailPage.backToPreviousPage(driver);
        productListPage = PageGeneratorManager.getProductListPage(driver);

        log.info("TC 05 Recently Viewed Products - Step: Click on Product Title of 2nd Product in list");
        productDetailPage = productListPage.clickOnDynamicProductTitleByProductIndex("2");

        log.info("TC 05 Recently Viewed Products - Step: Click Browser Back button to back to Product List page");
        productDetailPage.backToPreviousPage(driver);
        productListPage = PageGeneratorManager.getProductListPage(driver);

        log.info("TC 05 Recently Viewed Products - Step: Click on Product Title of 3rd Product in list");
        productDetailPage = productListPage.clickOnDynamicProductTitleByProductIndex("3");

        log.info("TC 05 Recently Viewed Products - Step: Get 3rd Product Name");
        String product3Name= productDetailPage.getProductName();

        log.info("TC 05 Recently Viewed Products - Step: Click Browser Back button to back to Product List page");
        productDetailPage.backToPreviousPage(driver);
        productListPage = PageGeneratorManager.getProductListPage(driver);

        log.info("TC 05 Recently Viewed Products - Step: Click on Product Title of 4th Product in list");
        productDetailPage = productListPage.clickOnDynamicProductTitleByProductIndex("4");

        log.info("TC 05 Recently Viewed Products - Step: Get 4th Product Name");
        String product4Name= productDetailPage.getProductName();

        log.info("TC 05 Recently Viewed Products - Step: Click Browser Back button to back to Product List page");
        productDetailPage.backToPreviousPage(driver);
        productListPage = PageGeneratorManager.getProductListPage(driver);

        log.info("TC 05 Recently Viewed Products - Step: Click on Product Title of 5th Product in list");
        productDetailPage = productListPage.clickOnDynamicProductTitleByProductIndex("5");

        log.info("TC 05 Recently Viewed Products - Step: Get 5th Product Name");
        String product5Name= productDetailPage.getProductName();

        log.info("TC 05 Recently Viewed Products - Step: Click Browser Back button to back to Product List page");
        productDetailPage.backToPreviousPage(driver);
        productListPage = PageGeneratorManager.getProductListPage(driver);

        log.info("TC 05 Recently Viewed Products - Step: Click on Recently viewed products link on Footer to navigate to that page");
        productListPage.clickOnDynamicLinkAtFooterByText(driver, "Recently viewed products");
        recentlyViewedProductsPage = PageGeneratorManager.getRecentlyViewedProductsPage(driver);

        log.info("TC 05 Recently Viewed Products - Step: Verify only 3 Products are displayed");
        verifyTrue(recentlyViewedProductsPage.areOnlyThreeProductsDisplayed());

        log.info("TC 05 Recently Viewed Products - Step: Verify 3rd Product from above step is displayed");
        verifyTrue(recentlyViewedProductsPage.isDynamicProductDisplayedByProductName(product3Name));

        log.info("TC 05 Recently Viewed Products - Step: Verify 4th Product from above step is displayed");
        verifyTrue(recentlyViewedProductsPage.isDynamicProductDisplayedByProductName(product4Name));

        log.info("TC 05 Recently Viewed Products - Step: Verify 5th Product from above step is displayed");
        verifyTrue(recentlyViewedProductsPage.isDynamicProductDisplayedByProductName(product5Name));
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        //closeBrowserAndDriver(driver);
    }
}
