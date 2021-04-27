package pageObjects;

import commons.AbstractPage;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import pageUIs.ProductDetailPUI;
import pageUIs.UserRegisterResultPUI;

public class ProductDetailPO extends AbstractPage {
    WebDriver driver;

    public ProductDetailPO(WebDriver driver) {
        this.driver = driver;
    }

    public ProductReviewPO clickOnAddYourReviewLink() {
        waitForElementClickable(driver, ProductDetailPUI.ADD_YOUR_REVIEW_LINK);
        clickOnElement(driver, ProductDetailPUI.ADD_YOUR_REVIEW_LINK);
        sleepInSecond(GlobalConstants.SLEEP_TIME_WAIT_FOR_PAGE_LOAD);
        return PageGeneratorManager.getProductReviewPage(driver);
    }

    public void clickOnAddToWishlistButton() {
        waitForElementClickable(driver, ProductDetailPUI.ADD_TO_WISHLIST_BUTTON_IN_PRODUCT_DETAIL);
        clickOnElement(driver, ProductDetailPUI.ADD_TO_WISHLIST_BUTTON_IN_PRODUCT_DETAIL);
    }

    public String getProductName() {
        waitForElementVisible(driver, ProductDetailPUI.PRODUCT_NAME_TEXT);
        return getElementText(driver, ProductDetailPUI.PRODUCT_NAME_TEXT);
    }
}
