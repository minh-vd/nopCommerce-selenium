package pageObjects;

import org.openqa.selenium.WebDriver;
import pageObjects.admin.AdminHomePO;
import pageObjects.admin.AdminLoginPO;

public class PageGeneratorManager {
    private static UserHomePO userHomePage;
    private static UserRegisterPO userRegisterPage;
    private static UserRegisterResultPO userRegisterResultPage;
    private static UserLoginPO userLoginPage;
    private static MyAccountPO myAccountPage;
    private static ProductDetailPO productDetailPage;
    private static ProductReviewPO productReviewPage;
    private static SearchPO searchPage;
    private static ProductListPO productListPage;
    private static WishlistPO wishlistPage;
    private static CartPO cartPage;
    private static CompareProductsPO compareProductsPage;
    private static RecentlyViewedProductsPO recentlyViewedProductsPage;
    private static CheckoutPO checkoutPage;
    private static OrderDetailPO orderDetailPage;
    private static AdminLoginPO adminLoginPage;
    private static AdminHomePO adminHomePage;

    private PageGeneratorManager() {
    }

    public static UserHomePO getUserHomePage(WebDriver driver) {
        /*if (userHomePage == null) {
            userHomePage = new UserHomePO(driver);
        }*/
        return new UserHomePO(driver);
    }

    public static UserRegisterPO getUserRegisterPage(WebDriver driver) {
        if (userRegisterPage == null) {
            userRegisterPage = new UserRegisterPO(driver);
        }
        return userRegisterPage;
    }

    public static UserRegisterResultPO getUserRegisterResultPage(WebDriver driver) {
        if (userRegisterResultPage == null) {
            userRegisterResultPage = new UserRegisterResultPO(driver);
        }
        return userRegisterResultPage;
    }

    public static UserLoginPO getUserLoginPage(WebDriver driver) {
        if (userLoginPage == null) {
            userLoginPage = new UserLoginPO(driver);
        }
        return userLoginPage;
    }

    public static MyAccountPO getMyAccountPage(WebDriver driver) {
        if (myAccountPage == null) {
            myAccountPage = new MyAccountPO(driver);
        }
        return myAccountPage;
    }

    public static ProductDetailPO getProductDetailPage(WebDriver driver) {
        if (productDetailPage == null) {
            productDetailPage = new ProductDetailPO(driver);
        }
        return productDetailPage;
    }

    public static ProductReviewPO getProductReviewPage(WebDriver driver) {
        if (productReviewPage == null) {
            productReviewPage = new ProductReviewPO(driver);
        }
        return productReviewPage;
    }

    public static SearchPO getSearchPage(WebDriver driver) {
        if (searchPage == null) {
            searchPage = new SearchPO(driver);
        }
        return searchPage;
    }

    public static ProductListPO getProductListPage(WebDriver driver) {
        if (productListPage == null) {
            productListPage = new ProductListPO(driver);
        }
        return productListPage;
    }

    public static WishlistPO getWishlistPage(WebDriver driver) {
        if (wishlistPage == null) {
            wishlistPage = new WishlistPO(driver);
        }
        return wishlistPage;
    }

    public static CartPO getCartPage(WebDriver driver){
        if (cartPage == null) {
            cartPage = new CartPO(driver);
        }
        return cartPage;
    }

    public static CompareProductsPO getCompareProductsPage(WebDriver driver) {
        if (compareProductsPage == null) {
            compareProductsPage = new CompareProductsPO(driver);
        }
        return compareProductsPage;
    }

    public static RecentlyViewedProductsPO getRecentlyViewedProductsPage(WebDriver driver) {
        if (recentlyViewedProductsPage == null) {
            recentlyViewedProductsPage = new RecentlyViewedProductsPO(driver);
        }
        return recentlyViewedProductsPage;
    }

    public static CheckoutPO getCheckoutPage(WebDriver driver) {
        if (checkoutPage == null) {
            checkoutPage = new CheckoutPO(driver);
        }
        return checkoutPage;
    }

    public static OrderDetailPO getOrderDetailPage(WebDriver driver) {
        if (orderDetailPage == null) {
            orderDetailPage = new OrderDetailPO(driver);
        }
        return orderDetailPage;
    }

    public static AdminLoginPO getAdminLoginPage(WebDriver driver) {
        if (adminLoginPage == null) {
            adminLoginPage = new AdminLoginPO(driver);
        }
        return adminLoginPage;
    }

    public static AdminHomePO getAdminHomePage(WebDriver driver) {
        if (adminHomePage == null) {
            adminHomePage = new AdminHomePO(driver);
        }
        return adminHomePage;
    }
}
