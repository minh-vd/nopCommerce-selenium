package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
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
}
