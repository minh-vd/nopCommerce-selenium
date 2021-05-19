package pageObjects;

import org.openqa.selenium.WebDriver;
import pageObjects.admin.*;

public class PageGeneratorManager {
    private PageGeneratorManager() {
    }

    public static UserHomePO getUserHomePage(WebDriver driver) {
        return new UserHomePO(driver);
    }

    public static UserRegisterPO getUserRegisterPage(WebDriver driver) {
        return new UserRegisterPO(driver);
    }

    public static UserRegisterResultPO getUserRegisterResultPage(WebDriver driver) {
        return new UserRegisterResultPO(driver);
    }

    public static UserLoginPO getUserLoginPage(WebDriver driver) {
        return new UserLoginPO(driver);
    }

    public static MyAccountPO getMyAccountPage(WebDriver driver) {
        return new MyAccountPO(driver);
    }

    public static ProductDetailPO getProductDetailPage(WebDriver driver) {
        return new ProductDetailPO(driver);
    }

    public static ProductReviewPO getProductReviewPage(WebDriver driver) {
        return new ProductReviewPO(driver);
    }

    public static SearchPO getSearchPage(WebDriver driver) {
        return new SearchPO(driver);
    }

    public static ProductListPO getProductListPage(WebDriver driver) {
        return new ProductListPO(driver);
    }

    public static WishlistPO getWishlistPage(WebDriver driver) {
        return new WishlistPO(driver);
    }

    public static CartPO getCartPage(WebDriver driver){
        return new CartPO(driver);
    }

    public static CompareProductsPO getCompareProductsPage(WebDriver driver) {
        return new CompareProductsPO(driver);
    }

    public static RecentlyViewedProductsPO getRecentlyViewedProductsPage(WebDriver driver) {
        return new RecentlyViewedProductsPO(driver);
    }

    public static CheckoutPO getCheckoutPage(WebDriver driver) {
        return new CheckoutPO(driver);
    }

    public static OrderDetailPO getOrderDetailPage(WebDriver driver) {
        return new OrderDetailPO(driver);
    }

    public static AdminLoginPO getAdminLoginPage(WebDriver driver) {
        return new AdminLoginPO(driver);
    }

    public static AdminHomePO getAdminHomePage(WebDriver driver) {
        return new AdminHomePO(driver);
    }

    public static AdminProductListPO getAdminProductListPage(WebDriver driver) {
        return new AdminProductListPO(driver);
    }

    public static AdminProductDetailPO getAdminProductDetailPage(WebDriver driver) {
        return new AdminProductDetailPO(driver);
    }

    public static AdminCustomerPO getAdminCustomerPage(WebDriver driver) {
        return new AdminCustomerPO(driver);
    }
}
