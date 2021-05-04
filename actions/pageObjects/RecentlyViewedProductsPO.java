package pageObjects;

import commons.AbstractPage;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import pageUIs.RecentlyViewedProductsPUI;
import pageUIs.WishlistPUI;

public class RecentlyViewedProductsPO extends AbstractPage {
    WebDriver driver;

    public RecentlyViewedProductsPO(WebDriver driver) {
        this.driver = driver;
    }

    public boolean areOnlyThreeProductsDisplayed() {
        waitForAllElementsVisible(driver, RecentlyViewedProductsPUI.PRODUCT_TITLE_LIST);
        if (getElementSize(driver, RecentlyViewedProductsPUI.PRODUCT_TITLE_LIST) == 3) {
            return true;
        } else return false;
    }

    public boolean isDynamicProductDisplayedByProductName(String productName) {
        waitForElementVisible(driver, RecentlyViewedProductsPUI.DYNAMIC_PRODUCT_TITLE, productName);
        return isElementDisplayed(driver, RecentlyViewedProductsPUI.DYNAMIC_PRODUCT_TITLE, productName);
    }
}
